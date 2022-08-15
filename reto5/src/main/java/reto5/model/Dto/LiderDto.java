package reto5.model.Dto;

public class LiderDto {
    private Integer ID;
    private String Nombre;
    private String PrimerApellido;
    private String CiudadResidencia;
    
    public Integer getID() {
        return ID;
    }
    public void setID(Integer iD) {
        ID = iD;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public String getPrimerApellido() {
        return PrimerApellido;
    }
    public void setPrimerApellido(String primerApellido) {
        PrimerApellido = primerApellido;
    }
    public String getCiudadResidencia() {
        return CiudadResidencia;
    }
    public void setCiudadResidencia(String ciudadResidencia) {
        CiudadResidencia = ciudadResidencia;
    }
}
