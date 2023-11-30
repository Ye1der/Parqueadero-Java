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
        try {
            EstacionamientoDAO estacionamiento = new EstacionamientoDAO();
            return estacionamiento.listar(ocupado);
        } catch (Exception ex) {
            System.out.println("Error al traer los datos de estacionamientos: " + ex.getMessage());
            return null;
        }
    }

    public ArrayList<EstacionamientoTO> estacionamientosVacios() {
        return listar(false);
    }

    public ArrayList<EstacionamientoTO> estacionamientosOcupados() {
        return listar(true);
    }

    public boolean vaciar(){
        return estacionamiento.actualizarEstado(false);
    }

    public boolean ocupar(){
        return estacionamiento.actualizarEstado(true);
    }

    public void agregar(int numero){
        estacionamiento.agregarEstacionamiento(numero);
    }

    public void eliminar(int numero) {
        estacionamiento.eliminarEstacionamiento(numero);
    }
}
