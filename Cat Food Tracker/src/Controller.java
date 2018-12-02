import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javafx.beans.Observable;

public class Controller {

	//For now, app supports one cat
	Cat cat;
	
	public Cat getCat() {
		return cat;
	}

	public void setCat(Cat cat) {
		this.cat = cat;
	}

	public void initializeCat(String name, double weight ) {
		cat = new Cat(name, weight);
	}
	
	public void addEntry(CatFood food, double quantity) {
		cat.addFoodEntry(new FoodEntry(food, new Date(), quantity ));
	}
	
	public double getRemainingCalories() {
		if(cat != null) {
			return cat.getRemainingCaloriesToday();
		} else {
			return 0;
		}
	}
	
	public double getTotalCalories() {
		if(cat != null) {
		return cat.getTotalCaloriesToday();
		} else {
			return 0;
		}
	}
	
	public double getCalorieGoal() {
		if(cat != null) {
		return cat.getCalorieGoal();
		} else {
			return 0;
		}
	}
	
	public ArrayList<CatFood> getFoods(){
		CatFoodDatabase fromDb = new CatFoodDatabase(".\\CatFoodInfo.txt");
		return fromDb.foodList;
	}
}
