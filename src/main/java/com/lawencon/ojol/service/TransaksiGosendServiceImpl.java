package com.lawencon.ojol.service;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import com.lawencon.ojol.model.Constants;
import com.lawencon.ojol.model.Driver;
import com.lawencon.ojol.model.JenisPaket;
import com.lawencon.ojol.model.TransaksiGosend;

public class TransaksiGosendServiceImpl implements TransaksiGosendService {
	@Override
	public void insertTransaksi(List<TransaksiGosend> list, TransaksiGosend transaksiGosend) throws Exception {
		list.add(transaksiGosend);
	}

	@Override
	public void showTransaksiGosend(List<TransaksiGosend> list) throws Exception {
		System.out.println("=== Laporan Transaksi Gosend ===");
		System.out.println("---------------------------");
		list.forEach(x -> {
			System.out.println("Id Transaksi : " + x.getIdTransaksiGosend());
			System.out.println("Lokasi : " + x.getLokasi());
			System.out.println("Tujuan : " + x.getTujuan());
			System.out.println("Jenis Paket : " + x.getJenisBarang().getNamaJenis());
			System.out.println("Harga : Rp. " + x.getHarga());
			System.out.println("Berat Paket : " + x.getBerat() + " Kg");
			System.out.println("Nama Driver : " + x.getDriver().getNama());
			System.out.println("No. Plat : " + x.getDriver().getPlat());
			System.out.println("Motor : " + x.getDriver().getMotor());
			System.out.println("---------------------------");
		});
	}

	@Override
	public void transaksiGosend(Scanner sc, Driver driver, DriverService driverService, TransaksiGosend transaksiGosend,
			JenisPaketService jenisPaketService, List<JenisPaket> listJenisPaket, int menu, JenisPaket jenisPaket,
			boolean kondisi, TransaksiGosendService transaksiGosendService, List<TransaksiGosend> listTransaksiGosend)
			throws Exception {
		sc.nextLine();
		System.out.println("\n===Gosend====");
		driver = driverService.getDriver(3);
		transaksiGosend.setIdTransaksiGosend(ThreadLocalRandom.current().nextInt());
		transaksiGosend.setDriver(driver);
		do {
			System.out.print("Masukan Lokasi Anda : ");
			transaksiGosend.setLokasi(sc.nextLine());
			if (transaksiGosend.getLokasi().equals("")) {
				System.out.println("Inputan tidak boleh kosong");
			}
		} while (transaksiGosend.getLokasi().equals(""));
		do {
			System.out.print("Masukan Tujuan Paket : ");
			transaksiGosend.setTujuan(sc.nextLine());
			if (transaksiGosend.getTujuan().equals("")) {
				System.out.println("Inputan tidak boleh kosong");
			}
		} while (transaksiGosend.getTujuan().equals(""));
		do {
			jenisPaketService.showJenisPaket(listJenisPaket);
			try {
				System.out.print("Pilih Jenis Paket : ");
				menu = sc.nextInt();
				if (menu > 0 && menu < 4) {
					jenisPaket = jenisPaketService.getById(listJenisPaket, menu);
					transaksiGosend.setJenisPaket(jenisPaket);
					kondisi = true;
					break;
				} else {
					System.out.println("Menu Tidak Ditemukan\n");
					kondisi = false;
					continue;
				}
			} catch (Exception e) {
				System.out.println("Inputan tidak boleh huruf\n");
				kondisi = false;
				sc.nextLine();
			}
		} while (kondisi == false);
		do {
			System.out.print("Berat Paket (Kg) : ");
			try {
				transaksiGosend.setBerat(sc.nextInt());
				if (transaksiGosend.getBerat() == 0) {
					System.out.println("Inputan tidak boleh nol\n");
					kondisi = false;
				} else {
					kondisi = true;
					break;
				}
			} catch (Exception e) {
				System.out.println("Inputan tidak boleh huruf\n");
				kondisi = false;
				sc.nextLine();
			}
		} while (kondisi == false);
		transaksiGosend.setHarga(
				Constants.HARGA_GOSEND * (transaksiGosend.getLokasi().length() + transaksiGosend.getTujuan().length())
						+ (transaksiGosend.getBerat() * jenisPaket.getHarga()));
		System.out.println("Harga : Rp. " + transaksiGosend.getHarga());
		System.out.println("Mencari Driver...");
		Thread.sleep(3000);
		System.out.println("===Driver Ditemukan===");
		System.out.println("Nama Driver : " + driver.getNama());
		System.out.println("Plat No : " + driver.getPlat());
		System.out.println("Jenis Motor : " + driver.getMotor());
		System.out.println();
		transaksiGosendService.insertTransaksi(listTransaksiGosend, transaksiGosend);
	}
}
