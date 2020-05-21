package com.lawencon.ojol.service;

import com.lawencon.ojol.model.Driver;

public class DriverServiceImpl implements DriverService {

	@Override
	public Driver getDriver(int id) throws Exception {
		switch (id) {
		case 1:
			return new Driver(1, "Deni Winaryo", "B 1212 AAA", "Honda Beat");
		case 2:
			return new Driver(2, "Cecep Indra", "B 1111 FAG", "Honda Beat");
		case 3:
			return new Driver(3, "Redi Angga", "B 1111 FAD", "Honda Beat");
		default:
			return null;
		}
	}

}
