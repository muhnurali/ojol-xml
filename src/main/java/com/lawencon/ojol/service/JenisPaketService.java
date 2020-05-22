package com.lawencon.ojol.service;

import java.util.List;

import com.lawencon.ojol.model.JenisPaket;

public interface JenisPaketService {
	void insertJenisPaket(List<JenisPaket> listJenisPaket, JenisPaket jenisPaket) throws Exception;

	void showJenisPaket(List<JenisPaket> listJenisPaket) throws Exception;

	JenisPaket getById(List<JenisPaket> listJenisPaket, int id) throws Exception;
}
