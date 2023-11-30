package Controllers;

import Models.FacturaDAO;
import TOs.FacturaTO;

public class FacturaCtrl {
    FacturaDAO facturaDao = new FacturaDAO();

    public void horaEntrada (String placa) {
        try {
            facturaDao.crearHoraEntrada(placa);
        } catch (Exception ex) {
            System.out.println("Error al registrar la hora de entrada: " + ex.getMessage());
        }
    }

    public FacturaTO generarFactura (String placa) {
        try {
            return facturaDao.generarFactura(placa);
        } catch (Exception ex) {
            System.out.println("Error al registrar la hora de entrada: " + ex.getMessage());
            return null;
        }
    }
}
