package domain;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.jupiter.api.Test;

import domain.CatFood;
import domain.FoodDiary;
import domain.FoodEntry;

class FoodDiaryTest {

	@Test
	void testInitialize() {
		FoodDiary diary = new FoodDiary();
		assertNotNull(diary.getEntries().get(DateUtils.truncate(new Date(), java.util.Calendar.DAY_OF_MONTH)));
		assertEquals(diary.getEntries().get(DateUtils.truncate(new Date(), java.util.Calendar.DAY_OF_MONTH)).size(), 0);
	}
	
	@Test
	void testAddEntry(){
		FoodDiary diary = new FoodDiary();
		CatFood food = new CatFood("b","c", "d", 25);
		FoodEntry entry = new FoodEntry(food, new Date(), 1);
		diary.addEntry(entry);
		assertEquals(diary.getTotalCaloriesToday(), 25);
	}
	
	@Test
	void testAddTwoEntries(){
		FoodDiary diary = new FoodDiary();
		CatFood food = new CatFood("b","c", "d", 25);
		FoodEntry entry1 = new FoodEntry(food, new Date(), 1);
		FoodEntry entry2 = new FoodEntry(food, new Date(), 1);
		diary.addEntry(entry1);
		diary.addEntry(entry2);
		assertEquals(diary.getTotalCaloriesToday(), 50);
	}
	
	@Test
	void testAddEntryWithQuantity(){
		FoodDiary diary = new FoodDiary();
		CatFood food = new CatFood("b","c", "d", 25);
		FoodEntry entry = new FoodEntry(food, new Date(), 3);
		diary.addEntry(entry);
		assertEquals(diary.getTotalCaloriesToday(), 75);
	}
	
	@Test
	void testGetTodaysEntries(){
		FoodDiary diary = new FoodDiary();
		CatFood food = new CatFood("b","c", "d", 25);
		FoodEntry entry = new FoodEntry(food, new Date(), 1);
		diary.addEntry(entry);
		assertEquals(diary.getTodaysEntries().size(), 1);
		assertEquals(diary.getTodaysEntries().get(0), entry);
	}
	
	@Test
	void testGetTodaysEntriesNewDay(){
		FoodDiary diary = new FoodDiary();
		diary.getEntries().clear();
		assertEquals(diary.getTodaysEntries(), null);		
	}
	
	@Test
	void testAddEntriesNewDay(){
		FoodDiary diary = new FoodDiary();
		diary.getEntries().clear();
		CatFood food = new CatFood("b","c", "d", 25);
		FoodEntry entry = new FoodEntry(food, new Date(), 1);
		diary.addEntry(entry);
		assertEquals(diary.getTotalCaloriesToday(), 25);		
	}
}
