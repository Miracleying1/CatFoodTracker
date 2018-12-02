import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.time.DateUtils;

public class FoodDiary {
	Map<Date, List<FoodEntry>> entries = new HashMap<Date, List<FoodEntry>>();
	
	public void addEntry(FoodEntry entry) {
		Date now = DateUtils.truncate(new Date(), java.util.Calendar.DAY_OF_MONTH);
		if(entries.containsKey(now)) {
			entries.get(now).add(entry);
		} else {
			entries.put(now, new ArrayList<FoodEntry>());
			entries.get(now).add(entry);
		}
	}
	
	public int getTotalCaloriesToday() {
		Date now = DateUtils.truncate(new Date(), java.util.Calendar.DAY_OF_MONTH);
		int total = 0;
		if(entries.containsKey(now)) {
			List<FoodEntry> list = entries.get(now);
			for(int i =0; i < list.size(); i++) {
				total += list.get(i).getCalories();
			}
		}
		return total;
	}
	
	public List<FoodEntry> getTodaysEntries() {
		Date now = DateUtils.truncate(new Date(), java.util.Calendar.DAY_OF_MONTH);
		if(entries.containsKey(now)) {
			return entries.get(now);
		}
		return null;
	}
	
}
