import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { GestionarComicComponent } from './semillero/componentes/gestionarComic/gestionar-comic';
import { GestionarRolesComponent } from './semillero/componentes/gestionarRoles/gestionar-roles';
import { GestionarPersonaComponent } from './semillero/componentes/gestionarPersona/gestionar-persona';
import { GestionarVentaComponent } from './semillero/componentes/gestionarVenta/gestionar-venta';
import { ConsultarComicComponent } from './semillero/componentes/consultarComic/consultar-comic';
import { BienvenidaComponent } from './semillero/componentes/home/bienvenida-component';

const routes: Routes = [
  { path: 'gestionar-comic', component: GestionarComicComponent },
  { path: 'gestionar-roles', component: GestionarRolesComponent },
  { path: 'gestionar-personas', component: GestionarPersonaComponent },
  { path: 'gestionar-ventas', component: GestionarVentaComponent },
  { path: 'consultar-comic', component: ConsultarComicComponent },
  { path: 'bienvenida', component: BienvenidaComponent, data : null }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { useHash: true })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
