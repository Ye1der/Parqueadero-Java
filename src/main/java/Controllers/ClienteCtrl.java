package Controllers;

import Models.ClienteDAO;
import TOs.ClienteTO;

import java.util.ArrayList;

public class ClienteCtrl {
    ClienteDAO cliente = new ClienteDAO();

    public ArrayList<ClienteTO> consultar (boolean mensualidad, String nombre, String cedula) {
        try {
            return cliente.consultar(mensualidad, nombre, cedula);
        } catch (Exception e) {
           System.out.println("Error al consultar los clientes: " + e.getMessage());
           return null;
        }
    }

    public void crearCliente(ClienteTO clienteTO){
        try {
            cliente.crearCliente(clienteTO);
        } catch (Exception e) {
            System.out.println("Error al cliente: " + e.getMessage());
        }
    }

    public void renovarMensualidad(int cedula) {
        try {
            cliente.renovarMensualidad(cedula);
        } catch (Exception e) {
            System.out.println("Error al renovar la mensualidad de el cliente " + cedula + ": " + e.getMessage());
        }
    }

    public void eliminarCliente(int cedula) {
        try {
            cliente.eliminarCliente(cedula);
        } catch (Exception e) {
            System.out.println("Error al eliminar el cliente " + cedula + ": " + e.getMessage());
        }
    }
}
