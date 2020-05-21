package com.lawencon.ojol.service;

import java.util.List;
import com.lawencon.ojol.model.TransaksiGosend;

public class TransaksiGosendServiceImpl implements TransaksiGosendService {

	public void insertTransaksi(List<TransaksiGosend> list, TransaksiGosend transaksiGosend) throws Exception {
		list.add(transaksiGosend);
	}

	public void showTransaksiGosend(List<TransaksiGosend> list) throws Exception {
		System.out.println("=== Laporan Transaksi Gosend ===");
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
			System.out.println();
		});
	}
}
