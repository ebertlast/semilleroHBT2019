import { Component, OnInit } from '@angular/core';
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
  private nombreEstudiante: string;
  /**
   * Nombre de la ciudad donde se encuentra el estudiante
   */
  private nombreCiudad: string;
  
  ngOnInit(): void {
    this.nombreEstudiante = "Ebert Manuel Zerpa Figueroa";
    this.nombreCiudad = "Montería";
  }
  
}