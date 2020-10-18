package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.EditDistance;

class EditDistanceTest {

	private EditDistance editor;
	
	@BeforeEach
	void setUp () {
		editor = new EditDistance ();
	}
	
	@Test
	void testSameStrings() {
		int cost = editor.compareStrings(" maingockien", " maingockien");
		assertEquals(0, cost);
	}
	
	@Test
	void testToltalDifferentStrings () {
		int cost = editor.compareStrings(" 12", " 0");
		assertEquals(2, cost);
	}

	@Test
	void testNormalStrings () {
		int cost = editor.compareStrings(" kien", " keni");
		assertEquals(2, cost);
	}
}
