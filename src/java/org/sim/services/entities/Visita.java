package org.sim.services.entities;
// Generated 06/08/2015 15:00:36 by Hibernate Tools 3.6.0


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Visita generated by hbm2java
 */
@Entity
@Table(name="Visita"
    ,catalog="SIM2"
)
public class Visita  implements java.io.Serializable {


     private Integer idVisita;
     private Date fechaVisita;
     private Float frecuencia;

    public Visita() {
    }

	
    public Visita(Date fechaVisita) {
        this.fechaVisita = fechaVisita;
    }
    public Visita(Date fechaVisita, Float frecuencia) {
       this.fechaVisita = fechaVisita;
       this.frecuencia = frecuencia;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idVisita", unique=true, nullable=false)
    public Integer getIdVisita() {
        return this.idVisita;
    }
    
    public void setIdVisita(Integer idVisita) {
        this.idVisita = idVisita;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="FechaVisita", nullable=false, length=10)
    public Date getFechaVisita() {
        return this.fechaVisita;
    }
    
    public void setFechaVisita(Date fechaVisita) {
        this.fechaVisita = fechaVisita;
    }

    
    @Column(name="Frecuencia", precision=12, scale=0)
    public Float getFrecuencia() {
        return this.frecuencia;
    }
    
    public void setFrecuencia(Float frecuencia) {
        this.frecuencia = frecuencia;
    }




}


