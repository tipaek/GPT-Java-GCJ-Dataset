import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Solution {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberInstances;
		try {
			numberInstances = Integer.parseInt(br.readLine());
		    for (int i = 1; i <= numberInstances; ++i) {
		    	StringBuilder sb= new StringBuilder();
		    	String[] arguments = br.readLine().split(" ");
		    	int x = Integer.parseInt(arguments[0]);
		    	int y = Integer.parseInt(arguments[1]);
		    	char[] tour = arguments[2].toCharArray();
		    	
		    	int diff = x + y;
		    	boolean success= false;
		    	for (int j=0; j<tour.length; j++) {
		    		if (tour[j]=='N') {
		    			y++;
		    		}
		    		if (tour[j]=='S') {
		    			y--;
		    		}
		    		if (tour[j]=='E') {
		    			x++;
		    		}
		    		if (tour[j]=='W') {
		    			x--;
		    		}
		    		diff = Math.abs(x) + Math.abs(y);
		    		//System.out.println("diff= " + diff +  " j+1: " + (j+1));
		    		
		    		if (diff <= j+1) {
		    			System.out.println("Case #" + i + ": " + (j+1));
		    			success = true;
		    			break;
		    		}
		    	}	    	
		    	
		    	if (!success) System.out.println("Case #" + i + ": " + "IMPOSSIBLE");

		    }
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
	
}
