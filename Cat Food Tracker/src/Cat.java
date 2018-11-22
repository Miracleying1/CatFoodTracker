
public class Cat {
	String catName;
	double weight;
	
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
	double calorieGoal=weight*30;
	
}
