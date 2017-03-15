package model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="parcel")
public class Parcel {
	
	@Column(name = "id")
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String weight;
	private String destination;
	
	public Parcel() {
	}

	public Parcel(String name, String weight, String destination) {
		this.name = name;
		this.weight = weight;
		this.destination = destination;
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

	@Override
	public String toString() {
		return "Parcel [id=" + id + ", name=" + name + ", weight=" + weight + ", destination=" + destination + "]";
	}

	
	

}
