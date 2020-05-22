package com.lawencon.ojol.service;

import java.util.List;

import com.lawencon.ojol.model.JenisPaket;

public class JenisPaketServiceImpl implements JenisPaketService {
	@Override
	public void showJenisPaket(List<JenisPaket> listJenisPaket) throws Exception {
		System.out.println("===Jenis Paket===");
		listJenisPaket.forEach(x -> {
			System.out.println(x.getIdJenis() + ". " + x.getNamaJenis() + ", Rp. " + x.getHarga());
		});
	}

	@Override
	public void insertJenisPaket(List<JenisPaket> listJenisPaket, JenisPaket jenisPaket) throws Exception {
		listJenisPaket.add(jenisPaket);
	}

	@Override
	public JenisPaket getById(List<JenisPaket> listJenisPaket, int id) throws Exception {
		return listJenisPaket.get(id - 1);
	}

}
