import java.util.Date;

public class FoodDiary {
	CatFood food;
	Date foodTimeEntry;
	double quantity;
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
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public double getCalories() {
		return food.getCalories()*quantity;	
	}
	
}
