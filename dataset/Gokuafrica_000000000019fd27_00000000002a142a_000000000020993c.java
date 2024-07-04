

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int c = 1;
		StringBuffer output = new StringBuffer();
		while(c<=t) {
			int n = sc.nextInt();
			int arr[][] = new int[n][n];
			for(int i=0;i<n;++i) {
				for(int j=0;j<n;++j) {
					arr[i][j]=sc.nextInt();
				}
			}
			int trace = 0;
			for(int i=0;i<n;++i) {
				trace+=arr[i][i];
			}
			ArrayList <HashSet<Integer>> rows = new ArrayList<HashSet<Integer>>(n);
			ArrayList <HashSet<Integer>> columns = new ArrayList<HashSet<Integer>>(n);
			
			for(int i=0;i<n;++i) {
				rows.add(new HashSet<Integer>(n));
				columns.add(new HashSet<Integer>(n));
			}
			
			for(int i=0;i<n;++i) {
				for(int j=0;j<n;++j) {
					rows.get(i).add(arr[i][j]);
					columns.get(j).add(arr[i][j]);
				}
			}
			int duplicateRows =0, duplicateColumns = 0;
			
			for(int i=0;i<n;++i) {
				if(rows.get(i).size()!=n) ++duplicateRows;
				if(columns.get(i).size()!=n) ++duplicateColumns;
			}
			output.append("Case #"+c+": "+trace+" "+duplicateRows+" "+duplicateColumns+"\n");
			++c;
		}
		System.out.print(output);
		sc.close();
	}

}
