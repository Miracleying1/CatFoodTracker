import java.util.ArrayList;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Cat {

	String catName;
	StringProperty fxCatName = new SimpleStringProperty();
	SimpleDoubleProperty fxCalorieGoal = new SimpleDoubleProperty(0);
	SimpleDoubleProperty fxRemainingCals = new SimpleDoubleProperty(0);

	double weight;

	FoodDiary foodDiary = new FoodDiary();
	ArrayList<WeightEntry> weightDiaryList = new ArrayList<WeightEntry>();

	public FoodDiary getFoodDiary() {
		return foodDiary;
	}

	public StringProperty getFxCatName() {
		return fxCatName;
	}

	public void setFoodDiary(FoodDiary foodDiary) {
		this.foodDiary = foodDiary;
	}

	public void setFxCatName(String fxCatName) {
		System.out.println("updaing fx cat name");
		this.fxCatName.set(fxCatName);
	}

	public SimpleDoubleProperty getFxCalorieGoal() {
		return fxCalorieGoal;
	}

	public SimpleDoubleProperty getFxRemainingCals() {
		return fxRemainingCals;
	}

	public ArrayList<WeightEntry> getWeightDiaryList() {
		return weightDiaryList;
	}

	public void setWeightDiaryList(ArrayList<WeightEntry> weightDiaryList) {
		weightDiaryList = weightDiaryList;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.setFxCatName(catName);
		this.catName = catName;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
		this.setCalorieGoal(weight * 30);
		fxRemainingCals.setValue(getCalorieGoal() - foodDiary.getTotalCaloriesToday());
	}

	public double getCalorieGoal() {
		return fxCalorieGoal.get();
	}

	public void setCalorieGoal(double calorieGoal) {
		this.fxCalorieGoal.setValue(calorieGoal);
	}

	public double getRemainingCaloriesToday() {
		return getCalorieGoal() - foodDiary.getTotalCaloriesToday();
	}

	public double getTotalCaloriesToday() {
		return foodDiary.getTotalCaloriesToday();
	}

	public void addFoodEntry(FoodEntry entry) {
		foodDiary.addEntry(entry);
		fxRemainingCals.setValue(getCalorieGoal() - foodDiary.getTotalCaloriesToday());
	}

	public void addWeightEntry(WeightEntry entry) {
		weightDiaryList.add(entry);
	}
}
