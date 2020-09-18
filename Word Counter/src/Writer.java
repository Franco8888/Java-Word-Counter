import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Writer {
	
	public static void Write(String name, ArrayList<String> text, int wordCount) {
		try {					

			  File file = new File(name);
		      FileWriter myWriter = new FileWriter(file);	

		      for(String str: text) {
		    	  myWriter.write(str);
		    	  myWriter.write("\n");
		    	  
		      }
		      myWriter.write("Word Count: " + Integer.toString(wordCount));
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } 
		catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		}
	}

}
