import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;

public class Cat {
	String catName;
	double weight;
	double calorieGoal=weight*30;
	ArrayList<FoodDiary> FoodDiaryList=new ArrayList<FoodDiary>();
	ArrayList<WeightDiary> WeightDiaryList=new ArrayList<WeightDiary>();
	
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
	}
	public double getCalorieGoal() {
		return calorieGoal;
	}
	public void setCalorieGoal(double calorieGoal) {
		this.calorieGoal = calorieGoal;
	}
	
	
	public double remainingCalories() {
		for (int i=0;i<FoodDiaryList.size();i++) {
			
			if (DateUtils.isSameDay(new Date(),FoodDiaryList.get(i).getFoodTimeEntry())){
				
			}
	
		}
		return calorieGoal;
	}
}
