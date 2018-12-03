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
	ArrayList<CatFood> foodList;

	public CatFoodDatabase(String filename) {
		this.filename = filename;
		File file = new File(filename);
		try {
			// TODO Currently this cannot handle names with spaces
			Scanner inputStream = new Scanner(file);
			foodList = new ArrayList<>();
			while (inputStream.hasNext()) {
				String data = inputStream.next();
				StringTokenizer tokens = new StringTokenizer(data, ",");
				if (tokens.countTokens() != 5) {
					throw new RuntimeException("invalid cat food db file");
				}
				foodList.add(new CatFood(tokens.nextToken(), tokens.nextToken(), tokens.nextToken(), tokens.nextToken(),
						Double.parseDouble(tokens.nextToken())));
			}
			inputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}
