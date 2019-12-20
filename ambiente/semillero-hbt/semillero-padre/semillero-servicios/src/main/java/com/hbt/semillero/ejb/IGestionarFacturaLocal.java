package com.hbt.semillero.ejb;

import java.util.List;

import javax.ejb.Local;

import com.hbt.semillero.dto.FacturaDTO;
import com.hbt.semillero.dto.TotalVentasDTO;

/**
 * Expone los métodos del EJB GestionarFactura 
 * 
 * @author Ebert Manuel Zerpa Figueroa
 *
 */
@Local
public interface IGestionarFacturaLocal {
	/**
	 * Guarda una nueva venta en la base de datos
	 * @param factura datos del comic y de la persona
	 */
	public void agregarVenta(FacturaDTO factura);
	
	public List<FacturaDTO> listarVentas(Long idComic);
}
