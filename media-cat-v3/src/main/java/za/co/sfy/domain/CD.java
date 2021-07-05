package za.co.sfy.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "cdtable")
@PrimaryKeyJoinColumn(name = "cd_artists")
public class CD extends MediaType implements Serializable {

	private static final long serialVersionUID = 1L;

	private int tracks;
	private List<String> artists;

	public CD() {
	}

	public CD(String title, int length, String genre, int tracks, List<String> artists) {
		super(title, length, genre);
		this.tracks = tracks;
		this.artists = artists;
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

	@Column(name = "tracks")
	public int getTracks() {
		return tracks;
	}

	public void setTracks(int tracks) {
		this.tracks = tracks;
	}

	@ElementCollection(targetClass = String.class)
	@Column(name = "artists")
	public List<String> getArtists() {
		return artists;
	}

	public void setArtists(List<String> artists) {
		this.artists = artists;
	}
}
