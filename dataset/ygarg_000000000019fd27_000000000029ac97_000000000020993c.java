import java.util.*;
import java.io.*;

public class Solution {
	public static void main (String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		int t = in.nextInt();
		
		for (int i = 0; i < t; i++) {
			int n = in.nextInt();
			ArrayList<ArrayList<Integer>> array = new ArrayList<ArrayList<Integer>>();
			int trace = 0;
			int rowCount = 0;
			int colCount = 0;
			
			for (int a = 0; a < n; a++) {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				for (int b = 0; b < n; b++) {
					temp.add(in.nextInt());
				}
				array.add(temp);
				trace += array.get(a).get(a);
			}
			
			for (int a = 0; a < n; a++) {
				Set<Integer> checkRow = new HashSet<Integer>();
				Set<Integer> checkCol = new HashSet<Integer>();
				for (int b = 0; b < n; b++) {
					checkRow.add(array.get(a).get(b));
					checkCol.add(array.get(b).get(a));
				}
				
				if (checkRow.size() != n) rowCount++;
				if (checkCol.size() != n) colCount++;
				
				
			}
			
			System.out.println("Case #" + (i+1) + ": " + trace + " " + rowCount + " " + colCount);
		}
		
	}
}
