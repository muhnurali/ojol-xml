package com.lawencon.ojol.service;

import java.util.List;
import java.util.Scanner;

import com.lawencon.ojol.model.DetailGofood;
import com.lawencon.ojol.model.Driver;
import com.lawencon.ojol.model.HeaderGofood;
import com.lawencon.ojol.model.Menu;

public interface HeaderGofoodService {
	void insertTransaksi(List<HeaderGofood> list, HeaderGofood header) throws Exception;

	void showTransaksiGofood(List<HeaderGofood> list) throws Exception;

	public void transaksiGofood(Scanner sc, Driver driver, DriverService driverService, int menu,
			HeaderGofood headerGofood, List<DetailGofood> listDetail, DetailGofoodService detailService,
			DetailGofood detailGofoodFix, boolean kondisi, MenuService menuService, List<Menu> listMenu, Menu menu0,
			List<Menu> listMenuFix, DetailGofood detailGofood, int total, List<DetailGofood> listDetailFix,
			List<HeaderGofood> listHeader) throws Exception;
}
