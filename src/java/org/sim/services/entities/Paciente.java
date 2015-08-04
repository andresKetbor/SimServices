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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Paciente generated by hbm2java
 */
@Entity
@Table(name="paciente"
    ,catalog="sim"
    , uniqueConstraints = @UniqueConstraint(columnNames="DNI") 
)
public class Paciente  implements java.io.Serializable {


     private Integer idPaciente;
     private int dni;
     private String nombre;
     private String apellido;
     private int edad;
     private float altura;
     private float peso;
     private Set<LibroReport> libroreportsForIdPaciente = new HashSet<LibroReport>(0);
     private Set<LibroReport> libroreportsForIdLibroReport = new HashSet<LibroReport>(0);

    public Paciente() {
    }

	
    public Paciente(int dni, String nombre, String apellido, int edad, float altura, float peso) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.altura = altura;
        this.peso = peso;
    }
    public Paciente(int dni, String nombre, String apellido, int edad, float altura, float peso, Set<LibroReport> libroreportsForIdPaciente, Set<LibroReport> libroreportsForIdLibroReport) {
       this.dni = dni;
       this.nombre = nombre;
       this.apellido = apellido;
       this.edad = edad;
       this.altura = altura;
       this.peso = peso;
       this.libroreportsForIdPaciente = libroreportsForIdPaciente;
       this.libroreportsForIdLibroReport = libroreportsForIdLibroReport;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="idPaciente", unique=true, nullable=false)
    public Integer getIdPaciente() {
        return this.idPaciente;
    }
    
    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }
    
    @Column(name="DNI", unique=true, nullable=false)
    public int getDni() {
        return this.dni;
    }
    
    public void setDni(int dni) {
        this.dni = dni;
    }
    
    @Column(name="Nombre", nullable=false, length=30)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Column(name="Apellido", nullable=false, length=30)
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    @Column(name="Edad", nullable=false)
    public int getEdad() {
        return this.edad;
    }
    
    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    @Column(name="Altura", nullable=false, precision=12, scale=0)
    public float getAltura() {
        return this.altura;
    }
    
    public void setAltura(float altura) {
        this.altura = altura;
    }
    
    @Column(name="Peso", nullable=false, precision=12, scale=0)
    public float getPeso() {
        return this.peso;
    }
    
    public void setPeso(float peso) {
        this.peso = peso;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="pacienteByIdPaciente")
    public Set<LibroReport> getLibroreportsForIdPaciente() {
        return this.libroreportsForIdPaciente;
    }
    
    public void setLibroreportsForIdPaciente(Set<LibroReport> libroreportsForIdPaciente) {
        this.libroreportsForIdPaciente = libroreportsForIdPaciente;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="pacienteByIdLibroReport")
    public Set<LibroReport> getLibroreportsForIdLibroReport() {
        return this.libroreportsForIdLibroReport;
    }
    
    public void setLibroreportsForIdLibroReport(Set<LibroReport> libroreportsForIdLibroReport) {
        this.libroreportsForIdLibroReport = libroreportsForIdLibroReport;
    }




}


