import { Component, OnInit } from "@angular/core";
import { GestionarPersonasService } from '../../services/gestionar-personas.service';
import { PersonaDTO } from '../../dto/persona.dto';
import { FormGroup, Validators, FormBuilder } from '@angular/forms';

@Component({
  selector: 'gestionar-persona',
  templateUrl: './gestionar-persona.html',
  // styleUrls: ['./gestionar-roles.css']
})
export class GestionarPersonaComponent implements OnInit {

  /**
   * Contiene todo el listado de personas de la base de datos
   */
  public listaPersonas: Array<PersonaDTO> = new Array<PersonaDTO>();

  /**
   * Contiene los datos de la persona actual que se está mirando
   */
  public persona: PersonaDTO;

  /**
   * Atributo que contiene los controles del formulario
   * 
   */
  public gestionarPersonaForm: FormGroup;

  /**
     * Atributo que indica si se envio a validar el formulario
     */
  public submitted: boolean;

  /**
   * Determina cuando está ocupado o no en una transacción a la base de datos
   */
  public cargando: boolean;

  private modoVista: string = "lista";
  constructor(private fb: FormBuilder, private gestionarPersonaService: GestionarPersonasService) { }
  ngOnInit() {
    this.gestionarPersonaForm = this.fb.group({
      nombre: [null, Validators.required],
      fnacimiento: [null, Validators.required],
      tipoDocumento: [null, Validators.required],
      documento: [null, Validators.required]
    });
    this.refrescarPersonas();
  }

  /**
   * @description Actualiza la lista de personas trayendolo desde la base de datos.
   * @author Ebert Zerpa
   */
  private refrescarPersonas() {
    this.cargando = true;
    this.listaPersonas = [];
    this.gestionarPersonaService.consultarPersonas().subscribe(res => {
      res.forEach(persona => {
        this.listaPersonas.push(persona);
      });
      // console.log(this.listaPersonas);
      this.cargando = false;
    });
  }

  /**
   * Se encarga de llenar los datos del cliente para mostrarlo en la pantalla
   * @param persona Persona a ser visualizada en el Card
   */
  private consultarPersona(persona: PersonaDTO): void {
    this.persona = new PersonaDTO();
    this.persona.id = persona.id;
    this.persona.nombre = persona.nombre;
    this.persona.tipoDocumento = persona.tipoDocumento;
    this.persona.documento = persona.documento;
    this.persona.fnacimiento = persona.fnacimiento;
    this.modoVista = "ver";
  }

  /**
   * Crea un nuevo cliente en la base de datos
   */
  private crearPersona(): void {
    this.submitted = true;
    if (this.gestionarPersonaForm.invalid) {
      return;
    }
    let p: PersonaDTO = new PersonaDTO();
    p.nombre = this.f.nombre.value;
    p.fnacimiento = this.f.fnacimiento.value;
    p.tipoDocumento = this.f.tipoDocumento.value;
    p.documento = this.f.documento.value;
    console.log(p);

    this.gestionarPersonaService.crearPersona(p).subscribe(res => {
      console.log(res);
      this.limpiarFormulario();
      this.regresar();
    });
  }

  /**
   * Limpia el formulario
   */
  private limpiarFormulario(): void {
    this.submitted = false;
    this.gestionarPersonaForm.controls.nombre.setValue(null);
    this.gestionarPersonaForm.controls.fnacimiento.setValue(null);
    this.gestionarPersonaForm.controls.tipoDocumento.setValue(null);
    this.gestionarPersonaForm.controls.documento.setValue(null);
  }

  /**
   * Regresa al principio de los pasos
   */
  private regresar() {
    this.refrescarPersonas();
    this.modoVista = 'lista'
  }
  /**
     * @description Obtiene los controles y sus propiedades
     * @author Ebert Zerpa
     */
  get f() {
    return this.gestionarPersonaForm.controls;
  }
}