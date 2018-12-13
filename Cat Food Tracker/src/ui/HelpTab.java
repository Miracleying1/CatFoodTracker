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

public class HelpTab extends JavaFxTab {

	public HelpTab(Controller control, Stage primaryStage) {
		super(control, primaryStage);
	}

	public Tab getTab() {

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.TOP_LEFT);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		Text scenetitle = new Text("Help");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0, 2, 1);

		Text help = new Text("Add your cat to the app. Once cat is added, other tabs will be enabled.\r\r\n" + 
				"As you feed your cat, add the food entry on the food tab. Take note of the remaining calories to determine how much you can feed your cat. \r\r\n" + 
				"Calorie goal is determined by a standard formula allowing 30 calories per pound of body weight.\r\r\n" + 
				"Each day, weigh your cat and add an entry on the weight tab, to track your cats progress over time.\r\r\n" + 
				"");		
		grid.add(help, 0, 1);

		Text credits = new Text("Images credits: \r\n"
				+ "www.flaticon.com \r\n" + 
				"www.icons8.com");
		grid.add(credits, 0, 16);
		
		Tab initTab = new Tab();
		ImageView icon = new ImageView(new Image("help.png"));
		icon.setFitWidth(16);
		icon.setFitHeight(16);
		initTab.setGraphic(icon);
		initTab.setText("Help");
		initTab.setContent(grid);
		initTab.setClosable(false);
		return initTab;

	}
}
