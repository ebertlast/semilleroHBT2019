/**
 * @description Clase RolDTO que contiene la informacion de un rol de personaje
 * 
 * @author Ebert Manuel Zerpa Figueroa <ebert15@hotmail.com>
 */
export class RolDTO {

    /**
    * Identificador del registro
    */
    public id: number;

    /**
    * Nombre del rol del personaje
    */
    public nombre: string;

    /**
    * Estado del registro (ACTIVO, INACTIVO)
    */
    public estado: string;
  
}