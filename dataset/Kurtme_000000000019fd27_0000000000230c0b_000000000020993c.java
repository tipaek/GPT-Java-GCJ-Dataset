import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		ArrayList<LinkedHashSet<Integer>> colList = new ArrayList<LinkedHashSet<Integer>>();
		int sum = 0;
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		int n = in.nextInt();
		for(int i = 1; i <= t; i++) {
			int repeatCol = n;
			int repeatRow = n;
			for(int j = 1; j <= n; j++) {
				LinkedHashSet<Integer> row = new LinkedHashSet<Integer>();
				colList.add(new LinkedHashSet<Integer>());
				for(int k = 1; k <= n; k++) {
					int currNumber = in.nextInt();
					if(i==j) sum += currNumber;
					row.add(currNumber);					
					colList.get(i-1).add(currNumber);
				}
				if(row.size()+1 < n) repeatRow--;
				for(LinkedHashSet<Integer> col : colList) {
					if(col.size()+1 < n) repeatCol--;
				}
			}			
			System.out.println("Case #"+i+": "+sum+" "+repeatRow+" "+repeatCol);
		}
	}
} // ≮