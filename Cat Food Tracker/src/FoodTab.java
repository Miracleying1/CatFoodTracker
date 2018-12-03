
import java.util.ArrayList;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FoodTab {
	
	Controller control; 
	Stage primaryStage;
	
	FoodTab(Controller control, Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.control = control;
	}
	
	public Tab getFoodTab() {
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
		
		Text subtitle = new Text();		
		subtitle.textProperty().bind(control.getCat().getFxCatName());
		grid.add(subtitle, 0, 1, 2, 1);

		
		ArrayList<CatFood> foods = control.getFoods();
		ObservableList<CatFood> options = FXCollections.observableArrayList();
		final ComboBox<CatFood> comboBox = new ComboBox<CatFood>(options);
		for (int i = 0; i < foods.size(); i++) {
			options.add(foods.get(i));
		}
		grid.add(comboBox, 0, 2);

		Label quantity = new Label("Quantity:");
		grid.add(quantity, 0, 3);

		TextField quantityTextField = new TextField();
		quantityTextField.setMaxWidth(50);
		grid.add(quantityTextField, 0, 4);

		Button btn = new Button("Add food");
		HBox hbBtn = new HBox(10);
		
		Text goal = new Text("Calorie Goal: " + control.getCalorieGoal());
		grid.add(goal, 0, 7);

		Text caloriesToday = new Text("Todays calories: " + control.getTotalCalories());
		grid.add(caloriesToday, 0, 8);
		
		Text remainingCalories = new Text("Remaining calories: " + control.getRemainingCalories());
		grid.add(remainingCalories, 0, 9);
		
		Text calorieMessage = new Text("Cat can keep eating!");
		grid.add(calorieMessage, 0, 10);

		hbBtn.setAlignment(Pos.TOP_LEFT);
		hbBtn.getChildren().add(btn);
		grid.add(hbBtn, 0, 5);

		TableView<FoodEntry> table = getFoodTable();
		grid.add(table, 0, 6);
		
		BooleanBinding bb = new BooleanBinding() {
			{
				super.bind(quantityTextField.textProperty(), comboBox.valueProperty());
			}

			@Override
			protected boolean computeValue() {
				return (quantityTextField.getText().isEmpty() || comboBox.getValue() == null);
			}
		};
		
		btn.disableProperty().bind(bb);		
		//todo listen to observable for total cals
		//todo listen to observable for remaining cals
		
		  control.getFxCalorieGoal().addListener(new ChangeListener<Object>(){
			  	@Override public void changed(ObservableValue<?> o,Object oldVal, 
                 Object newVal){
			  		goal.setText("Calorie Goal: " + control.getCalorieGoal());            
			  	}
		  });
		
		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				control.addEntry(comboBox.getValue(), Integer.parseInt(quantityTextField.getText()));
				
				// Todo The table display should update automatically if observable list is set
				// up correctly,
				// but setting it manually each time as a hack/shortcut
				caloriesToday.setText("Todays calories: " + control.getTotalCalories());
				remainingCalories.setText("Remaining calories: " + control.getRemainingCalories());
				if(control.getRemainingCalories() <= 0) {
					calorieMessage.setText("Cat is over the calorie limit!");
					calorieMessage.setFill(Color.RED);
				}
				ObservableList<FoodEntry> data = FXCollections.observableArrayList(control.getTodaysEntries());
				table.setItems(data);
			}
		});		

		return foodTab;
	}
	
	private TableView<FoodEntry> getFoodTable() {
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
		return table;
	}
	
}
