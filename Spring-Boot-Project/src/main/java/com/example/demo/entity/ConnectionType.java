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
import javax.persistence.OneToMany;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
@DynamicInsert
@DynamicUpdate
public class ConnectionType implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String type;
	private double fixedCharge;
	private double perUnitCharge;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy="connectionType")
	@JsonIgnore
	private List<Bill> bill;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy="connectionType")
	@JsonIgnore
	private List<Connections> connections;
	
	public List<Connections> getConnections() {
		return connections;
	}
	public void setConnections(List<Connections> connections) {
		this.connections = connections;
	}
	public List<Bill> getBill() {
		return bill;
	}
	public void setBill(List<Bill> bill) {
		this.bill = bill;
	}
	public ConnectionType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ConnectionType(int id, String type, double fixedCharge, double perUnitCharge) {
		super();
		this.id = id;
		this.type = type;
		this.fixedCharge = fixedCharge;
		this.perUnitCharge = perUnitCharge;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getFixedCharge() {
		return fixedCharge;
	}
	public void setFixedCharge(double fixedCharge) {
		this.fixedCharge = fixedCharge;
	}
	public double getPerUnitCharge() {
		return perUnitCharge;
	}
	public void setPerUnitCharge(double perUnitCharge) {
		this.perUnitCharge = perUnitCharge;
	}
	@Override
	public String toString() {
		return "ConnectionType [id=" + id + ", type=" + type + ", fixedCharge=" + fixedCharge + ", perUnitCharge="
				+ perUnitCharge + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(fixedCharge, id, perUnitCharge, type);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConnectionType other = (ConnectionType) obj;
		return Double.doubleToLongBits(fixedCharge) == Double.doubleToLongBits(other.fixedCharge) && id == other.id
				&& Double.doubleToLongBits(perUnitCharge) == Double.doubleToLongBits(other.perUnitCharge)
				&& Objects.equals(type, other.type);
	}
}
