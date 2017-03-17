package model;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PARCEL")
public class Parcel {
	
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String weight;
	
	@Column(name="addressee")
	private String destination;
	
	@Embedded
	private Stamp mainStamp;
	
	@ElementCollection(fetch = FetchType.EAGER)
	private Set<Stamp> stamps = new HashSet<>();
	
	@ElementCollection(fetch = FetchType.EAGER)
	private Map<String,String> labels = new HashMap<>();
	
	public Parcel() {}
	
	public Parcel(String name, String weight, String destination, Stamp mainStamp) {
		this.name = name;
		this.weight = weight;
		this.destination = destination;
		this.mainStamp = mainStamp;
	}

	public Set<Stamp> getStamps() {
		return stamps;
	}

	public void setStamps(Set<Stamp> stamps) {
		this.stamps = stamps;
	}

	public Map<String, String> getLabels() {
		return labels;
	}

	public void setLabels(Map<String, String> labels) {
		this.labels = labels;
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	public Stamp getMainStamp() {
		return mainStamp;
	}

	public void setMainStamp(Stamp mainStamp) {
		this.mainStamp = mainStamp;
	}

	@Override
	public String toString() {
		return "Parcel [id=" + id + ", name=" + name + ", weight=" + weight + ", destination=" + destination + "]";
	}

	
	

}
