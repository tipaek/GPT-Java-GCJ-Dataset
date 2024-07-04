import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int nbtest = in.nextInt();
		
		in.nextLine();
		for(int i = 0; i < nbtest; i++){
			String s;
			int nbParenthese = 0;
			
			s = in.nextLine();
			s = s.trim();
			System.out.print("Case #" + (i + 1) + ": ");
			for(int j = 0; j < s.length(); j++){
				int val;
				
				val = Integer.valueOf(String.valueOf(s.charAt(j)));
				if(val > nbParenthese){
					int diff = val - nbParenthese;
					
					for(int k = 0; k < diff; k++){
						System.out.print("(");
					}
					nbParenthese = val;
				} else if(val < nbParenthese){
					int diff = nbParenthese - val;
					
					for(int k = 0; k < diff; k++){
						System.out.print(")");
					}
					nbParenthese = val;
				}
				System.out.print(val);
			}
			for(int j = 0; j < nbParenthese; j++){
				System.out.print(")");
			}
			System.out.println("");
		}
	}
}