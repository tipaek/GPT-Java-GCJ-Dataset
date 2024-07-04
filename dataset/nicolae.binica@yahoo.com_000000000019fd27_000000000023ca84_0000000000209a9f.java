import java.util.Scanner;
import java.io.*;
import java.util.*;

class Solution {

	public static void main(String[] args) {

	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int Q = in.nextInt();
		for(int test = 1; test <= Q; test ++){
			System.out.printf("Case #%d: ", test);
			
			solve(in);
			
			System.out.println();
		}
	}
	
	public static void solve(Scanner in) {

		String s = in.next();
		String result = "";
		int cnt = 0;
		for(int i = 0; i < s.length(); i ++) {
			while(cnt < s.charAt(i) - '0') {
				cnt ++;
				result += '(';
			}
			while(cnt > s.charAt(i) - '0') {
				cnt --;
				result += ')';
			}
			result += s.charAt(i);
		}

		while(cnt > 0) {
			cnt --;
			result += ')';
		}
		System.out.print(result);
		
	}

}
