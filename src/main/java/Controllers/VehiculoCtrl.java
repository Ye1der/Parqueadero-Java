package Controllers;

import java.util.*;
import TOs.VehiculoTO;
import Models.VehiculoDAO;
        
public class VehiculoCtrl {

    public ArrayList<VehiculoTO> ListarVehiculo(){
        try {
            VehiculoDAO daoVehiculo = new VehiculoDAO();
            return daoVehiculo.ListarVehiculo();
            
        } catch (Exception ex) {
            System.out.println("error al listar los vehiculoTOs" + ex.getMessage());
            return null;
        }
    }
    
    public VehiculoTO BuscarxPlaca(String Placa){
        try {
            VehiculoDAO daoVehiculo = new VehiculoDAO();
            return daoVehiculo.BuscarxPlaca(Placa);
            
        } catch (Exception ex) {
            System.out.println("error al listar los vehiculoTOs" + ex.getMessage());
            return null;
        }
    }
    
    public boolean InsertarVehiculo(VehiculoTO vehiculoTO){
        try {
            VehiculoDAO daoVehiculo = new VehiculoDAO();
            return daoVehiculo.InsertarVehiculo(vehiculoTO);
            
        } catch (Exception ex) {
            System.out.println("Error al insertar en la DB" + ex.getMessage());
            return false;
        }
    }
    
    public boolean ActualizarVehiculo(VehiculoTO vehiculoTO){
        try {
            VehiculoDAO daoVehiculo = new VehiculoDAO();
            return daoVehiculo.ActualizarVehiculo(vehiculoTO);
        
        } catch (Exception ex) {
            System.out.println("Error al actualizar en la DB" + ex.getMessage());
            return false;
        }
    }
    
    public boolean EliminarVehiculo(String Placa){
        try {
        VehiculoDAO daoVehiculo = new VehiculoDAO();
        return daoVehiculo.EliminarVehiculo(Placa);
            
        } catch (Exception ex) {
            System.out.println("error al eliminar el vehiculoTO" + ex.getMessage());
            return false;
        }
    }
}
