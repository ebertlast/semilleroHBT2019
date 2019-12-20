package com.hbt.semillero.entidad;

import java.io.Serializable;
import java.time.LocalDate;

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
 * Clase entidad de base de datos PERSONA que corresponde a los datos del cliente
 * @author Ebert Manuel Zerpa Figueroa
 *
 */
@Entity
@Table(name = "PERSONA")
public class Persona implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Identificador único del registro de un cliente
	 */
	@Id
	@SequenceGenerator(allocationSize = 1, name = "PERSONA_ID_GENERATOR", sequenceName = "SEQ_PERSONA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSONA_ID_GENERATOR")
	@Column(name = "PERSONA_ID")
	private Long id;
	
	/**
	 * Razón social del cliente
	 */
	@Column(name="PERSONA_NOMBRE")
	private String nombre;
	
	/**
	 * Tipo de documento de identidad del cliente
	 */
	@Column(name="PERSONA_TIPODOCUMENTO")
	@Enumerated(value = EnumType.STRING)
	private TipoDocumentoEnum tipoDocumento;
	
	/**
	 * Documento de identidad de la persona
	 */
	@Column(name="PERSONA_DOCUMENTO")
	private String documento;
	
	/**
	 * Fecha de Nacimiento del cliente
	 */
	@Column(name="PERSONA_FNACIMIENTO")
	private LocalDate fnacimiento;
	
	public Persona(){ }
	
	public Persona(Long id){
		this.id = id;
	}

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
