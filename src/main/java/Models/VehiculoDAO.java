package Models;

import DB.ConnectionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import TOs.VehiculoTO;
        
public class VehiculoDAO {
    /*Listar
      Buscar por placa
      Crear
      Eliminar
      Actualizar
    */
    ConnectionDB connection = new ConnectionDB();

    public ArrayList<VehiculoTO> ListarVehiculo(){
        try {
            connection = new ConnectionDB();
            String query = "select * from Vehiculo";
            ResultSet dataVehiculos = connection.consult(query);
            ArrayList<VehiculoTO> vehiculoTOs = new ArrayList<>();
            
            while(dataVehiculos.next()){
                VehiculoTO TOvehiculo = new VehiculoTO();
                TOvehiculo.setIdVehiculo(dataVehiculos.getInt("IdVehiculo"));
                TOvehiculo.setPlaca(dataVehiculos.getString("Placa"));
                TOvehiculo.setColor(dataVehiculos.getString("Color"));
                TOvehiculo.setTipo(dataVehiculos.getString("Tipo"));
                vehiculoTOs.add(TOvehiculo);
            }
            
            connection.closeConnection();
            return vehiculoTOs;
            
        } catch (RuntimeException | SQLException ex) {
            System.out.println("error al listar los vehiculoTOs" + ex.getMessage());
            return null;
        }
    }
    
    public VehiculoTO BuscarxPlaca(String Placa){
        try {
            VehiculoTO TOvehiculo = new VehiculoTO();
            connection = new ConnectionDB();
            String query = "select * from Vehiculo where Placa = '"+Placa+"';";
            ResultSet dataVehiculos = connection.consult(query);
            
            TOvehiculo.setIdVehiculo(dataVehiculos.getInt("IdVehiculo"));
            TOvehiculo.setPlaca(dataVehiculos.getString("Placa"));
            TOvehiculo.setColor(dataVehiculos.getString("Color"));
            TOvehiculo.setTipo(dataVehiculos.getString("Tipo"));
            
            connection.closeConnection();
            return TOvehiculo;
            
        } catch (RuntimeException | SQLException ex) {
            System.out.println("error al listar los vehiculoTOs" + ex.getMessage());
            return null;
        }
    }
    
    public boolean InsertarVehiculo(VehiculoTO vehiculoTO){
        try {
            connection = new ConnectionDB();
            String query = "insert into Vehiculo (Placa, Color, Tipo) values('" + vehiculoTO.getPlaca() + 
                    "', '" + vehiculoTO.getColor() + "', '" + vehiculoTO.getTipo() + "')" ;
            return connection.execute(query);
            
        } catch (RuntimeException ex) {
            System.out.println("Error al insertar en la DB" + ex.getMessage());
            return false;
        }
    }
    
    public boolean ActualizarVehiculo(VehiculoTO vehiculoTO){
        try {
            boolean complete;
            connection = new ConnectionDB();
            String query = "update Vehiculo set Placa = '" + vehiculoTO.getPlaca() + "', Modelo = '" + vehiculoTO.getModelo()+
                "', Color = '" + vehiculoTO.getColor() + "', Tipo = '" + vehiculoTO.getTipo();
            complete = connection.execute(query);
            connection.closeConnection();
            return complete;
        
        } catch (RuntimeException ex) {
            System.out.println("Error al actualizar en la DB" + ex.getMessage());
            return false;
        }
    }
    
    public boolean EliminarVehiculo(String Placa){
        try {
            boolean complete;
            connection = new ConnectionDB();
            String query = "delete from Vehiculo where Placa = '"+Placa+"';";
            complete = connection.execute(query);
            connection.closeConnection();
            return complete;
        } catch (RuntimeException ex) {
            System.out.println("error al eliminar el vehiculoTO" + ex.getMessage());
            return false;
        }
    }
}
