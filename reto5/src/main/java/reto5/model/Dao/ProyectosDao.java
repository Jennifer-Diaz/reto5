package reto5.model.Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import reto5.model.Dto.ProyectosDto;
import reto5.utils.JDBCUtilities;

public class ProyectosDao {
    public List<ProyectosDto> ListarProyectos() throws SQLException, IOException{
      List<ProyectosDto> proyectos = new ArrayList<ProyectosDto>();

      Connection conn = JDBCUtilities.getConnection();
      PreparedStatement stm = null;
      ResultSet rs = null;
      String consulta = "select ID_Proyecto, Constructora, Numero_Habitaciones, Ciudad from Proyecto p where Ciudad IN ('Santa Marta','Cartagena','Barranquilla') and Clasificacion = 'Casa Campestre'";

      try{
        stm = conn.prepareStatement(consulta);
        rs = stm.executeQuery();

        while(rs.next()){
          ProyectosDto proyecto = new ProyectosDto();
          proyecto.setID_Proyecto(rs.getInt("ID_Proyecto"));
          proyecto.setConstructora(rs.getString("Constructora"));
          proyecto.setNumero_Habitaciones(rs.getInt("Numero_Habitaciones"));
          proyecto.setCiudad(rs.getString("Ciudad"));
          proyectos.add(proyecto);
        }
      } catch (Exception e) {
        System.out.println("SQL ERROR: " + e.getMessage());
        throw e;
      } finally{
        if (rs != null){
            rs.close();
        }
        if(stm != null){
            stm.close();
        }
        if(conn !=null){
            conn.close();
        }
      }
      return proyectos; 
    }
}
