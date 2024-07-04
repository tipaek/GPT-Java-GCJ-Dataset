import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	
	public String solve(int B, Scanner in) {
		if(B == 10) {
			StringBuilder ans = new StringBuilder("");
			for(int i = 1; i <= 10; i++) {
				System.out.println(i);
				System.out.flush();
				String get = in.nextLine();
				if(get.startsWith("1")) ans.append("1");
				else ans.append("0");
			}
			System.out.println(ans.toString());
			String res = in.nextLine();
			return res;
		}
		else if(B == 20) {
			char[] ans = new char[20];
			for(int i = 1; i <= 5; i++) {
				System.out.println(i);
				System.out.flush();
				String get = in.nextLine();
				if(get.startsWith("1")) ans[i-1] = '1';
				else ans[i-1] = '0';
			}
			for(int i = 20; i > 15; i--) {
				System.out.println(i);
				System.out.flush();
				String get = in.nextLine();
				if(get.startsWith("1")) ans[i-1] = '1';
				else ans[i-1] = '0';
			}
			int target1 = 0;
			int target2 = 0;
			
			for(int i = 1; i <= 5; i++) {
				if(ans[i-1] != ans[20-i]) {
					if(target1 == 0) target1 = i;
				}
				if(ans[i-1] == ans[20-i]) {
					if(target2 == 0) target2 = i;
				}
			}
			
			boolean reverse = false;
			boolean complement = false;
			
			System.out.println(target1);
			System.out.flush();
			String get1 = in.nextLine();
			System.out.println(target2);
			System.out.flush();
			String get2 = in.nextLine();
			if(get2.charAt(0) != ans[target2]) complement = true;
			if(get1.charAt(0) != ans[target1]) reverse = !complement;
			
			reverseNcomplement(reverse, complement, ans);	
			for(int i = 6; i <= 10; i++) {
				System.out.println(i);
				System.out.flush();
				String get = in.nextLine();
				if(get.startsWith("1")) ans[i-1] = '1';
				else ans[i-1] = '0';
			}
			empty(3, in);
			
			System.out.println(target1);
			System.out.flush();
			get1 = in.nextLine();
			System.out.println(target2);
			System.out.flush();
			get2 = in.nextLine();
			if(get2.charAt(0) != ans[target2]) complement = true;
			if(get1.charAt(0) != ans[target1]) reverse = !complement;
			
			reverseNcomplement(reverse, complement, ans);
				
			for(int i = 11; i <= 15; i++) {
				System.out.println(i);
				System.out.flush();
				String get = in.nextLine();
				if(get.startsWith("1")) ans[i-1] = '1';
				else ans[i-1] = '0';
			}
			
			empty(3, in);
			System.out.println(ans.toString());
			String res = in.nextLine();
			return res;
		}
		else {
			char[] ans = new char[100];
			for(int i = 1; i <= 5; i++) {
				System.out.println(i);
				System.out.flush();
				String get = in.nextLine();
				if(get.startsWith("1")) ans[i-1] = '1';
				else ans[i-1] = '0';
			}
			for(int i = 100; i > 95; i--) {
				System.out.println(i);
				System.out.flush();
				String get = in.nextLine();
				if(get.startsWith("1")) ans[i-1] = '1';
				else ans[i-1] = '0';
			}
			int target1 = 0;
			int target2 = 0;
			
			for(int i = 1; i <= 5; i++) {
				if(ans[i-1] != ans[20-i]) {
					if(target1 == 0) target1 = i;
				}
				if(ans[i-1] == ans[20-i]) {
					if(target2 == 0) target2 = i;
				}
			}
			
			for(int i = 0; i < 14; i++) {
				boolean reverse = false;
				boolean complement = false;
				
				System.out.println(target1);
				System.out.flush();
				String get1 = in.nextLine();
				System.out.println(target2);
				System.out.flush();
				String get2 = in.nextLine();
				if(get2.charAt(0) != ans[target2]) complement = true;
				if(get1.charAt(0) != ans[target1]) reverse = !complement;
				
				reverseNcomplement(reverse, complement, ans);
				for(int j = i*8 + 6; j <= i*8 + 13; j++) {
					System.out.println(j);
					System.out.flush();
					String get = in.nextLine();
					if(get.startsWith("1")) ans[j-1] = '1';
					else ans[j-1] = '0';
					
					if(j == 95) {
						System.out.println(ans.toString());
						String res = in.nextLine();
						return res;
					}
				}
			}
		}
		return "N";
	}
	
	private void empty(int N, Scanner in) {
		for(int i = 0; i < N; i++) {
			System.out.println(1);
			System.out.flush();
			in.nextLine();
		}
	}
	
	private void reverseNcomplement(boolean reverse, boolean complement, char[] ans) {
		if(reverse) {
			for(int i = 0; i < ans.length; i++) {
				if(ans[i] == '0') ans[i] = '1';
				else if(ans[i] == '1') ans[i] = '0';
			}
		}
		if(complement) {
			for(int i = 0; i < ans.length/2; i++) {
				char tmp = ans[i];
				ans[i] = ans[19-i];
				ans[19-i] = tmp;
			}
		}
	}
	
	
	public static void mainX(String[] args) {
		Solution Q = new Solution();
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Solution Q = new Solution();
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		int B = in.nextInt();
		in.nextLine();
		for (int i = 1; i <= t; ++i) {
			String s = Q.solve(B, in);
			System.out.flush();
			//if(s.startsWith("N")) return;
		}
	}

}
