import java.io.*;
import java.util.*;

//solution
public class Solution {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int test = 1; test <= t; test++) {
			String s = sc.next();
			int left = 0;
			int right = 0;
			System.out.print("Case #" + test + ": ");
			for (int i = 0; i < s.length(); i++) {
				int need = Integer.parseInt(s.substring(i, i+1));
				if (need > left) {
					for (int x = 0; x < need - left; x++) {
						System.out.print('(');
//						left++;
					}
					left += need - left;
					System.out.print(need);
				} else {
					for (int x = 0; x < left - need; x++) {
						System.out.print(')');
//						right++;
//						left--;
					}
					right += left - need;
					left -= left - need;
					System.out.print(need);
				}
			}
			for (int i = 0; i < left; i++) {
				System.out.print(')');
			}
			System.out.println();
		}
		//change class to solution
	}

}
