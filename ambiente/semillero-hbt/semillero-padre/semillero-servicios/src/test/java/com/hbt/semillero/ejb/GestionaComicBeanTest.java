package com.hbt.semillero.ejb;

import java.util.Date;

import javax.ejb.EJB;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.entidad.Comic;
import com.hbt.semillero.entidad.EstadoEnum;
import com.hbt.semillero.entidad.TematicaEnum;

import java.math.BigDecimal;
import java.time.LocalDate;

public class GestionaComicBeanTest {
	
	@EJB
	private IGestionarComicLocal gestionarComicBean; 
	
	@Test
	public void crearComicTest(ComicDTO comicNuevo) {
		ComicDTO comic = new ComicDTO();
		Assert.assertNotNull(comic);
//		comic.setAutores("Ebert Zerpa");
//		comic.setColor(Boolean.TRUE);
//		comic.setCantidad((long) 0);
//		comic.setColeccion("PRUEBA");
//		comic.setEditorial("Prueba");
//		comic.setEstadoEnum(EstadoEnum.ACTIVO);
//		comic.setFechaVenta(LocalDate.now());
//		comic.setNombre("Pruebas de Desarrollo");
//		comic.setNumeroPaginas(100);
//		comic.setPrecio(BigDecimal.valueOf(500));
//		comic.setTematicaEnum(TematicaEnum.AVENTURAS);		
//		gestionarComicBean.crearComic(comic);		
	}
}
