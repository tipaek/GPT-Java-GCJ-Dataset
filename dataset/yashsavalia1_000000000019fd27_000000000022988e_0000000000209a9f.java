import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCases = Integer.parseInt(in.nextLine());
		String[] outputs = new String[testCases];
		for (int i = 1; i <= testCases; ++i) {
			String input = in.nextLine();
			String parenthesized = parenthesizeInput(input);
			outputs[i - 1] = "Case #" + i + ": " +  parenthesized;
		}
		in.close();
		printOutput(outputs);
	}

	private static void printOutput(String[] outputs) {
		for(int i = 0; i < outputs.length; i++) {
			System.out.println(outputs[i]);
		}
	}

	private static String parenthesizeInput(String input) {
		StringBuilder parenthesizeString = new StringBuilder();
		for(char element : input.toCharArray()) {
			parenthesizeInput(parenthesizeString,Integer.parseInt(String.valueOf(element)));
		}
		return parenthesizeString.toString();
	}
	
	
	private static void parenthesizeInput(StringBuilder input, int element) {
		if(input.length()==0) {
			input.append(parenthesize(element));
		}else {
			boolean inserted=false;
			for(int i=input.length()-1;i>=0;i--) {
				if(Character.isDigit(input.charAt(i))){
					int previouseValue = Integer.parseInt(String.valueOf(input.charAt(i)));
					if(previouseValue >= element) {
						input.insert(input.length()-element, String.valueOf(element));
						inserted=true;
					}else {
						input.insert(i+1, getOpeningBrackets(element));
						input.insert(i+element+1, String.valueOf(element));
						input.insert(i+element+2, getClosingBrackets(element-previouseValue));
						inserted=true;
					}
					
						break;
					
				}
			}
			if(!inserted) {
				input.append(parenthesize(element));
			}
			
		}
		
		
	}
	
	private static int countEnclosingParentesis(String string) {
		int lastIndexOfOpeningParenthesis=string.lastIndexOf("(");
		int count=0;
		
		for(int i=string.length()-1;i>lastIndexOfOpeningParenthesis;i--) {
			if(string.charAt(i)==')') {
				count++;
			}
		}
		
		return count;
	}
	
	private static String getOpeningBrackets(int noOfBrackets) {
		char[] brackets= new char[noOfBrackets];
		Arrays.fill(brackets, '(');
		return String.valueOf(brackets);
	}
	
	private static String getClosingBrackets(int noOfBrackets) {
		char[] brackets= new char[noOfBrackets];
		Arrays.fill(brackets, ')');
		return String.valueOf(brackets);
	}
	
	private static String parenthesize(int value) {
		StringBuilder builder = new StringBuilder(String.valueOf(value));
		for (int i = 1; i <= value; i++) {
			builder.insert(0, "(");
			builder.append(")");
		}
		return builder.toString();
	}
	

}