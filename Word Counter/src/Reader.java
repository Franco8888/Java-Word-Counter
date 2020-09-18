import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {
	public static ArrayList<String> Read(String name){
		ArrayList<String> data = new ArrayList<String>();
		
		try {
		      File file = new File(name);				//open the file or create it
		      String nameOfFile = file.getName();		//get name wihtout path
		      Scanner myReader = new Scanner(file);
		      while (myReader.hasNextLine()) {
		    	  data.add(myReader.nextLine());
	
		      }
		      myReader.close();
		      data.add(nameOfFile);						//store name in array
	    		  
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occured");
		      e.printStackTrace();
		    }
		return data;
	}
}
