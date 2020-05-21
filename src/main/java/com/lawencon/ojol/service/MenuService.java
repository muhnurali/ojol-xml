package com.lawencon.ojol.service;

import java.util.List;

import com.lawencon.ojol.model.Menu;

public interface MenuService {
	void insertMenu(List<Menu> list, Menu menu) throws Exception;
	void showMenu(List<Menu> list) throws Exception;
	Menu seletMenu (List<Menu> list, int id)throws Exception;
}
