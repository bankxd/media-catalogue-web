package za.co.sfy.dataAccess;

import java.util.List;

import za.co.sfy.domain.MediaType;

public interface CatalogueResourceInterface {
	boolean create(MediaType type);

	MediaType retrieveMediaType(MediaType type);

	List<MediaType> retrieveAllOfType(MediaType type);

	boolean update(MediaType type, String title);

	boolean delete(MediaType type);
}
