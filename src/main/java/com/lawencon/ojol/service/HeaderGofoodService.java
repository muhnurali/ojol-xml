package com.lawencon.ojol.service;

import java.util.List;
import com.lawencon.ojol.model.HeaderGofood;

public interface HeaderGofoodService {
	void insertTransaksi(List<HeaderGofood> list, HeaderGofood header) throws Exception;
	void showTransaksiGofood(List<HeaderGofood> list) throws Exception;
}
