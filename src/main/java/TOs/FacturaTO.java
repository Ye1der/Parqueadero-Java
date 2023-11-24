package TOs;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class FacturaTO {
    private int IdFactura;
    private double Precio;
    private LocalDateTime FechaEntrada;
    private LocalDateTime FechaSalida;
    private int IdCliente;
    private int IdVehiculo;
    private int IdEstacionamiento;

    public FacturaTO(int IdFactura, double Precio, LocalDateTime FechaEntrada, LocalDateTime FechaSalida, int IdCliente, int IdVehiculo, int IdEstacionamiento) {
        this.IdFactura = IdFactura;
        this.Precio = Precio;
        this.FechaEntrada = FechaEntrada;
        this.FechaSalida = FechaSalida;
        this.IdCliente = IdCliente;
        this.IdVehiculo = IdVehiculo;
        this.IdEstacionamiento = IdEstacionamiento;
    }
    
    public FacturaTO(){
        
    }

    public int getIdFactura() {
        return IdFactura;
    }

    public void setIdFactura(int IdFactura) {
        this.IdFactura = IdFactura;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public LocalDateTime getFechaEntrada() {
        return FechaEntrada;
    }

    public void setFechaEntrada(LocalDateTime FechaEntrada) {
        this.FechaEntrada = FechaEntrada;
    }

    public LocalDateTime getFechaSalida() {
        return FechaSalida;
    }

    public void setFechaSalida(LocalDateTime FechaSalida) {
        this.FechaSalida = FechaSalida;
    }

    public int getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }

    public int getIdVehiculo() {
        return IdVehiculo;
    }

    public void setIdVehiculo(int IdVehiculo) {
        this.IdVehiculo = IdVehiculo;
    }

    public int getIdEstacionamiento() {
        return IdEstacionamiento;
    }

    public void setIdEstacionamiento(int IdEstacionamiento) {
        this.IdEstacionamiento = IdEstacionamiento;
    }
    
}
