package org.sim.services.entities;
// Generated 03/08/2015 20:25:36 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Usuario generated by hbm2java
 */
@Entity
@Table(name="usuario"
    ,catalog="sim"
)
public class Usuario  implements java.io.Serializable {


     private Integer idUsuario;
     private Rol rol;
     private int dni;
     private int nombre;
     private Set<Mensaje> mensajesForIdUsuarioRemitente = new HashSet<Mensaje>(0);
     private Set<Mensaje> mensajesForIdUsuaruiDestinatario = new HashSet<Mensaje>(0);

    public Usuario() {
    }

	
    public Usuario(Rol rol, int dni, int nombre) {
        this.rol = rol;
        this.dni = dni;
        this.nombre = nombre;
    }
    public Usuario(Rol rol, int dni, int nombre, Set<Mensaje> mensajesForIdUsuarioRemitente, Set<Mensaje> mensajesForIdUsuaruiDestinatario) {
       this.rol = rol;
       this.dni = dni;
       this.nombre = nombre;
       this.mensajesForIdUsuarioRemitente = mensajesForIdUsuarioRemitente;
       this.mensajesForIdUsuaruiDestinatario = mensajesForIdUsuaruiDestinatario;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="idUsuario", unique=true, nullable=false)
    public Integer getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idRol", nullable=false)
    public Rol getRol() {
        return this.rol;
    }
    
    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
    @Column(name="DNI", nullable=false)
    public int getDni() {
        return this.dni;
    }
    
    public void setDni(int dni) {
        this.dni = dni;
    }
    
    @Column(name="Nombre", nullable=false)
    public int getNombre() {
        return this.nombre;
    }
    
    public void setNombre(int nombre) {
        this.nombre = nombre;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="usuarioByIdUsuarioRemitente")
    public Set<Mensaje> getMensajesForIdUsuarioRemitente() {
        return this.mensajesForIdUsuarioRemitente;
    }
    
    public void setMensajesForIdUsuarioRemitente(Set<Mensaje> mensajesForIdUsuarioRemitente) {
        this.mensajesForIdUsuarioRemitente = mensajesForIdUsuarioRemitente;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="usuarioByIdUsuaruiDestinatario")
    public Set<Mensaje> getMensajesForIdUsuaruiDestinatario() {
        return this.mensajesForIdUsuaruiDestinatario;
    }
    
    public void setMensajesForIdUsuaruiDestinatario(Set<Mensaje> mensajesForIdUsuaruiDestinatario) {
        this.mensajesForIdUsuaruiDestinatario = mensajesForIdUsuaruiDestinatario;
    }




}


