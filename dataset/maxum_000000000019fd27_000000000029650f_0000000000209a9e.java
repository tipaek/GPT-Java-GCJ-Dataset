import java.util.*;
import java.io.*;


public class Solution {

	public static int MAX_QUERIES = 150;
	public static int ROUND_QUERIES = 10;

	enum Fluctuation {
		COMP, REV, REVCOMP, NONE;
	}

	public static void compute(Scanner in, int B) {
		char[] buf = new char[B];
		Arrays.fill(buf, 'X');

		int sameIdx = -1, diffIdx = -1;

		int cnt = 0;
		int idx = 0;

		int nQueries = 0;
		while (nQueries < MAX_QUERIES) {

			int z = 0;
			if (sameIdx == -1 && diffIdx != -1) {
				System.out.println((diffIdx+1));
				int newVal = in.nextLine().charAt(0);
				if (newVal == buf[diffIdx]) {
					modifyBuffer(buf, Fluctuation.NONE);
				} else {
					modifyBuffer(buf, Fluctuation.COMP);
				}
				/* waste this for symmetry */
				System.out.println((diffIdx+1));
				in.nextLine().charAt(0);
				z+=1;
			}

			if (sameIdx != -1 && diffIdx == -1) {
				System.out.println((sameIdx+1));
				int newVal = in.nextLine().charAt(0);
				if (newVal == buf[sameIdx]) {
					modifyBuffer(buf, Fluctuation.NONE);
				} else {
					modifyBuffer(buf, Fluctuation.COMP);
				}
				/* waste this for symmetry */
				System.out.println((sameIdx+1));
				in.nextLine().charAt(0);
				z+=1;
			}

			if (sameIdx != -1 && diffIdx != -1) {
				System.out.println((sameIdx+1));
				int newVal1 = in.nextLine().charAt(0);
				System.out.println((diffIdx+1));
				int newVal2 = in.nextLine().charAt(0);
				if (newVal1 == buf[sameIdx] && newVal2 == buf[diffIdx]) {
					modifyBuffer(buf, Fluctuation.NONE);
				}
				if (newVal1 != buf[sameIdx] && newVal2 != buf[diffIdx]) {
					modifyBuffer(buf, Fluctuation.COMP);
				}
				if (newVal1 == buf[sameIdx] && newVal2 != buf[diffIdx]) {
					modifyBuffer(buf, Fluctuation.REV);
				}
				if (newVal1 != buf[sameIdx] && newVal2 == buf[diffIdx]) {
					modifyBuffer(buf, Fluctuation.REVCOMP);
				}
				z+=1;
			}


			int i;
			for (i = 0; i < ROUND_QUERIES/2 - z; i++) {
				//System.err.println(new String(buf));
				System.out.println((idx+i+1));
				buf[idx+i] = in.nextLine().charAt(0);
				System.out.println((B-idx-i));
				buf[B-idx-i-1] = in.nextLine().charAt(0);

				if (buf[idx+i] == buf[B-idx-i-1]) { sameIdx = idx+i; }
				if (buf[idx+i] != buf[B-idx-i-1]) { diffIdx = idx+i; }

				cnt += 2;
				if (cnt == B) {
					break;
				}
			}
			idx += i;

			if (cnt == B) {
				//System.err.println(new String(buf));
				System.out.println(new String(buf));
				if (in.nextLine().charAt(0) == 'Y') {
					return;
				} else {
					System.exit(0);
				}
			}

			nQueries += 10;


		}

	}


	private static void modifyBuffer(char[] buf, Fluctuation fluc) {
		switch (fluc) {
			case REVCOMP: {
				modifyBuffer(buf, Fluctuation.REV);
				modifyBuffer(buf, Fluctuation.COMP);
				break;
			}

			case REV: {
				for (int i = 0; i < buf.length / 2; i++) {
					char tmp = buf[i];
					buf[i] = buf[buf.length-i-1];
					buf[buf.length-i-1] = tmp;
				}
				break;
			}

			case COMP: {
				for (int i = 0; i < buf.length; i++) {
					if (buf[i] == '0') { buf[i] = '1'; }
					else if (buf[i] == '1') { buf[i] = '0'; }
				}
				break;
			}


		}

	}



	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int T = in.nextInt();
		int B = in.nextInt(); in.nextLine();
		for (int i = 1; i <= T; i++) {
			compute(in, B);
		}

	}

}
