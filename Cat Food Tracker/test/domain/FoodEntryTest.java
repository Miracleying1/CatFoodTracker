package domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FoodEntryTest {


	@Test
	void testGetFood() {
		CatFood food=new CatFood("a","b","c","d",25);
		FoodEntry entry=new FoodEntry(food, new Date(), 3);
		entry.getFood();
		assertEquals(entry.getQuantity(),3);
		assertEquals(entry.getFood(), food);
	}
	
	@Test
	void testSetFood() {
		CatFood food=new CatFood("a","b","c","d",25);
		food.setCatFoodID("D001");
		food.setBrand("Merrick");
		food.setType("Dry");
		food.setCalories(26.56);
		assertEquals(food.getBrand(),"Merrick");
		assertEquals(food.getCatFoodID(), "D001");
		assertEquals(food.getType(),"Dry");
		assertEquals(food.getCalories(), 26.56);
	}
	
	@Test
	void testSetFoodTimeEntry() {
		CatFood food=new CatFood("a","b","c","d",25);
		FoodEntry entry=new FoodEntry(food, new Date(), 2);
		assertEquals(entry.getFoodTimeEntry(), new Date());
	}

	@Test
	void testGetFoodTimeEntry() {
		CatFood food=new CatFood("a","b","c","d",25);
		FoodEntry entry=new FoodEntry(food, null, 0);
		entry.setFoodTimeEntry(new Date());
		assertEquals(entry.getFoodTimeEntry(), new Date());
	}
	
	@Test
	void testSetQuantity() {
		CatFood food=new CatFood("a","b","c","d",25);
		FoodEntry entry=new FoodEntry(food, new Date(), 0);
		entry.setQuantity(2);
		assertEquals(entry.getQuantity(),2);
	}
	
	@Test
	void testGetQuantity() {
		CatFood food=new CatFood("a","b","c","d",25);
		FoodEntry entry=new FoodEntry(food, new Date(), 5);
		assertEquals(entry.getQuantity(),5);
	}
	
	@Test
	void testGetCalories() {
		CatFood food=new CatFood("a","b","c","d",25);
		FoodEntry entry=new FoodEntry(food, new Date(), 5);
		assertEquals(entry.getCalories(), 125);
	}
}
