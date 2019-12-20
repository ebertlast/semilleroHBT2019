import { Injectable } from '@angular/core';
import { Injector } from "@angular/core";
import { Observable } from 'rxjs';
import 'rxjs/add/operator/toPromise';
import { AbstractService } from './template.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { VentasDTO } from '../dto/ventas.dto';

/**
 * Servicio encargado de llamar a los servicios REST de
 * ejemplo
 */
@Injectable({
  providedIn: 'root'
})
export class GestionarVentasService extends AbstractService {
  
  /**
   * Constructor
   */
  constructor(injector: Injector, private httpClient: HttpClient) {
    super(injector);
  }

  /**
   * Genera un listado con todos los roles en la base de datos
   */
  public listarVentas(): Observable<any> {
    return this.httpClient.get('http://localhost:8085/semillero-servicios/rest/GestionarFactura/listarVentas');
  }

  public nuevaVenta(ventaDTO: VentasDTO): Observable<any> {
    return this.httpClient.post('http://localhost:8085/semillero-servicios/rest/GestionarFactura/nuevaVenta', ventaDTO);
  }

}
