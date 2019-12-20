/**
 * @description Clase PersonaDTO que contiene la informacion de los clientes
 * 
 * @author Ebert Manuel Zerpa Figueroa <ebert15@hotmail.com>
 */
export class PersonaDTO {

  /**
  * Identificador del registro
  */
  public id: number;

  /**
  * Nombre o razón social del cliente
  */
  public nombre: string;

  /**
  * Tipo de documento de identidad 
  */
  public tipoDocumento: string;

  /**
   * Documento de identidad
   */
  public documento: string;

  /**
   * Fecha de nacimiento de cliente
   */
  public fnacimiento: Date;
}