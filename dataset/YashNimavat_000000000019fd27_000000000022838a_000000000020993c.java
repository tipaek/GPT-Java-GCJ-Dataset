import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		 int testCases = s.nextInt();
		 for (int i = 1; i <= testCases; i++) {
			 int N = s.nextInt();
			 int trace = 0,repeatedRow = 0,repeatedCol = 0;
			 List<HashSet<String>> colsHashSets= new ArrayList<HashSet<String>>();
			 for(int j=0;j<N;j++) {
				 colsHashSets.add(new HashSet<String>()); 
			 }
			 for(int j=1;j<=N;j++) {
				 HashSet<String> rowHashSet = new HashSet<String>(); 
				 String[] row = new String[N];
				 for(int k=0;k<N;k++) {
					 row[k] = s.next();
					 if(colsHashSets.get(k)!=null) {
						 if(colsHashSets.get(k).contains(row[k])) {
							 repeatedCol++;
							 colsHashSets.set(k,null);
						 }
						 else {
							 colsHashSets.get(k).add(row[k]);
						 }
					 }
				 }
				 trace = trace + Integer.valueOf(row[j-1]);
				 for(int k=1;k<=N;k++) { 
					 if(rowHashSet.contains(String.valueOf(row[k-1]))) {
						 repeatedRow++;
						 break;
					 }
					 rowHashSet.add(row[k-1]);
				 }
			 }
			 System.out.println("Case #"+i+": "+trace+" "+repeatedRow+" "+repeatedCol);
		 }
	}
}
