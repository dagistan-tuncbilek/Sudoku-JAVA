package sudoku;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class UtilsTest {

	@Test
//	@DisplayName ("Test - GetFirstTile")
	void testGetFirstTile() {
		int actual = Utils.getFirstTile(new int []{1,4,5,8,2,4,0,1,2,3,5,9,0});
		int expected = 6;
		assertEquals(expected, actual);
	}

}
