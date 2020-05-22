package com.lawencon.ojol.service;

import java.util.List;

import com.lawencon.ojol.model.DetailGofood;

public interface DetailGofoodService {
	void insertGofood(List<DetailGofood> list, DetailGofood gofood) throws Exception;

	void showDetail(List<DetailGofood> list) throws Exception;

	DetailGofood selectDetail(List<DetailGofood> list, int id) throws Exception;

	void showMenu(List<DetailGofood> list) throws Exception;
}
