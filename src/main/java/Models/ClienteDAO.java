package Models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import DB.ConnectionDB;

import java.util.HashMap;

public class ClienteDAO {

  public ArrayList<Map<String, String>> listar() {
    ConnectionDB connection = new ConnectionDB();
    ResultSet result = connection.consult("select * from cliente");
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
}