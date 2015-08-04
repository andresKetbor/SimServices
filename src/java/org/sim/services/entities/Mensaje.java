package org.sim.services.entities;
// Generated 03/08/2015 20:25:36 by Hibernate Tools 3.2.1.GA


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Mensaje generated by hbm2java
 */
@Entity
@Table(name="mensaje"
    ,catalog="sim"
)
public class Mensaje  implements java.io.Serializable {


     private Integer idMensaje;
     private Usuario usuarioByIdUsuarioRemitente;
     private Usuario usuarioByIdUsuaruiDestinatario;
     private Alerta alerta;
     private String texto;

    public Mensaje() {
    }

    public Mensaje(Usuario usuarioByIdUsuarioRemitente, Usuario usuarioByIdUsuaruiDestinatario, Alerta alerta, String texto) {
       this.usuarioByIdUsuarioRemitente = usuarioByIdUsuarioRemitente;
       this.usuarioByIdUsuaruiDestinatario = usuarioByIdUsuaruiDestinatario;
       this.alerta = alerta;
       this.texto = texto;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="idMensaje", unique=true, nullable=false)
    public Integer getIdMensaje() {
        return this.idMensaje;
    }
    
    public void setIdMensaje(Integer idMensaje) {
        this.idMensaje = idMensaje;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idUsuarioRemitente", nullable=false)
    public Usuario getUsuarioByIdUsuarioRemitente() {
        return this.usuarioByIdUsuarioRemitente;
    }
    
    public void setUsuarioByIdUsuarioRemitente(Usuario usuarioByIdUsuarioRemitente) {
        this.usuarioByIdUsuarioRemitente = usuarioByIdUsuarioRemitente;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idUsuaruiDestinatario", nullable=false)
    public Usuario getUsuarioByIdUsuaruiDestinatario() {
        return this.usuarioByIdUsuaruiDestinatario;
    }
    
    public void setUsuarioByIdUsuaruiDestinatario(Usuario usuarioByIdUsuaruiDestinatario) {
        this.usuarioByIdUsuaruiDestinatario = usuarioByIdUsuaruiDestinatario;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idMensaje", unique=true, nullable=false, insertable=false, updatable=false)
    public Alerta getAlerta() {
        return this.alerta;
    }
    
    public void setAlerta(Alerta alerta) {
        this.alerta = alerta;
    }
    
    @Column(name="Texto", nullable=false, length=500)
    public String getTexto() {
        return this.texto;
    }
    
    public void setTexto(String texto) {
        this.texto = texto;
    }




}


