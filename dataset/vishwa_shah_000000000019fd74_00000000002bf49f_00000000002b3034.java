import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
	
	public static String findName(List<StringBuilder> pattern, int maxLengthIndex){
		boolean isFound = true;
		for(int i=0; i<pattern.size() ; i++){
			if( i!=maxLengthIndex){
				if(!pattern.get(maxLengthIndex).toString().contains(pattern.get(i).substring(1).toString())){
					isFound = false;
				}
			}
		}
		if(isFound){
			return pattern.get(maxLengthIndex).substring(1).toString();
		} else{
			return "*";
		}
	}
	
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int testCase = scanner.hasNext() ? scanner.nextInt() : 0;
		for(int t=1 ; t<=testCase ; t++){
			int n = scanner.hasNext() ? scanner.nextInt() : 0;
			List<StringBuilder> pattern = new ArrayList<StringBuilder>(); 
			boolean isTest1 = true;
			int maxLengthIndex = -1;
			int maxLength = -1;
			for(int p =0 ; p < n ; p++){
				pattern.add(new StringBuilder(scanner.next()));
				if(maxLength < pattern.get(p).length()){
					maxLengthIndex = p;
					maxLength = pattern.get(p).length();
				}
				if(pattern.get(p).charAt(0) != '*'){
					isTest1 = false;
				}
			}
			if(isTest1){
				String answer = findName(pattern, maxLengthIndex);
				System.out.println("Case #" + t + ": " + answer);
			}
			
		}
	}
}