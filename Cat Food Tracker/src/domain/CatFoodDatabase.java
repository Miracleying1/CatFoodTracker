package domain;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * This class simulates a database containing pet food data by reading from a
 * comma separated text file
 *
 */
public class CatFoodDatabase {
	String filename;
	private ArrayList<CatFood> foodList;

	public CatFoodDatabase(String filename) throws FileNotFoundException, RuntimeException {
		this.filename = filename;
		File file = new File(filename);		
			// TODO Currently this cannot handle names with spaces
			Scanner inputStream = new Scanner(file);
			this.foodList = new ArrayList<>();
			while (inputStream.hasNext()) {
				String data = inputStream.next();
				StringTokenizer tokens = new StringTokenizer(data, ",");
				if (tokens.countTokens() != 4) {
					throw new RuntimeException("invalid cat food db file");
				}
				getFoodList().add(new CatFood(tokens.nextToken(), tokens.nextToken(), tokens.nextToken(), Double.parseDouble(tokens.nextToken())));
			}
			inputStream.close();	
	}

	public ArrayList<CatFood> getFoodList() {
		return foodList;
	}
}
