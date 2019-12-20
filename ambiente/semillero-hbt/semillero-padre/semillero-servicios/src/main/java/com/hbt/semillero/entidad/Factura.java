package com.hbt.semillero.entidad;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="FACTURA")
public class Factura implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Identificador único de la factura
	 */
	@Id
	@SequenceGenerator(allocationSize = 1, name = "FACTURA_ID_GENERATOR", sequenceName = "SEQ_FACTURA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FACTURA_ID_GENERATOR")
	@Column(name = "FACTURA_ID")
	private Long id;
	
	@Column(name="FACTURA_FECHA")
	private LocalDateTime fecha;
	
	/**
	 * Comic asociada a la venta de la factura
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="FACTURA_COMIC_ID")
	private Comic comic;
	
	/**
	 * Persona cliente que compra el comic
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="FACTURA_PERSONA_ID")
	private Persona persona;

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
	public Comic getComic() {
		return comic;
	}

	/**
	 * Establece el comic a la factura
	 * @param comic comic en la factura
	 */
	public void setComic(Comic comic) {
		this.comic = comic;
	}

	/**
	 * Obtiene el cliente vinculado a la factura
	 * @return persona que compra el comic
	 */
	public Persona getPersona() {
		return persona;
	}

	/**
	 * Establece la persona que compra el comic
	 * @param persona persona que compra el comic
	 */
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	
}
