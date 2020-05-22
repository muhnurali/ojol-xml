package com.lawencon.ojol.service;

import java.util.List;
import java.util.Scanner;

import com.lawencon.ojol.model.Driver;
import com.lawencon.ojol.model.TransaksiGojeg;

public interface TransaksiGojegService {
	void insertTransaksi(List<TransaksiGojeg> list, TransaksiGojeg transaksiGojeg) throws Exception;

	void showTransaksiGojeg(List<TransaksiGojeg> list) throws Exception;

	void transaksiGojeg(Scanner sc, Driver driver, TransaksiGojeg transaksiGojeg,
			List<TransaksiGojeg> listTransaksiGojeg, DriverService driverService) throws Exception;
}
