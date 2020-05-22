package com.lawencon.ojol.service;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import com.lawencon.ojol.model.Constants;
import com.lawencon.ojol.model.DetailGofood;
import com.lawencon.ojol.model.Driver;
import com.lawencon.ojol.model.HeaderGofood;
import com.lawencon.ojol.model.Menu;

public class HeaderGofoodServiceImpl implements HeaderGofoodService {

	@Override
	public void showTransaksiGofood(List<HeaderGofood> list) throws Exception {
		System.out.println("=== Laporan Transaksi Gofood ===");
		System.out.println("---------------------");
		list.forEach(x -> {
			System.out.println("Id Transaksi : " + x.getIdTransaksiGofood());
			System.out.println("Lokasi : " + x.getLokasi());
			System.out.println("Harga : Rp. " + x.getTotal());
			System.out.println("Nama Driver : " + x.getDriver().getNama());
			System.out.println("No. Plat : " + x.getDriver().getPlat());
			System.out.println("Motor : " + x.getDriver().getMotor());
			System.out.println("Restoran : " + x.getDetail().get(0).getNamaRestoran());
			x.getDetail().get(0).getMenu().forEach(y -> {
				if (y.getQty() != 0) {
					System.out.println();
					System.out.println("Pesanan : " + y.getNama());
					System.out.println("Banyaknya : " + y.getQty());
					System.out.println("Harga : Rp. " + y.getHarga());
				}
			});
			System.out.println("---------------------");
		});
	}

	@Override
	public void insertTransaksi(List<HeaderGofood> list, HeaderGofood header) throws Exception {
		list.add(header);
	}

	@Override
	public void transaksiGofood(Scanner sc, Driver driver, DriverService driverService, int menu,
			HeaderGofood headerGofood, List<DetailGofood> listDetail, DetailGofoodService detailService,
			DetailGofood detailGofoodFix, boolean kondisi, MenuService menuService, List<Menu> listMenu, Menu menu0,
			List<Menu> listMenuFix, DetailGofood detailGofood, int total, List<DetailGofood> listDetailFix,
			List<HeaderGofood> listHeader) throws Exception {
		do {
			sc.nextLine();
			System.out.println("\n===Gofood====");
			driver = driverService.getDriver(menu);
			headerGofood.setIdTransaksiGofood(ThreadLocalRandom.current().nextInt());
			headerGofood.setDriver(driver);
			do {
				System.out.print("Masukan Lokasi Anda : ");
				headerGofood.setLokasi(sc.nextLine());
				if (headerGofood.getLokasi().equals("")) {
					System.out.println("Inputan tidak boleh kosong");
				}
			} while (headerGofood.getLokasi().equals(""));

			detailService.showDetail(listDetail);
			do {
				try {
					System.out.print("Pilih Restoran : ");
					menu = sc.nextInt();
					detailGofoodFix = detailService.selectDetail(listDetail, menu);
					kondisi = true;
				} catch (Exception e) {
					kondisi = false;
					System.out.println("Restoran Tidak Ditemukan\n");
					sc.nextLine();
				}
			} while (kondisi == false || detailGofoodFix == null);

			do {
				do {
					try {
						menuService.showMenu(listMenu);
						System.out.print("Pilih Pesanan : ");
						menu = sc.nextInt();
						menu0 = menuService.seletMenu(listMenu, menu);
						kondisi = true;
					} catch (Exception e) {
						System.out.println("Menu Tidak Ditemukan\n");
						kondisi = false;
						sc.nextLine();
					}
				} while (kondisi == false || menu0 == null);
				do {
					System.out.print("Banyaknya : ");
					try {
						menu0.setQty(sc.nextInt());
						if (menu0.getQty() == 0) {
							System.out.println("Inputan tidak boleh nol");
							kondisi = false;
						} else {
							kondisi = true;
						}
					} catch (Exception e) {
						System.out.println("Inputan tidak boleh huruf");
						kondisi = false;
						sc.nextLine();
					}
				} while (menu0.getQty() == 0 || kondisi == false);

				menuService.insertMenu(listMenuFix, menu0);
				detailGofood.setMenu(listMenuFix);

				total = total + (menu0.getHarga() * menu0.getQty());
				headerGofood.setTotal(total + (Constants.HARGA_GOFOOD * headerGofood.getLokasi().length()));
				detailService.insertGofood(listDetailFix, detailGofoodFix);
				headerGofood.setDetail(listDetailFix);
				System.out.println("===Menu===");
				System.out.println("9. Tambah Pesanan");
				System.out.println("99. Sudah");
				do {
					System.out.print("Pilih Menu : ");
					try {
						menu = sc.nextInt();
						if (menu == 9 || menu == 99) {
							kondisi = true;
						} else {
							System.out.println("Menu tidak ditemukan");
							kondisi = false;
						}
					} catch (Exception e) {
						System.out.println("Inputan tidak boleh huruf");
						kondisi = false;
					}
					sc.nextLine();
				} while (kondisi == false);
			} while (menu == 9);
			this.insertTransaksi(listHeader, headerGofood);
		} while (menu == 2);
		System.out.println("Harga : Rp. " + headerGofood.getTotal());
		System.out.println("Mencari Driver...");
		Thread.sleep(3000);
		System.out.println("===Driver Ditemukan===");
		System.out.println("Nama Driver : " + driver.getNama());
		System.out.println("Plat No : " + driver.getPlat());
		System.out.println("Jenis Motor : " + driver.getMotor());
		System.out.println();
	}

}
