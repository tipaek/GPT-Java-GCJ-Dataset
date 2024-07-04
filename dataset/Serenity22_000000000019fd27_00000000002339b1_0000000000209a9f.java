import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.Math;
import java.text.DecimalFormat; 

public class Solution {
	
	public static void main(String[] args) throws FileNotFoundException {
		try( Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
			int caseNumber = scanner.nextInt();
			if(caseNumber >= 1 && caseNumber <= 100) {
				for(int i=0; i<caseNumber; i++) {
					String s = scanner.next();
					String res = calc(s);
					
					System.out.println("Case #" + (i+1) + ": "  + res);
				}
			}
		}
	}
	
	public static String calc (String s) {
		String result = "";
		int start = 0;
		for(int i=0; i<s.length(); i++) {
			char current = s.charAt(i);
			int converted = Integer.parseInt(String.valueOf(current));  
//			System.out.println("Case ####" + converted);
			
			if(converted > start) {
				StringBuilder str = new StringBuilder();
				for(int count = 0; count < (converted - start); count++) {
					str.append("(");
				}
//				result = result + "(".repeat(converted - start) ;
				result = result + str.toString();
			}
			else if(converted < start) {
//				result = result + ")".repeat(start - converted);
				StringBuilder str = new StringBuilder();
				for(int count = 0; count < (start - converted); count++) {
					str.append(")");
				}
				result = result + str.toString();
			}
			result = result + String.valueOf(converted);
			start = converted;
		}
		int last = Integer.parseInt(String.valueOf(s.charAt(s.length() - 1))); 
		StringBuilder str = new StringBuilder();
		for(int count = 0; count < (last); count++) {
			str.append(")");
		}
//		result = result + ")".repeat(last);
		return result + str;
	}
	
}









