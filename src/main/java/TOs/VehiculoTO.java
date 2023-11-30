package TOs;

public class VehiculoTO {
    private int IdVehiculo;
    private String Placa;
    private String Modelo;
    private String Color;
    private String Tipo;
    private int IdCLiente;

    public VehiculoTO(int IdVehiculo, String Placa, String Modelo, String Color, String Tipo, int IdCLiente) {
        this.IdVehiculo = IdVehiculo;
        this.Placa = Placa;
        this.Modelo = Modelo;
        this.Color = Color;
        this.Tipo = Tipo;
        this.IdCLiente = IdCLiente;
    }

    public VehiculoTO() {

    }

    public int getIdVehiculo() {
        return IdVehiculo;
    }

    public void setIdVehiculo(int IdVehiculo) {
        this.IdVehiculo = IdVehiculo;
    }

    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String Placa) {
        this.Placa = Placa;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public int getIdCLiente() {
        return IdCLiente;
    }

    public void setIdCLiente(int IdCLiente) {
        this.IdCLiente = IdCLiente;
    }

}
