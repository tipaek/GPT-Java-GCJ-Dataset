import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Solution {
	
	private static Logger logger = Logger.getLogger(Solution.class.getName());	
	private static final int _ASCII_NUM_INIT_CODE = 48;
	//private static final int _ASCII_NUM_FINAL_CODE = 57;
	private static final char _INIT_PARENTHESIS = '(';
	private static final char _FINAL_PARENTHESIS = ')';

	/**
	 * Read input stream
	 */
	public static String[] readInput(InputStream inStream) {
		ArrayList<String> lines  = new ArrayList<String>();
				//Use a bufferedReader
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(inStream));
			String line = reader.readLine();
			while (line != null) {
				//Add line to the list
				lines.add(line);
				//Get next line
				line = reader.readLine();
			}
			
		}catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		 return lines.toArray(new String[lines.size()]);
	}
	
	
	private int convertASCIIChar2Num(char c) {
		return ((int)c - _ASCII_NUM_INIT_CODE);
	}
	/**
	 * Enclose the number character with as many parenthesis as it represents
	 * @param c
	 * @return encodedString
	 */
	private String encodeInputCharacter(char c) {
		String encodedCharacter= "";
		String initParenthesis ="";
		String finalParenthesis="";
		
		int num =  convertASCIIChar2Num(c);
		if(num>0 && num<=9)
			for (int i=0; i<num; i++) {
				initParenthesis +=_INIT_PARENTHESIS;
				finalParenthesis +=_FINAL_PARENTHESIS;
			}
	
		encodedCharacter = initParenthesis+num+finalParenthesis;
		return encodedCharacter;
	}
	
	
	/**
	 * After encoding a single character, perform nesting of parenthesis
	 * @param s
	 * @return
	 */
	private String attachNewCodedCharacter(String firstString, String secondString ) {
		if(firstString.length()>0 && secondString.length()>0 )
			while (firstString.charAt(firstString.length()-1)==_FINAL_PARENTHESIS 
					&& secondString.charAt(0)==_INIT_PARENTHESIS) {
				firstString= firstString.substring(0,firstString.length()-1);
				secondString = secondString.substring(1);
			}
		else
			logger.log(Level.WARNING, "Wrong encoded characters: "+firstString +", "+secondString);
		return firstString+secondString;
			
			
	}
	/**
	 * Encode each character number with the according number of parenthesis
	 * @param inputString
	 * @return encodedString
	 */
	public String encodeInputString(String inputString) {
		String printableString = "";
		
		if(inputString!=null) {
			for (int i=0; i< inputString.length(); i++) {
				String encodedCharacter = encodeInputCharacter(inputString.charAt(i));
				if (encodedCharacter.length()>0) {
					printableString = attachNewCodedCharacter(printableString, encodedCharacter);
				}else
					logger.log(Level.WARNING, "Input character cannot be encoded: "+encodedCharacter);
			}
		}
		
		return printableString;
	}
	
	public static void main(String[] args) {
		 //Read the input file
        String[] lines = readInput(System.in);
        
        Solution solution = new Solution();
        //Get T = Test cases
        int T = Integer.parseInt(lines[0]);

        //Encode each of the and print solution
        for (int i=1; i<=T; i++) {
        	System.out.println(String.format("Case #%d: %s", i, solution.encodeInputString(lines[i])));
        }
      
	}
	
}
