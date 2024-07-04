import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Solution {
	
	private static char[] solve(int L, StringTokenizer st) {
		BigInteger ct[] = new BigInteger[L];
		BigInteger p[] = new BigInteger[L + 1];
		for(int i = 0; i < L; i++)
			ct[i] = new BigInteger(st.nextToken());
		HashSet<BigInteger> primes = new HashSet();

		BigInteger p1 = ct[0].gcd(ct[1]);
		BigInteger p0 = ct[0].divide(p1);
		primes.add(p0);
		primes.add(p1);
		p[0] = p0;
		p[1] = p1;
		for(int i = 2; i <= L; i++) {
			// 0*1 1*2 2*3
			primes.add(p[i] = ct[i-1].divide(p[i-1]));
		}
		Object a[] = primes.toArray();
		Arrays.sort(a);
		HashMap<BigInteger,Integer> ai = new HashMap();
		for(int i = 0; i < a.length; i++)
			ai.put((BigInteger)a[i], i);

		char txt[] = new char[L + 1];
		for(int i = 0; i <= L; i++)
			txt[i] = (char)('A' + ai.get(p[i]).intValue());
		return txt;
	}
	
	private static void run(BufferedReader in, PrintStream out) throws IOException {
		int T = Integer.parseInt(in.readLine());
		for(int caseNr = 1; caseNr <= T; caseNr++) {
			String s = in.readLine();
			int l = s.length();
			StringBuilder sb = new StringBuilder(l * 3);
			int nd = 0;
			for(int i = 0; i < l; i++) {
				char ch;
				int c = (ch = s.charAt(i)) - '0';
				while(nd < c) {
					sb.append('(');
					nd++;
				}
				while(nd > c) {
					sb.append(')');
					nd--;
				}
				sb.append(ch);
			}
			while(nd > 0) {
				sb.append(')');
				nd--;
			}
			out.print("Case #" + caseNr + ": ");
			out.print(sb.toString());
			out.println();
		}
	}
	
	public static void main(String args[]) throws IOException {
		InputStream in = System.in;


		run(new BufferedReader(new InputStreamReader(in)), System.out);
	}
}