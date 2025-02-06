package com.sddevops.jenkins_maven.eclipse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SongCollectionTest {
	private SongCollection sc;
	private Song s1;
	private Song s2;
	private Song s3;
	private Song s4;
	private final int SONG_COLLECTION_SIZE = 4;

	private SongCollection scByTitle;
	private SongCollection scBySongLength;
	
	@BeforeEach
	void setUp() throws Exception {
		// Arrange
		sc = new SongCollection();
		s1 = new Song("001", "good 4 u", "Olivia Rodrigo", 3.59);
		s2 = new Song("002", "Peaches", "Justin Bieber", 3.18);
		s3 = new Song("003", "MONTERO", "Lil Nas", 2.3);
		s4 = new Song("004", "bad guy", "billie eilish", 3.14);
		sc.addSong(s1);
		sc.addSong(s2);
		sc.addSong(s3);
		sc.addSong(s4);
		// System.out.println("sc: "+sc.getSongs());
		
		scByTitle = new SongCollection();
		scByTitle.addSong(s3);
		scByTitle.addSong(s2);
		scByTitle.addSong(s4);
		scByTitle.addSong(s1);
		// ArrayList<Song> scByTitle;
		// System.out.println("scByTitle: "+scByTitle.getSongs());
		
		scBySongLength = new SongCollection();
		scBySongLength.addSong(s1);
		scBySongLength.addSong(s2);
		scBySongLength.addSong(s4);
		scBySongLength.addSong(s3);
		// ArrayList<Song> scBySongLength;
		// System.out.println("scBySongLength: "+scBySongLength.getSongs());
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetSongs() {
		//Act
		List<Song> testSc=sc.getSongs();
		//Assert that Song Collection is equals to Song Collection Size 4
		assertEquals(testSc.size(),SONG_COLLECTION_SIZE);
	}

	@Test
	void testAddSong() {
		List<Song> testSc=sc.getSongs();
		//Assert that Song Collection is equals to Song Collection Size 4
		assertEquals(testSc.size(),SONG_COLLECTION_SIZE);
		//Act
		sc.addSong(s1);
		//Assert that Song Collection is equals to Song Collection Size 4 + 1
		assertEquals(testSc.size(),SONG_COLLECTION_SIZE+1);

	}

	@Test
	void testSortSongsByTitle() {
		//fail("Not yet implemented");
		//Act
		ArrayList<Song> testSc = sc.sortSongsByTitle();
		//Assert
		assertEquals(testSc,scByTitle.getSongs());

	}

	@Test
	void testSortSongsBySongLength() {
		//fail("Not yet implemented");
		//Act
		ArrayList<Song> testSc = sc.sortSongsBySongLength();
		//Assert
		assertEquals(testSc,scBySongLength.getSongs());
	}

	@Test
	void testFindSongsById() {
		//Act
		Song testSc=sc.findSongsById("002");
		//Assert
		assertEquals(testSc.getId(),"002");
	}

	@Test
	void testFindSongByTitle() {
		//Act
		Song testSc=sc.findSongByTitle("bad guy");
		//Assert
		assertEquals(testSc.getTitle(),"bad guy");
	}

}
