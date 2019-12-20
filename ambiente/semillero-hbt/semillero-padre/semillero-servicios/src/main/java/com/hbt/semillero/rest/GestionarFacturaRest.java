package com.hbt.semillero.rest;

import org.apache.log4j.Logger;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dto.FacturaDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.ejb.IGestionarFacturaLocal;

@Path("/GestionarFactura")
public class GestionarFacturaRest {
	final static Logger logger = Logger.getLogger(GestionarFacturaRest.class);

	@EJB
	private IGestionarFacturaLocal gestionarFacturaEJB;
	
	@POST
	@Path("/nuevaVenta")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultadoDTO registrarPersona(FacturaDTO facturaNueva){
		ResultadoDTO resultadoDTO=new ResultadoDTO();
		try {
			logger.info("Creando nueva venta");
			gestionarFacturaEJB.agregarVenta(facturaNueva);			
			resultadoDTO.setExitoso(Boolean.TRUE);
			resultadoDTO.setMensajeEjecucion("Venta registrada exitosamente");
		}catch (Exception e) {
			resultadoDTO.setExitoso(Boolean.FALSE);
			resultadoDTO.setMensajeEjecucion(e.getMessage());
		}
		return resultadoDTO;
	}
}
