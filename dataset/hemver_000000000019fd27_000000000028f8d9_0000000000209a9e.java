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
		int size = in.nextInt();
		for (int test = 1; test <= testCaseNumber; test++) {
			int[] matrix = new int[size];
		
			for (int i = 1; i <= size; i++) {
				System.out.println(i);
				System.out.flush();
				String element = in.next();
				if (element.equals("N")) {
                    continue;
                } else {
				matrix[i - 1] = Integer.parseInt(element);
                }
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