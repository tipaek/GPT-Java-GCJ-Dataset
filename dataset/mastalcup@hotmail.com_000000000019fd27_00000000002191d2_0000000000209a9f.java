import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	public static void main(String[] args){
		try(Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))){
			int t = Integer.parseInt(in.nextLine());
			
		    for (int i = 1; i <= t; ++i) {
		    	String nums = in.nextLine();
		    	
				System.out.println("Case #" + i + ": " + parenthesizeNumber(nums)) ;
		    }
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private static String parenthesizeNumber(String nums){
		StringBuilder parenthesized = new StringBuilder();
		
		int unclosedParentheses = 0;
		
		for(char c: nums.toCharArray()){
			int thisNum = Character.getNumericValue(c);
			while(unclosedParentheses != thisNum){
				if(unclosedParentheses < thisNum){
					parenthesized.append("(");
					unclosedParentheses++;
				}
				else{
					parenthesized.append(")");
					unclosedParentheses--;
				}
			}
			parenthesized.append(thisNum);
		}
		
		if(unclosedParentheses > 0){
			parenthesized.append(String.join("", Collections.nCopies(unclosedParentheses, ")")));			
		}
		
		return parenthesized.toString();
	}
}
