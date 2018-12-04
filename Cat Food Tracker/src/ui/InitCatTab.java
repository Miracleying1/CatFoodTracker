package ui;

import common.Controller;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class InitCatTab extends JavaFxTab {

	public InitCatTab(Controller control, Stage primaryStage) {
		super(control, primaryStage);
	}

	public Tab getTab() {

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.TOP_LEFT);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		Text scenetitle = new Text("Setup");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0, 2, 1);

		Label catName = new Label("Cat name:");
		grid.add(catName, 0, 1);

		TextField catNameTextField = new TextField();
		grid.add(catNameTextField, 1, 1);

		Label weight = new Label("Starting weight:");
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
				catNameTextField.setEditable(false);
				weightTextField.setEditable(false);
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
}
