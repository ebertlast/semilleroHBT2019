import { Component, OnInit } from "@angular/core";
import { GestionarRolesService } from '../../services/gestionar-roles.service';
import { RolDTO } from '../../dto/rol.dto';

/**
 * @description Componenete gestionar comic, el cual contiene la logica CRUD
 * 
 * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
 */
@Component({
  selector: 'gestionar-roles',
  templateUrl: './gestionar-roles.html',
  // styleUrls: ['./gestionar-roles.css']
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