package domain;
import java.util.ArrayList;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cat {

	StringProperty fxCatName = new SimpleStringProperty();
	SimpleDoubleProperty fxCalorieGoal = new SimpleDoubleProperty(0);
	SimpleDoubleProperty fxRemainingCals = new SimpleDoubleProperty(0);
	SimpleDoubleProperty fxMaxWeight = new SimpleDoubleProperty(0);
	SimpleDoubleProperty fxMinWeight = new SimpleDoubleProperty(0);

	double startingWeight;

	FoodDiary foodDiary = new FoodDiary();
	WeightDiary weightDiary = new WeightDiary();	

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
		this.fxCatName.set(fxCatName);
	}

	public SimpleDoubleProperty getFxCalorieGoal() {
		return fxCalorieGoal;
	}

	public SimpleDoubleProperty getFxRemainingCals() {
		return fxRemainingCals;
	}

	public ObservableList<WeightEntry> getWeightDiaryList() {
		return weightDiary.getFxWeightDiaryList();
	}

	public String getCatName() {
		return fxCatName.getValue();
	}

	public void setCatName(String catName) {
		this.setFxCatName(catName);
	}

	public double getStartingWeight() {
		return startingWeight;
	}

	public void setStartingWeight(double weight) {
		this.startingWeight = weight;
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
		weightDiary.addEntry(entry);
		setFxMaxWeight(weightDiary.getHighestWeight());
		setFxMinWeight(weightDiary.getLowestWeight());
	}

	public SimpleDoubleProperty getFxMaxWeight() {
		return fxMaxWeight;
	}

	public void setFxMaxWeight(double fxMaxWeight) {
		this.fxMaxWeight.set(fxMaxWeight);
	}

	public SimpleDoubleProperty getFxMinWeight() {
		return fxMinWeight;
	}

	public void setFxMinWeight(double fxMinWeight) {
		this.fxMinWeight.set(fxMinWeight);
	}	
}
