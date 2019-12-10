/**
 * @description Clase ObjetoDTO que contiene las propiedades que solicitan en la actividad #2
 * 
 * @author Ebert Manuel Zerpa Figueroa <ebert15@hotmail.com>
 */
export class LibroDTO {

  /**
  * Indicador del libro.
  */
  public id: number;

  /**
  * Nombre del libro.
  */
  public nombre: string;

  /**
  * Editorial del libro.
  */
  public editorial: string;

  /**
  * Categoría de tema del libro.
  */
  public tematica: string;

  /**
  * Número de páginas que contiene el libro.
  */
  public numeroPaginas: number;

  /**
  * Precio del libro.
  */
  public precio: number;

  /**
  * Autor o autores del libro.
  */
  public autores: string;

  /**
  * Determina si las páginas estan impresas a color (true) o blanco y negro (false).
  */
  public aColor: boolean;

  /**
  * Fecha de venta.
  */
  public fechaVenta: Date;

  /**
  * Activo o Inactivo.
  */
  public estado: string;

}