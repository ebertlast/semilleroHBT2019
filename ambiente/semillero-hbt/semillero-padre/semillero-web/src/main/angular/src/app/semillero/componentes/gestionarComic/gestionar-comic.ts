
import { ComicDTO } from '../../dto/comic.dto';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { GestionarComicsService } from '../../services/gestionar-comics.service';

/**
 * @description Componenete gestionar comic, el cual contiene la logica CRUD
 * 
 * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
 */
@Component({
    selector: 'gestionar-comic',
    templateUrl: './gestionar-comic.html',
    styleUrls: ['./gestionar-comic.css']
})
export class GestionarComicComponent implements OnInit {

    /**
     * Atributo que contiene los controles del formulario
     */
    public gestionarComicForm: FormGroup;

    /**
     * Atributo que contendra la informacion del comic
     */
    public comic: ComicDTO;

    /**
     * Atributo que contendra la lista de comics creados
     */
    public listaComics: Array<ComicDTO>;

    public idComic: number = 0;

    /**
     * Atributo que indica si se envio a validar el formulario
     */
    public submitted: boolean;

    /**
     * Guarda el ultimo comic eliminado para ser mostrado como un alerta
     */
    public comicEliminado: ComicDTO;

    /**
     * Permite seguir viendo el mensaje de alerta de eliminado o descartarlo de la pantalla.
     */
    public mostrarMensaje: boolean;

