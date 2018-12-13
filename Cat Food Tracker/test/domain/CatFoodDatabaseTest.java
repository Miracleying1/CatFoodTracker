package domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
public class CatFoodDatabaseTest {

	@Test
	public void testInitialize() {
		CatFoodDatabase testDb = null;
		try {
			testDb = new CatFoodDatabase(new String(".\\test\\domain\\testDBFiles\\testCatFoodDb.txt"));
		} catch (FileNotFoundException e) {
			fail("exception thrown");
		}
		assertEquals(testDb.getFoodList().size(), 1);
		assertEquals(testDb.getFoodList().get(0).getBrand(), "Merrick");
		assertEquals(testDb.getFoodList().get(0).getFoodName(), "Turkey Yum");
		assertEquals(testDb.getFoodList().get(0).getType(), "Dry");
		assertEquals(testDb.getFoodList().get(0).getCalories(), 26.56);
	}
	
	@Test
	public void testInvalidFile() {			
		 Assertions.assertThrows(RuntimeException.class, new Executable() {
		        @Override
		        public void execute() throws Throwable {
		        	CatFoodDatabase db = new CatFoodDatabase(new String(".\\test\\domain\\testDBFiles\\testCatFoodDbInvalid.txt"));
		        }
		    });
	}
}

