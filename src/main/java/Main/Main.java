package Main;

import Models.ClienteDAO;

import java.util.Map;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    ClienteDAO cliente = new ClienteDAO();

    ArrayList<Map<String, String>> result = cliente.listar();

    System.out.println(result);
  }
}
