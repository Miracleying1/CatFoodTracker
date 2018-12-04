import java.util.Date;

import javafx.beans.property.SimpleIntegerProperty;

public class FoodEntry {
	CatFood food;
	Date foodTimeEntry;
	int quantity;
	
	public FoodEntry(CatFood food, Date time, int quantity) {
		this.food = food;
		this.foodTimeEntry = time;
		this.quantity = quantity;
	}
	
	public CatFood getFood() {
		return food;
	}
	
	public void setFood(CatFood food) {
		this.food = food;
	}
	public Date getFoodTimeEntry() {
		return foodTimeEntry;
	}
	public void setFoodTimeEntry(Date foodTimeEntry) {
		this.foodTimeEntry = foodTimeEntry;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getCalories() {
		return food.getCalories( )* quantity;	
	}
}
