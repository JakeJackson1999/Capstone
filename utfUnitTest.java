package fileTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class utfUnitTest {

	@Test
	void checkUTFValid() {
		boolean check = fileTest.utfCheck("abcdefghijklmnop");
		Assert.assertTrue(check);
	}
	
	@Test
	void checkUTFInvalid() {
		boolean check = fileTest.utfCheck("!@#$%");
		Assert.assertFalse(check);
	}

}
