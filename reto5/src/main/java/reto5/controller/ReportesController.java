package reto5.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import reto5.model.Dao.ComprasDao;
import reto5.model.Dao.LiderDao;
import reto5.model.Dao.ProyectosDao;
import reto5.model.Dto.ComprasDto;
import reto5.model.Dto.LiderDto;
import reto5.model.Dto.ProyectosDto;

public class ReportesController {
    private LiderDao LiderDao;
    private ProyectosDao ProyectosDao;
    private ComprasDao ComprasDao;

    public ReportesController() {
        LiderDao = new LiderDao();
        ProyectosDao = new ProyectosDao();
        ComprasDao = new ComprasDao();
    }

    public List<LiderDto> ListarLideres() throws SQLException, IOException{
        return LiderDao.ListarLideres();
    }
    public List<ProyectosDto> ListarProyectos() throws SQLException, IOException{
        return ProyectosDao.ListarProyectos();
    }
    public List<ComprasDto> ListarCompras() throws SQLException, IOException{
        return ComprasDao.ListarCompras();
    }
}
