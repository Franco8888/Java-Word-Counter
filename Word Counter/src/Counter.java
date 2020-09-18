import java.util.ArrayList;
import java.util.Scanner;

public class Counter {
	
	public static ArrayList<String> SeparateWords(ArrayList<String> arr) {		
		//Separate the words and place each word in a new element in the array
		//If an element is empty or contains a '-' then do not add it to the array since it will not be a word

		ArrayList<String> seperated = new ArrayList<String>();				//array - each element contains a word 
		
		for(String j: arr) {
			String[] arrOfStr= j.split(" ");
			for(String i:arrOfStr) {
				if(!i.contains("-") && !i.isEmpty()){ 						//if an element is empty or contains a '-' then do not add it
					seperated.add(i);
				}			
			}
		}
		
		//words may still contain punctuation. get rid of punctuation
		ArrayList<String> seperatedNoPunctuation = new ArrayList<String>();	//array - each element contains a word without punctuation
		for(String i: seperated) {
			seperatedNoPunctuation.add(i.replaceAll("[,]|[.]|[\"]|[?]|[!]", ""));			
		}
		
		return seperatedNoPunctuation;
	}
	
	public static String userInput() {
		Scanner sc = new Scanner(System.in);
	
		System.out.println("Enter the name of the new file:");
		String str = sc.nextLine();
		sc.close();		
		return str;
	}
	

	public static void main(String[] args) {
		
		ArrayList<String> in = new ArrayList<String>();
		String NameOfFile = args[0];							//name of the file
		
		in = Reader.Read(NameOfFile);							//read the file
		
		String fileNameNoPath = in.get(in.size()-1);			//get name of file without path
		in.remove(in.size()-1);									//remove last element
		
		String newName = userInput();							//get new name of the file
		
		String path = NameOfFile.replace(fileNameNoPath, "");	//get path without the name
		String newNamePath = path + newName;					//combine new name with path		
		
		ArrayList<String> seperated = SeparateWords(in);		//place each word in an element
		int wordCount = seperated.size();						//get the word count
		
				
		Writer.Write(newNamePath, seperated, wordCount); 		//write to file
		
	}

}
