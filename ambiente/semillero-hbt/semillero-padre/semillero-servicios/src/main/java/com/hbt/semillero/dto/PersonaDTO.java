package com.hbt.semillero.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.hbt.semillero.entidad.TipoDocumentoEnum;

/**
 * Determina el DTO para consultar, modificar y eliminar una persona.
 * @author Ebert Manuel Zerpa Figueroa
 *
 */
public class PersonaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nombre;
	private TipoDocumentoEnum tipoDocumento;
	private LocalDate fnacimiento;
	private String documento;
	
	/**
	 * Obtiene el identificador del registro del cliente
	 * @return Identificador del registro del cliente
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Establece el identificador del registro del cliente
	 * @param id Identificador del registro del cliente
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Obtiene la razón social del cliente
	 * @return Razón social del cliente
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece la razón social del cliente
	 * @param nombre Razón social del cliente
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene el tipo de documento de identidad del cliente
	 * @return Tipo de documento de identidad del cliente
	 */
	public TipoDocumentoEnum getTipoDocumento() {
		return tipoDocumento;
	}

	/**
	 * Establece el tipo de documento de identidad del cliente
	 * @param tipoDocumento Tipo de documento de identidad del cliente
	 */
	public void setTipoDocumento(TipoDocumentoEnum tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	/**
	 * Obtiene la fecha de nacimiento del cliente
	 * @return Fecha de nacimiento del cliente
	 */
	public LocalDate getFnacimiento() {
		return fnacimiento;
	}

	/**
	 * Establece la fecha de nacimiento del cliente
	 * @param fnacimiento Fecha de nacimiento del cliente
	 */
	public void setFnacimiento(LocalDate fnacimiento) {
		this.fnacimiento = fnacimiento;
	}

	/**
	 * Método encargado de convertir los datos recibidos en JSON al tipo PersonaDTO.
	 * <b>Caso de Uso:</b>
	 * 
	 * @param arg Cadena que representa el objeto complejo JSON.
	 * @return Instancia con los datos recibidos.
	 */
	public static PersonaDTO valueOf(String arg) {
		return JsonUtils.valueOf(arg, PersonaDTO.class);
	}
	
	/**
	 * Método encargado de convertir los datos recibidos en PersonaDTO al JSON esperado
	 * 
	 * @param dto DTO
	 * @return Json
	 */
	@Override
	public String toString() {
		return JsonUtils.toStringJson(this);
	}
	
	/**
	 * Obtiene el número de documento de identificación de la persona
	 * @return Número de documento de identificación de la persona
	 */
	public String getDocumento() {
		return documento;
	}

	/**
	 * Establece el número de documento de identificación de la persona
	 * @param documento Número de documento de identificación de la persona
	 */
	public void setDocumento(String documento) {
		this.documento = documento;
	}
}
