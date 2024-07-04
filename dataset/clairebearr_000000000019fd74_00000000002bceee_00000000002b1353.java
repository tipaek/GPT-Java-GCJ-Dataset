import java.io.*;
import java.util.*;

//solution
public class Solution {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int test = 1; test <= t; test++) {
			int n = sc.nextInt();
			System.out.println("Case #" + test + ":");
			System.out.println("1 1");
			int sum = 1;
			if (n == 1) continue;
			System.out.println("2 1");
			sum = 2;
			int count = 2;
			while (sum + count <= n) {
				System.out.println(count + 1 + " " + 2);
				sum += count;
				count++;
			}
//			count++;
			while (sum < n) {
				System.out.println(count + " " + 1);
				sum++;
				count++;
			}
		}
	}

}
