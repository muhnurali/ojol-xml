package com.lawencon.ojol.model;

public class TransaksiGosend {
	private int idTransaksiGosend, berat, harga;
	private String lokasi, tujuan;
	private JenisPaket jenisBarang;
	private Driver driver;
	
	public TransaksiGosend() {	}
	
	public TransaksiGosend(int idTransaksiGosend, int berat, int harga, String lokasi, String tujuan,
			JenisPaket jenisBarang, Driver driver) {
		super();
		this.idTransaksiGosend = idTransaksiGosend;
		this.berat = berat;
		this.harga = harga;
		this.lokasi = lokasi;
		this.tujuan = tujuan;
		this.jenisBarang = jenisBarang;
		this.driver = driver;
	}
	public int getIdTransaksiGosend() {
		return idTransaksiGosend;
	}
	public void setIdTransaksiGosend(int idTransaksiGosend) {
		this.idTransaksiGosend = idTransaksiGosend;
	}
	public int getBerat() {
		return berat;
	}
	public void setBerat(int berat) {
		this.berat = berat;
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
	public JenisPaket getJenisPaket() {
		return jenisBarang;
	}
	public void setJenisPaket(JenisPaket jenisBarang) {
		this.jenisBarang = jenisBarang;
	}
	public JenisPaket getJenisBarang() {
		return jenisBarang;
	}
	public void setJenisBarang(JenisPaket jenisBarang) {
		this.jenisBarang = jenisBarang;
	}
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	
	
}
