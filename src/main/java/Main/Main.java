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
      FacturaDAO factura = new FacturaDAO();
      // factura.crearHoraEntrada("XYZ-123");
      factura.generarFactura("XYZ-123");
  }
}
