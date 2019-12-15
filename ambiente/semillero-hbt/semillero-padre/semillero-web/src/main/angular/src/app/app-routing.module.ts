import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { GestionarComicComponent } from './semillero/componentes/gestionarComic/gestionar-comic';
import { ConsultarComicComponent } from './semillero/componentes/consultarComic/consultar-comic';
import { BienvenidaComponent } from './semillero/componentes/home/bienvenida-component';

const routes: Routes = [
  { path: 'gestionar-comic', component: GestionarComicComponent },
  { path: 'consultar-comic', component: ConsultarComicComponent },
  { path: 'bienvenida', component: BienvenidaComponent, data : null }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { useHash: true })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
