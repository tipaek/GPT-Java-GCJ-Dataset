import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		try(Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))){
			int t = Integer.parseInt(in.nextLine());
			
		    for (int i = 1; i <= t; ++i) {
				List<String> patterns = new ArrayList<>();
		    	int numberOfPatterns = Integer.parseInt(in.nextLine());
		    	for(int j = 0; j < numberOfPatterns; j++){
		    		patterns.add(in.nextLine());
		    	}
		    	
				System.out.println("Case #" + i + ": " + findAnswer(patterns));
		    }
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private static String findAnswer(List<String> patterns){
		String longestPrefixNeeded = "";
		String longestSuffixNeeded = "";
		for(String s: patterns){
			String[] parts = s.split("\\*");
			String prefix = parts[0];
			String suffix = parts[parts.length-1];
			if(prefix.length() > longestPrefixNeeded.length()){
				longestPrefixNeeded = prefix;
			}
			if(parts.length > 1 && suffix.length() > longestSuffixNeeded.length()){
				longestSuffixNeeded = suffix;
			}
		}

		for(String s: patterns){
			s = s.replaceAll("\\*", "");
			if(longestPrefixNeeded.length() > 0 && !longestPrefixNeeded.startsWith(s)){
				return "*";
			}
			if(longestSuffixNeeded.length() > 0 && !longestSuffixNeeded.endsWith(s)){
				return "*";
			}
		}
		
		return longestPrefixNeeded + longestSuffixNeeded;
	}
	
}
