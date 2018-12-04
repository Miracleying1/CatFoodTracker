package common;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import domain.Cat;
import domain.CatFood;
import domain.CatFoodDatabase;
import domain.FoodEntry;
import domain.WeightEntry;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.ObservableList;

public class Controller {

	// For now, app supports one cat

	// Flag indicating whether cat is initialized
	private final SimpleBooleanProperty unInitialized = new SimpleBooleanProperty(true);

	Cat cat;

	Controller() {
		cat = new Cat();
	}

	public Cat getCat() {
		return cat;
	}

	public void initializeCat(String name, double weight) {
		unInitialized.setValue(false);
		cat.setCatName(name);
		cat.setStartingWeight(weight);
		cat.addWeightEntry(new WeightEntry(weight, new Date()));
	}

	public SimpleBooleanProperty getUnInitialized() {
		return unInitialized;
	}

	public void addEntry(CatFood food, int quantity) {
		cat.addFoodEntry(new FoodEntry(food, new Date(), quantity));
	}

	public void addWeightEntry(Date date, double weight) {
		cat.addWeightEntry(new WeightEntry(weight, date));
	}

	public List<FoodEntry> getTodaysEntries() {
		return cat.getFoodDiary().getTodaysEntries();
	}

	public double getRemainingCalories() {
		return cat.getRemainingCaloriesToday();
	}

	public SimpleDoubleProperty getFxRemainingCalories() {
		return cat.getFxRemainingCals();
	}

	public double getTotalCalories() {
		return cat.getTotalCaloriesToday();
	}

	public double getCalorieGoal() {
		return cat.getCalorieGoal();
	}

	public ArrayList<CatFood> getFoods() {
		CatFoodDatabase fromDb = new CatFoodDatabase(".\\CatFoodInfo.txt");
		return fromDb.getFoodList();
	}

	public ObservableList<WeightEntry> getWeightEntries() {
		return cat.getWeightDiaryList();
	}

	public SimpleDoubleProperty getFxCalorieGoal() {
		return cat.getFxCalorieGoal();
	}
}
