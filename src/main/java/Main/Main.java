package Main;

import Controllers.ClienteCtrl;
import Models.ClienteDAO;
import Models.EstacionamientoDAO;
import Models.FacturaDAO;
import TOs.ClienteTO;
import TOs.FacturaTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
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
  }
}
