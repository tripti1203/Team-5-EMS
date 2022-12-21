package com.example.demo.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.example.demo.Exception.ResourceNotFoundException;

import lombok.Data;
import lombok.ToString;

@Entity
@NamedStoredProcedureQuery(name="generateBillByConnectionId", procedureName = "generateBillByConnectionId",parameters= {
		@StoredProcedureParameter(mode= ParameterMode.IN,name="inputId",type=Integer.class),
		@StoredProcedureParameter(mode= ParameterMode.IN,name="currentReading",type=Integer.class)
},resultClasses=Bill.class)
@NamedStoredProcedureQuery(name="billsByMonthAndYear", procedureName = "billsByMonthAndYear",parameters= {
		@StoredProcedureParameter(mode= ParameterMode.IN,name="iyear",type=Integer.class),
		@StoredProcedureParameter(mode= ParameterMode.IN,name="imonth",type=Integer.class)
},resultClasses=Bill.class)
@NamedStoredProcedureQuery(name="billsByCityAndArea", procedureName = "billsByCityAndArea",parameters= {
		@StoredProcedureParameter(mode= ParameterMode.IN,name="iarea",type=String.class),
		@StoredProcedureParameter(mode= ParameterMode.IN,name="icity",type=String.class)
},resultClasses=Bill.class)
@DynamicInsert
@DynamicUpdate
public class Bill implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "consumerId")
	private Consumer consumer;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "connectionId")
	private Connections connections;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "connectionTypeId")
	private ConnectionType connectionType;
	
	private String dateTime;
	private int oldReading;
	private int newReading;
	private int billedUnits;
	private double totalAmount;
	
	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Bill(int id, Consumer consumer, Connections connections, ConnectionType connectionType, String dateTime,
			int oldReading, int newReading, int billedUnits, double totalAmount) {
		this.id = id;
		this.consumer = consumer;
		this.connections = connections;
		this.connectionType = connectionType;
		this.dateTime = dateTime;
		this.oldReading = oldReading;
		this.newReading = newReading;
		this.billedUnits = billedUnits;
		this.totalAmount = totalAmount;
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
	public Connections getConnections() {
		return connections;
	}
	public void setConnections(Connections connections) {
		this.connections = connections;
	}
	public ConnectionType getConnectionType() {
		return connectionType;
	}
	public void setConnectionType(ConnectionType connectionType) {
		this.connectionType = connectionType;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public int getOldReading() {
		return oldReading;
	}
	public void setOldReading(int oldReading) {
		this.oldReading = oldReading;
	}
	public int getNewReading() {
		return newReading;
	}
	public void setNewReading(int newReading) {
		this.newReading = newReading;
	}
	public int getBilledUnits() {
		return billedUnits;
	}
	public void setBilledUnits(int billedUnits) {
		this.billedUnits = billedUnits;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public String toString() {
		return "Bill [id=" + id + ", consumer=" + consumer + ", connections=" + connections + ", connectionType="
				+ connectionType + ", dateTime=" + dateTime + ", oldReading=" + oldReading + ", newReading="
				+ newReading + ", billedUnits=" + billedUnits + ", totalAmount=" + totalAmount + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(billedUnits, connectionType, connections, consumer, dateTime, id, newReading, oldReading,
				totalAmount);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bill other = (Bill) obj;
		return billedUnits == other.billedUnits && Objects.equals(connectionType, other.connectionType)
				&& Objects.equals(connections, other.connections) && Objects.equals(consumer, other.consumer)
				&& Objects.equals(dateTime, other.dateTime) && id == other.id && newReading == other.newReading
				&& oldReading == other.oldReading
				&& Double.doubleToLongBits(totalAmount) == Double.doubleToLongBits(other.totalAmount);
	}
	
}

