
import { ComicDTO } from '../../dto/comic.dto';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';

/**
 * @description Visualizar los datos de un Comic
 * 
 * @author Ebert Manuel Zerpa Figueroa <ebert15@hotmail.com>
 */
@Component({
  selector: 'consultar-comic',
  templateUrl: './consultar-comic.html',
})
export class ConsultarComicComponent implements OnInit {

  /**
   * Atributo que contiene los controles del formulario
   */
  public gestionarComicForm: FormGroup;

  /**
   * Atributo que contendra la informacion del comic
   */
  public comic: ComicDTO;

  /**
   * @description Este es el constructor del componente ConsultarComicComponent
   * @author Ebert Manuel Zerpa Figueroa <ebert15@hotmail.com>
   */
  constructor(private fb: FormBuilder,
    private router: Router, private activatedRoute: ActivatedRoute) {
    this.gestionarComicForm = this.fb.group({
      nombre: [null, Validators.required],
      editorial: [null],
      tematica: [null],
      coleccion: [null],
      numeroPaginas: [null],
      precio: [null],
      autores: [null],
      color: [null]
    });
  }

  /**
   * @description Evento angular que se ejecuta al invocar el componente
   * @author Ebert Manuel Zerpa Figueroa <ebert15@hotmail.com>
   */
  ngOnInit(): void {
    // Se toma el comic pasado como parametro en la ruta
    let comic = this.activatedRoute.snapshot.params;
    // Establezco los valores en el formulario con los datos del Comic
    this.gestionarComicForm.controls.nombre.setValue(comic.nombre);
    this.gestionarComicForm.controls.editorial.setValue(comic.editorial);
    this.gestionarComicForm.controls.tematica.setValue(comic.tematica);
    this.gestionarComicForm.controls.coleccion.setValue(comic.coleccion);
    this.gestionarComicForm.controls.numeroPaginas.setValue(comic.numeroPaginas);
    this.gestionarComicForm.controls.precio.setValue(comic.precio);
    this.gestionarComicForm.controls.autores.setValue(comic.autores);
    this.gestionarComicForm.controls.color.setValue(comic.color);
    this.gestionarComicForm.controls.nombre.disable();
    this.gestionarComicForm.controls.editorial.disable();
    this.gestionarComicForm.controls.tematica.disable();
    this.gestionarComicForm.controls.coleccion.disable();
    this.gestionarComicForm.controls.numeroPaginas.disable();
    this.gestionarComicForm.controls.precio.disable();
    this.gestionarComicForm.controls.autores.disable();
    this.gestionarComicForm.controls.color.disable();
    //  this.gestionarComicForm.controls.color.enable(); para habilitar el campo

    this.comic = new ComicDTO();
    this.comic.nombre = comic.nombre;
    this.comic.editorial = comic.editorial;
    this.comic.tematica = comic.tematica;
    this.comic.coleccion = comic.coleccion;
    this.comic.numeroPaginas = comic.numeroPaginas;
    this.comic.precio = comic.precio;
    this.comic.autores = comic.autores;
    this.comic.color = comic.color;
  }

  /**
   * @description Regresa al listado de comics con el comic para que se vea exactamente antes de llegar a la ventana de consulta
   */
  public regresar() {
    this.router.navigate(['gestionar-comic', this.comic]);
  }

  /**
   * @description Metodo que obtiene los controles y sus propiedades
   * @author Ebert Manuel Zerpa Figueroa
   */
  get f() {
    return this.gestionarComicForm.controls;
  }
}