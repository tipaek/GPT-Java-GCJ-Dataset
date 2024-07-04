
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    
//	Scanner in = null;
//	try {
//		in = new Scanner(new File("D:\\perso\\GoogleCodeJam\\GoogleCodeJam\\src\\_2020\\QualificationRound\\B\\files\\B.TXT"));
//	} catch (FileNotFoundException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}

	
    		int nbCases = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    		String line = in.nextLine();
    		for(int caseNumber = 0; caseNumber < nbCases; caseNumber++){
        		line = in.nextLine();
        		String result = "";
        		int currentDepth = 0;
        		for (char c : line.toCharArray()) {
        			int i = Integer.parseInt(""+c);
        			if (i > currentDepth) {
        				for (int j = 0; j < i - currentDepth; j++) {
        					result+="(";
        				}
        			} 
        			if (i < currentDepth) {
         				for (int j = 0; j < currentDepth - i; j++) {
         					result+=")";
         				}
         			}
        			result+=c;
        			currentDepth = i;
        		}
        		
        		for (int i = 0; i < currentDepth; i++) {
        			result += ")";
        		}
        		
        		
				System.out.println("Case #"+(caseNumber+1) + ": " + result);
			}
    		in.close();
	}
}