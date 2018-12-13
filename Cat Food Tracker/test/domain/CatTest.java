package domain;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

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
		CatFood food = new CatFood("b","c", "d", 25);
		cat.addFoodEntry(new FoodEntry(food, new Date(), 1));
		
		cat.setStartingWeight(10);
		assertEquals(cat.getStartingWeight(), 10);
		assertEquals(cat.getCalorieGoal(), 300);
		assertEquals(cat.getTotalCaloriesToday(), 25);
		assertEquals(cat.getRemainingCaloriesToday(), 275);
	}
	
	@Test
	void testGetFoodDiary() {
		CatFood food=new CatFood("b","c","d",25);
		FoodEntry entry = new FoodEntry(food, new Date(), 5);
		FoodDiary diary=new FoodDiary();
		diary.addEntry(entry);
		assertNotEquals(diary.getEntries(), entry);
		assertNotEquals(diary.getTodaysEntries(),entry);
	}
	
	@Test
	void testSetFoodDiary() {
		CatFood food=new CatFood("b","c","d",25);
		FoodEntry entry = new FoodEntry(food, new Date(), 5);
		FoodDiary diary=new FoodDiary();
		Map<Date, List<FoodEntry>> entries = new HashMap<Date, List<FoodEntry>>();
		entries.get(entry);
		diary.setEntries(entries);
		assertEquals(diary.getEntries(),entries);
	}

	@Test
	void testCatName() {
		Cat cat=new Cat();
		cat.setCatName("Fred");
		assertEquals(cat.getCatName(),"Fred");
	}
	
	@Test
	void testCalorieGoal() {
		Cat cat=new Cat();
		cat.setCalorieGoal(300);
		assertEquals(cat.getCalorieGoal(),300);
	}

}
