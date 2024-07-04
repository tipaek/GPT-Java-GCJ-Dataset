import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        for(int a=1; a<=cases; a++) {
	        int n = in.nextInt();
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
        		k += arr.get(i).get(i);
        		Set<Integer> rawSet = new HashSet<Integer>(arr.get(i));
    			if(rawSet.size() != arr.get(i).size())
    				r++;
        		List<Integer> col = new ArrayList<>();
    			for(int j=0; j<n; j++) {
    				col.add(arr.get(j).get(i));
        		}
    			Set<Integer> colSet = new HashSet<Integer>(col);
    			if(colSet.size() != col.size())
    				c++;
        	}
	        System.out.println("Case #" + a + ": " + k + " " + r + " " + c);
        }
	}
}