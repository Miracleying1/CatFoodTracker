
import java.util.ArrayList;
import java.util.List;

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CatTrackerApp extends Application {

	Stage primaryStage;

	public static void main(String[] args) {
		launch(args);
	}

	private void showStartScreen(Stage primaryStage, Controller control) {
		Text scenetitle = new Text("Cat Tracker");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));

		TabPane tabPane = new TabPane();
		Scene scene = new Scene(tabPane);
		Tab initTab = getCatInitTab(control);
		Tab foodTab = getFoodTab(control);
		// Todo would be nice to disable until cat is initialized
		// foodTab.setDisable(true);

		tabPane.getTabs().add(initTab);
		tabPane.getTabs().add(foodTab);

		primaryStage.setScene(scene);
		primaryStage.setHeight(600);
		primaryStage.setWidth(800);
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
			}
		});
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		grid.add(hbBtn, 1, 4);
		Tab initTab = new Tab();
		ImageView icon = new ImageView(new Image("cat.png"));
	    icon.setFitWidth(16); 
	    icon.setFitHeight(16);
	    initTab.setGraphic(icon);
		initTab.setText("Your Cat");
		initTab.setContent(grid);
		initTab.setClosable(false);
		return initTab;

	}

	
	public Tab getFoodTab(Controller control) {
		Tab foodTab = new Tab();
		ImageView icon = new ImageView(new Image("fish-food.png"));
	    icon.setFitWidth(16); 
	    icon.setFitHeight(16);
		foodTab.setGraphic(icon);
		foodTab.setClosable(false);
		foodTab.setText("Food Log");
		GridPane grid = new GridPane();
		foodTab.setContent(grid);
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		Text scenetitle = new Text("Food log");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0, 2, 1);
		ArrayList<CatFood> foods = control.getFoods();
		ObservableList<CatFood> options = FXCollections.observableArrayList();
		final ComboBox<CatFood> comboBox = new ComboBox<CatFood>(options);
		for (int i = 0; i < foods.size(); i++) {
			options.add(foods.get(i));
		}
		grid.add(comboBox, 0, 1);

		Label quantity = new Label("Quantity:");
		grid.add(quantity, 0, 2);

		TextField quantityTextField = new TextField();
		quantityTextField.setMaxWidth(50);
		grid.add(quantityTextField, 0, 3);

		Button btn = new Button("Add food");
		HBox hbBtn = new HBox(10);
		
		Text goal = new Text("Calorie Goal: " + control.getCalorieGoal());
		grid.add(goal, 0, 6);

		Text caloriesToday = new Text("Todays calories: " + control.getTotalCalories());
		grid.add(caloriesToday, 0, 7);
		
		Text remainingCalories = new Text("Remaining calories: " + control.getRemainingCalories());
		grid.add(remainingCalories, 0, 8);

		hbBtn.setAlignment(Pos.TOP_LEFT);
		hbBtn.getChildren().add(btn);
		grid.add(hbBtn, 0, 4);

		TableView<FoodEntry> table = new TableView<FoodEntry>();
		TableColumn foodName = new TableColumn("Food");
		foodName.setMinWidth(300);
		foodName.setCellValueFactory(new PropertyValueFactory<FoodEntry, CatFood>("food"));

		TableColumn quantityCol = new TableColumn("Amount");
		quantityCol.setMinWidth(100);
		quantityCol.setCellValueFactory(new PropertyValueFactory<FoodEntry, String>("quantity"));

		TableColumn timeCol = new TableColumn("Time");
		timeCol.setMinWidth(200);
		timeCol.setCellValueFactory(new PropertyValueFactory<FoodEntry, String>("foodTimeEntry"));
		table.getColumns().addAll(foodName, quantityCol, timeCol);
		table.prefHeightProperty().bind(primaryStage.heightProperty());
		table.prefWidthProperty().bind(primaryStage.widthProperty());
		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				control.addEntry(comboBox.getValue(), Integer.parseInt(quantityTextField.getText()));
				
				// Todo The table display should update automatically if observable list is set
				// up correctly,
				// but setting it manually each time as a hack/shortcut
				goal.setText("Calorie Goal: " + control.getCalorieGoal());
				caloriesToday.setText("Todays calories: " + control.getTotalCalories());
				remainingCalories.setText("Remaining calories: " + control.getRemainingCalories());				
				ObservableList<FoodEntry> data = FXCollections.observableArrayList(control.getTodaysEntries());
				table.setItems(data);
			}
		});
		grid.add(table, 0, 5);

		return foodTab;
	}

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.getIcons().add(new Image("veterinary.png"));
		Controller control = new Controller();
		primaryStage.setTitle("Pet Health Tracker");
		showStartScreen(primaryStage, control);

	}
}
