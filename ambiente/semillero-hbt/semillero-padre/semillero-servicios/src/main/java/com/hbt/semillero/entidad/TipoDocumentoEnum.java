package com.hbt.semillero.entidad;

/**
 * Determina los tipos de documentos de identificaciones permitidos para clientes
 * @author Ebert Manuel Zerpa Figueroa
 *
 */
public enum TipoDocumentoEnum {
	CEDULA_CIUDADANIA("enum.tipodocumento.cedula_ciudadania"),
	CEDULA_EXTRANJERIA("enum.tipodocumento.cedula_extranjeria"),
	PASAPORTE("enum.tipodocumento.pasaporte"),
	OTRO("enum.tipodocumento.otro");
	
	/**
	 * Atributo que contiene la clave del mensaje para la internacionalizacion
	 */
	private String codigoMensaje;
	
	/**
	 * Constructor que recibe como parametro el codigo del mensaje
	 * @param codigoMensaje Clave del mensaje para para internacionalizacion
	 */
	TipoDocumentoEnum(String codigoMensaje){
		this.codigoMensaje=codigoMensaje;
	}
	
	/**
	 * Obtiene el código del mensaje de internacionalización
	 * @return Código del mensaje de internacionalización
	 */
	public String getCodigoMensaje() {
		return codigoMensaje;
	}
	
	/**
	 * Establece el código del mensaje de internacionalización
	 * @param codigoMensaje Código del mensaje de internacionalización
	 */
	public void setCodigoMensaje(String codigoMensaje) {
		this.codigoMensaje = codigoMensaje;
	}
}
