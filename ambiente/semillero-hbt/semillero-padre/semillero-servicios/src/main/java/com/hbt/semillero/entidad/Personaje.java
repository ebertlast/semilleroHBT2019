package com.hbt.semillero.entidad;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * Clase correspondiente al personaje del super héroe
 * @author Ebert Zerpa
 * @version 1.0
 *
 */
@Entity
@Table(name = "PERSONAJE")
public class Personaje implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Código único del personaje 
	 */
	@Id
	@SequenceGenerator(allocationSize = 1, name = "PERSONAJE_ID_GENERATOR", sequenceName = "SEC_PERSONAJE")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSONAJE_ID_GENERATOR")
	@Column(name = "PERS_ID")
	private Long id;
	
	/**
	 * Nombre del personaje
	 */
	@Column(name="PERS_NOMBRE")
	private String nombre;
	
	/**
	 * Comics en la que aparece el personaje
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PERS_ID_COMIC")
	private Comic comic;
	
	/**
	 * Estado del registro
	 */	
	@Column(name="PERS_ESTADO")
	@Enumerated(value = EnumType.STRING)
	private EstadoEnum estado;
	
	@Column(name="PERS_SUPERPODER")
	private String superPoder; // Super Poder
	
	
	/**
	 * Constructor de la clase
	 */
	public Personaje() {	
		
	}
	
	/**
	 * Metodo encargado de retornar el valor del atributo id
	 * 
	 * @return id: Identificador del modelo (Personaje)
	 */
	@Column(name = "PERS_ID")
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
	 * @return El nombre del Personaje
	 */
	@Column(name = "PERS_NOMBRE")
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
	 * Metodo encargado de retornar el valor del atributo superPoder
	 * 
	 * @return Super Poder del personaje
	 */
	@Column(name = "PERS_SUPERPODER")
	public String getSuperPoder() {
		return superPoder;
	}
	
	/**
	 * Metodo encargado de modificar el valor del atributo superPoder
	 * 
	 * @param superPoder Super Poder del personaje.
	 */
	public void setSuperPoder(String superPoder) {
		this.superPoder = superPoder;
	}
	
	/**
	 * Sustituye o asigna el comic al que pertenece el personaje
	 * @param comic
	 */
	public void setComic(Comic comic) {
		this.comic = comic;
	}
	
	/**
	 * Devuelve el comic al que pertenece el personaje
	 * @return Comic
	 */
	public Comic getComic() {
		return this.comic;
	}
	
	public void setEstado(EstadoEnum estado) {
		this.estado=estado;
	}
	
	public EstadoEnum getEstado() {
		return this.estado;
	}
	
	
}
