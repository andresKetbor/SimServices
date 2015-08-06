package org.sim.services.entities.common.daos;


import org.sim.services.entities.LibroReport;
import org.sim.services.entities.common.GenericDao;


public class LibroReportDao extends GenericDao<LibroReport> {

    public LibroReportDao() {
        super(LibroReport.class);
    }

    
    public LibroReport findById(long id) {
        return super.findById(id);
    }

    
    
}
