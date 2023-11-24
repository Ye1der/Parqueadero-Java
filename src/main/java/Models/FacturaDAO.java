package Models;

import DB.ConnectionDB;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FacturaDAO {

    public void crearHoraEntrada(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String query = "insert into Factura(FechaEntrada) values('"
                + LocalDateTime.now().format(formatter) + "')";

        ConnectionDB connection = new ConnectionDB();
        connection.execute(query);
        connection.closeConnection();
    }
}
