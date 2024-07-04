import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	int t = in.nextInt();
	in.nextLine();
    for (int i = 1; i <= t; ++i) {
		    	int size = in.nextInt();
		    	int trace = in.nextInt();
		    	int sumNumbers = size*(size+1)/2;
		    	if(trace % size == 0) {
		    		System.out.println("Case #"+i+": POSSIBLE");
		    		for(int j = 1; j <= size; j++) {
	    				List<Integer> line = new ArrayList<>();
		    			for(int l = 1; l <= size; l++) {
		    				line.add(l);
		    			}
		    			Collections.rotate(line, size - (trace/size)+j);
		    			for(int elem : line) {
		    				System.out.print(elem);
		    			}
		    			System.out.println();
		    		}
		    	}
		    	else if(sumNumbers == trace && size > 2) {
		    		System.out.println("Case #"+i+": POSSIBLE");
		    		for(int j = 1; j <= size; j++) {
	    				List<Integer> line = new ArrayList<>();
	    				for(int l = 1; l <= size; l++) {
	    					if(j != l) {
	    						line.add(l);
	    					}
		    			}
	    				if(j == 1) {
	    					Collections.rotate(line, j-2);
	    				}
	    				if(j == size) {
	    					Collections.rotate(line, size/2-1);
	    				}
	    				else {
	    					Collections.rotate(line, j-1);
	    				}
	    				line.add(j-1, j);
			    		for(int elem : line) {
		    				System.out.print(elem);
		    			}
		    			System.out.println();
		    		}
		    	}
		    	else {
		    		System.out.println("Case #"+i+": IMPOSSIBLE");
		    	}
		    }
  }
}