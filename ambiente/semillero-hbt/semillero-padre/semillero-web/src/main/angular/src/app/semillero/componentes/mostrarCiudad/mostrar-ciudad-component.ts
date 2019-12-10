import { Component, OnInit } from '@angular/core';
import { LibroDTO } from '../../dto/libro.dto';
/**
 * @description Archivo tipo COMPONENTE que muestra el nombre del estudiante del curso y la ciudad donde vive.
 * @author Ebert Zerpa
 */
@Component({
  selector: 'mostrar-ciudad',
  templateUrl: './mostrar-ciudad-component.html'
})

export class MostrarCiudadComponent implements OnInit {
  /** 
   * Nombre del estudiante para ser mostrado en la vista
   */
  public nombreEstudiante: string;
  /**
   * Nombre de la ciudad donde se encuentra el estudiante
   */
  public nombreCiudad: string;
  /**
   * Arreglo de libros que será utilizado para llenar una pila de 5 libros
   */
  public libros: Array<LibroDTO>;
  /**
   * Se guarda el último libro eliminado de la pila
   */
  public libroEliminado: LibroDTO;

  /**
   * Determina si el usuario quiere seguír viendo el mensaje
   */
  public mostrarMensaje: boolean;

  ngOnInit(): void {
    this.nombreEstudiante = "Ebert Manuel Zerpa Figueroa";
    this.nombreCiudad = "Montería";

    this.libros = new Array<LibroDTO>();

    this.autoGenerarLibros();
  }

  /**
   * Genera libros para publicación automáticamente
   */
  private autoGenerarLibros(): void {
    // Mostrar el mensaje que se ha eliminado el libro
    this.mostrarMensaje = true;
    // Se limpia la variable que guarda el último libro eliminado
    this.libroEliminado = undefined;
    // Para efectos de práctica del ejercicio propuesto se hará una iteración de 5 veces para autogenerar los registros de ejemplo
    for (let i = 0; i < 5; i++) {
      let libro = new LibroDTO(); // Objeto tipo libro que se adicionará a la pila de libros (this.libros)
      libro.id = i + 1;
      libro.nombre = `Libro de auto creación tomo #${i + 1}`; // Nombre autogenerado por tomos
      libro.editorial = "HEINSOHN - HGS";
      libro.tematica = "Tecnología";
      libro.numeroPaginas = Math.ceil(Math.random() * 1000); // Número de tres dígitos aleatorios para determinar el número de hojas
      libro.precio = Number.parseFloat(`${Math.ceil(Math.random() * 100000)}.${Math.ceil(Math.random() * 100)}`); // Precio autogenerado de 5 dígitos con sus respectivos decimales de dos dígitos
      libro.autores = "Ebert Zerpa";
      libro.aColor = (i % 2 === 0); // Verdadero si es un número par
      libro.fechaVenta = new Date(); // Fecha actual de la venta
      libro.estado = "Activo"; // Todos activos
      this.libros.push(libro); // Se agrega el libro 
    }
  }

  /**
   * Quita un libro de la pila de libros
   * @param libro Libro a ser eliminado de la pila
   */
  private descartarLibro(libro: LibroDTO): void {
    this.libroEliminado = libro;
    // ubicamos el indice del libro dentro de la pila de libros
    let indice: number = this.libros.findIndex(x => x === libro);
    // Quitamos el libro de la pila
    this.libros.splice(indice, 1);
    // Mostrar el mensaje que se ha eliminado el libro
    this.mostrarMensaje = true;
    
  }

}