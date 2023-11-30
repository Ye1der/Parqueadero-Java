package Models;

import DB.ConnectionDB;
import TOs.EstacionamientoTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EstacionamientoDAO {
    public boolean actualizarEstado(boolean ocupar) {
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
            if (idResult.next()) {
                id = idResult.getInt("IdEstacionamiento");
            } else
                return false;
        } catch (SQLException ex) {
            System.out.println("error al obtener un id de estacionamiento ocupado: " + ex.getMessage());
        }

        String queryVaciar = "update Estacionamiento set Ocupado = " + actualizar + " where IdEstacionamiento = " + id;
        connection.execute(queryVaciar);
        connection.closeConnection();

        return true;
    }

    public ArrayList<EstacionamientoTO> listar(boolean ocupado) {
        int estado = 0;
        if (ocupado)
            estado = 1;

        String query = "select * from Estacionamiento where Ocupado = " + estado;
        ConnectionDB connection = new ConnectionDB();
        ResultSet data = connection.consult(query);

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

        connection.closeConnection();

        return estacionamientos;
    }

    public void agregarEstacionamiento(int numero) {
        StringBuffer query = new StringBuffer();
        query.append("insert into Estacionamiento(Numero, Ocupado) values(");
        query.append(numero).append(", ");
        query.append(0).append(")");

        ConnectionDB connection = new ConnectionDB();
        connection.execute(query.toString());
        connection.closeConnection();
    }

    public void eliminarEstacionamiento(int numero) {
        String query = "delete from EStacionamiento where Numero = " + numero;
        ConnectionDB connection = new ConnectionDB();
        connection.execute(query);
        connection.closeConnection();
    }
}
