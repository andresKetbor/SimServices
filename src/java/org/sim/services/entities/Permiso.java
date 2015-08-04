package org.sim.services.entities;
// Generated 03/08/2015 20:25:36 by Hibernate Tools 3.2.1.GA


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Permiso generated by hbm2java
 */
@Entity
@Table(name="permiso"
    ,catalog="sim"
)
public class Permiso  implements java.io.Serializable {


     private Integer idPermiso;
     private String accion;

    public Permiso() {
    }

    public Permiso(String accion) {
       this.accion = accion;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="idPermiso", unique=true, nullable=false)
    public Integer getIdPermiso() {
        return this.idPermiso;
    }
    
    public void setIdPermiso(Integer idPermiso) {
        this.idPermiso = idPermiso;
    }
    
    @Column(name="Accion", nullable=false, length=25)
    public String getAccion() {
        return this.accion;
    }
    
    public void setAccion(String accion) {
        this.accion = accion;
    }




}


