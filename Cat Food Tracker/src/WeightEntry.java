import java.util.Date;

public class WeightEntry {
	double weight;
	Date date;

	WeightEntry(double weight, Date date) {
		this.weight = weight;
		this.date = date;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