    /**
     * @description Este es el constructor del componente GestionarComicComponent
     * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
     */
    constructor(private fb: FormBuilder,
        private router: Router, private activatedRoute: ActivatedRoute,
        private gestionarComicsService: GestionarComicsService
    ) {
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
     * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
     */
    ngOnInit(): void {
        console.log("Ingreso al al evento oninit");
        this.comic = new ComicDTO();
        this.listaComics = new Array<ComicDTO>();

        let comic = this.activatedRoute.snapshot.params;
        if (comic && comic.nombre) {
            this.gestionarComicForm.controls.nombre.setValue(comic.nombre);
            this.gestionarComicForm.controls.editorial.setValue(comic.editorial);
            this.gestionarComicForm.controls.tematica.setValue(comic.tematica);
            this.gestionarComicForm.controls.coleccion.setValue(comic.coleccion);
            this.gestionarComicForm.controls.numeroPaginas.setValue(comic.numeroPaginas);
            this.gestionarComicForm.controls.precio.setValue(comic.precio);
            this.gestionarComicForm.controls.autores.setValue(comic.autores);
            this.gestionarComicForm.controls.color.setValue(comic.color.toString());
            this.gestionarComicForm.controls.nombre.enable();
            this.gestionarComicForm.controls.editorial.enable();
            this.gestionarComicForm.controls.tematica.enable();
            this.gestionarComicForm.controls.coleccion.enable();
            this.gestionarComicForm.controls.numeroPaginas.enable();
            this.gestionarComicForm.controls.precio.enable();
            this.gestionarComicForm.controls.autores.enable();
            this.gestionarComicForm.controls.color.enable();
        }

        this.gestionarComicsService.consultarComics().subscribe(res => {
            // console.log(res);
            res.forEach(comic => {
                this.listaComics.push(comic);
            });
        })

    }

    /**
     * @description Metodo que permite validar el formulario y crear o actulizar un comic
     */
    public crearActualizarComic(): void {
        this.submitted = true;
        if (this.gestionarComicForm.invalid) {
            return;
        }
        let comics: Array<ComicDTO> = [];
        if (this.comic && this.comic.nombre) {
            comics = this.listaComics.filter(x => x.nombre == this.gestionarComicForm.controls.nombre.value);
        }
        if (comics.length > 0) {
            let indice: number = this.listaComics.findIndex(x => x === comics[0]);
            this.comic = this.listaComics[indice];
            this.comic.nombre = this.gestionarComicForm.controls.nombre.value;
            this.comic.editorial = this.gestionarComicForm.controls.editorial.value;
            this.comic.tematica = this.gestionarComicForm.controls.tematica.value;
            this.comic.coleccion = this.gestionarComicForm.controls.coleccion.value;
            this.comic.numeroPaginas = this.gestionarComicForm.controls.numeroPaginas.value;
            this.comic.precio = this.gestionarComicForm.controls.precio.value;
            this.comic.autores = this.gestionarComicForm.controls.autores.value;
            this.comic.color = this.gestionarComicForm.controls.color.value;

            this.listaComics[indice] = this.comic;

        } else {
            this.idComic++;
            this.comic = new ComicDTO();
            this.comic.id = this.idComic + "";
            this.comic.nombre = this.gestionarComicForm.controls.nombre.value;
            this.comic.editorial = this.gestionarComicForm.controls.editorial.value;
            this.comic.tematica = this.gestionarComicForm.controls.tematica.value;
            this.comic.coleccion = this.gestionarComicForm.controls.coleccion.value;
            this.comic.numeroPaginas = this.gestionarComicForm.controls.numeroPaginas.value;
            this.comic.precio = this.gestionarComicForm.controls.precio.value;
            this.comic.autores = this.gestionarComicForm.controls.autores.value;
            this.comic.color = this.gestionarComicForm.controls.color.value;
            this.listaComics.push(this.comic);
        }
        this.limpiarFormulario();
    }

    /**
     * Metodo que permite consultar un comic de la tabla y sus detalles e inhabilitar el formulario
     * @param posicion en la lista del comic seleccionado
     */
    public consultarComic(posicion: number): void {
        let comic = this.listaComics[posicion];
        // this.gestionarComicForm.controls.nombre.setValue(comic.nombre);
        // this.gestionarComicForm.controls.editorial.setValue(comic.editorial);
        // this.gestionarComicForm.controls.tematica.setValue(comic.tematica);
        // this.gestionarComicForm.controls.coleccion.setValue(comic.coleccion);
        // this.gestionarComicForm.controls.numeroPaginas.setValue(comic.numeroPaginas);
        // this.gestionarComicForm.controls.precio.setValue(comic.precio);
        // this.gestionarComicForm.controls.autores.setValue(comic.autores);
        // this.gestionarComicForm.controls.color.setValue(comic.color);
        // this.gestionarComicForm.controls.nombre.disable();
        // this.gestionarComicForm.controls.editorial.disable();
        // this.gestionarComicForm.controls.tematica.disable();
        // this.gestionarComicForm.controls.coleccion.disable();
        // this.gestionarComicForm.controls.numeroPaginas.disable();
        // this.gestionarComicForm.controls.precio.disable();
        // this.gestionarComicForm.controls.autores.disable();
        // this.gestionarComicForm.controls.color.disable();
        //        this.gestionarComicForm.controls.color.enable(); para habilitar el campo
        this.router.navigate(['consultar-comic', comic]);

    }

    public editarComic(comic: any): void {
        this.comic = comic;
        this.gestionarComicForm.controls.nombre.setValue(comic.nombre);
        this.gestionarComicForm.controls.editorial.setValue(comic.editorial);
        this.gestionarComicForm.controls.tematica.setValue(comic.tematica);
        this.gestionarComicForm.controls.coleccion.setValue(comic.coleccion);
        this.gestionarComicForm.controls.numeroPaginas.setValue(comic.numeroPaginas);
        this.gestionarComicForm.controls.precio.setValue(comic.precio);
        this.gestionarComicForm.controls.autores.setValue(comic.autores);
        this.gestionarComicForm.controls.color.setValue(comic.color);
    }

    private limpiarFormulario(): void {
        this.submitted = false;
        this.gestionarComicForm.controls.nombre.setValue(null);
        this.gestionarComicForm.controls.editorial.setValue(null);
        this.gestionarComicForm.controls.tematica.setValue(null);
        this.gestionarComicForm.controls.coleccion.setValue(null);
        this.gestionarComicForm.controls.numeroPaginas.setValue(null);
        this.gestionarComicForm.controls.precio.setValue(null);
        this.gestionarComicForm.controls.autores.setValue(null);
        this.gestionarComicForm.controls.color.setValue(null);
    }

    /**
     * @description Metodo que obtiene los controles y sus propiedades
     * @author Diego Fernando Alvarez Silva
     */
    get f() {
        return this.gestionarComicForm.controls;
    }

    private eliminarComic(comic: ComicDTO): void {
        this.mostrarMensaje = false;
        this.comicEliminado = comic;
        // ubicamos el indice del comic dentro de la lista
        let indice: number = this.listaComics.findIndex(c => c === comic);
        // Quitamos el comic de la pila
        this.listaComics.splice(indice, 1);
        // Mostrar el mensaje que se ha eliminado el libro
        this.mostrarMensaje = true;

    }
}