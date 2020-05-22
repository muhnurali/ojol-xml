package com.lawencon.ojol.model;

import java.util.List;

public class HeaderGofood {

	private int idTransaksiGofood, total;
	private String lokasi;
	private List<DetailGofood> detail;
	private Driver driver;

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public List<DetailGofood> getDetail() {
		return detail;
	}

	public void setDetail(List<DetailGofood> detail) {
		this.detail = detail;
	}

	public int getIdTransaksiGofood() {
		return idTransaksiGofood;
	}

	public void setIdTransaksiGofood(int idTransaksiGofood) {
		this.idTransaksiGofood = idTransaksiGofood;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getLokasi() {
		return lokasi;
	}

	public void setLokasi(String lokasi) {
		this.lokasi = lokasi;
	}

}
