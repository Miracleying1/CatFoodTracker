package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CatFoodTest {
	@Test
	void testGetBrand() {
		CatFood food=new CatFood("a","b","c", 3.2);
		assertEquals(food.getBrand(),"a");
	}
	
	@Test
	void testSetBrand() {
		CatFood food=new CatFood("a","b","c", 3.2);
		food.setBrand("d");
		assertEquals(food.getBrand(),"d");
	}
	
	@Test
	void testGetType() {
		CatFood food=new CatFood("a","b","c", 3.2);
		assertEquals(food.getType(),"c");
	}
	
	@Test
	void testSetType() {
		CatFood food=new CatFood("a","b","c", 3.2);
		food.setType("d");
		assertEquals(food.getType(),"d");
	}
	
	@Test
	void testGetCalories() {
		CatFood food=new CatFood("a","b","c", 3.2);
		assertEquals(food.getCalories(),3.2);
	}
	
	@Test
	void testSetCalories() {
		CatFood food=new CatFood("a","b","c", 3.2);
		food.setCalories(5.6);
		assertEquals(food.getCalories(),5.6);
	}
	
	

}
