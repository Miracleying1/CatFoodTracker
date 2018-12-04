package ui;
import common.Controller;
import javafx.scene.control.Tab;
import javafx.stage.Stage;

public abstract class JavaFxTab {

	Controller control;
	Stage primaryStage;

	JavaFxTab(Controller control, Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.control = control;
	}

	public abstract Tab getTab();
}
