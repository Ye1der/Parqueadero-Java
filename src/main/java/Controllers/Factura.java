package Controllers;

import Models.FacturaDAO;

public class Factura {
    FacturaDAO facturaDao = new FacturaDAO();

    public void horaEntrada (String placa) {
        try {
            facturaDao.crearHoraEntrada(placa);
        } catch (Exception ex) {
            System.out.println("Error al registrar la hora de entrada: " + ex.getMessage());
        }
    }

    public void generarFactura (String placa) {
        try {
            facturaDao.generarFactura(placa);
        } catch (Exception ex) {
            System.out.println("Error al registrar la hora de entrada: " + ex.getMessage());
        }
    }
}
