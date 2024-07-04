import java.util.*;
import java.io.*;

/**
 * Problem 4
 */
public class Solution {
	
	public static void main(String[] args) {
		 
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		//fetch the number of test cases
		int testCaseNumber = in.nextInt();
		//fetch the first matrix number
		for (int test = 1; test <= testCaseNumber; test++) {
			int size = in.nextInt();
			int[] matrix = new int[size];
		
			for (int i = 1; i <= size; i++) {
					System.out.println(i);
					System.out.flush();
					int element = in.nextInt();
					matrix[i - 1] = element;
			}
			StringBuilder string = new StringBuilder();
			for (int i = 1; i <= size; i++) {
				string.append(matrix[i - 1]);
			}
			System.out.println(string);
			System.out.flush();
			String result = in.next();
			if (result.equalsIgnoreCase("N")) {
				break;
			}
		}
		in.close();
	}
}