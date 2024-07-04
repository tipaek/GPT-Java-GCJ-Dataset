import java.io.PrintStream;
import java.math.BigInteger;
import java.util.*;
import java.util.Map.Entry;

/**
 * 2020-R1.
 * @author Albert Choi
 */
public class Solution {
	static Scanner in = new Scanner(System.in);
	static PrintStream sout = System.out, serr = System.err;
	static int nint() {return in.nextInt();}
	static long nlong() {return in.nextLong();}
	static BigInteger nbig() {return in.nextBigInteger();}
	static String nline() {return in.nextLine();}

	static long[][] pascal = new long[50][];
	
	static long pascal(int i, int j){
		if (j == 1 || j == i) return 1;
		else return pascal[i][j];
	}

	public static void main(String[] args) {
		for (int i=1;i<50;i++){
			pascal[i] = new long[i+1];
			for (int j=1;j<i+1;j++){
				if (j==1 || j==i) {
					pascal[i][j] = 1;
				}
				else pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j];
//				serr.print(pascal[i][j] + " ");
			}
//			serr.println();
		}		
		
//		for (int i=1; i<1001; i++) {
//			serr.println(i);
//		}
		int T = nint(); nline();
		for (int t=1; t<=T; t++) {
			sout.println("Case #" + t + ": " + String.valueOf(
					new Solution().doProblem()
			));
		}
	}

	int N;
	boolean bs[];
	


	Object doProblem() {
		N = nint();
		path.add(new Pair(1,1));
		findPath(N-1);
		StringBuilder sb = new StringBuilder();
		
		long sum = 0;
		for (Pair p: path){
			sb.append(p.a);
			sb.append(" ");
			sb.append(p.b);
//			sb.append(" " + pascal(p.a, p.b));
			sb.append("\n");
			sum += pascal(p.a, p.b);
		}
		if (sum != N) {
			throw new RuntimeException("FAIL");
//			serr.println("FAIL " + N + " " + sum);
//			return sb;
		}
		return sb;
	}
	
	static class Pair {
		int a, b;
		Pair(int aa, int bb) {a=aa;b=bb;}
	}
	
	List<Pair> path = new ArrayList<>();

	void findPath(long goal) {
		while (goal > 0) {
			Pair last = path.get(path.size()-1);
			if (goal <= 500 - path.size()) {
				// go straight down
				while (last.b > 1) {
					last = new Pair(last.a, last.b - 1);
					path.add(last);
					goal -= pascal[last.a][last.b];
				}
				while (goal > 0) {
					last = new Pair(last.a+1, 1);
					path.add(last);
					goal--;
				}
			}
			else {
				long nextRow = 0;
				for (int k=1; k<=last.b; k++) {
					nextRow += pascal[last.a+1][k];
				}
				if (nextRow + pascal[last.a+1][last.b+1] <= goal) {
					path.add(new Pair(last.a+1, last.b+1));
					goal -= pascal[last.a+1][last.b+1];
				}
				else if (nextRow <= goal) {
					path.add(new Pair(last.a+1, last.b));
					goal -= pascal[last.a+1][last.b];
				}
				else {
					path.add(new Pair(last.a, last.b-1));
					goal -= pascal[last.a][last.b-1];
				}
			}
		}
	}
}