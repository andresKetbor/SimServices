package org.sim.services.entities.common.daos;


import org.sim.services.entities.Visita;
import org.sim.services.entities.common.GenericDao;


public class VisitaDao extends GenericDao<Visita> {

    public VisitaDao() {
        super(Visita.class);
    }

    
    public Visita findById(long id) {
        return super.findById(id);
    }

    
    
}
