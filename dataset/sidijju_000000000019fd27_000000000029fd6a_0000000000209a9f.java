import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	static Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	public static void main(String[] args){
		int t = sc.nextInt(); sc.nextLine();
		for(int i = 0; i < t; i ++) {
			System.out.print("Case #" + (i + 1) + ":");
			solve(sc.nextLine());
			System.out.println();
		}
	}
	private static void solve(String line) {
		int l = Integer.parseInt(line.substring(0, 1));
		String ans = "";
		for(int i = 0; i < l; i ++) {ans += "(";}
		int last = l;
		for(int i = 1; i < line.length(); i ++) {
			int curr = Integer.parseInt(line.substring(i, i + 1));
			if(curr == last) {ans += curr;}
			else {
				ans += last;
				for(int j = 0; j < last - curr; j ++) {ans += ")";}
				l -= last - curr > 0? last - curr: 0;
				for(int j = 0; j < curr - l; j ++) {ans += "(";}
				l += curr - l;
			}
			last = curr;
		}
		l = Integer.parseInt(line.substring(line.length() - 1, line.length()));
		ans += l;
		for(int i = 0; i < l; i ++) {ans += ")";}
		System.out.print(" " +  ans);
	}
	
	
}
