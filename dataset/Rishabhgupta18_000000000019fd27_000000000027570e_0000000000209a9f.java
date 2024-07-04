import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
      
      
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = Integer.parseInt("" + in.nextLine());
		for (int k = 1; k <= t; k++) {
			String s = in.nextLine();
			int n = s.length();
			System.out.print("Case #" + k + ": ");
			for (int j = 1; j <= s.charAt(0) - 48; j++) {
				System.out.print("(");
			}
			System.out.print(s.charAt(0));
			for (int i = 1; i < n; i++) {
				int temp = s.charAt(i) - s.charAt(i - 1);
				if (temp > 0) {
					for (int j = 1; j <= temp; j++) {
						System.out.print("(");
					}
					System.out.print(s.charAt(i));
				} else if (temp < 0) {
					for (int j = 1; j <= (-temp); j++) {
						System.out.print(")");
					}
					System.out.print(s.charAt(i));
				} else {
					System.out.print(s.charAt(i));
				}
			}
			for (int j = 1; j <= s.charAt(n - 1) - 48; j++) {
				System.out.print(")");
			}
			System.out.println();
		}

	
  }
}