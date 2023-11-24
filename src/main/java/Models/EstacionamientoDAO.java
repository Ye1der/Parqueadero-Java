package Models;

import DB.ConnectionDB;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EstacionamientoDAO {
    public void actualizarEstado(boolean ocupar) {
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

    public ResultSet listar(boolean ocupado) {
        int estado = 0;
        if (ocupado) estado = 1;

        String query = "select * from Estacionamiento where Ocupado = " + estado;
        ConnectionDB connection = new ConnectionDB();
        ResultSet result = connection.consult(query);
        connection.closeConnection();

        return result;
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
