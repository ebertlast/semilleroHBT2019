package com.hbt.semillero.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import com.hbt.semillero.dto.PersonaDTO;
import com.hbt.semillero.dto.PersonajeDTO;
import com.hbt.semillero.entidad.Persona;
import com.hbt.semillero.rest.GestionarPersonaRest;

/**
 * Determina el BEAN para realizar la gestión de la entidad PERSONA
 * 
 * @author Ebert Manuel Zerpa Figueroa
 *
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GestionarPersonaBean implements IGestionarPersonaLocal {
	final static Logger logger = Logger.getLogger(GestionarPersonaBean.class);

	/**
	 * Atributo em que se usa para interacturar con el contexto de persistencia.
	 */
	@PersistenceContext
	private EntityManager em;

	/**
	 * Recibe una estructura de tipo PersonaDTO y la persiste
	 * 
	 * @param personaNueva Corresponde al nuevo registro que se guardará en la base de datos
	 */
	@Override
	public void crearPersona(PersonaDTO personaNueva) {
		try {
			logger.info("Ejecutando método crearPersona desde GestionarPersonaBean");
			Persona p = convertirPersonaDTOToPersona(personaNueva);
			em.persist(p);
		} catch (Exception e) {
			throw (e);
		}
	}

	/**
	 * Obtiene el listado de todas las personas registradas en la base de datos.
	 * @return Listado de personas
	 */
	@Override
	public List<PersonaDTO> consultarPersonas() {
		try {
			logger.info("Ejecutando método consultarPersonas desde GestionarPersonaBean");
			List<PersonaDTO> listado=new ArrayList<PersonaDTO>();
			List<Persona> resultados = em.createQuery("select p from Persona p").getResultList();
			for(Persona persona: resultados) {
				listado.add(convertirPersonaToPersonaDTO(persona));
			}
			return listado;
		}catch(Exception e) {
			throw(e);
		}
	}

	/**
	 * Obtiene los datos de una persona en específico
	 * 
	 * @param id Identificador único de registro de la persona en la base de datos
	 * @return Persona asociada al identificador consultado
	 */
	@Override
	public PersonaDTO consultarPersona(Long id) {
		try {
			Persona persona=new Persona();
			persona=em.find(Persona.class, id);
			PersonaDTO personajeDTO=convertirPersonaToPersonaDTO(persona);
			return personajeDTO;
		}catch (Exception e) {
			throw e;
		}

	}

	/**
	 * 
	 * Metodo encargado de transformar una PersonaDTO a una Persona
	 * 
	 * @param personaDTO objeto personaDTO a ser transformado
	 * @return objeto de tipo Persona
	 */
	private Persona convertirPersonaDTOToPersona(PersonaDTO personaDTO) {
		Persona persona = new Persona();
		persona.setId(personaDTO.getId());
		persona.setNombre(personaDTO.getNombre());
		persona.setFnacimiento(personaDTO.getFnacimiento());
		persona.setTipoDocumento(personaDTO.getTipoDocumento());
		persona.setDocumento(personaDTO.getDocumento());
		return persona;
	}

	/**
	 * 
	 * Metodo encargado de transformar una Persona a una PersonaDTO
	 * 
	 * @param persona Objeto de tipo Rol
	 * @return Objeto de tipo RolDTO
	 */
	private PersonaDTO convertirPersonaToPersonaDTO(Persona persona) {
		PersonaDTO personaDTO = new PersonaDTO();
		personaDTO.setId(persona.getId());
		personaDTO.setNombre(persona.getNombre());
		personaDTO.setTipoDocumento(persona.getTipoDocumento());
		personaDTO.setFnacimiento(persona.getFnacimiento());
		personaDTO.setDocumento(persona.getDocumento());
		return personaDTO;
	}



}
