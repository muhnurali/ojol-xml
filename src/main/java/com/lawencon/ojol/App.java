package com.lawencon.ojol;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lawencon.ojol.model.Constants;
import com.lawencon.ojol.model.DetailGofood;
import com.lawencon.ojol.model.Driver;
import com.lawencon.ojol.model.HeaderGofood;
import com.lawencon.ojol.model.JenisPaket;
import com.lawencon.ojol.model.Menu;
import com.lawencon.ojol.model.TransaksiGojeg;
import com.lawencon.ojol.model.TransaksiGosend;
import com.lawencon.ojol.service.DetailGofoodService;
import com.lawencon.ojol.service.DetailGofoodServiceImpl;
import com.lawencon.ojol.service.DriverService;
import com.lawencon.ojol.service.DriverServiceImpl;
import com.lawencon.ojol.service.HeaderGofoodService;
import com.lawencon.ojol.service.HeaderGofoodServiceImpl;
import com.lawencon.ojol.service.JenisPaketService;
import com.lawencon.ojol.service.JenisPaketServiceImpl;
import com.lawencon.ojol.service.MenuService;
import com.lawencon.ojol.service.MenuServiceImpl;
import com.lawencon.ojol.service.TransaksiGojegService;
import com.lawencon.ojol.service.TransaksiGojegServiceImpl;
import com.lawencon.ojol.service.TransaksiGosendService;
import com.lawencon.ojol.service.TransaksiGosendServiceImpl;

/**
 * MUHAMMAD NUR ALI
 *
 */
public class App {

