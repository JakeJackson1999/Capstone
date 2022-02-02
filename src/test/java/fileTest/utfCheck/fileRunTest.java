package fileTest.utfCheck;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class fileRunTest {

	@Test
	void testUtfCheckValid() {
		fileRun testing = new fileRun();
		
		boolean expected = true;
		boolean check = testing.utfCheck("AbcdefgHijklmnOOp");
		assertEquals(expected, check);
	}

	@Test
	void testUtfCheckInvalid() {
		fileRun testing = new fileRun();
		boolean expected = false;
		boolean check = testing.utfCheck("!@#$%^&*(");
		assertEquals(expected, check);
	}
}
