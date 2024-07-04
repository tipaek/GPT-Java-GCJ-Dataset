import java.io.*;
import java.util.*;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int test = 1; test <= t; test++) {
			int n = sc.nextInt();
			System.out.println("Case #" + test + ":");
			System.out.println("1 1");
			if (n == 1) continue;
			System.out.println("2 1");
			int sum = 2;
			int row = 3;
			if (sum < n) {
				System.out.println("3 2");
				sum += 2;
				while (sum < n) {
					System.out.println(row + " " + 1);
					row++;
					sum++;
				}
			}
//			while (sum < n) {
//				System.out.println(row + " " + 1);
//				sum++; 
//				row++;
//			}
		}
	}

}
