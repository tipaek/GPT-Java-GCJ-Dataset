import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		if(in.hasNext()) {
			int t = in.nextInt();
			for(int k = 1; k <= t; k++) {
				int n = in.nextInt();
				int sum = 0;
				int repeatCol = 0;
				int repeatRow = 0;
				ArrayList<LinkedHashSet<Integer>> colList = new ArrayList<LinkedHashSet<Integer>>();
				for(int x = 1; x <= n; x++ ) colList.add(new LinkedHashSet<Integer>());
				for (int i = 1; i <= n; i++) {
					LinkedHashSet<Integer> row = new LinkedHashSet<Integer>();
					for(int j = 1; j <= n; j++) {
						int currNumber = in.nextInt();
						if(i==j) sum += currNumber;
					    row.add(currNumber);					
						colList.get(j-1).add(currNumber);
					}
					if(row.size() < n) repeatRow++;
				}			
				for(LinkedHashSet<Integer> col : colList) {
					if(col.size() < n) repeatCol++;
				}
				System.out.println("Case #"+k+": "+sum+" "+repeatRow+" "+repeatCol);
			}
		}
		in.close();
	}
}
