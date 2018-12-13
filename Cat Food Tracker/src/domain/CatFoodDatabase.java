package domain;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

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
			Scanner inputStream = new Scanner(file);
			inputStream.useDelimiter("\\n");
			this.foodList = new ArrayList<>();
			while (inputStream.hasNextLine()) {
				String data = inputStream.nextLine();			
				String[] tokens = data.split(",");			
				if (tokens.length != 4) {
					throw new RuntimeException("invalid cat food db file, found invalid number of tokens:" + tokens.length);
				}
				getFoodList().add(new CatFood(tokens[0], tokens[1], tokens[2], Double.parseDouble(tokens[3])));
			}
			inputStream.close();	
	}

	public ArrayList<CatFood> getFoodList() {
		return foodList;
	}
}
