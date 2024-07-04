import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String args[]) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));//FileReader("in.in"));
		int cases = Integer.parseInt(in.readLine());
		for(int c=0; c<cases; c++) {
			String nums = in.readLine();
			int depth = 0;
			ArrayList<Character> output = new ArrayList<Character>();
			for(int x=0; x<nums.length(); x++) {
				int num = Integer.parseInt(nums.charAt(x)+"");
				//System.out.println(num);
				if(num>depth) {
					while(num>depth) {
						output.add('(');
						depth++;
					}
				}
				else {
					while(num<depth) {
						output.add(')');
						depth--;
					}
				}
				output.add(nums.charAt(x));
			}
			while(depth>0) {
				output.add(')');
				depth--;
			}
			String outputString = "";
			for(char ch:output) outputString+=ch+"";
			System.out.printf("Case #%d: %s\n", c+1, outputString);
		}
		
		
	}
}
