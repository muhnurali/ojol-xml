package com.lawencon.ojol.model;

import java.util.List;

public class DetailGofood {
	
	private int id;
	private String namaRestoran;
	private List<Menu> menu;
	
	public DetailGofood() {}	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNamaRestoran() {
		return namaRestoran;
	}

	public void setNamaRestoran(String namaRestoran) {
		this.namaRestoran = namaRestoran;
	}

	public List<Menu> getMenu() {
		return menu;
	}

	public void setMenu(List<Menu> menu) {
		this.menu = menu;
	}
	
	

}
