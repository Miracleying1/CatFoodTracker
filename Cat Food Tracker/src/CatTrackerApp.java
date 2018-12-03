
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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
		Tab initTab = new InitCatTab(control, primaryStage).getCatInitTab();
		Tab foodTab = new FoodTab(control, primaryStage).getFoodTab();
		
		foodTab.disableProperty().bind(control.getUnInitialized());		

		tabPane.getTabs().add(initTab);
		tabPane.getTabs().add(foodTab);

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
