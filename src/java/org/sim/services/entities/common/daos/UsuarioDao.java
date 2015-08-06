package org.sim.services.entities.common.daos;


import org.sim.services.entities.Usuario;
import org.sim.services.entities.common.GenericDao;


public class UsuarioDao extends GenericDao<Usuario> {

    public UsuarioDao() {
        super(Usuario.class);
    }

    

    public Usuario findById(long id) {
        return super.findById(id);
    }

    


  
    
}
