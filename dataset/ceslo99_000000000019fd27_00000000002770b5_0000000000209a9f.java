import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = Integer.parseInt(in.nextLine());
		for(int i = 0; i < t; i++) {
			String number = in.nextLine();
			addParanthesis(number, i);
		}
		

	}
	
	public static void addParent(String s) {
		
	}
	
	public static void addParanthesis(String s, int caseNum) {
		StringBuilder sb = new StringBuilder();
		Queue<Character> q = new LinkedList<>();
		
		int current = 0;
		int previous = 0;
		int pl = 0;
		int addP = 0;
	
		for(int i = 0; i < s.length(); i++) {
			current = Character.getNumericValue(s.charAt(i)); 
			if(i > 0) {
				previous = Character.getNumericValue(s.charAt(i-1)); 
			}
			//System.out.println(previous+":"+ current);
			if(current == previous) {
				sb.append(s.charAt(i));
			}
			else if(current > previous) {
				addP = 0;
				while(addP < current - previous) {
					sb.append("(");
					addP++;
				}
				
				sb.append(s.charAt(i));
			}
			else if( current < previous) {
		
				addP = 0;
				while(addP > (current - previous)) {
					sb.append(")");
					addP--;
				}	
				
				sb.append(s.charAt(i));
			}	
			
		}
		addP = 0;
		while(addP < current) {
			sb.append(")");
			addP++;
		}
		
		System.out.println("Case #"+ (caseNum+1) + ": "+ sb.toString());
	}

}
