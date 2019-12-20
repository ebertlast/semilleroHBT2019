package com.hbt.semillero.ejb;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import com.hbt.semillero.dto.FacturaDTO;
import com.hbt.semillero.entidad.Comic;
import com.hbt.semillero.entidad.Factura;
import com.hbt.semillero.entidad.Persona;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GestionarFacturaBean implements IGestionarFacturaLocal {
	final static Logger logger = Logger.getLogger(GestionarPersonaBean.class);

	/**
	 * Atributo em que se usa para interacturar con el contexto de persistencia.
	 */
	@PersistenceContext
	private EntityManager em;

	@Override
	public void agregarVenta(FacturaDTO facturaDTO) {
		try {
			logger.info("Ejecutando método agregarVenta desde GestionarFacturaBean");
			Factura f = convertirFacturaDTOToFactura(facturaDTO);
			System.out.println(f.getComic().getId());
			System.out.println(f.getPersona().getId());
			System.out.println(f.getFecha().toString());
			
			em.persist(f);
			
		} catch (Exception ex) {
			throw ex;
		}
	}

	private Factura convertirFacturaDTOToFactura(FacturaDTO facturaDTO) {
		Factura factura = new Factura();
		factura.setId(facturaDTO.getId());
		factura.setFecha(facturaDTO.getFecha());
		Comic c = new Comic(facturaDTO.getIdComic());
		factura.setComic(c);
		Persona p = new Persona(facturaDTO.getIdPersona());
		factura.setPersona(p);
		// DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		factura.setFecha(now);
		return factura;
	}

}
