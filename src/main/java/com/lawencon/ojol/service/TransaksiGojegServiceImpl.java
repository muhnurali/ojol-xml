package com.lawencon.ojol.service;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import com.lawencon.ojol.model.Constants;
import com.lawencon.ojol.model.Driver;
import com.lawencon.ojol.model.TransaksiGojeg;

public class TransaksiGojegServiceImpl implements TransaksiGojegService {
	@Override
	public void insertTransaksi(List<TransaksiGojeg> list, TransaksiGojeg transaksiGojeg) throws Exception {
		list.add(transaksiGojeg);
	}

	@Override
	public void showTransaksiGojeg(List<TransaksiGojeg> list) throws Exception {
		System.out.println("=== Laporan Transaksi Gojeg ===");
		System.out.println("---------------------------");
		list.forEach(x -> {
			System.out.println("Id Transaksi : " + x.getIdTransaksiGojeg());
			System.out.println("Harga : " + x.getHarga());
			System.out.println("Lokasi : " + x.getLokasi());
			System.out.println("Tujuan : " + x.getTujuan());
			System.out.println("Nama Driver : " + x.getDriver().getNama());
			System.out.println("No. Plat : " + x.getDriver().getPlat());
			System.out.println("Motor : " + x.getDriver().getMotor());
			System.out.println("---------------------------");
		});
	}

	@Override
	public void transaksiGojeg(Scanner sc, Driver driver, TransaksiGojeg transaksiGojeg,
			List<TransaksiGojeg> listTransaksiGojeg, DriverService driverService) throws Exception {
		sc.nextLine();
		System.out.println("\n===Gojeg====");
		driver = driverService.getDriver(1);
		transaksiGojeg.setIdTransaksiGojeg(ThreadLocalRandom.current().nextInt());
		transaksiGojeg.setDriver(driver);
		do {
			System.out.print("Masukan Lokasi Anda : ");
			transaksiGojeg.setLokasi(sc.nextLine());
			if (transaksiGojeg.getLokasi().equals("")) {
				System.out.println("Inputan tidak boleh kosong");
			}
		} while (transaksiGojeg.getLokasi().equals(""));
		do {
			System.out.print("Masukan Tujuan Anda : ");
			transaksiGojeg.setTujuan(sc.nextLine());
			if (transaksiGojeg.getTujuan().equals("")) {
				System.out.println("Inputan tidak boleh kosong");
			}
		} while (transaksiGojeg.getTujuan().equals(""));
		transaksiGojeg.setHarga(
				(transaksiGojeg.getTujuan().length() + transaksiGojeg.getLokasi().length()) * Constants.HARGA_GOJEG);
		System.out.println("Harga : Rp. " + transaksiGojeg.getHarga());
		System.out.println("Mencari Driver...");
		Thread.sleep(3000);
		System.out.println("===Driver Ditemukan===");
		System.out.println("Nama Driver : " + driver.getNama());
		System.out.println("Plat No : " + driver.getPlat());
		System.out.println("Jenis Motor : " + driver.getMotor());
		System.out.println();
		this.insertTransaksi(listTransaksiGojeg, transaksiGojeg);
	}

}
