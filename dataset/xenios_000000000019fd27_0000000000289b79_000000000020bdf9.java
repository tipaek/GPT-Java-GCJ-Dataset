import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Steve Mwangi
 * 11:48:25 AM
 * 2020
 */
public class Solution {
	public static void main(String[] args) throws FileNotFoundException{
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        
        for(int iii = 0; iii < t; iii++){
        	int x = iii+1;
        	int lines = in.nextInt();
        	in.nextLine();
        	int start = 0;
        	int end = 0;
        	int previousS = -1;
        	int previousE = -1;
        	String result = "C";
        	String next = "";
        	int[][] times = new int[lines][2];
        	for(int i =0; i < lines; i++) {
        		String oneRow = in.nextLine();
            	String[] temp = oneRow.split(" ");
            	start = Integer.parseInt(temp[0]);
            	end = Integer.parseInt(temp[1]);
            	times[i][0] = start;
            	times[i][1] = end;
            	if(previousS != -1 && previousE != -1) {
            		if(start < previousE) {
            			next = "J";
            		} else {
            			next = "C";
            		}
            		result = result.concat(next);
            	}
            	previousS = start;
            	previousE = end;
            	if(i-2>=0) {
            		if(times[i-2][1] > times[i-1][0] && times[i-1][1] > start && times[i-2][1] > start) {
            			result = "IMPOSSIBLE";
            			break;
            		}
            	}
        	}
        	System.out.println("Case #" + x + ": " + result);
    	}
    }
}
