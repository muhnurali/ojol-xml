package com.lawencon.ojol.service;

import java.util.List;
import com.lawencon.ojol.model.TransaksiGojeg;

public class TransaksiGojegServiceImpl implements TransaksiGojegService {

	public void insertTransaksi(List<TransaksiGojeg> list, TransaksiGojeg transaksiGojeg) throws Exception {
		list.add(transaksiGojeg);	
	}
	
	public void showTransaksiGojeg(List<TransaksiGojeg> list) throws Exception {
		System.out.println("=== Laporan Transaksi Gojeg ===");
		list.forEach(x->{
			System.out.println("Id Transaksi : "+x.getIdTransaksiGojeg());
			System.out.println("Harga : "+x.getHarga());
			System.out.println("Lokasi : "+x.getLokasi());
			System.out.println("Tujuan : "+x.getTujuan());
			System.out.println("Nama Driver : "+x.getDriver().getNama());
			System.out.println("No. Plat : "+x.getDriver().getPlat());
			System.out.println("Motor : "+x.getDriver().getMotor());
			System.out.println();
		});
	}
	
}
