import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/*Quick Notes
Use BigInteger & BigDecimal for large numbers - They are arbitrarily precise.

*/
public class Solution {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int totalTestCases = Integer.parseInt(in.nextLine());

		for(int i = 0; i < totalTestCases; i++) {
			
			char[] S = in.nextLine().toCharArray();
			int[] line = new int[S.length];
					
			for(int j = 0; j < S.length; j++) {
				line[j] = Character.getNumericValue(S[j]);
			}
			
			//Break into sub strings
			ArrayList<ArrayList<Integer>> substrs = new ArrayList<ArrayList<Integer>>();
			//ArrayList<String> output = new ArrayList<String>();
			String increasing = "";
			
			for(int j = 0; j < S.length; j++) {
				if(j == 0) {
					ArrayList<Integer> newSub = new ArrayList<Integer>();
					newSub.add(line[j]);
					substrs.add(newSub);
				} else {
					//break when increasing from prev decreasing
					if(increasing.equals("NO") && line[j] > line[j-1]) {
						ArrayList<Integer> newSub = new ArrayList<Integer>();
						newSub.add(line[j]);
						substrs.add(newSub);
					} else {
						substrs.get(substrs.size() - 1).add(line[j]);
					}
					
					if(line[j] > line[j-1]) {
						increasing = "YES";
					} else {
						increasing = "NO";
					}
				}
			}
			/*
			for(int j = 0; j < substrs.size(); j++) {
				System.out.println();
				for(int k = 0; k < substrs.get(j).size(); k++) {
					System.out.println(substrs.get(j).get(k));
				}
			}
			*/
			String outputLine = "";
			for(int j = 0; j < substrs.size(); j++) {
				
				ArrayList<Integer> currSub = substrs.get(j);
				
				for(int k = 0; k < currSub.size(); k++) {
					
					if (k == 0) {
						for(int p = 0; p < currSub.get(k); p++) {
							outputLine += "(";
						}
					}
					
					if (k > 0 && currSub.get(k) > currSub.get(k - 1)) {
						for(int p = 0; p < (currSub.get(k) - currSub.get(k - 1)); p++) {
							outputLine += "(";
						}
					} 
					
					outputLine += currSub.get(k);
					
					if (k < currSub.size() - 1 && currSub.get(k) > currSub.get(k + 1)) {
						for(int p = 0; p < (currSub.get(k) - currSub.get(k + 1)); p++) {
							outputLine += ")";
						}
					}
					
					if(k == currSub.size() - 1) {
						for(int p = 0; p < currSub.get(k); p++) {
							outputLine += ")";
						}
					}
				}
			}
			
			outputLine = outputLine.replaceAll("\\)\\(", "");
			System.out.println("Case #" + (i+1) + ": " + outputLine);
		}
		
		in.close();
	}
}
