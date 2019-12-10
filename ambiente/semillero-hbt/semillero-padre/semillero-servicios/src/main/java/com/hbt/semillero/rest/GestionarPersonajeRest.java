package com.hbt.semillero.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dto.PersonajeDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.ejb.IGestionarPersonajeLocal;

/**
 * <b>Descripción:<b> Clase que determina el servicio rest que permite gestionar los personajes
 * 
 * @author Ebert Zerpa
 * @version 1.0
 */
@Path("/GestionarPersonaje")
public class GestionarPersonajeRest {
	/**
	 * Atriburo que permite gestionar un comic
	 */
	@EJB
	private IGestionarPersonajeLocal gestionarPersonajeEJB;
	
	/**
	 * 
	 * Metodo encargado de traer la informacion de los personajes
	 * http://localhost:8085/semillero-servicios/rest/GestionarPersonaje/consultarPersonajes
	 * 
	 * @param idComic
	 * @return
	 */
	@GET
	@Path("/consultarPersonajes")
	@Produces(MediaType.APPLICATION_JSON)
	public List<PersonajeDTO> consultarPersonajes() {
		return gestionarPersonajeEJB.consultarPersonajes();
	}
	
	/**
	 * Crear nuevos personajes
	 * POST: http://localhost:8085/semillero-servicios/rest/GestionarPersonaje/nuevoPersonaje
	 * @param persona
	 * @return
	 */
	@POST
	@Path("/nuevoPersonaje")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultadoDTO crearPersonaje(PersonajeDTO personajeNuevo) {
		gestionarPersonajeEJB.crearPersonaje(personajeNuevo);
		ResultadoDTO resultadoDTO = new ResultadoDTO(Boolean.TRUE, "Personaje creado exitosamente");
		return resultadoDTO;
	}
}
