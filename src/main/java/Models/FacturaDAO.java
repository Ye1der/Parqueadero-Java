package Models;

import DB.ConnectionDB;
import TOs.FacturaTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class FacturaDAO {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public void crearHoraEntrada(String placa){
        StringBuffer query = new StringBuffer();
        query.append("insert into Factura(FechaEntrada, Placa) values('");
        query.append(LocalDateTime.now().format(formatter)).append("', '");
        query.append(placa).append("')");

        ConnectionDB connection = new ConnectionDB();
        connection.execute(query.toString());
        connection.closeConnection();
    }

    public FacturaTO generarFactura(String placa) throws SQLException {
        String query = "select IdFactura, FechaEntrada from Factura where Precio IS NULL and Placa = '" + placa + "' limit 1";
        ConnectionDB connection = new ConnectionDB();
        ResultSet dataFactura = connection.consult(query);

        int id = 1;
        Integer tiempoParqueado = null;
        LocalDateTime fechaEntrada = null;
        LocalDateTime fechaActual = LocalDateTime.now();

        try {
            if (dataFactura.next()) {
                id = dataFactura.getInt("IdFactura");
                fechaEntrada = LocalDateTime.parse(dataFactura.getString("FechaEntrada"), formatter);
                tiempoParqueado = (int) fechaActual.until(fechaEntrada, ChronoUnit.SECONDS);
            } else return null;
        } catch (SQLException ex) {
            System.out.println("Error al obtener el id de la factura al generar la factura: " + ex.getMessage());
        }

        tiempoParqueado = (int) Math.abs(tiempoParqueado);
        tiempoParqueado = (int) Math.ceil( (float) tiempoParqueado/60/30);

        int precio;
        if (tiempoParqueado < 48) precio = (int) tiempoParqueado * 500;
        else precio = (int) Math.ceil(tiempoParqueado/48) * 5000;

        FacturaTO factura = new FacturaTO(id, precio, fechaEntrada, fechaActual, placa);

        StringBuffer queryUpdate = new StringBuffer();
        queryUpdate.append("UPDATE Factura SET ");
        queryUpdate.append("FechaSalida = '").append(fechaActual.format(formatter)).append("', ");
        queryUpdate.append("Precio = ").append(precio);
        queryUpdate.append(" WHERE IdFactura = ").append(id);

        connection.execute(queryUpdate.toString());
        connection.closeConnection();
        dataFactura.close();

        return factura;
    }

    public ArrayList<FacturaTO> listar(String placa){
        StringBuffer query = new StringBuffer();
        query.append("select * from Factura ");
        if (placa != null) query.append("where Placa = '").append(placa).append("'");

        ConnectionDB connection = new ConnectionDB();
        ResultSet facturasData = connection.consult(query.toString());
        ArrayList<FacturaTO> facturas = new ArrayList<>();

        try {
            while (facturasData.next()) {
                FacturaTO facturaTo = new FacturaTO();

                facturaTo.setIdFactura(facturasData.getInt("IdFactura"));
                facturaTo.setPrecio(facturasData.getInt("Precio"));
                facturaTo.setPlaca(facturasData.getString("PLaca"));
                facturaTo.setFechaEntrada(LocalDateTime.parse(facturasData.getString("FechaEntrada"), formatter));
                facturaTo.setFechaSalida(LocalDateTime.parse(facturasData.getString("FechaSalida"), formatter));

                facturas.add(facturaTo);
            }
        } catch (SQLException ex){
            System.out.println("Error al consultar la lista de facturas" + ex.getMessage());
        }

        return facturas;
    }
}

