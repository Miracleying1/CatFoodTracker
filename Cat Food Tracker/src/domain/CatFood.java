package domain;
public class CatFood {
	String catFoodID;
	String brand;
	String foodName;
	String flavor;
	String type;
	double calories;// per oz

	public CatFood(String brand, String foodName, String type, double calories) {
		this.catFoodID = catFoodID;
		this.brand = brand;
		this.foodName = foodName;
		this.type = type;
		this.calories = calories;
	}

	public String getCatFoodID() {
		return catFoodID;
	}

	public void setCatFoodID(String catFoodID) {
		this.catFoodID = catFoodID;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getCalories() {
		return calories;
	}

	public void setCalories(double calories) {
		this.calories = calories;
	}
	
	public String toString() {
		return brand + " " + foodName + " " + type + " (" + calories + " calories)";
	}
	
}
