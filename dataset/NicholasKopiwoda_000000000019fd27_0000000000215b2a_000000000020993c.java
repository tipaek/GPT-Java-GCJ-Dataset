import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int numberOfCases = in.nextInt();
		for (int i = 0; i < numberOfCases; i++) {
			int size = in.nextInt();
			in.nextLine();
			int[][] matrix = new int[size][size];
			for (int x = 0; x < size; x++) {
				//int y = 0;
				for (int y = 0; y < size; y++) {
					matrix[x][y] = in.nextInt();
				}
			}
			int k = 0;
			for (int d = 0; d < size; d++) {
				k += matrix[d][d];
			}
			//rows
			int r = 0;
			
			for (int d = 0; d < size; d++) {
				Set<Integer> set = new HashSet<Integer>(); 
				for (int d2 = 0; d2 < size; d2++) {
					set.add(matrix[d][d2]);
				}
				if (set.size() < size) {
					r++;
				}
			}
			
			//columns
			int c = 0;
			
			for (int d = 0; d < size; d++) {
				Set<Integer> set = new HashSet<Integer>(); 
				for (int d2 = 0; d2 < size; d2++) {
					set.add(matrix[d2][d]);
				}
				if (set.size() < size) {
					c++;
				}
			}
			
			System.out.println("Case #" + (i + 1) + ": " + k + " " + r + " " + c);
		
		}
}}