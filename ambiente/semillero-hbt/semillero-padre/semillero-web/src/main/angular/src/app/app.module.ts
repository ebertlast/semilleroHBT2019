import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { APP_BASE_HREF } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { MenuComponent } from './semillero/componentes/menu/menu-component';
import { BienvenidaComponent } from './semillero/componentes/home/bienvenida-component';
import { CrearPersonaComponent } from './semillero/componentes/crearPersona/crear-persona-component';
import { GestionarComicComponent } from './semillero/componentes/gestionarComic/gestionar-comic';
import { ConsultarComicComponent } from './semillero/componentes/consultarComic/consultar-comic';
import { MostrarCiudadComponent } from './semillero/componentes/mostrarCiudad/mostrar-ciudad-component';
import { GestionarRolesComponent } from './semillero/componentes/gestionarRoles/gestionar-roles';
import { GestionarPersonaComponent } from './semillero/componentes/gestionarPersona/gestionar-persona';
import { GestionarVentaComponent } from './semillero/componentes/gestionarVenta/gestionar-venta';

// DTOs
export { ComicDTO } from './semillero/dto/comic.dto';
export { ResultadoDTO } from './semillero/dto/resultado.dto';

//Manejo de servicios

import { EjemploService } from './semillero/services/ejemplo.service';
import { GestionarComicsService } from './semillero/services/gestionar-comics.service';
import { GestionarRolesService } from './semillero/services/gestionar-roles.service';
import { GestionarPersonasService } from './semillero/services/gestionar-personas.service';
import { GestionarVentasService } from './semillero/services/gestionar-ventas.service';
import { AbstractService } from './semillero/services/template.service';

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    BienvenidaComponent,
    CrearPersonaComponent,
    GestionarComicComponent,
    ConsultarComicComponent,
    MostrarCiudadComponent,
    GestionarRolesComponent,
    GestionarPersonaComponent,
    GestionarVentaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [
    { provide: APP_BASE_HREF, useValue: '/SemilleroHBT' }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {

}
