package com.hbt.semillero.dto;

import java.io.Serializable;

import com.hbt.semillero.entidad.EstadoEnum;

/**
 * 
 * b>Descripción:<b> Clase que determina el dto a usar para modificar,
 * consultar y posteriormente eliminar un Personaje
 * @author Ebert Zerpa
 *
 */
public class PersonajeDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id; // Código único del personaje
	private String nombre; // Nombre del Personaje
	private Long idComic;
	//private String descripcion; // Descripción del personaje, super poderes y otros
	private String superPoder; // Super Poder
	private EstadoEnum estado;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getIdComic() {
		return idComic;
	}
	public void setIdComic(Long idComic) {
		this.idComic = idComic;
	}
	public String getSuperPoder() {
		return superPoder;
	}
	public void setSuperPoder(String superPoder) {
		this.superPoder = superPoder;
	}
	public EstadoEnum getEstado() {
		return estado;
	}
	public void setEstado(EstadoEnum estado) {
		this.estado = estado;
	}
	/**
	 * Método encargado de convertir los datos recibidos en JSON al tipo PersonajeDTO.
	 * <b>Caso de Uso:</b>
	 * 
	 * @param arg Cadena que representa el objeto complejo JSON.
	 * @return Instancia con los datos recibidos.
	 */
	public static PersonajeDTO valueOf(String arg) {
		return JsonUtils.valueOf(arg, PersonajeDTO.class);
	}

	/**
	 * Método encargado de convertir los datos recibidos en PersonajeDTO al JSON
	 * esperado
	 * 
	 * @param dto DTO
	 * 
	 * @return Json
	 */
	@Override
	public String toString() {
		return JsonUtils.toStringJson(this);
	}
}
