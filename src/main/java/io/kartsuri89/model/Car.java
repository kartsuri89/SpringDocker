package io.kartsuri89.model;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="cars")
public class Car{
	@Id
	private int carId;
	private String carName;
	
	public Car() {}
	
	public Car(String carName) {
		this.carName = carName;
	}

	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}

}
