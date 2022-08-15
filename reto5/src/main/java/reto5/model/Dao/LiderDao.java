package reto5.model.Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import reto5.model.Dto.LiderDto;
import reto5.utils.JDBCUtilities;

public class LiderDao {
    public List<LiderDto> ListarLideres() throws SQLException, IOException{
        List<LiderDto> lideres = new ArrayList<LiderDto>();

        Connection conn = JDBCUtilities.getConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;
        String consulta = "select ID_Lider, Nombre, Primer_Apellido, Ciudad_Residencia from Lider l ORDER BY Ciudad_Residencia ASC";

        try {
            stm = conn.prepareStatement(consulta);
            rs = stm.executeQuery();

            while(rs.next()){
                LiderDto lider = new LiderDto();
                lider.setID(rs.getInt("ID_Lider"));
                lider.setNombre(rs.getString("Nombre"));
                lider.setPrimerApellido(rs.getString("Primer_Apellido"));
                lider.setCiudadResidencia(rs.getString("Ciudad_Residencia"));
                lideres.add(lider);
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
        return lideres;
    }
}
