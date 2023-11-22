package TOs;

public class EstacionamientoTO {
    private int IdEstacionamiento;
    private int Numero;
    private String Estado;

    public EstacionamientoTO(int IdEstacionamiento, int Numero, String Estado) {
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

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
}
