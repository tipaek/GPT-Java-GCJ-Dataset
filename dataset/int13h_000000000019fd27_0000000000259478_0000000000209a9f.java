import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		solve();
	}

	private static void solve() {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		int t = sc.nextInt();
		for (int i2 = 1; i2 <= t; i2++) {
			String line = sc.next();
			System.out.println("Case #" + i2 + ": " + solution(line));
		}

		sc.close();
	}

	private static String solution(String line) {
		//System.out.println("[" + line + "]");
		
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		ArrayList<Integer> counts = new ArrayList<Integer>();
		int last = -1;
		for (int i = 0; i < line.length(); i++) {
			int n = line.charAt(i)-'0';
			if (last != n) {
				numbers.add(n);
				counts.add(1);
				last = n;
			} else {
				counts.set(counts.size()-1, counts.get(counts.size()-1)+1);
			}
		}
		//System.out.println("numbers: " + numbers);
		//System.out.println("counts: " + counts);
		
		StringBuilder sb = new StringBuilder();
		
		int r = 0;
		for (int i = 0; i < numbers.size(); i++) {
			int n = numbers.get(i);
			int c = counts.get(i);
			if (r < n) {
				for (int j = 0; j < n-r; j++) {
					sb.append("(");
				}
				for (int j = 0; j < c; j++) {
					sb.append(n);
				}
				r = n;
			} else if (r >= n) {
				for (int j = 0; j < r-n; j++) {
					sb.append(")");
				}
				for (int j = 0; j < c; j++) {
					sb.append(n);
				}
				r = n;
			}
			
		}
		
		
		for (int j = 0; j < r; j++) {
			sb.append(")");
		}
		
		

		return sb.toString();
	}



}
