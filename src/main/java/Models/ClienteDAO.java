package Models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.time.LocalDate;

import DB.ConnectionDB;
import TOs.ClienteTO;

public class ClienteDAO {

  // -> Requerimientos Cliente
  // --> Mostrar la lista de clientes
  // --> Renovar o agregar mensualidad

  public ArrayList<ClienteTO> consultar (boolean mensualidad, String nombre, String cedula) {
    StringBuffer query = new StringBuffer();
    LocalDate fecha = LocalDate.now().minusMonths(1);

    query.append("select * from Cliente where 1 ");
    
    if (mensualidad) { 
    query.append("and Mensualidad > '");
    query.append(fecha.format(DateTimeFormatter.ISO_DATE)).append("' ");
    }

    if (!nombre.equals("")) query.append("and Nombre = '").append(nombre).append("' ");

    if (!cedula.equals("")) query.append("and Cedula = ").append(cedula);

    ConnectionDB connection = new ConnectionDB();
    ResultSet data = connection.consult(query.toString());
    ArrayList<ClienteTO> clientes = new ArrayList<>();

    try {
      while (data.next()) {
          ClienteTO clienteTO = new ClienteTO();

          clienteTO.setIdCliente(data.getInt("IdCliente"));
          clienteTO.setCedula(data.getInt("Cedula"));
          clienteTO.setNombre(data.getString("Nombre"));

          if (data.getString("Mensualidad") != null) {
              clienteTO.setMensualidad(LocalDate.parse(data.getString("Mensualidad")));
          } else {
              clienteTO.setMensualidad(null);
          }

          clientes.add(clienteTO);
      }

    } catch (SQLException ex) {
        System.out.println("error al cargar los datos" + ex.getMessage());
    }

    return clientes;
  }

  public void crearCliente(ClienteTO cliente) {
      LocalDate fechaActual;
      fechaActual = LocalDate.parse(LocalDate.now().format(DateTimeFormatter.ISO_DATE));

      StringBuffer query = new StringBuffer();
      if (cliente.getMensualidad() != null) query.append("insert into Cliente(Cedula, Nombre, Mensualidad) values(");
      if (cliente.getMensualidad() == null) query.append("insert into Cliente(Cedula, Nombre) values(");

      query.append(cliente.getCedula()).append(",");
      query.append("'").append(cliente.getNombre()).append("'");

      if (cliente.getMensualidad() != null) query.append(", '").append(fechaActual).append("'");
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








