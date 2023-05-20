package micronaut.demo.movie.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

public class Movie implements Serializable{
	
	private static final long serialVersionUID = 3413033273791553964L;
	
	private String id;

	private String description;
	
	private float year;

	public Movie() {
		
	}
	
	public Movie(String description) {
		this.description = description;
	}
	
	public String getId() {
		return id;
	}
	public String getDescription() {
		return description;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
}
