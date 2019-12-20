package com.hbt.semillero.dto;

public class TotalVentasDTO {
	private Long total;
	private String comic;

	public TotalVentasDTO() {
	}

	public TotalVentasDTO(String comic, Long total) {
		super();
		this.comic = comic;
		this.total = total;
	}

	public String getComic() {
		return comic;
	}

	public void setComic(String comic) {
		this.comic = comic;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

}
