import java.util.*;
import java.io.*;
import java.lang.Math;


public class Solution {

    public static void main(String []args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int length = Integer.parseInt(in.nextLine());
		for (int i = 0; i < length; i++) {
			char[] arr = in.nextLine().toCharArray();
			int nestingDepth = 0;
			String finalString = "";
			
			for (char currentChar: arr) {
				int currentInt = Character.getNumericValue(currentChar);
				if (currentInt == nestingDepth) {
				    finalString += currentInt;
				} else if (currentInt > nestingDepth) {
				    for (int j = 0; j <= (currentInt - nestingDepth); j++) {
				        finalString += "(";
				        nestingDepth++;
				    }
				    finalString += Integer.toString(currentInt);
				} else if (currentInt < nestingDepth) {
				    for (int j = 0; j <= (nestingDepth - currentInt); j++) {
				        finalString += ")";
				        nestingDepth--;
				    }
				    finalString += Integer.toString(currentInt);
				}
			}
			
			for (int j = 0; j < nestingDepth; j++) {
			    finalString += ")";
			}
            System.out.println("Case #" + (i + 1) + ": " + finalString);
	   }
	   
    }
    
}