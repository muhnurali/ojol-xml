package com.lawencon.ojol.service;

import java.util.List;
import com.lawencon.ojol.model.TransaksiGosend;

public interface TransaksiGosendService {
	void insertTransaksi(List<TransaksiGosend> list, TransaksiGosend transaksiGosend) throws Exception;
	void showTransaksiGosend(List<TransaksiGosend> list) throws Exception;
}
