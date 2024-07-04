import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; i++) {
			int n = in.nextInt();
			int[][] matrix = new int[n][n];
			for (int j = 0; j < n; j++) 
			{
				for(int k = 0; k < n; k++)
				{
					int l = in.nextInt();
					matrix[j][k] = l;
				}
			}
			int k = 0;
			int r = 0;
			int c = 0;
			for (int j = 0; j < n; j++) {
				k+=matrix[j][j];
			}
			for (int j = 0; j < n; j++) {
				ArrayList<Integer> s= new ArrayList<Integer>();
				for (int j2 = 0; j2 < n; j2++) {
					if(s.contains(matrix[j][j2]))
					{
						r++;
						break;
					}
					else
					{
						s.add(matrix[j][j2]);
					}
				}
			}
			for (int j = 0; j < n; j++) {
				ArrayList<Integer> s= new ArrayList<Integer>();
				for (int j2 = 0; j2 < n; j2++) {
					if(s.contains(matrix[j2][j]))
					{
						c++;
						break;
					}
					else
					{
						s.add(matrix[j2][j]);
					}
				}
			}
			System.out.println("Case #" + i + ": " + k + " " + r + " "+ c);
		}
	}
}