	public static void main(String[] args) throws Exception {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("beans-setter.xml");

		Scanner sc = new Scanner(System.in);
		int menu = 0;
		boolean kondisi = true;

		TransaksiGojegService transaksiGojegService = context.getBean("transaksiGojegService",
				TransaksiGojegServiceImpl.class);
		List<TransaksiGojeg> listTransaksiGojeg = new ArrayList<>();

		Driver driver = context.getBean("driver", Driver.class);
		DriverService driverService = context.getBean("driverService", DriverServiceImpl.class);

		List<TransaksiGosend> listTransaksiGosend = new ArrayList<>();
		JenisPaketService jenisPaketService = context.getBean("jenisPaketService", JenisPaketServiceImpl.class);
		TransaksiGosendService transaksiGosendService = context.getBean("transaksiGosendService",
				TransaksiGosendServiceImpl.class);

		JenisPaket jenisPaket1 = context.getBean("jenisPaket", JenisPaket.class);
		jenisPaket1.setIdJenis(1);
		jenisPaket1.setNamaJenis("Elektronik");
		jenisPaket1.setHarga(5000);
		JenisPaket jenisPaket2 = context.getBean("jenisPaket", JenisPaket.class);
		jenisPaket2.setIdJenis(2);
		jenisPaket2.setNamaJenis("Pecah Belah");
		jenisPaket2.setHarga(7000);
		JenisPaket jenisPaket3 = context.getBean("jenisPaket", JenisPaket.class);
		jenisPaket3.setIdJenis(3);
		jenisPaket3.setNamaJenis("Hewan");
		jenisPaket3.setHarga(9000);

		List<JenisPaket> listJenisPaket = new ArrayList<>();
		jenisPaketService.insertJenisPaket(listJenisPaket, jenisPaket1);
		jenisPaketService.insertJenisPaket(listJenisPaket, jenisPaket2);
		jenisPaketService.insertJenisPaket(listJenisPaket, jenisPaket3);

		DetailGofood detailGofood = context.getBean("detailGofood", DetailGofood.class);
		MenuService menuService = context.getBean("menuService", MenuServiceImpl.class);
		HeaderGofoodService headerService = context.getBean("headerGofoodService", HeaderGofoodServiceImpl.class);
		DetailGofoodService detailService = context.getBean("detailGofoodService", DetailGofoodServiceImpl.class);
		List<Menu> listMenu = new ArrayList<>();
		List<DetailGofood> listDetail = new ArrayList<>();
		List<HeaderGofood> listHeader = new ArrayList<>();

		Menu menu0 = null;
		Menu menu1 = context.getBean("menu", Menu.class);
		menu1.setIdMenu(1);
		menu1.setNama("Paket Super Besar 1");
		menu1.setHarga(35000);
		menu1.setQty(0);
		Menu menu2 = context.getBean("menu", Menu.class);
		menu2.setIdMenu(2);
		menu2.setNama("Paket Super Besar 2");
		menu2.setHarga(40000);
		menu2.setQty(0);
		Menu menu3 = context.getBean("menu", Menu.class);
		menu3.setIdMenu(3);
		menu3.setNama("Paket Biasa 1");
		menu3.setHarga(25000);
		menu3.setQty(0);
		Menu menu4 = context.getBean("menu", Menu.class);
		menu4.setIdMenu(4);
		menu4.setNama("Paket Biasa 2");
		menu4.setHarga(30000);
		menu4.setQty(0);

		menuService.insertMenu(listMenu, menu1);
		menuService.insertMenu(listMenu, menu2);
		menuService.insertMenu(listMenu, menu3);
		menuService.insertMenu(listMenu, menu4);

		detailGofood.setId(1);
		detailGofood.setNamaRestoran("KFC");
		detailGofood.setMenu(listMenu);
		detailService.insertGofood(listDetail, detailGofood);

		do {
			TransaksiGojeg transaksiGojeg = context.getBean("transaksiGojeg", TransaksiGojeg.class);

			System.out.println("===Aplikasi Gojeg===");
			System.out.println("1. Gojeg");
			System.out.println("2. Gofood");
			System.out.println("3. Gosend");
			System.out.println("4. History");
			System.out.println("0. Exit");
			System.out.print("Pilih menu : ");
			try {
				menu = sc.nextInt();
				switch (menu) {
				case 1:
					sc.nextLine();
					System.out.println("\n===Gojeg====");
					driver = driverService.getDriver(menu);
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
					transaksiGojegService.insertTransaksi(listTransaksiGojeg, transaksiGojeg);
					break;
				case 2:
					HeaderGofood headerGofood = context.getBean("headerGofood", HeaderGofood.class);
					DetailGofood detailGofoodFix = context.getBean("detailGofood", DetailGofood.class);
					List<DetailGofood> listDetailFix = new ArrayList<>();
					List<Menu> listMenuFix = new ArrayList<>();
					int total = 0;
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
								kondisi =false;
								System.out.println("Menu Tidak Ditemukan\n");
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
									System.out.println("Pesanan Tidak Ditemukan\n");
									kondisi =false;
									sc.nextLine();
								}
							} while (kondisi==false || menu0 == null);
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
						headerService.insertTransaksi(listHeader, headerGofood);
					} while (menu == 2);
					System.out.println("Harga : Rp. " + headerGofood.getTotal());
					System.out.println("Mencari Driver...");
					Thread.sleep(3000);
					System.out.println("===Driver Ditemukan===");
					System.out.println("Nama Driver : " + driver.getNama());
					System.out.println("Plat No : " + driver.getPlat());
					System.out.println("Jenis Motor : " + driver.getMotor());
					System.out.println();
					break;
				case 3:
					TransaksiGosend transaksiGosend = context.getBean("transaksiGosend", TransaksiGosend.class);
					JenisPaket jenisPaket = context.getBean("jenisPaket", JenisPaket.class);

					sc.nextLine();
					System.out.println("\n===Gosend====");
					driver = driverService.getDriver(menu);
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
								kondisi=true;
								break;
							} else {
								System.out.println("Menu Tidak Ditemukan\n");
								kondisi =false;
								continue;
							}
						} catch (Exception e) {
							System.out.println("Inputan tidak boleh huruf\n");
							kondisi = false;
							sc.nextLine();
						}
					} while ( kondisi == false);
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
					break;
				case 4:
					do {
						System.out.println("\n===History===");
						System.out.println("1. Gojeg");
						System.out.println("2. Gofood");
						System.out.println("3. Gosend");
						System.out.println("99. Kembali");
						do {
							System.out.print("Pilih Menu : ");
							try {
								menu = sc.nextInt();
								break;
							} catch (Exception e) {
								System.out.println("Inputan tidak boleh huruf");
								kondisi = false;
								sc.nextLine();
							}
						} while (kondisi == false);
						kondisi = true;
						switch (menu) {
						case 1:
							transaksiGojegService.showTransaksiGojeg(listTransaksiGojeg);
							break;
						case 2:
							try {
								headerService.showTransaksiGofood(listHeader);

							} catch (Exception e) {
								e.printStackTrace();
							}
							break;
						case 3:
							transaksiGosendService.showTransaksiGosend(listTransaksiGosend);
							break;
						case 99:
							System.out.println();
							break;
						default:
							System.out.println("\nMenu Tidak Ditemukan");
							break;
						}
					} while (menu != 99);
					break;
				case 0 :
					System.out.println("=== Terimakasih Sudah Menggunakan Aplikasi Ini ===");
					System.exit(0);
					break;
				default:
					System.out.println("Menu Tidak Ditemukan");
					break;
				}
			} catch (Exception e) {
				System.out.println("\nInputan Salah, Hanya Angka Yang Diperbolehkan");
				sc.nextLine();
			}
		} while (menu != 0);
		sc.close();
	}

}
