import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
	    Scanner kb = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int cases = kb.nextInt();
	    for(int i = 1; i <= cases; i++) {
	    	int lines = kb.nextInt();
	    	int[][] square = new int[lines][lines];
	    	for(int row = 0; row < lines; row++) {
	    		for(int col = 0; col < lines; col++)
	    			square[row][col] = kb.nextInt();
	    	}
	    	int k = 0; //DIAGNAL SUM
	    	for(int row = 0; row < square.length; row++)
	    		k += square[row][row];
	    	int r = 0; //HOW MANY ROWS HAVE DUPLICATES
	    	for(int[] row : square) {
	    		boolean dup = false;
	    		for(int q = 0; q < row.length-1; q++)
	    			for(int w = q+1; w < row.length; w++)
	    				if(row[q] == row[w])
	    					dup = true;
	    		if(dup)
	    			r++;
	    	}
	    	int c = 0; //HOW MANY ROWS HAVE DUPLICATES
	    	for(int col = 0; col < square[0].length; col++) {
	    		boolean dup = false;
	    		for(int row = 0; row < square.length-1; row++)
	    			for(int q = row+1; q < square.length; q++)
	    				if(square[row][col] == square[q][col])
	    					dup = true;
	    		if(dup)
	    			c++;
	    	}
	    	System.out.println("Case #" + i + ": " + k + " " + r + " " + c);
	    }
	}
}