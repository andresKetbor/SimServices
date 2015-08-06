package org.sim.services.entities.common.daos;


import org.sim.services.entities.Paciente;
import org.sim.services.entities.common.GenericDao;


public class PacienteDao extends GenericDao<Paciente> {

    public PacienteDao() {
        super(Paciente.class);
    }

    
    public Paciente findById(long id) {
        return super.findById(id);
    }

    
    
}
