import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { GestionarVentasService } from '../../services/gestionar-ventas.service';
import { GestionarComicsService } from '../../services/gestionar-comics.service';
import { GestionarPersonasService } from '../../services/gestionar-personas.service';
import { VentasDTO } from '../../dto/ventas.dto';
import { PersonaDTO } from '../../dto/persona.dto';
import { ComicDTO } from '../../dto/comic.dto';
import { Router } from '@angular/router';

@Component({
  selector: 'gestionar-venta',
  templateUrl: './gestionar-venta.html',
  // styleUrls: ['./gestionar-roles.css']
})
  /**
   * @description Gestionar Ventas de Comics
   * @author Ebert Zerpa
   */
export class GestionarVentaComponent implements OnInit {
  /**
   * Contiene la lista de todas las ventas
   */
  public listaVentas: Array<VentasDTO> = new Array<VentasDTO>();
  /**
   * Contiene la lista de todos los clientes
   */
  public listaPersonas: Array<PersonaDTO> = new Array<PersonaDTO>();
  /**
   * Contiene la lista de todos los comics
   */
  public listaComics: Array<ComicDTO> = new Array<ComicDTO>();
  /**
   * Tipos de vistas para navegar entre secciónes del componente
   */
  public tipoVista: string = "resumen";
  /**
   * Controlar el formulario
   */
  public gestionarVentaForm: FormGroup;

  constructor(private fb: FormBuilder, private gestionarVentaService: GestionarVentasService, private gestionarComicsService: GestionarComicsService, private gestionarPersonasService: GestionarPersonasService, private router: Router) { }
  ngOnInit() {
    // Consulta todos los comics disponibles para ser vendidos
    this.gestionarComicsService.consultarComics().subscribe(res => {
      res.forEach(c => {
        this.listaComics.push(c);
      });
      // Consulta todos clientes disponibles para venderles comics
      this.gestionarPersonasService.consultarPersonas().subscribe(res => {
        res.forEach(p => {
          this.listaPersonas.push(p);
        });
        this.refrescarVentas();
      })
    });
    
    this.gestionarVentaForm = this.fb.group({
      persona: [null, Validators.required],
      comic: [null, Validators.required]
    });
  }

  /**
   * Actualiza el listado de ventas
   */
  private refrescarVentas(): void {
    this.gestionarVentaService.listarVentas().subscribe(res => {
      // console.log("Ventas", res);
      this.listaVentas = [];
      res.forEach(v => {
        let venta: VentasDTO = new VentasDTO();
        venta.idComic = v.idComic
        venta.id = v.id;
        venta.idPersona = v.idPersona;
        venta.fecha = v.fecha;
        this.listaComics.filter(x => x.id == v.idComic).forEach(c => {
          venta.comic = c;
        });
        this.listaPersonas.filter(x => x.id == v.idPersona).forEach(p => {
          venta.persona = p;
        })
        this.listaVentas.push(venta);
      });
    })
  }

  /**
   * Se encarga de registrar una venta
   */
  private vender(): void {
    if (this.gestionarVentaForm.invalid) {
      alert("Debes seleccionar tanto el cliente como el comic para generar la venta");
      return;
    }

    let venta: VentasDTO = new VentasDTO();
    venta.idComic = +this.f.comic.value;
    venta.idPersona = +this.f.persona.value;
    this.gestionarVentaService.nuevaVenta(venta).subscribe(res => {
      this.limpiarFormulario();
      this.refrescarVentas();
      this.tipoVista = "resumen";
    })


  }

  /**
   * Limpia los controles de persona y comic del formulario de venta
   */
  private limpiarFormulario(): void {
    // this.submitted = false;
    this.gestionarVentaForm.controls.persona.setValue(null);
    this.gestionarVentaForm.controls.comic.setValue(null);
  }

  /**
   * Acceso directo a los controles del formulario
   */
  get f() {
    return this.gestionarVentaForm.controls;
  }

  /**
   * Obtiene el listado resumido de las ventas
   */
  get resumirVentas(): Array<any> {
    let _return: Array<any> = new Array();
    this.listaComics.forEach(c => {
      let comic: any = c;
      comic.totalVentas = this.listaVentas.filter(x => x.idComic.toString() == c.id).length;

      _return.push(comic);
    });
    return _return;
  }

  /**
   * Obtiene el total de las ventas
   */
  get totalVentas(): number {
    let _return: number = 0;
    this.listaComics.forEach(c => {
      let comic: any = c;
      comic.totalVentas = this.listaVentas.filter(x => x.idComic.toString() == c.id).length;
      if (comic.totalVentas > 0) {
        _return += comic.precio * comic.totalVentas;
      }
    });
    return _return;
  }
}