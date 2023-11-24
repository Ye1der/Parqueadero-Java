package Models;

import DB.ConnectionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VehiculoDAO {
    /*Listar
      Buscar por placa
      Crear
      Eliminar
      Actualizar
    */
    ConnectionDB connection = new ConnectionDB();

    public ArrayList<Map> Listar(){
        try {
            connection = new ConnectionDB();
            String query = "select * from Vehiculo";
            ResultSet dataVehiculos = connection.consult(query);
            ArrayList<Map> vehiculos = new ArrayList<>();
            
            while(dataVehiculos.next()){
                Map vehiculo = new HashMap();
                vehiculo.put("IdVehiculo", dataVehiculos.getString("IdVehiculo"));
                vehiculo.put("Placa",dataVehiculos.getString("Placa"));
                vehiculo.put("Modelo", dataVehiculos.getString("Modelo"));
                vehiculo.put("Color",dataVehiculos.getString("Color"));
                vehiculo.put("Tipo",dataVehiculos.getString("Tipo"));
                vehiculos.add(vehiculo);
            }
            
            connection.closeConnection();
            return vehiculos;
            
        } catch (RuntimeException | SQLException ex) {
            System.out.println("error al listar los vehiculos" + ex.getMessage());
            return null;
        }
    }
    
    public Map BuscarxPlaca(String Placa){
        try {
            Map vehiculo = new HashMap();
            connection = new ConnectionDB();
            String query = "select * from Vehiculo where Placa = '"+Placa+"';";
            ResultSet dataVehiculos = connection.consult(query);
            
            vehiculo.put("IdVehiculo", dataVehiculos.getString("IdVehiculo"));
            vehiculo.put("Placa",dataVehiculos.getString("Placa"));
            vehiculo.put("Modelo", dataVehiculos.getString("Modelo"));
            vehiculo.put("Color",dataVehiculos.getString("Color"));
            vehiculo.put("Tipo",dataVehiculos.getString("Tipo"));
            
            connection.closeConnection();
            return vehiculo;
            
        } catch (RuntimeException | SQLException ex) {
            System.out.println("error al listar los vehiculos" + ex.getMessage());
            return null;
        }
    }
    
    /*public boolean Insertar(){
        try {
            connection = new ConnectionDB();
            String query = "insert into Vehiculo (Placa, Modelo, Color, Tipo) values('" + ;
            
        } catch (Exception e) {
        }
    }*/
    
    /*public boolean Actualizar(){
        boolean complete;
        connection = new ConnectionDB();
        String query = "update Vehiculo set Placa = '";
    }*/
    
    public void EliminarVehiculo(String Placa){
        try {
        connection = new ConnectionDB();
        String query = "delete from Vehiculo where Placa = '"+Placa+"';";
        connection.execute(query);
        connection.closeConnection();
            
        } catch (RuntimeException ex) {
            System.out.println("error al eliminar el vehiculo" + ex.getMessage());
        }
    }
}
