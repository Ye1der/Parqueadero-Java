package Models;

import DB.ConnectionDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EstacionamientoDAO {
    private void actualizarEstado(boolean ocupar) {
        int id = -1;
        int buscar = 1;
        int actualizar = 0;

        if (ocupar) {
            buscar = 0;
            actualizar = 1;
        }

        String queryConsult = "select IdEstacionamiento from Estacionamiento where Ocupado = " + buscar + " limit 1";
        ConnectionDB connection = new ConnectionDB();
        ResultSet idResult = connection.consult(queryConsult);

        try {
            if (idResult.next()) id = idResult.getInt("IdEstacionamiento");
        } catch (SQLException ex) {
            System.out.println("error al obtener un id de estacionamiento ocupado: " + ex.getMessage());
        }

        String queryVaciar = "update Estacionamiento set Ocupado = " + actualizar + " where IdEstacionamiento = " + id;
        connection.execute(queryVaciar);
        connection.closeConnection();
    }

    public void vaciar() {
        actualizarEstado(false);
    }

    public  void ocupar() {
        actualizarEstado(true);
    }

    private ArrayList<Map<String, String>> listar(boolean ocupado) {
        int estado = 0;
        if (ocupado) estado = 1;

        String query = "select * from Estacionameinto where Ocupado = " + estado;
        ConnectionDB connection = new ConnectionDB();
        ResultSet result = connection.consult(query);
        ArrayList<Map<String, String>> estacionamientos = new ArrayList<>();

        try {
            while (result.next()) {
                Map<String, String> data = new HashMap<>();
                data.put("id", result.getString("IdEstacionamiento"));
                data.put("numero", result.getString("Numero"));
                data.put("estado", result.getString("Ocupado"));

                estacionamientos.add(data);
            }
        } catch (SQLException ex) {
            System.out.println("Error al listar los estacionamientos: " + ex.getMessage());
        }

        return estacionamientos;
    }


}
