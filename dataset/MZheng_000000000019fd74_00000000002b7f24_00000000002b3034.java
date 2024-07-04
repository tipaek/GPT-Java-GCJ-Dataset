import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String args[]) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("in.in"));//InputStreamReader(System.in));
		int c = Integer.parseInt(in.readLine());
		for(int cases=0; cases<c; cases++) {
			int num = Integer.parseInt(in.readLine());
			String[] patterns = new String[num];
			for(int p=0; p<num; p++) {
				patterns[p] = in.readLine();
			}
			Arrays.sort(patterns, Comparator.comparing(String::length)); //sorts array by string legnth
			//System.out.println(Arrays.toString(patterns));
			boolean possible = true; 
			int compareCount = num-1; //number of patterns currently being compared
			int charCount = 0; //charCount of longest pattern
			while(possible&&compareCount>0&&charCount<patterns[num-1].length()) {
				for(int x=num-1-compareCount; x<compareCount; x++) {//start from the first one in all patterns that still needs to be checked
					char ch = patterns[x].charAt(patterns[x].length()-1-charCount);
					if(ch=='*') compareCount--; //if the pattern arrives at *, remove it fromt he "comapring" list
					else if(ch!=patterns[num-1].charAt(patterns[num-1].length()-1-charCount)){ //checks if the chars are equals w/ the longest
					//	System.out.println(ch+"_"+patterns[num-1].charAt(patterns[num-1].length()-1-charCount));
						possible = false;
						break;
					}
					
				}
				charCount++;
			}
			System.out.printf("Case #%d: ", cases+1);
			if(possible) System.out.println("A"+patterns[num-1].substring(1));
			else System.out.println("*");
					
		}
	}
}
