package com.hbt.semillero.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dto.PersonajeDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.dto.RolDTO;
import com.hbt.semillero.ejb.IGestionarRolLocal;

@Path("/GestionarRol")
public class GestionarRolRest {

	/**
	 * Atriburo que permite gestionar un comic
	 */
	@EJB
	private IGestionarRolLocal gestionarRolEJB;

	/**
	 * 
	 * Consulta la informacion de un rol determiando
	 * http://localhost:8085/semillero-servicios/rest/GestionarRol/consultarRol?idRol=1
	 * 
	 * @param idRol
	 * @return Objeto de tipo RolDTO
	 */
	@GET
	@Path("/consultarRol")
	@Produces(MediaType.APPLICATION_JSON)
	public RolDTO consultarRol(@QueryParam("idRol") Long idRol) {
		if (idRol != null) {
			RolDTO rolDTO = gestionarRolEJB.consultarRol(idRol);
			return rolDTO;
		}
		return null;
	}

	//	/**
	//	 *
	//	 * @return
	//	 */
	//	@GET
	//	@Path("/test")
	//	@Produces(MediaType.APPLICATION_JSON)
	//	public String testRest() {
	//		return "Prueba inicial servicios rest en el semillero java hbt";
	//	}

	/**
	 * Genera un listado con todos los roles en la base de datos
	 * @return Listado de roles
	 */
	@GET
	@Path("/consultarRoles")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<RolDTO> consultarRoles() {
		return gestionarRolEJB.consultarRoles();
	}

	/**
	 * Crea un nuevo rol 
	 * @param rolNuevo Estructura de tipo ROL para ser guardado en la base de datos
	 * @return objeto de tipo resultadoDTO 
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/nuevoRol")
	public ResultadoDTO nuevoRol(RolDTO rolNuevo) {
		ResultadoDTO resultadoDTO=new ResultadoDTO();
		try {
			gestionarRolEJB.nuevoRol(rolNuevo);			
			resultadoDTO.setExitoso(Boolean.TRUE);
			resultadoDTO.setMensajeEjecucion("Rol creado exitosamente");
		}catch (Exception e) {
			resultadoDTO.setExitoso(Boolean.FALSE);
			resultadoDTO.setMensajeEjecucion(e.getMessage());
		}


		return resultadoDTO;
	}

	/**
	 * Eliminar un rol de la base de datos
	 * @param idRol Identificador del rol a ser eliminado
	 * @return objeto de tipo resultadoDTO
	 */
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/eliminarRol")
	public ResultadoDTO eliminarRol(@QueryParam("idRol") Long idRol) {
		gestionarRolEJB.eliminarRol(idRol);
		ResultadoDTO resultadoDTO = new ResultadoDTO(Boolean.TRUE, "Rol eliminado exitosamente");
		return resultadoDTO;
	}

	/**
	 * Metodo encargado de editar un Rol
	 * @param rolEditado json con la estructura del rol ya editado 
	 */
	@PUT
	@Path("/editar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultadoDTO editarRol(RolDTO rolEditado) {
		gestionarRolEJB.editarRol(rolEditado);
		ResultadoDTO resultadoDTO = new ResultadoDTO(Boolean.TRUE, "Rol editado exitosamente");
		return resultadoDTO;
	}
}

