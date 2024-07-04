import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	
	static String t0 = "7\r\n" + 
			"0000\r\n" + 
			"101\r\n" + 
			"111000\r\n" + 
			"1\r\n" +
			"2\r\n" +
			"21\r\n" +
			"221\r\n" + 
			"312\r\n";
	
	public static void main(String[] args) {
		
		//Scanner in = new Scanner(t0);
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		int T = in.nextInt();
		in.nextLine();
	
	    int count = 1;
		while(in.hasNextLine()) {
			//System.out.println();
			StringBuilder sb = new StringBuilder();
			String currentLine = in.nextLine();
			//System.out.println(currentLine);
			
			
			int open = 0, close = 0, first = -1;
			for(int i = 0; i < currentLine.length(); i++) {
				char curr = currentLine.charAt(i);
				int input = Character.getNumericValue(curr);
				//System.out.println("i = " + i + " curr = " + curr);
				
				if(i != 0) {
					if(input > first) {
						int j = first;
						while(j != input) {
							sb.append("(");
							j++;
							close++;
						}
						sb.append(input);
					} else if (input == first) {
						sb.append(input);
					} else if (input < first) {
						int j = first;
						while(j != input) {
							//System.out.println("appending ) because curr is : " + input + " and i = " + i);
							sb.append(")");
							j--;
							close--;
						}
						sb.append(input);
						
					}
				} else {
					if(input != 0) {
						open = input;
						close = 0;
						while(open > 0) {
							//System.out.println(" appending ( because curr is : " + input + " and i = " + i);
							sb.append("(");
							open--;
							close++;
						}
						sb.append(input);
					} else {
						sb.append(input);
					}
				}
				
				first = input;
			
				}
				
					if(close > 0) {
				int j = close;
				while(j > 0) {
					//System.out.println("appending ) to close out");
					sb.append(")");
					j--;
			}
			
			
			}
			
			System.out.println("Case #" + count++ + ": " + sb);
		}
		
	}

}