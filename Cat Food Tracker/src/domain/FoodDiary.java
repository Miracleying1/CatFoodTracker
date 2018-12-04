package domain;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.time.DateUtils;

public class FoodDiary {
	private Map<Date, List<FoodEntry>> entries = new HashMap<Date, List<FoodEntry>>();

	public FoodDiary() {
		Date now = DateUtils.truncate(new Date(), java.util.Calendar.DAY_OF_MONTH);
		getEntries().put(now, new ArrayList<FoodEntry>());
	}

	public void addEntry(FoodEntry entry) {
		Date now = DateUtils.truncate(new Date(), java.util.Calendar.DAY_OF_MONTH);
		if (getEntries().containsKey(now)) {
			getEntries().get(now).add(entry);
		} else {
			getEntries().put(now, new ArrayList<FoodEntry>());
			getEntries().get(now).add(entry);
		}
	}

	public int getTotalCaloriesToday() {
		Date now = DateUtils.truncate(new Date(), java.util.Calendar.DAY_OF_MONTH);
		int total = 0;
		if (getEntries().containsKey(now)) {
			List<FoodEntry> list = getEntries().get(now);
			for (int i = 0; i < list.size(); i++) {
				total += list.get(i).getCalories();
			}
		}
		return total;
	}

	public List<FoodEntry> getTodaysEntries() {
		Date now = DateUtils.truncate(new Date(), java.util.Calendar.DAY_OF_MONTH);
		if (getEntries().containsKey(now)) {
			return getEntries().get(now);
		}
		return null;
	}

	public Map<Date, List<FoodEntry>> getEntries() {
		return entries;
	}

	public void setEntries(Map<Date, List<FoodEntry>> entries) {
		this.entries = entries;
	}

}
