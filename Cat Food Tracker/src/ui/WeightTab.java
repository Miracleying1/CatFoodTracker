package ui;

import java.util.Date;

import common.Controller;
import domain.WeightEntry;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class WeightTab extends JavaFxTab {
	public WeightTab(Controller control, Stage primaryStage) {
		super(control, primaryStage);
	}

	public Tab getTab() {
		Tab tab = new Tab();
		ImageView icon = new ImageView(new Image("balance.png"));
		icon.setFitWidth(16);
		icon.setFitHeight(16);
		tab.setGraphic(icon);
		tab.setClosable(false);
		tab.setText("Weight Log");

		GridPane grid = new GridPane();
		tab.setContent(grid);
		grid.setAlignment(Pos.TOP_LEFT);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		Text scenetitle = new Text("Weight log");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0, 2, 1);

		Text subtitle = new Text();
		subtitle.textProperty().bind(control.getCat().getFxCatName());
		grid.add(subtitle, 0, 1, 2, 1);

		Label label = new Label("Add new weight entry:");
		grid.add(label, 0, 2);

		TextField textField = new TextField();
		grid.add(textField, 0, 3);

		TableView<WeightEntry> table = getWeightTable();

		Button btn = new Button("Add entry");
		HBox hbBtn = new HBox(10);

		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		grid.add(hbBtn, 0, 4);

		table.setItems(control.getWeightEntries());

		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				control.addWeightEntry(new Date(), Double.parseDouble(textField.getText())); //
			}
		});

		grid.add(table, 0, 5);

		Text maxWeight = new Text();
		maxWeight.setText("Max weight: " + control.getCat().getFxMaxWeight());
		control.getCat().getFxMaxWeight().addListener(new ChangeListener<Object>() {
			@Override
			public void changed(ObservableValue<?> o, Object oldVal, Object newVal) {
				maxWeight.setText("Max weight: " + newVal);
			}
		});
		grid.add(maxWeight, 0, 6);

		Text minWeight = new Text();
		maxWeight.setText("Min weight: " + control.getCat().getFxMinWeight());
		control.getCat().getFxMinWeight().addListener(new ChangeListener<Object>() {
			@Override
			public void changed(ObservableValue arg0, Object oldVal, Object newVal) {
				minWeight.setText("Min weight: " + newVal);
			}
		});
		grid.add(minWeight, 0, 7);

		return tab;
	}

	private TableView<WeightEntry> getWeightTable() {
		TableView<WeightEntry> table = new TableView<WeightEntry>();
		TableColumn weightColumn = new TableColumn("Weight");
		weightColumn.setMinWidth(100);
		weightColumn.setCellValueFactory(new PropertyValueFactory<WeightEntry, Double>("weight"));

		TableColumn dateCol = new TableColumn("Date");
		dateCol.setMinWidth(300);
		dateCol.setCellValueFactory(new PropertyValueFactory<WeightEntry, Date>("date"));

		table.getColumns().addAll(weightColumn, dateCol);
		table.prefHeightProperty().bind(primaryStage.heightProperty());
		table.prefWidthProperty().bind(primaryStage.widthProperty());
		return table;
	}

}
