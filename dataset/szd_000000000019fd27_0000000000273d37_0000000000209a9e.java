import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Solution {

	private static char ask(BufferedReader in, PrintStream out, int b) throws IOException {
		out.println(b+1);
		out.flush();
		char ch = in.readLine().charAt(0);
		if(ch == 'N')
			System.exit(1);
		return ch;
	}

	private static int N = 1;
	private static int C = 2;
	private static int R = 4;
	private static int X = 8;
	
	static final int M[] = new int[] {
		N|R, C|X, // 000 001
		N|X, R|C, // 010 011
		R|C, N|X, // 100 101
		C|X, N|R, // 110 111
	};
	
	private static void run(BufferedReader in, PrintStream out) throws IOException {
		StringTokenizer st = new StringTokenizer(in.readLine());
		int T = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		for(int caseNr = 1; caseNr <= T; caseNr++) {
			int b = 0;
			int q = 0;
			char bits[] = new char[B], ch;
			while(b < B) {
				final int p1 = b >> 1;
				final int p2 = B - 1 - p1;
				if(q > 0 && q % 10 == 0) {
					int b0 = bits[0] - '0';
					int bb = bits[B - 1] - '0';
					int c0 = ask(in, out, 0) - '0';
					int bs0 = (b0 << 1) | bb;
					int m0 = M[(bs0 << 1) | c0];
					for(int i = 1; i < p1; i++) {
						int bi = bits[i] - '0';
						int bj = bits[B - 1 - i] - '0';
						int bsi = (bi << 1) | bj;
						if(bs0 != bsi && (bs0 != (bsi ^ 3))) {
							q++;
							int ci = ask(in, out, i) - '0';
							int mi = M[(bsi << 1) | ci];
							m0 &= mi;
							break;
						}
					}
					if((q & 1) == 0) {
						q++;
						ask(in, out, 0);
					}
					if((m0 & N) != 0)
						;
					else if((m0 & C) != 0) {
						for(int i = 0; i < p1; i++) {
							bits[i] ^= 1;
							bits[B - 1 - i] ^= 1;
						}
					}
					else if((m0 & R) != 0) {
						for(int i = 0; i < p1; i++) {
							char bi = bits[i];
							bits[i] = bits[B - 1 - i];
							bits[B - 1 - i] = bi;
						}
					}
					else {
						for(int i = 0; i < p1; i++) {
							char bi = bits[i];
							bits[i] = (char)(bits[B - 1 - i] ^ 1);
							bits[B - 1 - i] = (char)(bi ^ 1);
						}
					}
				}
				q++;
				bits[p1] = ask(in, out, p1);
				q++;
				bits[p2] = ask(in, out, p2);
				b += 2;
			}
			out.println(new String(bits));
			out.flush();
			ch = in.readLine().charAt(0);
			if(ch == 'N')
				System.exit(1);
		}
	}
	
	public static void main(String args[]) throws IOException {
		InputStream in = System.in;

		run(new BufferedReader(new InputStreamReader(in)), System.out);
	}
}