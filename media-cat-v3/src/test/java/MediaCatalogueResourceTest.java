import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import za.co.sfy.dataAccess.MediaCatalogueResource;
import za.co.sfy.domain.CD;
import za.co.sfy.domain.DVD;

class MediaCatalogueResourceTest {

	CD cd;
	DVD dvd;
	MediaCatalogueResource resource;

	@BeforeEach
	void setUp() throws Exception {
		cd = new CD();
		cd.setId(14);
		cd.setTitle("American Idiot");
		cd.setLength(111);
		cd.setGenre("updated");
		cd.setTracks(11);
		List<String> list = new ArrayList<>();
		list.add("artist");
		cd.setArtists(list);
		resource = new MediaCatalogueResource();

		dvd = new DVD();
		dvd.setId(3);
		dvd.setTitle("Invictus");
		dvd.setLength(111);
		dvd.setGenre("updated");
		dvd.setLeadActor("updated");
		dvd.setLeadActress("updated");
	}

//	@Test
//	void createTestcd() {
//		assertEquals(true, resource.createMediaType(cd));
//	} // PASSED
//
//	@Test
//	void createTestdvd() {
//		assertEquals(true, resource.createMediaType(dvd));
//	} // PASSED
//
//	@Test
//	void retrieveAllCDTest() {
//		List<MediaType> retrieveAllOfCDType = resource.retrieveAllOfType(new CD());
//		assertEquals(63, retrieveAllOfCDType.get(0).getLength());
//	} // PASSED
//
//	@Test
//	void retrieveAllDVDTest() {
//		List<MediaType> retrieveAllOfDVDType = resource.retrieveAllOfType(new DVD());
//		assertEquals(123, retrieveAllOfDVDType.get(0).getLength());
//	} // PASSED


//	@Test
//	void retrieveCD() {
//		MediaType retrievedCD = (CD) resource.retrieveMediaType(cd);
//		assertEquals(14, retrievedCD.getId());
//		assertEquals("American Idiot", retrievedCD.getTitle());
//	} 

	//	@Test
//	void retrieveDVD() {
//		MediaType retrievedDVD = (DVD) resource.retrieveMediaType(dvd);
//		assertEquals(3, retrievedDVD.getId());
//		assertEquals("Invictus", retrievedDVD.getTitle());
//	} 
	
//	@Test
//	void updateCDTest() {
//		assertEquals(true, resource.updateMediaType(cd));
//	} // PASSED

//	@Test
//	void updateDVDTest() {
//		assertEquals(true, resource.deleteMediaType(dvd));
//	} // PASSED
	
	@Test
	void deleteCDTest() {
		assertEquals(true, resource.deleteMediaType(cd));
	}
	
	@Test
	void deleteDVDTest() {
		assertEquals(true, resource.deleteMediaType(cd));
	}

}
