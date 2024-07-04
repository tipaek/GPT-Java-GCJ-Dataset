import java.util.*;
import java.io.*;
    
public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		//Test Cases
		int t = Integer.parseInt(in.nextLine()); 
		for (int x = 1; x <= t; ++x) 
		{
			String[] strNumbers = in.nextLine().split(""); //list of integers '0-9'
			int stringDigits[] = new int[strNumbers.length];
			//Add string to array
			for(int i = 0; i < stringDigits.length; i++) {
				stringDigits[i] = Integer.parseInt(strNumbers[i]);
			}
          
			//Paren Calculating
			String rtnVal = "";
			int openParen = 0;
			int parenDiff = 0;
			//Iterates to check the next int
			for(int i = 0; i < stringDigits.length; i++) {
				parenDiff = openParen - stringDigits[i];
				//Need to OPEN Parens
				if (parenDiff < 0) {
					for(int j = 0; j > parenDiff; j-- ) {
						rtnVal += "(";
						openParen++;
					}					
				}
				//Need to CLOSE Parens
				if(parenDiff > 0) {				
					for(int j = 0; j < parenDiff; j++ ) {
						rtnVal += ")";
						openParen--;
					}
				}
				//Add new Int
				rtnVal += stringDigits[i];
			}
			while(openParen!=0)
			{
				rtnVal += ")";
				openParen--;
			}
									
          //Output
          System.out.println("Case #" + x + ": " + rtnVal );

        }

        in.close();
	}
}

