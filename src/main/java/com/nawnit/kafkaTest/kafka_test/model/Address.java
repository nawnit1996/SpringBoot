package com.nawnit.kafkaTest.kafka_test.model;

public class Address {
	private Integer id;
	private String city;
	private String line1;

	public Address(Integer id, String city, String line1) {
		super();
		this.id = id;
		this.city = city;
		this.line1 = line1;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

}
