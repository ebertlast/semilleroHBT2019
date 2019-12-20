package com.hbt.semillero.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Determina el DTO para consultar, modificar y eliminar una venta.
 * @author Ebert Manuel Zerpa Figueroa
 *
 */
public class FacturaDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private LocalDateTime fecha;
	private Long idComic;
	private Long idPersona;
	
	/**
	 * Obtiene el identificador del registro de la factura
	 * @return Identificador del registro de la factura
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Establece el identificador del registro de la factura
	 * @param id identificador del registro de la factura
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * Obtiene la fecha de venta
	 * @return fecha de venta
	 */
	public LocalDateTime getFecha() {
		return fecha;
	}

	/**
	 * Establece la fecha de venta
	 * @param fecha fecha de venta
	 */
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	/**
	 * Obtiene el comic asociado a la venta
	 * @return comic en la venta
	 */
	public Long getIdComic() {
		return idComic;
	}

	/**
	 * Establece el comic a la factura
	 * @param comic comic en la factura
	 */
	public void setIdComic(Long idComic) {
		this.idComic = idComic;
	}

	/**
	 * Obtiene el cliente vinculado a la factura
	 * @return persona que compra el comic
	 */
	public Long getIdPersona() {
		return idPersona;
	}

	/**
	 * Establece la persona que compra el comic
	 * @param persona persona que compra el comic
	 */
	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}
}
