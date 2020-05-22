package com.lawencon.ojol.service;

import java.util.List;
import java.util.Scanner;

import com.lawencon.ojol.model.Driver;
import com.lawencon.ojol.model.JenisPaket;
import com.lawencon.ojol.model.TransaksiGosend;

public interface TransaksiGosendService {
	void insertTransaksi(List<TransaksiGosend> list, TransaksiGosend transaksiGosend) throws Exception;

	void showTransaksiGosend(List<TransaksiGosend> list) throws Exception;

	void transaksiGosend(Scanner sc, Driver driver, DriverService driverService, TransaksiGosend transaksiGosend,
			JenisPaketService jenisPaketService, List<JenisPaket> listJenisPaket, int menu, JenisPaket jenisPaket,
			boolean kondisi, TransaksiGosendService transaksiGosendService, List<TransaksiGosend> listTransaksiGosend)
			throws Exception;
}
