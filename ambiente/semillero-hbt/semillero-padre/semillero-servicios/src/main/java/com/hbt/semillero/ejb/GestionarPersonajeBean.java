/**
 * GestionarComicBean.java
 */
package com.hbt.semillero.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.dto.PersonajeDTO;
import com.hbt.semillero.entidad.Comic;
import com.hbt.semillero.entidad.EstadoEnum;
import com.hbt.semillero.entidad.Personaje;

/**
 * <b>Descripción:<b> Clase que determina el bean para realizar las gestion de
 * los personajes
 * 
 * @author Ebert Zerpa
 * @version 1.0
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GestionarPersonajeBean implements IGestionarPersonajeLocal {

	final static Logger logger = Logger.getLogger(GestionarPersonajeBean.class);

	/**
	 * Atributo em que se usa para interacturar con el contexto de persistencia.
	 */
	@PersistenceContext
	private EntityManager em;

	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarPersonajeLocal#crearPersonaje(com.hbt.semillero.dto.PersonajeDTO)
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void crearPersonaje(PersonajeDTO personajeNuevo) {
		// Entidad nueva
		Personaje personaje = convertirPersonajeDTOToPersonaje(personajeNuevo);
		// Se almacena la informacion y se maneja la enidad personaje
		em.persist(personaje);
		System.out.println("Mensaje desde crearPersonaje");
	}

	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarPersonajeLocal#modificarPersonaje(com.hbt.semillero.dto.PersonajeDTO)
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void modificarPersonaje(Long id, String nombre, PersonajeDTO personajeNuevo) {
		Personaje personajeModificar;
		if(personajeNuevo==null) {
			personajeModificar = em.find(Personaje.class, id);
		}else {
			personajeModificar = convertirPersonajeDTOToPersonaje(personajeNuevo);
		}
		personajeModificar.setNombre(nombre);
		em.merge(personajeModificar);
	}

	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarPersonajeLocal#modificarPersonaje(com.hbt.semillero.dto.PersonajeDTO)
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void editarPersonaje(PersonajeDTO personajeEditado) {
		Personaje personajeEncontrado;
		if(personajeEditado.getId()==null) {
			// Manejar una excepción aquí
		}else {
			personajeEncontrado = em.find(Personaje.class, personajeEditado.getId());
			if(personajeEncontrado==null) {
				// Manejar una excepción aquí
			}else {			
				Comic comic=new Comic();
				comic.setId(personajeEditado.getIdComic());
				personajeEncontrado.setComic(comic);
				personajeEncontrado.setEstado(personajeEditado.getEstado());
				personajeEncontrado.setId(personajeEditado.getId());
				personajeEncontrado.setNombre(personajeEditado.getNombre());
				personajeEncontrado.setSuperPoder(personajeEditado.getSuperPoder());
				em.merge(personajeEncontrado);
			}
		}

	}

	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarPersonajeLocal#eliminarPersonaje(java.lang.Long)
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void eliminarPersonaje(Long idPersonaje) {
		/* Opción 1 */
		Personaje personajeEliminar = em.find(Personaje.class, idPersonaje);
		if (personajeEliminar != null) {
			System.out.println("Se ha encontrado el personaje a Eliminar");
			em.remove(personajeEliminar);
		}else {
			System.out.println("No se ha encontrado el personaje a Eliminar");
		}
		em.flush();
		em.clear();

		/* Opción 2 */
		// Query query = em.createQuery("DELETE FROM Personaje p WHERE p.id = :idPersonaje").setParameter("idPersonaje",
		// 		idPersonaje);
		// query.executeUpdate();

	}

	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarPersonajeLocal#consultarPersonaje(java.lang.String)
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public PersonajeDTO consultarPersonaje(String idPersonaje) {
		Personaje personaje = null;
		personaje = new Personaje();
		personaje = em.find(Personaje.class, Long.parseLong(idPersonaje));
		PersonajeDTO personajeDTO = convertirPersonajeToPersonajeDTO(personaje);
		return personajeDTO;
	}

	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarPersonajeLocal#consultarPersonajes()
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<PersonajeDTO> consultarPersonajes() {
		// logger.debug("This is debug message");
		// logger.info("This is info message");
		// logger.warn("This is warn message");
		// logger.fatal("This is fatal message");
		// logger.error("This is error message");
		List<PersonajeDTO> resultadosPersonajeDTO = new ArrayList<PersonajeDTO>();
		// PersonajeDTO p=new PersonajeDTO();
		// p.setEstado(EstadoEnum.ACTIVO);
		// p.setId((long) 1);
		// p.setIdComic((long) 1);
		// p.setNombre("Pruebas de Desarrollo");
		// p.setSuperPoder("Pruebas de Desarrollo");
		// resultadosPersonajeDTO.add(p);

		@SuppressWarnings("unchecked")
		List<Personaje> resultados = em.createQuery("select p from Personaje p").getResultList();
		for (Personaje personaje : resultados) {
			resultadosPersonajeDTO.add(convertirPersonajeToPersonajeDTO(personaje));
		}
		return resultadosPersonajeDTO;
	}

	/**
	 * 
	 * Metodo encargado de transformar un personaje a un personajeDTO
	 * 
	 * @param personaje
	 * @return
	 */
	private Personaje convertirPersonajeDTOToPersonaje(PersonajeDTO personajeDTO) {
		Personaje personaje = new Personaje();
		personaje.setId(personajeDTO.getId());
		personaje.setNombre(personajeDTO.getNombre());
		personaje.setComic(new Comic());
		personaje.getComic().setId(personajeDTO.getIdComic());
		personaje.setEstado(personajeDTO.getEstado());
		personaje.setSuperPoder(personajeDTO.getSuperPoder());
		return personaje;
	}

	/**
	 * 
	 * Metodo encargado de transformar un Personaje a un PerosnajeDTO
	 * 
	 * @param comic
	 * @return
	 */
	private PersonajeDTO convertirPersonajeToPersonajeDTO(Personaje personaje) {
		PersonajeDTO personajeDTO = new PersonajeDTO();
		personajeDTO.setId(personaje.getId());
		personajeDTO.setNombre(personaje.getNombre());
		personajeDTO.setIdComic(personaje.getComic().getId());
		personajeDTO.setEstado(personaje.getEstado());
		personajeDTO.setSuperPoder(personaje.getSuperPoder());
		return personajeDTO;
	}
}