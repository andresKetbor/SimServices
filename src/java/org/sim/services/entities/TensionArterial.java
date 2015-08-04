package org.sim.services.entities;
// Generated 03/08/2015 20:25:36 by Hibernate Tools 3.2.1.GA


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tensionarterial generated by hbm2java
 */
@Entity
@Table(name="tensionarterial"
    ,catalog="sim"
)
public class TensionArterial  implements java.io.Serializable {


     private int idMedicion;
     private float tensionArterial;

    public TensionArterial() {
    }

    public TensionArterial(int idMedicion, float tensionArterial) {
       this.idMedicion = idMedicion;
       this.tensionArterial = tensionArterial;
    }
   
     @Id 
    
    @Column(name="idMedicion", unique=true, nullable=false)
    public int getIdMedicion() {
        return this.idMedicion;
    }
    
    public void setIdMedicion(int idMedicion) {
        this.idMedicion = idMedicion;
    }
    
    @Column(name="TensionArterial", nullable=false, precision=12, scale=0)
    public float getTensionArterial() {
        return this.tensionArterial;
    }
    
    public void setTensionArterial(float tensionArterial) {
        this.tensionArterial = tensionArterial;
    }




}


