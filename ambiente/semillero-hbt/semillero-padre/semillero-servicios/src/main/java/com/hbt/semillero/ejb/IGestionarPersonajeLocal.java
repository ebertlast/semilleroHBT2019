package com.hbt.semillero.ejb;

import java.util.List;

import javax.ejb.Local;

import com.hbt.semillero.dto.PersonajeDTO;

/**
 * Expone los métodos del EJB GestionarPersonaje Las interfaces determinan una
 * especie de contrato donde se define las firmas de los metodos, define que se
 * necesita implementar pero no el como eso lo realiza la clase que la
 * implementa Palabras claves interface e implements
 * 
 * @author Ebert Zerpa
 *
 */
@Local
public interface IGestionarPersonajeLocal {
	/**
	 * Metodo encargado de crear un Personaje y persistirlo
	 * @author Ebert Zerpa
	 * @param personajeNuevo informacion nueva a crear
	 */
	public void crearPersonaje(PersonajeDTO personajeNuevo);
	
	/**
	 * 
	 * Metodo encargado de consultar un personaje, modificarlo y guardarlo
	 * @author Ebert Zerpa
	 * @param personajeModificado informacion modificada a guardar
	 * 
	 */
	public void modificarPersonaje(Long personajeID, String nombre, PersonajeDTO personajeModificado);
	
	
	/**
	 * 
	 * Metodo encargado de guardar un personaje ya editado
	 * @author Ebert Zerpa
	 * @param personajeModificado informacion modificada a guardar
	 * 
	 */
	public void editarPersonaje(PersonajeDTO personajeModificado);

	/**
	 * 
	 * Metodo encargado de eliminar un personaje
	 * @author Ebert Zerpa
	 * @param PersonajeID informacion a eliminar
	 * 
	 */
	public void eliminarPersonaje(Long PersonajeID);

	/**
	 * 
	 * Metodo encargado de retornar la informacion de un personaje
	 * @param personajeID identificador del personaje a ser consultado
	 * @return Personaje Resultado de la consulta
	 * @throws Exception si no se recibe personajeID
	 */
	public PersonajeDTO consultarPersonaje(String personajeID);

	/**
	 * 
	 * Metodo encargado de retornar una lista de personajes
	 * 
	 * @return
	 */
	public List<PersonajeDTO> consultarPersonajes();
}
