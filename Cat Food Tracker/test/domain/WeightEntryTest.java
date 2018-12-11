package domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WeightEntryTest {

	@Test
	void testGetWeight() {
		WeightEntry entry=new WeightEntry(11, new Date());
		assertEquals(entry.getWeight(),11);	
	}
	
	@Test
	void testSetWeigt() {
		WeightEntry entry=new WeightEntry(1,new Date());
		entry.setWeight(12);
		assertEquals(entry.getWeight(),12);
	}
	
	@Test
	void testSetDate() {
		WeightEntry entry=new WeightEntry(1,null);
		entry.setDate(new Date());
		assertEquals(entry.getDate(), new Date());
	}

	@Test
	void testGetDate() {
		WeightEntry entry=new WeightEntry(1, new Date());
		assertEquals(entry.getDate(), new Date());
	}
}
