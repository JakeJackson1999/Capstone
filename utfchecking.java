package Testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class utfchecking {

	@Test
	void checkUTFValid() {
		boolean check = testing.utfCheck("abcdefghijklmnop");
		Assert.assertTrue(check);
	}
	
	@Test
	void checkUTFInvalid() {
		boolean check = testing.utfCheck("!@#$%");
		Assert.assertFalse(check);
	}

}
