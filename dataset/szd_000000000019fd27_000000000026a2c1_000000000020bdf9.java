import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Solution {
	
	private static void run(BufferedReader in, PrintStream out) throws IOException {
		int T = Integer.parseInt(in.readLine());
		for(int caseNr = 1; caseNr <= T; caseNr++) {
			int N = Integer.parseInt(in.readLine());
			int a[] = new int[N];
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				a[i] = (s << 21) | (e << 10) | i;
			}
			Arrays.sort(a);
			char ret[] = new char[N];
			int C = 0;
			int J = 0;
			for(int i = 0; i < N; i++) {
				int A = a[i];
				int s = A >> 21;
				int e = (A >> 10) & 2047;
				int n = A & 1023;
				if(C <= s) {
					C = e;
					ret[n] = 'C';
				}
				else if(J <= s) {
					J = e;
					ret[n] = 'J';
				}
				else {
					ret = null;
					break;
				}
			}
			out.print("Case #" + caseNr + ": ");
			if(ret == null)
				out.print("IMPOSSIBLE");
			else
				out.print(new String(ret));
			out.println();
		}
	}
	
	public static void main(String args[]) throws IOException {
		InputStream in = System.in;

		run(new BufferedReader(new InputStreamReader(in)), System.out);
	}
}