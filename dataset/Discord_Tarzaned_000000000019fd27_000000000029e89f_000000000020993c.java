import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static void main (String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		for(int z = 1; z <= number; z++) {
		    System.out.print("Case #" + z + ": ");
		    computer(sc);
		}
		sc.close();
	}
	public static void computer(Scanner sc)
	{
	    // creating matrix
	    int size = sc.nextInt();
	    sc.nextLine();
	    int[][] matrix = new int[size][size];
	    for(int i = 0; i < size; i++) {
	        for(int j = 0; j < size; j++) {
	            matrix[i][j] = sc.nextInt();
	        }
	    }
	    // trace
	    int trace = 0;
	    for(int i = 0; i < size; i++) {
	        trace = trace + matrix[i][i];
	    }
	    // # of rows
	    int r_count = 0;
	    for(int i = 0; i < size; i++) {
	        for (int j = 0; j < size; j++) {
	            HashSet<Integer> seen = new HashSet<Integer>();
	            if(seen.contains(matrix[i][j])) {
	                r_count = r_count + 1;
	                break;
	            } else {
	                seen.add(matrix[i][j]);
	            }
	        }
	    }
	    // # of columns
	    int c_count = 0;
	    for(int i = 0; i < size; i++) {
	        for (int j = 0; j < size; j++) {
	            HashSet<Integer> seen = new HashSet<Integer>();
	            if(seen.contains(matrix[j][i])) {
	                c_count = c_count + 1;
	                break;
	            } else {
	                seen.add(matrix[j][i]);
	            }
	        }
	    }
	    System.out.println("" + trace + " " + r_count + " " + c_count + " ");
	}
}