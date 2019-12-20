import { Injectable } from '@angular/core';
import { Injector } from "@angular/core";
import { Observable } from 'rxjs';
import 'rxjs/add/operator/toPromise';
import { AbstractService } from './template.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { RolDTO } from '../dto/rol.dto';

/**
 * Servicio encargado de llamar a los servicios REST de
 * ejemplo
 */
@Injectable({
  providedIn: 'root'
})
export class GestionarRolesService extends AbstractService {

  /**
   * Constructor
   */
  constructor(injector: Injector, private httpClient: HttpClient) {
    super(injector);
  }

  /**
   * Genera un listado con todos los roles en la base de datos
   */
  public consultarRoles(): Observable<any> {
    return this.httpClient.get('http://localhost:8085/semillero-servicios/rest/GestionarRol/consultarRoles');
  }

  /**
   * Consulta la informacion de un rol determiando
   * @param id Identificador del rol a consultar
   */
  public consultarRol(id: number): Observable<any> {
    return this.httpClient.get(`http://localhost:8085/semillero-servicios/rest/GestionarRol/consultarRoles?id=${id}`);
  }

  /**
   * Crea un nuevo rol 
   * @param rolDTO Estructura de tipo ROL para ser guardado en la base de datos
   */
  public crearRol(rolDTO: RolDTO): Observable<any> {
    return this.httpClient.post('http://localhost:8085/semillero-servicios/rest/GestionarComic/nuevoRol', rolDTO);
  }
  
  /**
   * Se encarga de guardar los datos de un rol ya editado
   * @param rolDTO Estructura de tipo ROL ya editado para guardar los cambios
   */
  public editarRol(rolDTO: RolDTO): Observable<any> {
    return this.httpClient.put('http://localhost:8085/semillero-servicios/rest/GestionarComic/editar', rolDTO);
  }
  
  /**
   * Eliminar un rol de la base de datos
   * @param id Identificador del rol a ser eliminado
   */
  public eliminarRol(id: number): Observable<any> {
    return this.httpClient.delete(`http://localhost:8085/semillero-servicios/rest/GestionarComic/eliminarRol?idRol=${id}`);
  }
}
