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

  private ArrayList<Map<String, String>> consultar(boolean mensualidad) {
    StringBuffer query = new StringBuffer();
    LocalDate fecha = LocalDate.now().minusMonths(1);

    if (mensualidad) {
      query.append("select * from Cliente");
    } else {
      query.append("select * from Cliente where Mensualidad > '");
      query.append(fecha.format(DateTimeFormatter.ISO_DATE)).append("' ");
    }

    ConnectionDB connection = new ConnectionDB();
    ResultSet result = connection.consult(query.toString());
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

  public ArrayList<Map<String, String>> listar() {
      return consultar(true);
  }

  public ArrayList<Map<String, String>> listarMensualidad() {
    return consultar(false);
  }

  public void crearCliente(int cedula, String nombre, boolean mensualidad) {
      LocalDate fechaActual;
      fechaActual = LocalDate.parse(LocalDate.now().format(DateTimeFormatter.ISO_DATE));

      StringBuffer query = new StringBuffer();
      if (mensualidad) query.append("insert into Cliente(Cedula, Nombre, Mensualidad) values(");
      if (!mensualidad) query.append("insert into Cliente(Cedula, Nombre) values(");
      query.append(cedula).append(",");
      query.append("'").append(nombre).append("'");
      if (mensualidad) query.append(", '").append(fechaActual).append("'");
      query.append(")");

      ConnectionDB connection = new ConnectionDB();
      connection.execute(query.toString());
      connection.closeConnection();
  }

  public void renovarMensualidad (int cedula) {
      LocalDate fechaActual;
      fechaActual = LocalDate.parse(LocalDate.now().format(DateTimeFormatter.ISO_DATE));

      StringBuffer query = new StringBuffer();
      query.append("update Cliente set Mensualidad = '").append(fechaActual).append("' ");
      query.append("where Cedula = ").append(cedula);

      ConnectionDB connection = new ConnectionDB();
      connection.execute(query.toString());
  }

  public void eliminarCliente (int cedula) {
      String query = "delete from Cliente where Cedula = " + cedula;
      ConnectionDB connection = new ConnectionDB();
      connection.execute(query);
      connection.closeConnection();
  }
}








