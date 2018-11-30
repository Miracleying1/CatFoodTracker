import java.util.Date;

public class Controller {

	//For now, app supports one cat
	Cat cat;
	
	public void initializeCat(String name, double weight ) {
		cat = new Cat(name, weight);
	}
	
	public void addEntry(CatFood food, double quantity) {
		cat.addFoodEntry(new FoodEntry(food, new Date(), quantity ));
	}
	
	public double getRemainingCalories() {
		return cat.getRemainingCaloriesToday();
	}
	
	public double getTotalCalories() {
		return cat.getTotalCaloriesToday();
	}
	
	public double getCalorieGoal() {
		return cat.getCalorieGoal();
	}
}
