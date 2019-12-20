import { Component, OnInit } from "@angular/core";
import { GestionarRolesService } from '../../services/gestionar-roles.service';
import { RolDTO } from '../../dto/rol.dto';

/**
 * @description Componenete gestionar comic, el cual contiene la logica CRUD
 * 
 * @author Ebert Manuel Zerpa Figueroa <ebert15@hotmail.com>
 */
@Component({
  selector: 'gestionar-roles',
  templateUrl: './gestionar-roles.html',
})

export class GestionarRolesComponent implements OnInit {
  public listaRoles: Array<RolDTO> = new Array<RolDTO>();
  constructor(private gestionarRolesService: GestionarRolesService) { }
  ngOnInit() {
    this.refrescarRoles();
  }
  private refrescarRoles(): void {
    this.gestionarRolesService.consultarRol(8).subscribe(res => {
      if (res.length) {
        res.forEach(rol => {
          this.listaRoles.push(rol);
        });
      }
      console.log("Listado de Roles:", this.listaRoles);
    }, error => {
      console.error(error);
    })
  }
  private consultarRol(rol: RolDTO): void {
    this.gestionarRolesService.consultarRol(rol.id).subscribe(res => {
      console.log("Información del rol:", res[0]);
    });
  }
}