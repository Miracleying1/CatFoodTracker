import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

class CatTest {

	@Test
	void testSetStartingWeight() {
		Cat cat = new Cat();
		cat.setStartingWeight(10);
		assertEquals(cat.getStartingWeight(), 10);
		assertEquals(cat.getCalorieGoal(), 300);
		assertEquals(cat.getRemainingCaloriesToday(), 300);
	}

	@Test
	void testGetRemainingCals() {
		Cat cat = new Cat();
		CatFood food = new CatFood("a","b", "c", "d", 25);
		cat.addFoodEntry(new FoodEntry(food, new Date(), 1));
		
		cat.setStartingWeight(10);
		assertEquals(cat.getStartingWeight(), 10);
		assertEquals(cat.getCalorieGoal(), 300);
		assertEquals(cat.getTotalCaloriesToday(), 25);
		assertEquals(cat.getRemainingCaloriesToday(), 275);
	}
}
