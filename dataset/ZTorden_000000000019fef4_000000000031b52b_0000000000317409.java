import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;
import java.lang.Math;

public class Solution {

	InputStream in;
	PrintStream out;
	Scanner scanner;

	
	Solution(InputStream in, PrintStream out){
		this.in = in;
		this.out=out;
		scanner = new Scanner(new BufferedReader(new InputStreamReader(in)));
	}
	long x,y;
	String s;
	
	private void readTest() {
		x = scanner.nextLong();
		y = scanner.nextLong();
		s = scanner.nextLine().trim();
	}

	boolean isPossible;
	long result;
	
	private void calculate() {
		long dist = Math.abs(x)+Math.abs(y);
		isPossible = dist <= s.length() * 2;
		if(isPossible) {
			result=0;
			while(result<s.length()) {
				if (dist<=result) {
					isPossible = true;
					return;
				}
				switch (s.charAt((int) result)) {
				case 'S': 
					y--;
					if(y<0) dist++; else dist--;
					break;
				case 'N': 
					y++;
					if(y>0) dist++; else dist--;
					break;
				case 'E': 
					x++;
					if(x>0) dist++; else dist--;
					break;
				case 'W': 
					x--;
					if(x<0) dist++; else dist--;
					break;
				}
				result++;
			}
			isPossible = dist<=result;
		}
		
	}

	private void printResult(int i) {
		StringBuilder sb = new StringBuilder();
		sb.append("Case #" + i + ": ");
		
		if(isPossible)
			sb.append(result);
		else
			sb.append("IMPOSSIBLE");
		
		out.println(sb.toString());
		
	}

	public static void main(String[] args) {
		new Solution(System.in, System.out).run();
	}

	public void run() {
		int T = scanner.nextInt();
		scanner.nextLine();
		
		for(int i = 1; i <= T; i++) {
			readTest();
			calculate();
			printResult(i);
		}
	}

}