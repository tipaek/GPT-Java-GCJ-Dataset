import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {


	public static void main(String[] args) {
		solve();
	}

	
	private static void solve() {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		int t = sc.nextInt();
		
		for (int i2 = 1; i2 <= t; i2++) {
			int n = sc.nextInt();
			System.out.println("Case #" + i2 + ":");
			solution(n);
		}

		sc.close();
	}

	private static String solution(int n) {
		
		if (n <= 1000) {
			System.out.println(1 + " " + 1);
			int sum = 1;
			int last = 1;
			for (int i = 1; i < 500; i++) {
				if (sum+i > n) {
					break;
				}
				last = i;
				sum += i;
				System.out.println((i+1) + " " + 2);
			}
			//System.out.println("sum: " + sum);
			for (int i = last; i < 500; i++) {
				if (sum+1 > n) {
					break;
				}
				sum += 1;
				System.out.println((i+1) + " " + 1);
			}
			//System.out.println("sum: " + sum);
			
		}
		
		return ""+n;
	}


}
