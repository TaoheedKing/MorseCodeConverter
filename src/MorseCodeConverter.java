import java.io.File;
import java.util.Scanner;

/** 
 * Utility class. Translates morse code to English
 * @author Taoheed King
 *
 */
public class MorseCodeConverter {

	private static MorseCodeTree codeTree = new MorseCodeTree();

	/**
	 * returns a string with all the data in the tree in LNR order with an space in between them. 
	 * Uses the toArrayList method in MorseCodeTree It should return the data in this order: 
	 * @return the data in the tree in LNR order separated by a space.
	 */
	public static String printTree(){
		StringBuilder result = new StringBuilder();
		
		for (String temp: codeTree.toArrayList()) {
			result.append(temp.trim() + " ");
		}
		
		return result.toString().trim();
		
	}
	
	/**
	 * Converts Morse code into English. Each letter is delimited by a space (‘ ‘). Each word is delimited by a ‘/’. 
	 * @param code - String in morse code
	 * @return English translation of a morse code
	 */
	public static String convertToEnglish(String code){
		StringBuilder decoded = new StringBuilder();
		String [] wordArray = code.split("/");
		String [][] characterArray = new String[wordArray.length][];
		
		for (int i = 0; i< characterArray.length; i++) {
			wordArray[i] = wordArray[i].trim();
			characterArray[i] = wordArray[i].split("\\s+");
		}
		
		for (int i = 0; i < characterArray.length; i++) {
			for (int j = 0; j < characterArray[i].length; j++) {
				decoded.append(codeTree.fetch(characterArray[i][j]));
			}
			decoded.append(" ");
		}
		
		return decoded.toString().trim();
	}
	
	/**
	 * @param codeFile - File that contains Morse Code 
	 * @return The English translation of the file 
	 * @throws java.io.FileNotFoundException
	 */
	public static String convertToEnglish(File codeFile) throws java.io.FileNotFoundException{
		StringBuilder codeSB = new StringBuilder();
		Scanner scanner = new Scanner(codeFile);
		
		while(scanner.hasNextLine()){
			codeSB.append(scanner.nextLine());
		}
		
		return convertToEnglish(codeSB.toString());
	}
	
	
	
}
