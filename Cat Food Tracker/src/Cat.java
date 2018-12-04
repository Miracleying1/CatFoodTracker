import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
public class Cat {


	String catName;
	double weight;
	double calorieGoal;
	
	FoodDiary foodDiary = new FoodDiary();
	ArrayList<WeightEntry> WeightDiaryList=new ArrayList<WeightEntry>();
	
	public FoodDiary getFoodDiary() {
		return foodDiary;
	}

	public void setFoodDiary(FoodDiary foodDiary) {
		this.foodDiary = foodDiary;
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
		this.catName = catName;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
		calorieGoal= weight*30;
	}
	public double getCalorieGoal() {
		return calorieGoal;
	}
	public void setCalorieGoal(double calorieGoal) {
		this.calorieGoal = calorieGoal;
	}
	
	public double getRemainingCaloriesToday() {	
		int totalCalorieToday =  foodDiary.getTotalCaloriesToday();
		return calorieGoal - totalCalorieToday;
	}
	
	public double getTotalCaloriesToday() {
		return foodDiary.getTotalCaloriesToday();		
	}
	
	public void addFoodEntry(FoodEntry entry) {
		foodDiary.addEntry(entry);
	}
}
