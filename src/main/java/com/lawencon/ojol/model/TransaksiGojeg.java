package com.lawencon.ojol.model;

public class TransaksiGojeg {

	private int idTransaksiGojeg, harga;
	private String lokasi, tujuan;
	private Driver driver;

	public TransaksiGojeg() {
	}

	public TransaksiGojeg(int idTransaksiGojeg, int harga, String lokasi, String tujuan, Driver driver) {
		this.idTransaksiGojeg = idTransaksiGojeg;
		this.harga = harga;
		this.lokasi = lokasi;
		this.tujuan = tujuan;
		this.driver = driver;
	}

	public int getIdTransaksiGojeg() {
		return idTransaksiGojeg;
	}

	public void setIdTransaksiGojeg(int idTransaksiGojeg) {
		this.idTransaksiGojeg = idTransaksiGojeg;
	}

	public int getHarga() {
		return harga;
	}

	public void setHarga(int harga) {
		this.harga = harga;
	}

	public String getLokasi() {
		return lokasi;
	}

	public void setLokasi(String lokasi) {
		this.lokasi = lokasi;
	}

	public String getTujuan() {
		return tujuan;
	}

	public void setTujuan(String tujuan) {
		this.tujuan = tujuan;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

}
