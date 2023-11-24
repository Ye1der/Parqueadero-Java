package Main;

import Models.ClienteDAO;
import Models.EstacionamientoDAO;

import java.util.Map;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    ClienteDAO cliente = new ClienteDAO();
      EstacionamientoDAO estacionamiento = new EstacionamientoDAO();

    // cliente.crearCliente(1234567899, "Alberto", false);
    // cliente.crearCliente(1234567890, "Jaimito", true);
    // cliente.eliminarCliente(1234567899);

      ArrayList<Map<String, String>> result = cliente.listar();

      for (Map<String, String> data : result) {
          System.out.println("id: " + data.get("id"));
          System.out.println("cedula: " + data.get("cedula"));
          System.out.println("nombre: " + data.get("nombre"));
          System.out.println("mensualidad: " + data.get("mensualidad") + "\n");
      }

      estacionamiento.eliminarEstacionamiento(5);
      System.out.println(estacionamiento.estacionamientosVacios());
  }
}
