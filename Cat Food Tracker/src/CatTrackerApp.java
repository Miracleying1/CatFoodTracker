
import java.util.ArrayList;

import javafx.application.Application;
import javafx.beans.binding.BooleanBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//To enable JavaFx UI, follow instructions for allowing accesing (option using Eclipse Build Path worked well)
//https://stackoverflow.com/questions/22812488/using-javafx-in-jre-8-access-restriction-error
public class CatTrackerApp extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	private void showStartScreen(Stage primaryStage, Controller control) {
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		Scene scene = new Scene(grid, 600, 575);
		Text scenetitle = new Text("Cat Tracker");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0, 2, 1);

		Label catName = new Label("Cat name:");
		grid.add(catName, 0, 1);

		TextField catNameTextField = new TextField();
		grid.add(catNameTextField, 1, 1);

		Label weight = new Label("Weight:");
		grid.add(weight, 0, 2);

		TextField weightTextField = new TextField();
		grid.add(weightTextField, 1, 2);

		Text currentCat = new Text("Current cat: ");
		grid.add(currentCat, 0, 5);

		Text currentCatWeight = new Text("Current cat weight: ");
		grid.add(currentCatWeight, 0, 6);

		Text caloriesToday = new Text("Todays calories: ");
		grid.add(caloriesToday, 0, 7);

		BooleanBinding bb = new BooleanBinding() {
			{
				super.bind(catNameTextField.textProperty(), weightTextField.textProperty());
			}

			@Override
			protected boolean computeValue() {
				return (catNameTextField.getText().isEmpty() || weightTextField.getText().isEmpty());
			}
		};
		Button btn = new Button("Add cat");
		HBox hbBtn = new HBox(10);
		btn.disableProperty().bind(bb);

		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				control.initializeCat(catNameTextField.getText(), Double.parseDouble(weightTextField.getText()));
				currentCat.setText("Current cat: " + control.getCat().getCatName());
				currentCatWeight.setText("Current weight: " + control.getCat().getWeight());
				caloriesToday.setText("Todays Calories: " + control.getCat().getTotalCaloriesToday());
				showFoodScreen(primaryStage, control);
				
			}
		});
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		grid.add(hbBtn, 1, 4);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void showFoodScreen(Stage primaryStage, Controller control) {
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		Text scenetitle = new Text("Add food");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0, 2, 1);
		ArrayList<CatFood> foods = control.getFoods();
		ObservableList<String> options = FXCollections.observableArrayList();
		final ComboBox<String> comboBox = new ComboBox<String>(options);
		for(int i =0; i < foods.size(); i++) {
			options.add(foods.get(i).getBrand());
		}
		grid.add(comboBox, 0, 1);
		primaryStage.getScene().setRoot(grid);
	}

	@Override
	public void start(Stage primaryStage) {
		Controller control = new Controller();
		primaryStage.setTitle("Cat food Tracker");
		showStartScreen(primaryStage, control);

	}
}
//public class CatTrackerApp {
//
//	
//	 public static void main(String[] args) {
//		Controller control = new Controller();
//		CatFoodUI ui = new CatFoodUI();
//		
//		//Following code is simulation of events UI might trigger
//		control.initializeCat("Buddy", 15.0 );
//		//Todo get list of foods from fake DB 
//		//String catFoodID,String brand, String type, double calories
//		control.addEntry(new CatFood("1", "Purina", "dry", 30), 1);
//		
//		System.out.println("Goal cals: " + control.getCalorieGoal());
//		System.out.println("Consumed cals: " + control.getTotalCalories());
//		System.out.println("Remaining cals: " + control.getRemainingCalories());
//		
//		control.addEntry(new CatFood("1", "Purina", "wet", 50), 2);
//		System.out.println("Goal cals: " + control.getCalorieGoal());
//		System.out.println("Consumed cals: " + control.getTotalCalories());
//		System.out.println("Remaining cals: " + control.getRemainingCalories());
//		 
//	 }
//}
