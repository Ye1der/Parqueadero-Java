package TOs;

public class FacturaTO {
    private int IdFactura;
    private double Precio;
    private String FechaEntrada;
    private String FechaSalida;
    private int IdCliente;
    private int IdVehiculo;
    private int IdEstacionamiento;

    public FacturaTO(int IdFactura, double Precio, String FechaEntrada, String FechaSalida, int IdCliente, int IdVehiculo, int IdEstacionamiento) {
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

    public String getFechaEntrada() {
        return FechaEntrada;
    }

    public void setFechaEntrada(String FechaEntrada) {
        this.FechaEntrada = FechaEntrada;
    }

    public String getFechaSalida() {
        return FechaSalida;
    }

    public void setFechaSalida(String FechaSalida) {
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
