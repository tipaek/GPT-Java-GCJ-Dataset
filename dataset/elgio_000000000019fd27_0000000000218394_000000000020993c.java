import java.util.List;
import java.sql.CallableStatement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	
	public static void main(String[] args) {
	
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = in.nextInt();
		
		int caseNumber = 1;
		while(in.hasNextLine()) {
			int N = in.nextInt();
			in.nextLine();
			
			int t = 0;
			int r = 0;
			int c = 0;
			
			List<Set<Integer>> rowList = new ArrayList<Set<Integer>>();
			List<Set<Integer>> columnList = new ArrayList<Set<Integer>>();
			for(int i = 0; i < N; i++) {
				String currentLine = in.nextLine();
				Scanner lineScanner = new Scanner(currentLine);
				//System.out.println("Line : " + currentLine);
				
				for(int j = 0; j < N; j++) {
					int current = Integer.parseInt(lineScanner.next());
					
					if(i == 0) {
						Set<Integer> currentColumnSet = new TreeSet<Integer>();
						columnList.add(currentColumnSet);
					}
					
					if(j == 0) {
						Set<Integer> currentRowSet = new TreeSet<Integer>();
						rowList.add(currentRowSet);
					}
					
					columnList.get(j).add(current);
					rowList.get(i).add(current);
					if(i==j) {
						
						t+= current;
					}
				}
			}
			
			for(Set<Integer> s : rowList) {
				if(s.size() < N) {
					r++;
				}
			}
			
			for(Set<Integer> s : columnList) {
				if(s.size() < N) {
					c++;
				}
				
			}
			
			//System.out.println("END RESULTS : t = " + t + "\tr = " + r + "\tc = " + c);
			
			System.out.println("Case #" + caseNumber++ +": " + t + " " + r + " " + c);
		}
		
	}
}