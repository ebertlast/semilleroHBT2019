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

import org.apache.log4j.Logger;

import com.hbt.semillero.dto.PersonajeDTO;
import com.hbt.semillero.dto.RolDTO;
import com.hbt.semillero.entidad.Personaje;
import com.hbt.semillero.entidad.Rol;

/**
 * <b>Descripción:<b> Clase que determina el bean para realizar las gestion de
 * los personajes
 * 
 * @author Ebert Zerpa
 * @version 1.0
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GestionarRolBean implements IGestionarRolLocal {

	final static Logger logger = Logger.getLogger(GestionarPersonajeBean.class);

	/**
	 * Atributo em que se usa para interacturar con el contexto de persistencia.
	 */
	@PersistenceContext
	private EntityManager em;

	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarPersonajeLocal#consultarPersonajes()
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<RolDTO> consultarRoles() {
		List<RolDTO> resultadosRolDTO = new ArrayList<RolDTO>();
		@SuppressWarnings("unchecked")
		List<Rol> resultados = em.createQuery("select r from Rol r").getResultList();
		for (Rol rol : resultados) {
			resultadosRolDTO.add(convertirRolToRolDTO(rol));
		}
		return resultadosRolDTO;
	}
	
	/**
	 * Consultar un rol
	 * @param idRol identificador del rol a ser consultado
	 * @return Rol asociado al identificador recibido
	 */
	public RolDTO consultarRol(Long idRol) {
		Rol rol = null;
		rol = new Rol();
		rol = em.find(Rol.class, idRol);
		RolDTO rolDTO = convertirRolToRolDTO(rol);
		return rolDTO;
	}

	/**
	 * Registra un nuevo rol en la base de datos
	 * @see com.hbt.semillero.ejb.IGestionarRolLocal#nuevoRol(com.hbt.semillero.dto.RolDTO)
	 * @param rolNuevo rol a ser agregado a la nueva base de datos
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void nuevoRol(RolDTO rolNuevo) {
		// Entidad nueva
		Rol rol = convertirRolDTOToRol(rolNuevo);
		// Se almacena la informacion y se maneja la entidad Rol
		em.persist(rol);
		em.flush();
		em.clear();
	}

	/**
	 * Elimina un registro de la tabla Rol
	 * @param rolID identificador del rol a ser eliminado
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void eliminarRol(Long rolID) {
		Rol rolEliminar = em.find(Rol.class, rolID);
		if (rolEliminar != null) {
			em.remove(rolEliminar);
		}else {
		}
		em.flush();
		em.clear();
	}
	
	/**
	 * Guarda los datos de un rol editado
	 * @param rolEditado rol con datos editados y su respectivo id
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void editarRol(RolDTO rolEditado) {
		Rol rolEncontrado;
		if(rolEditado.getId()==null) {
			// Manejar una excepción aquí
		}else {
			rolEncontrado = em.find(Rol.class, rolEditado.getId());
			if(rolEncontrado==null) {
				// Manejar una excepción aquí
			}else {			
				rolEncontrado.setId(rolEditado.getId());
				rolEncontrado.setEstado(rolEditado.getEstado());
				rolEncontrado.setNombre(rolEditado.getNombre());
				em.merge(rolEncontrado);
			}
		}
	}

	/**
	 * 
	 * Metodo encargado de transformar un RolDTO a un Rol
	 * 
	 * @param rolDTO objeto rolDTO a ser transformado
	 * @return objeto de tipo Rol
	 */
	private Rol convertirRolDTOToRol(RolDTO rolDTO) {
		Rol rol = new Rol();
		rol.setId(rolDTO.getId());
		rol.setNombre(rolDTO.getNombre());
		rol.setEstado(rolDTO.getEstado());
		return rol;
	}

	/**
	 * 
	 * Metodo encargado de transformar un Rol a un RolDTO
	 * 
	 * @param rol Objeto de tipo Rol
	 * @return Objeto de tipo RolDTO
	 */
	private RolDTO convertirRolToRolDTO(Rol rol) {
		RolDTO rolDTO = new RolDTO();
		rolDTO.setId(rol.getId());
		rolDTO.setNombre(rol.getNombre());
		rolDTO.setEstado(rol.getEstado());
		return rolDTO;
	}

	

}