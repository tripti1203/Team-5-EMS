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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString
@DynamicInsert
@DynamicUpdate
public class Connections implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "consumerId")
	private Consumer consumer;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "connectionTypeId")
	private ConnectionType connectionType;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy="connections")
	@JsonIgnore
	private List<Bill> bill;
	
	private int oldReading;
	private String addedOn;
	
	public Connections() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Connections(int id, Consumer consumer, ConnectionType connectionType, int oldReading, String addedOn) {
		super();
		this.id = id;
		this.consumer = consumer;
		this.connectionType = connectionType;
		this.oldReading = oldReading;
		this.addedOn = addedOn;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Consumer getConsumer() {
		return consumer;
	}
	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}
	public ConnectionType getConnectionType() {
		return connectionType;
	}
	public void setConnectionType(ConnectionType connectionType) {
		this.connectionType = connectionType;
	}
	public int getOldReading() {
		return oldReading;
	}
	public void setOldReading(int oldReading) {
		this.oldReading = oldReading;
	}
	public String getAddedOn() {
		return addedOn;
	}
	public void setAddedOn(String addedOn) {
		this.addedOn = addedOn;
	}
	
	public List<Bill> getBill() {
		return bill;
	}
	public void setBill(List<Bill> bill) {
		this.bill = bill;
	}
	
	@Override
	public String toString() {
		return "Connections [id=" + id + ", consumer=" + consumer + ", connectionType=" + connectionType
				+ ", oldReading=" + oldReading + ", addedOn=" + addedOn + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(addedOn, connectionType, consumer, id, oldReading);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Connections other = (Connections) obj;
		return Objects.equals(addedOn, other.addedOn) && Objects.equals(connectionType, other.connectionType)
				&& Objects.equals(consumer, other.consumer) && id == other.id && oldReading == other.oldReading;
	}
}
