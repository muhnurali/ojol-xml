package com.lawencon.ojol;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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
		int menu = 99999;
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
			menuService.showMenuUtama();
			TransaksiGojeg transaksiGojeg = context.getBean("transaksiGojeg", TransaksiGojeg.class);
			try {
				menu = sc.nextInt();
				switch (menu) {
				case 1:
					transaksiGojegService.transaksiGojeg(sc, driver, transaksiGojeg, listTransaksiGojeg, driverService);
					break;
				case 2:
					HeaderGofood headerGofood = context.getBean("headerGofood", HeaderGofood.class);
					DetailGofood detailGofoodFix = context.getBean("detailGofood", DetailGofood.class);
					List<DetailGofood> listDetailFix = new ArrayList<>();
					List<Menu> listMenuFix = new ArrayList<>();
					int total = 0;
					headerService.transaksiGofood(sc, driver, driverService, menu, headerGofood, listDetail,
							detailService, detailGofoodFix, kondisi, menuService, listMenu, menu0, listMenuFix,
							detailGofoodFix, total, listDetailFix, listHeader);
					break;
				case 3:
					TransaksiGosend transaksiGosend = context.getBean("transaksiGosend", TransaksiGosend.class);
					JenisPaket jenisPaket = context.getBean("jenisPaket", JenisPaket.class);
					transaksiGosendService.transaksiGosend(sc, driver, driverService, transaksiGosend,
							jenisPaketService, listJenisPaket, menu, jenisPaket, kondisi, transaksiGosendService,
							listTransaksiGosend);
					break;
				case 4:
					do {
						menuService.showMenuHistory();
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
							System.out.println("Menu Tidak Ditemukan");
							break;
						}
					} while (menu != 99);
					break;
				case 0:
					System.out.println("=== Terimakasih Sudah Menggunakan Aplikasi Ini ===");
					System.exit(0);
					break;
				default:
					System.out.println("Menu Tidak Ditemukan");
					break;
				}
			} catch (Exception e) {
				System.out.println("Inputan Salah, Hanya Angka Yang Diperbolehkan\n");
				sc.nextLine();
			}
		} while (menu != 0);
		sc.close();
	}

}
