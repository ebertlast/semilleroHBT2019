import { ComicDTO } from './comic.dto';
import { PersonaDTO } from './persona.dto';

/**
 * @description Clase PersonaDTO que contiene la informacion de los clientes
 * 
 * @author Ebert Manuel Zerpa Figueroa <ebert15@hotmail.com>
 */
export class VentasDTO {

  /**
  * Identificador del registro
  */
  public id: number;

  /**
  * Código del Comic
  */
  public idComic: number;

  /**
  * Código de la Persona
  */
  public idPersona: number;

  /**
   * Fecha de nacimiento de cliente
   */
  public fecha: Date;

  public comic: ComicDTO;
  public persona: PersonaDTO;
}