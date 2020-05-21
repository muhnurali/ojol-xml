package com.lawencon.ojol.service;

import java.util.List;
import com.lawencon.ojol.model.TransaksiGojeg;

public interface TransaksiGojegService {
	void insertTransaksi(List<TransaksiGojeg> list, TransaksiGojeg transaksiGojeg) throws Exception;
	void showTransaksiGojeg(List<TransaksiGojeg> list) throws Exception;
}
