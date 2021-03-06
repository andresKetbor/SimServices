package org.sim.services.entities;
// Generated 06/08/2015 15:00:36 by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Accion generated by hbm2java
 */
@Entity
@Table(name="Accion"
    ,catalog="SIM2"
)
public class Accion  implements java.io.Serializable {


     private Integer idAccion;
     private String accion;
     private Set<RolAccion> rolAccions = new HashSet<RolAccion>(0);

    public Accion() {
    }

	
    public Accion(String accion) {
        this.accion = accion;
    }
    public Accion(String accion, Set<RolAccion> rolAccions) {
       this.accion = accion;
       this.rolAccions = rolAccions;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idAccion", unique=true, nullable=false)
    public Integer getIdAccion() {
        return this.idAccion;
    }
    
    public void setIdAccion(Integer idAccion) {
        this.idAccion = idAccion;
    }

    
    @Column(name="Accion", nullable=false, length=30)
    public String getAccion() {
        return this.accion;
    }
    
    public void setAccion(String accion) {
        this.accion = accion;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="accion")
    public Set<RolAccion> getRolAccions() {
        return this.rolAccions;
    }
    
    public void setRolAccions(Set<RolAccion> rolAccions) {
        this.rolAccions = rolAccions;
    }




}


