package Controllers;

import Models.ClienteDAO;
import TOs.ClienteTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ClienteCtrl {
    ClienteDAO cliente = new ClienteDAO();

    private ArrayList<ClienteTO> consultar(boolean mensualidad) {
        ResultSet data = cliente.consultar(mensualidad);
        ArrayList<ClienteTO> clientes = new ArrayList<>();

        try {
            while (data.next()) {
                ClienteTO clienteTO = new ClienteTO();

                clienteTO.setIdCliente(data.getInt("IdCliente"));
                clienteTO.setCedula(data.getInt("Cedula"));
                clienteTO.setNombre(data.getString("Nombre"));

                if (data.getString("Mensualidad") != null) {
                    clienteTO.setMensualidad(LocalDate.parse(data.getString("Mensualidad")));
                } else {
                    clienteTO.setMensualidad(null);
                }

                clientes.add(clienteTO);
            }

        } catch (SQLException ex) {
            System.out.println("error al cargar los datos" + ex.getMessage());
        }

        return clientes;
    }

    public ArrayList<ClienteTO> listar(){
        return consultar(false);
    }

    public ArrayList<ClienteTO> listarMensualidad() {
        return consultar(true);
    }

    public void crearCliente(ClienteTO clienteTO){
        cliente.crearCliente(clienteTO);
    }

    public void renovarMensualidad(int cedula) {
        cliente.renovarMensualidad(cedula);
    }

    public void eliminarCliente(int cedula) {
        cliente.eliminarCliente(cedula);
    }
}
