import java.util.ArrayList;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
public class Cat {


	String catName;
	StringProperty fxCatName = new SimpleStringProperty();
	SimpleDoubleProperty fxCalorieGoal = new SimpleDoubleProperty(0);	

	double weight;
	
	FoodDiary foodDiary = new FoodDiary();
	ArrayList<WeightEntry> WeightDiaryList=new ArrayList<WeightEntry>();
	
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

	public ArrayList<WeightEntry> getWeightDiaryList() {
		return WeightDiaryList;
	}

	public void setWeightDiaryList(ArrayList<WeightEntry> weightDiaryList) {
		WeightDiaryList = weightDiaryList;
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
	}
	public double getCalorieGoal() {
		return fxCalorieGoal.get();
	}
	public void setCalorieGoal(double calorieGoal) {		
		this.fxCalorieGoal.setValue(calorieGoal);		
	}
	
	public double getRemainingCaloriesToday() {	
		int totalCalorieToday =  foodDiary.getTotalCaloriesToday();
		return getCalorieGoal() - totalCalorieToday;
	}
	
	public double getTotalCaloriesToday() {
		return foodDiary.getTotalCaloriesToday();		
	}
	
	public void addFoodEntry(FoodEntry entry) {
		foodDiary.addEntry(entry);
	}
}
