package com.lawencon.ojol.service;

import java.util.List;

import com.lawencon.ojol.model.Menu;

public class MenuServiceImpl implements MenuService{

	@Override
	public void insertMenu(List<Menu> list, Menu menu) throws Exception {
		list.add(menu);
	}

	@Override
	public void showMenu(List<Menu> list) throws Exception {
		System.out.println("===Menu===");
		list.forEach(x->{
			System.out.println(x.getIdMenu()+". "+x.getNama()+", Rp. "+x.getHarga());
		});
	}

	@Override
	public Menu seletMenu(List<Menu> list, int id) throws Exception {
		return list.get(id-1);
	}

	@Override
	public void showMenuUtama() throws Exception {
		System.out.println("===Aplikasi Gojeg===");
		System.out.println("1. Gojeg");
		System.out.println("2. Gofood");
		System.out.println("3. Gosend");
		System.out.println("4. History");
		System.out.println("0. Exit");
		System.out.print("Pilih menu : ");
	}
	
	@Override
	public void showMenuHistory() throws Exception{
		System.out.println("\n===History===");
		System.out.println("1. Gojeg");
		System.out.println("2. Gofood");
		System.out.println("3. Gosend");
		System.out.println("99. Kembali");
	}

}
