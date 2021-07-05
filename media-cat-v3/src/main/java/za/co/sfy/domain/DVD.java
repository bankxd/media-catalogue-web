package za.co.sfy.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "dvdtable")
public class DVD extends MediaType implements Serializable {

	private static final long serialVersionUID = 1L;

	private String leadActor;
	private String leadActress;

	public DVD() {
	}

	public DVD(String title, int length, String genre, String leadActor, String leadActress) {
		super(title, length, genre);
		this.leadActor = leadActor;
		this.leadActress = leadActress;
	}

	@Override
	public int getId() {
		return super.getId();
	}

	@Override
	public void setId(int id) {
		super.setId(id);
	}

	@Override
	public String getTitle() {
		return super.getTitle();
	}

	@Override
	public void setTitle(String title) {
		super.setTitle(title);
	}

	@Override
	public int getLength() {
		return super.getLength();
	}

	@Override
	public void setLength(int length) {
		super.setLength(length);
	}

	@Override
	public String getGenre() {
		return super.getGenre();
	}

	@Override
	public void setGenre(String genre) {
		super.setGenre(genre);
	}

	@Column(name = "leadactor")
	public String getLeadActor() {
		return leadActor;
	}

	public void setLeadActor(String leadActor) {
		this.leadActor = leadActor;
	}

	@Column(name = "leadactress")
	public String getLeadActress() {
		return leadActress;
	}

	public void setLeadActress(String leadActress) {
		this.leadActress = leadActress;
	}
}
