package com.lawencon.ojol.service;

import java.util.List;
import com.lawencon.ojol.model.HeaderGofood;

public class HeaderGofoodServiceImpl implements HeaderGofoodService {
	
	
	@Override
	public void showTransaksiGofood(List<HeaderGofood> list) throws Exception {
		System.out.println("=== Laporan Transaksi Gofood ===");
		list.forEach(x->{
			System.out.println("Id Transaksi : "+x.getIdTransaksiGofood());
			System.out.println("Lokasi : "+x.getLokasi());
			System.out.println("Harga : Rp. "+x.getTotal());
			System.out.println("Nama Driver : " + x.getDriver().getNama());
			System.out.println("No. Plat : " + x.getDriver().getPlat());
			System.out.println("Motor : " + x.getDriver().getMotor());
			System.out.println("Restoran : "+x.getDetail().get(0).getNamaRestoran());
			x.getDetail().get(0).getMenu().forEach(y->{
				System.out.println();
				System.out.println("Pesanan : "+y.getNama());
				System.out.println("Banyaknya : "+ y.getQty());
				System.out.println("Harga : Rp. "+y.getHarga());
			});
			System.out.println("---------------------");
		});
	}
	

	@Override
	public void insertTransaksi(List<HeaderGofood> list, HeaderGofood header) throws Exception {
		list.add(header);		
	}

	

	
}
