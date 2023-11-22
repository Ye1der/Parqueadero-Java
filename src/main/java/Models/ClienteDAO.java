package Models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Map;
import java.time.LocalDate;

import DB.ConnectionDB;
import TOs.ClienteTO;

import java.util.HashMap;

public class ClienteDAO {

  // -> Requerimientos Cliente
  // --> Mostrar la lista de clientes
  // --> Renovar o agregar mensualidad

  public ArrayList<Map<String, String>> listar(boolean mensualidad) {
    String query;
    LocalDate fecha = LocalDate.now().minusMonths(1);

    if (mensualidad) {
      query = "select * from Cliente";
    } else {
      query = "select * from Cliente where Mensualidad > '" + fecha.format(DateTimeFormatter.ISO_DATE) + "'";
      System.out.println(query);
    }

    ConnectionDB connection = new ConnectionDB();
    ResultSet result = connection.consult(query);
    ArrayList<Map<String, String>> data = new ArrayList<>();

    try {
      while (result.next()) {
        Map<String, String> mapa = new HashMap<>();

        mapa.put("id", result.getString("IdCliente"));
        mapa.put("cedula", result.getString("Cedula"));
        mapa.put("nombre", result.getString("Nombre"));
        mapa.put("mensualidad", result.getString("Mensualidad"));

        data.add(mapa);
      }
      connection.closeConnection();

    } catch (SQLException ex) {
      System.out.println("error al cargar los datos" + ex.getMessage());
    }

    return data;
  }

  public void crearCliente(int cedula, String nombre, boolean mensualidad) {
      String fechaActual = "ninguna";

      if (mensualidad) {
          fechaActual = LocalDate.now().format(DateTimeFormatter.ISO_DATE);
      }

      StringBuffer query = new StringBuffer();
      query.append("insert into Cliente(Cedula, Nombre, Mensualidad) values(");
      query.append(cedula + ",");
      query.append("'" + nombre + "',");
      query.append(" '" + fechaActual + "')");

      ConnectionDB connection = new ConnectionDB();
      connection.execute(query.toString());
  }
}