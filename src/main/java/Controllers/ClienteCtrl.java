package Controllers;

import Models.ClienteDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ClienteCtrl {
    ClienteDAO cliente = new ClienteDAO();

    private ArrayList<Map<String, String>> consultar(boolean mensualidad) {
        ResultSet data = cliente.consultar(mensualidad);
        ArrayList<Map<String, String>> clientes = new ArrayList<>();

        try {
            while (data.next()) {
                Map<String, String> mapa = new HashMap<>();

                mapa.put("id", data.getString("IdCliente"));
                mapa.put("cedula", data.getString("Cedula"));
                mapa.put("nombre", data.getString("Nombre"));
                mapa.put("mensualidad", data.getString("Mensualidad"));

                clientes.add(mapa);
            }

        } catch (SQLException ex) {
            System.out.println("error al cargar los datos" + ex.getMessage());
        }

        return clientes;
    }

    public ArrayList<Map<String, String>> listar(){
        return consultar(false);
    }

    public ArrayList<Map<String, String>> listarMensualidad() {
        return consultar(true);
    }

    public void crearCliente(int cedula, String nombre, boolean mensualidad){
        cliente.crearCliente(cedula, nombre, mensualidad);
    }

    public void renovarMensualidad(int cedula) {
        cliente.renovarMensualidad(cedula);
    }

    public void eliminarCliente(int cedula) {
        cliente.eliminarCliente(cedula);
    }
}
