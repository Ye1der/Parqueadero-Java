package Main;

import Models.ClienteDAO;

import java.util.Map;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    ClienteDAO cliente = new ClienteDAO();

    cliente.crearCliente(1234567890, "Delgado", false);

    ArrayList<Map<String, String>> result = cliente.listar(false);

    System.out.println(result);
  }
}
