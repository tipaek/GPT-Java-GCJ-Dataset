import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        if(cases <= 100 && cases >= 1) {
	        for(int a=1; a<=cases; a++) {
		        int n = in.nextInt();
	        	if(n <= 100 && n >= 2) {
			        List<List<Integer>> arr = new ArrayList<>();
		        	for(int i=0; i<n; i++) {
		        		List<Integer> ar = new ArrayList<>();
		        		for(int j=0; j<n; j++) 
		        			ar.add(in.nextInt());
		        		arr.add(ar);
		        	}
		        	int k = 0;
		        	int r = 0;
		        	int c = 0;
		        	for(int i=0; i<n; i++) {
		        		for(int j=0; j<n; j++) {
		        			if(arr.get(i).get(j) <= n && arr.get(i).get(j) >= 1) {
			        			if(i == j) 
			        				k += arr.get(i).get(j);
			        			int checkRow = Collections.frequency(arr.get(i), arr.get(i).get(j));
			        			List<Integer> col = new ArrayList<>();
			        			for(int x=0; x<n; x++)
			        				col.add(arr.get(x).get(j));
			        			int checkCol = Collections.frequency(col, arr.get(i).get(j));
			        			if(checkRow > 1)
			        				r = Math.max(r, checkRow);
			        			if(checkCol > 1)
			        				c = Math.max(c, checkCol);
		        			}
		        		}
		        	}
			        System.out.println("Case #" + a + ": " + k + " " + r + " " + c);
	        	}
	        }
        }
	}
}