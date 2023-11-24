package Controllers;

import Models.EstacionamientoDAO;
import TOs.EstacionamientoTO;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EstacionamientoCtrl {
    EstacionamientoDAO estacionamiento = new EstacionamientoDAO();

    private ArrayList<EstacionamientoTO> listar(boolean ocupado) {
        ResultSet data = estacionamiento.listar(ocupado);
        ArrayList<EstacionamientoTO> estacionamientos = new ArrayList<>();

        try {
            while (data.next()) {
                EstacionamientoTO estacionamientoTO = new EstacionamientoTO();
                estacionamientoTO.setIdEstacionamiento(data.getInt("IdEstacionamiento"));
                estacionamientoTO.setNumero(data.getInt("Numero"));
                estacionamientoTO.setEstado(data.getInt("Ocupado") == 1);

                estacionamientos.add(estacionamientoTO);
            }
        } catch (SQLException ex) {
            System.out.println("Error al listar los estacionamientos: " + ex.getMessage());
        }

        return estacionamientos;
    }

    public ArrayList<EstacionamientoTO> estacionamientosVacios() {
        return listar(false);
    }

    public ArrayList<EstacionamientoTO> estacionamientosOcupados() {
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
