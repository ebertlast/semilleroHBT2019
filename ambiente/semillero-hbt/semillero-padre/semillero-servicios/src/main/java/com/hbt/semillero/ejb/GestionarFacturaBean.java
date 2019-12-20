package com.hbt.semillero.ejb;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import com.hbt.semillero.dto.FacturaDTO;
import com.hbt.semillero.dto.TotalVentasDTO;
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
	
	@SuppressWarnings("unchecked")
	public List<FacturaDTO> listarVentas(Long idComic){
		
//		List<TotalVentasDTO> ventasDTO=new ArrayList<TotalVentasDTO>();
//		List<Object> resultados = em.createQuery("SELECT f FROM FACTURA f").getResultList();
		StringBuilder sb=new StringBuilder();
		try {
			List<FacturaDTO> listado=new ArrayList<FacturaDTO>();
			List<Factura> resultados = em.createQuery("select f from Factura f").getResultList();
			for(Factura factura: resultados) {
				listado.add(convertirFacturaToFacturaDTO(factura));
			}
			return listado;
//			sb.append("SELECT new com.hbt.semillero.dto.TotalVentasDTO(COUNT(c.nombre), c.nombre) ");
//			sb.append("FROM Factura f ");
//			sb.append("JOIN f.comic c ");
//			sb.append("GROUP BY c.nombre ");
			
//			sb.append("select count(c.SCID),c.scnombre from FACTURA f inner join comic c on c.SCID=f.FACTURA_COMIC_ID group by c.scnombre");
//			sb.append("select f from FACTURA f");
			
//			sb.append("SELECT F FROM FACTURA F");
//			javax.persistence.Query query =
//			return em.createQuery(sb.toString()).getResultList();
			
		} catch (Exception e) {
			throw e;
		}
//		return ventasDTO;
	}
	
	private FacturaDTO convertirFacturaToFacturaDTO(Factura factura) {
		FacturaDTO facturaDTO = new FacturaDTO();
		if (factura.getId() != null) {
			facturaDTO.setId(factura.getId());
		}
		facturaDTO.setFecha(factura.getFecha());
		facturaDTO.setIdComic(factura.getComic().getId());
		facturaDTO.setIdPersona(factura.getPersona().getId());
		return facturaDTO;
	}

	private Factura convertirFacturaDTOToFactura(FacturaDTO facturaDTO) {
		Factura factura = new Factura();
		try {
			factura.setId(facturaDTO.getId());
			factura.setFecha(facturaDTO.getFecha());
			Comic c = new Comic(facturaDTO.getIdComic());
			factura.setComic(c);
			Persona p = new Persona(facturaDTO.getIdPersona());
			factura.setPersona(p);
			// DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			factura.setFecha(now);
		}catch(Exception ex) {
			throw ex;
		}
		return factura;
	}

}
