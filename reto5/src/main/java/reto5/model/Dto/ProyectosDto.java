package reto5.model.Dto;

public class ProyectosDto {
    private Integer ID_Proyecto;
    private String Constructora;
    private Integer Numero_Habitaciones;
    private String Ciudad;

    public Integer getID_Proyecto() {
        return ID_Proyecto;
    }
    public void setID_Proyecto(Integer iD_Proyecto) {
        ID_Proyecto = iD_Proyecto;
    }
    public String getConstructora() {
        return Constructora;
    }
    public void setConstructora(String constructora) {
        Constructora = constructora;
    }
    public Integer getNumero_Habitaciones() {
        return Numero_Habitaciones;
    }
    public void setNumero_Habitaciones(Integer numero_Habitaciones) {
        Numero_Habitaciones = numero_Habitaciones;
    }
    public String getCiudad() {
        return Ciudad;
    }
    public void setCiudad(String ciudad) {
        Ciudad = ciudad;
    } 
}
