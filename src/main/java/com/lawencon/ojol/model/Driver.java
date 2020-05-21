package com.lawencon.ojol.model;

public class Driver {
	private int idDriver;
	private String nama, plat, motor;
	
	public Driver() {}
	
	public Driver(int idDriver, String nama, String plat, String motor) {
		this.idDriver = idDriver;
		this.nama = nama;
		this.plat = plat;
		this.motor = motor;
	}
	
	public int getIdDriver() {
		return idDriver;
	}
	public void setIdDriver(int idDriver) {
		this.idDriver = idDriver;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public String getPlat() {
		return plat;
	}
	public void setPlat(String plat) {
		this.plat = plat;
	}
	public String getMotor() {
		return motor;
	}
	public void setMotor(String motor) {
		this.motor = motor;
	}
	
	
}
