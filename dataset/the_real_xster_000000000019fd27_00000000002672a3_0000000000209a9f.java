import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;


public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int testCases = Integer.parseInt(br.readLine());
			
			for(int i=0;i<testCases;i++) {
				String s = br.readLine();
				
				String ans = "";
				for(int j=0;j<s.length();j++) {
					int current = Character.getNumericValue(s.charAt(j));
					
					if(j == 0) {
						String openingString = "";
						for(int k=0;k<current;k++) {
							openingString += "(";
						}
						
						String closingString = "";
						for(int k=0;k<current;k++) {
							closingString += ")";
						}
						
						ans += openingString + current + closingString;
					}
					
					else {
						int lastNumber = Character.getNumericValue(s.charAt(j-1));
						int ansLength = ans.length();
						
						if(lastNumber == current) {
							String tempString = ans.substring(0, ansLength-current) + current + ans.substring(ansLength-current,ansLength);
							ans = tempString;
						}
						else if(lastNumber > current) {
							String tempString = ans.substring(0, ansLength-current) + current + ans.substring(ansLength-current,ansLength);
							ans = tempString;
						}
						else if(lastNumber < current) {
							
							String openingString = "";
							for(int k=0;k<current - lastNumber;k++) {
								openingString += "(";
							}
							
							String closingString = "";
							for(int k=0;k<current - lastNumber;k++) {
								closingString += ")";
							}
							
							String tempString = ans.substring(0, ansLength-lastNumber) + openingString + current + closingString + ans.substring(ansLength-lastNumber,ansLength);
							ans = tempString;
						}
					}
				}
				String outputString = "Case #" + (i+1) + ": " + ans;
				System.out.println(outputString);
			}
		} 
		
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
