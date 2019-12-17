package com.hbt.semillero.entidad;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Rol de los personajes
 * @author Ebert Zerpa
 *
 */
@Entity
@Table(name = "ROL")
public class Rol implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Código unico del ROL
	 */
	@Id
	@SequenceGenerator(allocationSize=1,name="ROL_ID_GENERATOR",sequenceName="SEC_ROL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ROL_ID_GENERATOR")
	@Column(name="ROL_ID")
	private Long id;
	
	/**
	 * Nombre del ROL
	 */
	@Column(name="ROL_NOMBRE")
	private String nombre;
	
	/**
	 * Estado del registro
	 */
	@Column(name="ROL_ESTADO")
	@Enumerated(value = EnumType.STRING)
	private EstadoEnum estado;
	
	
	/**
	 * Constructor de la clase
	 */
	public Rol() {	
	}

	/**
	 * Metodo encargado de retornar el valor del atributo id
	 * 
	 * @return id: Identificador del modelo (ROL)
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo id
	 * 
	 * @param id El nuevo id a modificar.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo nombre
	 * 
	 * @return El nombre del ROL
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo nombre
	 * 
	 * @param nombre El nuevo nombre a modificar.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo estado
	 * 
	 * @return El estado actual del ROL
	 */
	public EstadoEnum getEstado() {
		return estado;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo estado
	 * 
	 * @param estado El nuevo estado del ROL.
	 */
	public void setEstado(EstadoEnum estado) {
		this.estado = estado;
	}
	
	
}
