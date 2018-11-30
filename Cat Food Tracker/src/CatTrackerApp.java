
public class CatTrackerApp {

	
	 public static void main(String[] args) {
		Controller control = new Controller();
		CatFoodUI ui = new CatFoodUI();
		
		//Following code is simulation of events UI might trigger
		control.initializeCat("Buddy", 15.0 );
		//Todo get list of foods from fake DB 
		//String catFoodID,String brand, String type, double calories
		control.addEntry(new CatFood("1", "Purina", "dry", 30), 1);
		
		System.out.println("Goal cals: " + control.getCalorieGoal());
		System.out.println("Consumed cals: " + control.getTotalCalories());
		System.out.println("Remaining cals: " + control.getRemainingCalories());
		
		control.addEntry(new CatFood("1", "Purina", "wet", 50), 2);
		System.out.println("Goal cals: " + control.getCalorieGoal());
		System.out.println("Consumed cals: " + control.getTotalCalories());
		System.out.println("Remaining cals: " + control.getRemainingCalories());
		 
	 }
}
