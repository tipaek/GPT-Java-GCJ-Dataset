import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			System.out.println("Case #" + i + ": ");
			if(n == 501) {
				System.out.print("1 1\n2 2\n3 2\n3 3\n");	
				for(int j = 4; j < 500; j++) {
					System.out.println(j + " " + j);
				}
			} else {
				for(int j = 1; j <= n; j++) {
					System.out.println(j + " " + j);
				}
			}
		}
	}
}