package za.co.sfy.domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Access(AccessType.PROPERTY)
public abstract class MediaType {

	private int id;
	private String title;
	private int length;
	private String genre;

	public MediaType() {
	}
	
	public MediaType(String title, int length, String genre) {
		this.title = title;
		this.length = length;
		this.genre = genre;
	}
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	@Column(name = "title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "length")
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	@Column(name = "genre")
	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
}
