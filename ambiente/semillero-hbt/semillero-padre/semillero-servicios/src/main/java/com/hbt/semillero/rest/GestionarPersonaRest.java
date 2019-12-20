package com.hbt.semillero.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.hbt.semillero.dto.PersonaDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.ejb.IGestionarPersonaLocal;

/**
 * Determina el servicio REST que permite gestionar las personas
 * @author Ebert Manuel Zerpa Figueroa
 *
 */
@Path("/GestionarPersona")
public class GestionarPersonaRest {
	final static Logger logger = Logger.getLogger(GestionarPersonaRest.class);
	
	@EJB
	private IGestionarPersonaLocal gestionarPersonaEJB;
	
	/**
	 * Crea un nuevo registro de persona y la persiste
	 *
	 * http://localhost:8085/semillero-servicios/rest/GestionarPersona/nuevaPersona
	 * {"nombre":"Ebert Zerpa","tipoDocumento":"CEDULA_EXTRANJERIA","documento":"17576172","fnacimiento":"1987-01-01"}
	 * 
	 * @param personaNueva
	 * @return
	 */
	@POST
	@Path("/nuevaPersona")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultadoDTO registrarPersona(PersonaDTO personaNueva){
		ResultadoDTO resultadoDTO=new ResultadoDTO();
		try {
			logger.debug("Creando nueva persona");
			gestionarPersonaEJB.crearPersona(personaNueva);			
			resultadoDTO.setExitoso(Boolean.TRUE);
			resultadoDTO.setMensajeEjecucion("Persona registrada exitosamente");
		}catch (Exception e) {
			resultadoDTO.setExitoso(Boolean.FALSE);
			resultadoDTO.setMensajeEjecucion(e.getMessage());
		}
		return resultadoDTO;
	}
	
	/**
	 * Obtiene el listado de todas las personas registradas en la base de datos.
	 * @return Listado de personas
	 */
	@GET
	@Path("/consultarPersonas")
	@Produces(MediaType.APPLICATION_JSON)
	public List<PersonaDTO> consultarPersonas(){
		return gestionarPersonaEJB.consultarPersonas();
	} 
	
	/**
	 * Obtiene los datos de una persona en específico
	 * 
	 * @param id Identificador único de registro de la persona en la base de datos
	 * @return Persona asociada al identificador consultado
	 */
	@GET
	@Path("consultarPersona")
	@Produces(MediaType.APPLICATION_JSON)
	public PersonaDTO consultarPersona(@QueryParam("id") Long id){
		return gestionarPersonaEJB.consultarPersona(id);
	}
}
