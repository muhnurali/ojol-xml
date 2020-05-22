package com.lawencon.ojol.service;

import java.util.List;

import com.lawencon.ojol.model.DetailGofood;

public class DetailGofoodServiceImpl implements DetailGofoodService {

	@Override
	public void insertGofood(List<DetailGofood> list, DetailGofood gofood) throws Exception {
		list.add(gofood);
	}

	@Override
	public void showDetail(List<DetailGofood> list) throws Exception {
		System.out.println("===Restoran==");
		list.forEach(x -> {
			System.out.println(x.getId() + ". " + x.getNamaRestoran());
		});
	}

	@Override
	public DetailGofood selectDetail(List<DetailGofood> list, int id) throws Exception {
		return list.get(id - 1);
	}

	@Override
	public void showMenu(List<DetailGofood> list) throws Exception {
		System.out.println("===Menu===");
		list.forEach(x -> {
			x.getMenu().forEach(y -> {
				System.out.println(y.getIdMenu() + ". " + y.getNama() + ", Rp. " + y.getHarga());
			});
		});
	}

}
