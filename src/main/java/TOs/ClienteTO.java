package TOs;

import java.time.LocalDate;

public class ClienteTO {
    private int IdCliente;
    private int Cedula;
    private String Nombre;
    private LocalDate Mensualidad = null;

    public ClienteTO(int Cedula, String Nombre, LocalDate Mensualidad) {
        this.Cedula = Cedula;
        this.Nombre = Nombre;
        this.Mensualidad = Mensualidad;
    }

    public ClienteTO() {

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

    public LocalDate getMensualidad() {
        return Mensualidad;
    }

    public void setMensualidad(LocalDate Mensualidad) {
        this.Mensualidad = Mensualidad;
    }
}
