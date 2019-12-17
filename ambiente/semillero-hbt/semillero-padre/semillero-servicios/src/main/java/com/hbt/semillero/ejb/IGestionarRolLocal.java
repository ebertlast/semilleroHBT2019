package com.hbt.semillero.ejb;

import java.util.List;

import javax.ejb.Local;

import com.hbt.semillero.dto.RolDTO;

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
public interface IGestionarRolLocal {

	/**
	 * 
	 * Devuelve un rol determinado asociado al identificador que recibe
	 * 
	 * @return objeto de tipo RolDTO
	 */
  public RolDTO consultarRol(Long idRol);
  
  
	/**
	 * 
	 * Metodo encargado de retornar una lista de roless
	 * 
	 * @return lista de objetos de tipo RolDTO
	 */
  public List<RolDTO> consultarRoles();
  
  /**
	 * Metodo encargado de crear un Rol y persistirlo
	 * @author Ebert Zerpa
	 * @param rolNuevo informacion nueva a crear
	 */
  public void nuevoRol(RolDTO rolNuevo);
  
  /**
	 * 
	 * Metodo encargado de eliminar un rol
	 * @author Ebert Zerpa
	 * @param rolID Identificador del Rol a Eliminar
	 * 
	 */
  public void eliminarRol(Long rolID);
 
  /**
	 * 
	 * Metodo encargado de eliminar un rol
	 * @author Ebert Zerpa
	 * @param rolEditado objeto de tipo RolDTO ya editado para guardar los cambios
	 * 
	 */
	public void editarRol(RolDTO rolEditado);
}

