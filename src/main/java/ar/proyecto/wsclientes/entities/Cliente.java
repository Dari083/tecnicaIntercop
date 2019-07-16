package ar.proyecto.wsclientes.entities;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;

import ar.proyecto.wsclientes.utils.ClienteUtils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "CLIENTES")
@ApiModel(description = "Detalles Cliente. ")
public class Cliente {
	
	@JsonIgnore
	@Id
	@GeneratedValue(generator = "assigned")
	@Column(name = "ID", unique= true )
	private int id;
	
	@Column(name = "NOMBRE",nullable = false, length = 25)
	@ApiModelProperty("Tamaño max 25 caracteres, no puede ser nulo")
	private String nombre;
	
	@Column(name = "APELLIDO",nullable = false, length = 25)
	@ApiModelProperty("Tamaño max 25 caracteres, no puede ser nulo")
	private String apellido;
	
	@Column(name = "EDAD")
	@ApiModelProperty("Número entero no puede ser nulo")
	private int edad;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	@Column(name = "FECHA_NACIMIENTO")
	@ApiModelProperty("Pattern dd/MM/yyyy")
	private LocalDate fechaNacimiento;
	
	@Column(name = "FECHA_PROBABLE_MUERTE")
	@ApiModelProperty("Pattern dd/MM/yyyy")
	private LocalDate fechaProbableMuerte;
	
	public static int PROMEDIO_VIDA_HOMBRE = 73;
	public static int PROMEDIO_VIDA_MUJER = 80;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacmiento) {
		this.fechaNacimiento = fechaNacmiento;
		this.fechaProbableMuerte = fechaProbableMuerte();
	}
	public LocalDate getFechaProbableMuerte() {
		return fechaProbableMuerte;
	}
	
	private LocalDate fechaProbableMuerte() {
		int restantes = PROMEDIO_VIDA_HOMBRE - this.edad;
		LocalDate fechaMuerte = this.fechaNacimiento.plusYears(restantes);
		return fechaMuerte;
	}
}
