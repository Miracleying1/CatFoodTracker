import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class CatFoodList {
	String filename;
	CatFood[] CatFoodList;
	
	public CatFoodList(String filename) {
		this.filename=filename;
		int numLines=0;
		File file=new File(filename);
		try
		{
			Scanner inputStream=new Scanner(file);
			inputStream.next();
			while (inputStream.hasNext()) {
				String data=inputStream.next();
				numLines++;
			}
		inputStream.close();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	public CatFood fetchCatFood(int idx) {
		return CatFoodList[idx];
	}
	public int FindCatFoodIndex(String Input) {//to search for the user input in the list
		int index=-1;
		for(int i=0; i<CatFoodList.length;i++) {
			if(CatFoodList[i].getCatFoodID().equals(Input)) {
				index=i;
				break;
			}
		}
		return index;
	}
}
