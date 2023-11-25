package Main;

import Controllers.ClienteCtrl;
import Models.ClienteDAO;
import Models.EstacionamientoDAO;
<<<<<<< HEAD
import Models.VehiculoDAO;
=======
import Models.FacturaDAO;
import TOs.ClienteTO;
import TOs.FacturaTO;
>>>>>>> dev-Y

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
<<<<<<< HEAD
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
=======
      ClienteCtrl cliente = new ClienteCtrl();

      for (ClienteTO clienteTO : cliente.listar()) {
          System.out.println("id: " + clienteTO.getIdCliente());
          System.out.println("nombre: " + clienteTO.getNombre());
          System.out.println("cedula: " + clienteTO.getCedula());
          System.out.println("mensualidad: " + clienteTO.getMensualidad() + "\n");
      }

      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
      LocalDateTime fechaAhora = LocalDateTime.parse(LocalDateTime.now().format(formatter), formatter);
      System.out.println(LocalDateTime.now().format(formatter));
      System.out.println(fechaAhora);

      FacturaDAO factura = new FacturaDAO();
      factura.crearHoraEntrada();
>>>>>>> dev-Y
  }
}
