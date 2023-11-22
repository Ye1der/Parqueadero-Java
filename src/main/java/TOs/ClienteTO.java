package TOs;

public class ClienteTO {
    private int IdCliente;
    private int Cedula;
    private String Nombre;
    private String Mensualidad;

    public ClienteTO(int IdCliente, int Cedula, String Nombre, String Mensualidad) {
        this.IdCliente = IdCliente;
        this.Cedula = Cedula;
        this.Nombre = Nombre;
        this.Mensualidad = Mensualidad;
    }
    
    public ClienteTO(){
    
    }
    
    public int getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }

    public int getCedula() {
        return Cedula;
    }

    public void setCedula(int Cedula) {
        this.Cedula = Cedula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getMensualidad() {
        return Mensualidad;
    }

    public void setMensualidad(String Mensualidad) {
        this.Mensualidad = Mensualidad;
    }
    
}
