package common;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ui.FoodTab;
import ui.HelpTab;
import ui.InitCatTab;
import ui.WeightTab;

public class CatTrackerApp extends Application {

	Stage primaryStage;

	public static void main(String[] args) {
		launch(args);
	}

	private void initializeTabs(Stage primaryStage, Controller control) {
		Text scenetitle = new Text("Cat Tracker");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));

		TabPane tabPane = new TabPane();
		Scene scene = new Scene(tabPane);
		Tab initTab = new InitCatTab(control, primaryStage).getTab();
		Tab foodTab = new FoodTab(control, primaryStage).getTab();
		Tab weightTab = new WeightTab(control, primaryStage).getTab();
		Tab helpTab = new HelpTab(control, primaryStage).getTab();

		foodTab.disableProperty().bind(control.getUnInitialized());
		weightTab.disableProperty().bind(control.getUnInitialized());

		tabPane.getTabs().add(initTab);
		tabPane.getTabs().add(foodTab);
		tabPane.getTabs().add(weightTab);
		tabPane.getTabs().add(helpTab);

		primaryStage.setScene(scene);
		primaryStage.setHeight(600);
		primaryStage.setWidth(800);
		primaryStage.show();

	}

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.getIcons().add(new Image("veterinary.png"));
		Controller control = new Controller();
		primaryStage.setTitle("Pet Health Tracker");
		initializeTabs(primaryStage, control);

	}
}
