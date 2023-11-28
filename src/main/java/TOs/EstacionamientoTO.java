package TOs;

public class EstacionamientoTO {
    private int IdEstacionamiento;
    private int Numero;
    private boolean Estado;

    public EstacionamientoTO(int IdEstacionamiento, int Numero, boolean Estado) {
        this.IdEstacionamiento = IdEstacionamiento;
        this.Numero = Numero;
        this.Estado = Estado;
    }
    
    public EstacionamientoTO(){
        
    }

    public int getIdEstacionamiento() {
        return IdEstacionamiento;
    }

    public void setIdEstacionamiento(int IdEstacionamiento) {
        this.IdEstacionamiento = IdEstacionamiento;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int Numero) {
        this.Numero = Numero;
    }

    public boolean getEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }
    
}
