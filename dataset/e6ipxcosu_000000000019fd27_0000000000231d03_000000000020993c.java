import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Vector;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class Solution {
	public static void main(String[] args) throws IOException {
		Scanner s1 = new Scanner(System.in);
		int T = Integer.parseInt(s1.nextLine());	
	    int[][] matrix = new int[101][101];
	    for(int i = 1; i <= T; i++)
	    {
	        int[] row = new int[101];
	        int n = Integer.parseInt(s1.nextLine());
	        for(int k = 0; k < n; k++)
	        {
    	        String[] s = s1.nextLine().split(" ");
    	        for(int j = 0; j < n; j++)
    	            matrix[k][j] = Integer.parseInt(s[j]);
	        }
	        int r = 0;
	        int c = 0;
	        int tr = 0;
	        for(int k = 0; k < n; k++)
	        {
    	        tr += matrix[k][k];
	        }
	        for(int k = 0; k < n; k++)
	        {
	            Set<Integer> rows = new HashSet<>();
	            for(int j = 0; j < n; j++)
	            {
    	            rows.add(matrix[k][j]);
	            }
	            if(rows.size() != n)
	                r++;
	        }
	        for(int j = 0; j < n; j++)
	        {
	            Set<Integer> col = new HashSet<>();
	            for(int k = 0; k < n; k++)
                {
    	            col.add(matrix[k][j]);
	            }
	            if(col.size() != n)
	                c++;
	        }
	        System.out.println("Case #" + i + ": " + tr + " " + r + " " + c);
	    }
	}

}
