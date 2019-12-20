package com.hbt.semillero.ejb;

import java.util.List;

import javax.ejb.Local;

import com.hbt.semillero.dto.PersonaDTO;

/**
 * Expone los métodos del EJB GestionarPersona Las interfaces determinan una
 * especie de contrato donde se define las firmas de los metodos, define que se
 * necesita implementar pero no el como eso lo realiza la clase que la
 * implementa Palabras claves interface e implements
 * 
 * @author Ebert Manuel Zerpa Figueroa
 *
 */
@Local
public interface IGestionarPersonaLocal {
	/**
	 * Se encarga de crear una persona y persistirla
	 * @param persona
	 */
	public void crearPersona(PersonaDTO persona);
	
	/**
	 * Obtiene el listado de todas las personas registradas en la base de datos.
	 * @return Listado de personas
	 */
	public List<PersonaDTO> consultarPersonas();
	
	/**
	 * Obtiene los datos de una persona en específico
	 * 
	 * @param id Identificador único de registro de la persona en la base de datos
	 * @return Persona asociada al identificador consultado
	 */
	public PersonaDTO consultarPersona(Long id);
}
