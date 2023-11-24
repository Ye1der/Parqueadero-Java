package Main;

import Models.ClienteDAO;
import Models.EstacionamientoDAO;
import Models.VehiculoDAO;

import java.util.Map;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    ClienteDAO cliente = new ClienteDAO();
    EstacionamientoDAO estacionamiento = new EstacionamientoDAO();
    VehiculoDAO vehiculo = new VehiculoDAO();
    Scanner entrada = new Scanner(System.in);
    
    // cliente.crearCliente(1234567899, "Alberto", false);
    // cliente.crearCliente(1234567890, "Jaimito", true);
    // cliente.eliminarCliente(1234567899);

      //ArrayList<Map<String, String>> result = cliente.listar();

     /* for (Map<String, String> data : result) {
          System.out.println("id: " + data.get("id"));
          System.out.println("cedula: " + data.get("cedula"));
          System.out.println("nombre: " + data.get("nombre"));
          System.out.println("mensualidad: " + data.get("mensualidad") + "\n");
      }*/
      
      //estacionamiento.eliminarEstacionamiento(5);
      //System.out.println(estacionamiento.estacionamientosVacios());
      
      System.out.println(vehiculo.Listar());
      System.out.println("Ingrese la Placa");
      String Placa = entrada.next();
      System.out.println(vehiculo.BuscarxPlaca(Placa));
  }
}
