package com.lawencon.ojol.model;

public class JenisPaket {
	private int idJenis, harga;
	private String nama;
	
	public JenisPaket() {
	}
	
	public JenisPaket(int idJenis,String nama, int harga) {
		this.idJenis=idJenis;
		this.nama=nama;
		this.harga=harga;
	}
	
	public int getIdJenis() {
		return idJenis;
	}
	public void setIdJenis(int idJenis) {
		this.idJenis = idJenis;
	}
	public int getHarga() {
		return harga;
	}
	public void setHarga(int harga) {
		this.harga = harga;
	}
	public String getNamaJenis() {
		return nama;
	}
	public void setNamaJenis(String jenis) {
		this.nama = jenis;
	}
	
	
}
