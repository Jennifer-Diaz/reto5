package reto5.model.Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import reto5.model.Dto.ComprasDto;
import reto5.utils.JDBCUtilities;

public class ComprasDao {
    public List<ComprasDto> ListarCompras() throws SQLException, IOException{
        List<ComprasDto> compras = new ArrayList<ComprasDto>();
        Connection conn = JDBCUtilities.getConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;
        String consulta = "select c.ID_Compra, p.Constructora, p.Banco_Vinculado from Compra c JOIN Proyecto p on c.ID_Proyecto = p.ID_Proyecto where c.Proveedor = 'Homecenter' and p.Ciudad = 'Salento'";

        try{
          stm = conn.prepareStatement(consulta);
          rs = stm.executeQuery();
          while(rs.next()){
            ComprasDto compra = new ComprasDto();
            compra.setID_Compra(rs.getInt("ID_Compra"));
            compra.setConstructora(rs.getString("Constructora"));
            compra.setBanco_Vinculado(rs.getString("Banco_Vinculado"));
            compras.add(compra);
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
        return compras;
    }
}
