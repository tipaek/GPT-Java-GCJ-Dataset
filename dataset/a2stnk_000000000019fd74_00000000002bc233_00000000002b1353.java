import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int T = sc.nextInt();
		
		for(int i=0; i<T; i++) {
			pw.printf("Case #%d: ", i+1);
			solve(sc, pw);
		}
		
		sc.close();
		pw.close();
	}

	static void solve(Scanner sc, PrintWriter pw) {
		int N = sc.nextInt();
		pw.println();
		
		if(N<=500) {
			for(int i=0; i<N; i++) {
				pw.println((i+1) + " 1");
			}
		} else if(N<=1000) {
			pw.println("1 1");
			int r=1;
			int c=1;
			int sum = 1;
			while(sum+r<=N) {
				pw.println((r+1)+ " " + (c+1));
				sum += r;
				r++;
			}
			r--;
			c=0;
			while(sum<N) {
				pw.println((r+1)+ " " + (c+1));
				sum += 1;
				r++;
			}
		}
		
		pw.flush();
		return;
	}
}
