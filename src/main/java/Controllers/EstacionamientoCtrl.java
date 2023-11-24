package Controllers;

import Models.EstacionamientoDAO;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EstacionamientoCtrl {
    EstacionamientoDAO estacionamiento = new EstacionamientoDAO();

    private ArrayList<Map<String, String>> listar(boolean ocupado) {
        ResultSet data = estacionamiento.listar(ocupado);
        ArrayList<Map<String, String>> estacionamientos = new ArrayList<>();

        try {
            while (data.next()) {
                Map<String, String> table = new HashMap<>();
                table.put("id", data.getString("IdEstacionamiento"));
                table.put("numero", data.getString("Numero"));
                table.put("estado", data.getString("Ocupado"));

                estacionamientos.add(table);
            }
        } catch (SQLException ex) {
            System.out.println("Error al listar los estacionamientos: " + ex.getMessage());
        }

        return estacionamientos;
    }

    public ArrayList<Map<String, String>> estacionamientosVacios() {
        return listar(false);
    }

    public ArrayList<Map<String, String>> estacionamientosOcupados() {
        return listar(true);
    }

    public void vaciar(){
        estacionamiento.actualizarEstado(false);
    }

    public void ocupar(){
        estacionamiento.actualizarEstado(true);
    }

    public void agregar(int numero){
        estacionamiento.agregarEstacionamiento(numero);
    }

    public void eliminar(int numero) {
        estacionamiento.eliminarEstacionamiento(numero);
    }
}
