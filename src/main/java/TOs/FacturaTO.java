package TOs;

import java.time.LocalDateTime;

public class FacturaTO {
    private int IdFactura;
    private int Precio;
    private LocalDateTime FechaEntrada;
    private LocalDateTime FechaSalida;
    private String placa;

    public FacturaTO(int IdFactura, int Precio, LocalDateTime FechaEntrada, LocalDateTime FechaSalida, String placa) {
        this.IdFactura = IdFactura;
        this.Precio = Precio;
        this.FechaEntrada = FechaEntrada;
        this.FechaSalida = FechaSalida;
        this.placa = placa;
    }

    public FacturaTO() {

    }

    public int getIdFactura() {
        return IdFactura;
    }

    public void setIdFactura(int IdFactura) {
        this.IdFactura = IdFactura;
    }

    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int Precio) {
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

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}
