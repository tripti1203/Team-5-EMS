package com.example.demo.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.ToString;

@Entity
@DynamicInsert
@DynamicUpdate
public class Address implements Serializable {
	@Id
	private int id;
	private String area;
	private String city;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy="address")
	@JsonIgnore
	private List<Consumer> consumer;
	
	public Address(int id, String area, String city) {
		super();
		this.id = id;
		this.area = area;
		this.city = city;
	}

	public Address() {
		super();
	}

	public Address(int id) {
		this.id = id;
	}

	public List<Consumer> getConsumer() {
		return consumer;
	}

	public void setConsumer(List<Consumer> consumer) {
		this.consumer = consumer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", area=" + area + ", city=" + city + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(area, city, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(area, other.area) && Objects.equals(city, other.city) && id == other.id;
	}
	
}
