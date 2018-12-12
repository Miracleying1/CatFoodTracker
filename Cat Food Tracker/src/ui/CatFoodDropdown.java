package ui;

import java.util.ArrayList;

import common.Controller;
import domain.CatFood;
import javafx.beans.property.ObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

public class CatFoodDropdown {

	private ComboBox<CatFood> comboBox;
	
	CatFoodDropdown(Controller control){
		ArrayList<CatFood> foods = control.getFoods();
		ObservableList<CatFood> options = FXCollections.observableArrayList();
		comboBox = new ComboBox<CatFood>(options);
		for (int i = 0; i < foods.size(); i++) {
			options.add(foods.get(i));
		}
	}

	public ComboBox<CatFood> getComboBox() {
		return comboBox;
	}
	
	public CatFood getSelection() {
		return comboBox.getValue();
	}
	
	public ObjectProperty<CatFood> getProperty() {
		return comboBox.valueProperty();
	}
	
	public boolean comboBoxHasSelection() {
		return comboBox.getValue() != null;
	}
}
