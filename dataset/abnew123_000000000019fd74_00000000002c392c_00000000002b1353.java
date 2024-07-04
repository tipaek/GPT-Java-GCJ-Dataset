import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
	    for (int i = 1; i <= t; ++i) {
	    		int n = in.nextInt();
	    		System.out.println("Case #" + i + ":");
	    		if(n < 100) {
	    			for(int j = 0; j < n; j++) {
	    				System.out.println((j+1) + " " + 1);
	    			}
	    		}
	    		else {
	    			n = n - 30;
	    			int counter = 0;
	    			List<Integer> rows = new ArrayList<>();
	    			while(n > 0) {
	    				if(n%2 == 1) {
	    					rows.add(counter);
	    				}
	    				n/=2;
	    				counter++;
	    			}
	    			int remaining = 30 - rows.get(rows.size() - 1) + rows.size();
	    			boolean flag = true;
	    			for(int j = 0; j <= rows.get(rows.size() - 1); j ++) {
	    				if(rows.contains((Integer)j)) {
	    					flag = !flag;
	    					for(int k = 0; k < j; k++) {
	    						System.out.println((j+1) + " " + (flag?(k + 1):(j + 1 - k)));
	    					}
	    				}
	    				System.out.println((j+1) + " " + (flag?(j+1):1));
	    			}
	    			for(int j = rows.get(rows.size() - 1) + 1; j < rows.get(rows.size() - 1) + remaining; j++) {
	    				System.out.println((j+1) + " " + (flag?1:(j+1)));
	    			}
	    			
	    		}
	    		
	    }
	}

}
