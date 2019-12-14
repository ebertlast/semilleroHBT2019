package com.hbt.semillero.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dto.ComicDTO;
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
	 * 
	 * Metodo encargado de traer la informacion de un personaje determiando
	 * http://localhost:8085/semillero-servicios/rest/GestionarPersonaje/consultarPersonaje?idPersonaje=1
	 * 
	 * @param idPersonaje
	 * @return
	 */
	@GET
	@Path("/consultarPersonaje")
	@Produces(MediaType.APPLICATION_JSON)
	public PersonajeDTO consultarPersonaje(@QueryParam("idPersonaje") Long idPersonaje) {
		if (idPersonaje != null) {
			PersonajeDTO personajeDTO = gestionarPersonajeEJB.consultarPersonaje(idPersonaje.toString());
			return personajeDTO;
		}
		return null;
	}
	
	/**
	 * Crear nuevos personajes
	 * POST: http://localhost:8085/semillero-servicios/rest/GestionarPersonaje/nuevoPersonaje
	 * @param personajeNuevo Json con estructura de un personaje sin el Identificador 
	 * @return
	 */
	@POST
	@Path("/nuevoPersonaje")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultadoDTO crearPersonaje(PersonajeDTO personajeNuevo) {
		//System.out.println("Crear Personaje");
		gestionarPersonajeEJB.crearPersonaje(personajeNuevo);
		ResultadoDTO resultadoDTO = new ResultadoDTO(Boolean.TRUE, "Personaje creado exitosamente");
		return resultadoDTO;
	}
	
	
	/**
	 * 
	 * Metodo encargado de eliminar un personaje correspondiente al id pasado como parametro
	 * DELETE: http://localhost:8085/semillero-servicios/rest/GestionarPersonaje/eliminar
	 * @param idPersonaje identificador del Personaje
	 */
	@POST
	@Path("/eliminar")
	@Produces(MediaType.APPLICATION_JSON)
	public void eliminarComic(@QueryParam("idPersonaje") Long idPersonaje) {
		if (idPersonaje != null) {
			gestionarPersonajeEJB.eliminarPersonaje(idPersonaje);
		}
	}
	
	/**
	 * 
	 * Metodo encargado de modificar el nombre de un personaje
	 * http://localhost:8085/semillero-servicios/rest/GestionarPersonaje/modificar?idPersonaje=1&nombre=nuevonombre
	 * @param idPersonaje identificador del personaje a buscar
	 * @param nombre nombre nuevo del personaje
	 */
	@POST
	@Path("/modificar")
	@Produces(MediaType.APPLICATION_JSON)
	public ResultadoDTO modificarPersonaje(@QueryParam("idPersonaje") Long idPersonaje, @QueryParam("nombre") String nombre) {
		gestionarPersonajeEJB.modificarPersonaje(idPersonaje, nombre, null);
		ResultadoDTO resultadoDTO = new ResultadoDTO(Boolean.TRUE, "Personaje editado exitosamente");
		return resultadoDTO;
	}
	
	/**
	 * 
	 * Metodo encargado de modificar el nombre de un personaje
	 * http://localhost:8085/semillero-servicios/rest/GestionarPersonaje/modificar?idPersonaje=1&nombre=nuevonombre
	 * @param idPersonaje identificador del personaje a buscar
	 * @param personajeEditado json con la estructura del personaje ya editado 
	 */
	@POST
	@Path("/editar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultadoDTO editarPersonaje(PersonajeDTO personajeEditado) {
		gestionarPersonajeEJB.editarPersonaje(personajeEditado);
		ResultadoDTO resultadoDTO = new ResultadoDTO(Boolean.TRUE, "Personaje editado exitosamente");
		return resultadoDTO;
	}
}
