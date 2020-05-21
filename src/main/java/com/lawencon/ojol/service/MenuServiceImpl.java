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

}
