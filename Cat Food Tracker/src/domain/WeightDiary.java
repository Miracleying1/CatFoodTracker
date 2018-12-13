package domain;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class WeightDiary {

	
	private ObservableList<WeightEntry> fxWeightDiaryList = FXCollections.observableArrayList();

	public ObservableList<WeightEntry> getFxWeightDiaryList() {
		return fxWeightDiaryList;
	}

	public void addEntry(WeightEntry entry) {
		this.fxWeightDiaryList.add(entry);
	}
	
	public double getLowestWeight() {
		double lowest = Integer.MAX_VALUE;
		for(int i =0; i< fxWeightDiaryList.size(); i++) {
			if(fxWeightDiaryList.get(i).getWeight() < lowest) {
				lowest = fxWeightDiaryList.get(i).getWeight(); 
			}			
		}
		return lowest;
	}
	
	public double getHighestWeight() {
		double highest = 0;
		for(int i =0; i< fxWeightDiaryList.size(); i++) {
			if(fxWeightDiaryList.get(i).getWeight() > highest) {
				highest = fxWeightDiaryList.get(i).getWeight(); 
			}			
		}
		return highest;		
	}
}
