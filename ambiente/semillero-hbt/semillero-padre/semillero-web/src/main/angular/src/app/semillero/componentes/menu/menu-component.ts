import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

/**
 * @description Componente menu, el cual contiene la logica para direccionar a los modulos
 * desarrollados
 * 
 * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
 */
@Component({
  selector: 'home-page',
  templateUrl: './menu-component.html',
})
export class MenuComponent implements OnInit {

  /**
   * Constructor de la clase
   * @param router permite direccionar a otros componentes
   */
  constructor(private router: Router) {

  }

  /**
   * Evento angular que se ejecuta al iniciar el componente
   */
  ngOnInit(): void {

  }

  /**
   * @description Metodo encargado de direccionar al componente de gestionar comic
   * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
   */
  public navegarGestionarComic(): void {
    this.router.navigate(['gestionar-comic']);
  }

  /**
   * @description Metodo encargado de direccionar al componente de gestionar comic
   * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
   */
  public navegarHome(): void {
    this.router.navigate(['bienvenida']);
  }

  public navegarGestionarCompra(): void {
    this.router.navigate(['gestionar-ventas']);
  }

  /**
   * @description Direccionar al componente de gestionar roles
   * @author Ebert Manuel Zerpa Figueroa <ebert15@hotmail.com>
   */
  public navegarGestionarRoles(): void {
    this.router.navigate(['gestionar-roles']);
  }

  /**
   * @description Direccionar al componente de gestionar persona
   * @author Ebert Manuel Zerpa Figueroa <ebert15@hotmail.com>
   */
  public navegarGestionarPersonas(): void {
    this.router.navigate(['gestionar-personas']);
  }
}