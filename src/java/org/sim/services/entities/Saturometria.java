package org.sim.services.entities;
// Generated 03/08/2015 20:25:36 by Hibernate Tools 3.2.1.GA


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Saturometria generated by hbm2java
 */
@Entity
@Table(name="saturometria"
    ,catalog="sim"
)
public class Saturometria  implements java.io.Serializable {


     private int idMedicion;
     private float oxigenoEnSangre;

    public Saturometria() {
    }

    public Saturometria(int idMedicion, float oxigenoEnSangre) {
       this.idMedicion = idMedicion;
       this.oxigenoEnSangre = oxigenoEnSangre;
    }
   
     @Id 
    
    @Column(name="idMedicion", unique=true, nullable=false)
    public int getIdMedicion() {
        return this.idMedicion;
    }
    
    public void setIdMedicion(int idMedicion) {
        this.idMedicion = idMedicion;
    }
    
    @Column(name="OxigenoEnSangre", nullable=false, precision=12, scale=0)
    public float getOxigenoEnSangre() {
        return this.oxigenoEnSangre;
    }
    
    public void setOxigenoEnSangre(float oxigenoEnSangre) {
        this.oxigenoEnSangre = oxigenoEnSangre;
    }




}


