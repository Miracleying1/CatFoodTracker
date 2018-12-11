package domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WeightDiaryTest {

	@Test
	void testAddEntryt() {
		WeightDiary diary=new WeightDiary();
		WeightEntry entry=new WeightEntry(11, new Date());
		diary.addEntry(entry);
		assertNotNull(diary.getLowestWeight());
	}
	
	@Test
	void testGetLowestWeight() {
		WeightDiary diary=new WeightDiary();
		WeightEntry entry1=new WeightEntry(11, new Date());
		diary.addEntry(entry1);
		WeightEntry entry2=new WeightEntry(12, new Date());
		diary.addEntry(entry2);
		assertEquals(diary.getLowestWeight(),11);
	}
	
	@Test
	void testGetHighestWeight() {
		WeightDiary diary=new WeightDiary();
		WeightEntry entry1=new WeightEntry(11, new Date());
		diary.addEntry(entry1);
		WeightEntry entry2=new WeightEntry(12, new Date());
		diary.addEntry(entry2);
		assertEquals(diary.getLowestWeight(),12);
	}


}
