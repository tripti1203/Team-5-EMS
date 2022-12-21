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
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.example.demo.entity.Address;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString
@DynamicInsert
@DynamicUpdate
public class Consumer implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String lastName;
	private String addedOn;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "addressId")
	private Address address;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy="consumer")
	@JsonIgnore
	private List<Connections> connections;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy="consumer")
	@JsonIgnore
	private List<Bill> bill;
	
	public List<Bill> getBill() {
		return bill;
	}

	public void setBill(List<Bill> bill) {
		this.bill = bill;
	}

	public List<Connections> getConnections() {
		return connections;
	}

	public void setConnections(List<Connections> connections) {
		this.connections = connections;
	}

	public Consumer() {
		super();
	}

	public Consumer(int id, String firstName, String lastName, String addedOn, Address address) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.addedOn = addedOn;
		this.address = address;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(String addedOn) {
        this.addedOn = addedOn;
    }

	@Override
	public String toString() {
		return "Consumer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", addedOn=" + addedOn
				+ ", address=" + address + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(addedOn, address, firstName, id, lastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Consumer other = (Consumer) obj;
		return Objects.equals(addedOn, other.addedOn) && Objects.equals(address, other.address)
				&& Objects.equals(firstName, other.firstName) && id == other.id
				&& Objects.equals(lastName, other.lastName);
	}
}
