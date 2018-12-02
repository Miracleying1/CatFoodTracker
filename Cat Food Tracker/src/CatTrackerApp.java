
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
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
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
		Text scenetitle = new Text("Cat Tracker");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));

		TabPane tabPane = new TabPane();
		Scene scene = new Scene(tabPane, 600, 575);
		Tab initTab = getCatInitTab(control);
		Tab foodTab = getFoodTab(control);
		//TODO foodTab.setDisable(true);
		
		tabPane.getTabs().add(initTab);
		tabPane.getTabs().add(foodTab);

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public Tab getCatInitTab(Controller control) {

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.TOP_LEFT);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

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
			}
		});
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		grid.add(hbBtn, 1, 4);
		Tab initTab = new Tab();
		initTab.setText("Your Cat");
		initTab.setContent(grid);
		initTab.setClosable(false);
		return initTab;

	}

	public Tab getFoodTab(Controller control) {
		Tab foodTab = new Tab();
		foodTab.setClosable(false);
		foodTab.setText("Food Log");
		GridPane grid = new GridPane();
		foodTab.setContent(grid);
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		Text scenetitle = new Text("Add food");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0, 2, 1);
		ArrayList<CatFood> foods = control.getFoods();
		ObservableList<CatFood> options = FXCollections.observableArrayList();
		final ComboBox<CatFood> comboBox = new ComboBox<CatFood>(options);
		for (int i = 0; i < foods.size(); i++) {
			options.add(foods.get(i));
		}
		grid.add(comboBox, 0, 1);

		Button btn = new Button("Add food");
		HBox hbBtn = new HBox(10);

		Text caloriesToday = new Text("Todays calories: " + control.getTotalCalories());
		grid.add(caloriesToday, 0, 7);

		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				control.addEntry(comboBox.getValue(), 1);
				caloriesToday.setText("Todays calories: " + control.getTotalCalories());
			}
		});
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		grid.add(hbBtn, 1, 4);
		
		return foodTab;
	}

	@Override
	public void start(Stage primaryStage) {
		Controller control = new Controller();
		primaryStage.setTitle("Cat food Tracker");
		showStartScreen(primaryStage, control);

	}
}
