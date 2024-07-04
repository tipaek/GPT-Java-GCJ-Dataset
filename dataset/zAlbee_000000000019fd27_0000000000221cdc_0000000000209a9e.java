import java.io.PrintStream;
import java.math.BigInteger;
import java.util.*;
import java.util.Map.Entry;

/**
 * 2020-Q.
 * @author Albert Choi
 */
public class Solution {
	static Scanner in = new Scanner(System.in);
	static PrintStream sout = System.out, serr = System.err;
	static int nint() {return in.nextInt();}
	static long nlong() {return in.nextLong();}
	static BigInteger nbig() {return in.nextBigInteger();}
	static String nline() {return in.nextLine();}
	
	static int B;
	public static void main(String[] args) {
		int T = nint(); B = nint(); nline();
		for (int t=1; t<=T; t++) {
			new Solution().doProblem();
		}
	}

	// get response to answer as a char
	char getrc() {
		char c = nline().charAt(0);
		if (c == 'N') System.exit(0);
		return c;
	}

	static class Pair {
		int pos;
		char val;
		Pair(int p, char v) {
			pos = p;
			val = v;
		}
		int index() {
			return pos-1;
		}
		int rindex() {
			return B-pos;
		}
	}

	int pos = 1;
	int round = 0;
	
	List<Pair> sames = new ArrayList<>();
	List<Pair> diffs = new ArrayList<>();
	
	void doProblem() {

		while (true) {
			// find pairs of bits (x,y) at position P and B-P, i.e. mirrored positions
			findPairs();

			// we must have reached round 10 OR we went through half the array
			if (pos > B/2) {
				// went through half the array
				// we're done!
				// Convert pairs into an array
				char[] ans = new char[B];
				for (Pair p : sames) {
					ans[p.index()] = p.val;
					ans[p.rindex()] = p.val;
				}
				for (Pair p : diffs) {
					ans[p.index()] = p.val;
					ans[p.rindex()] = flip(p.val);
				}
				sout.println(ans);
				getrc();
				return;
			}
			if (round % 10 == 0) {
				if (!sames.isEmpty()) {
					// re-query same pair
					Pair same = sames.get(0);
					char newVal = query(same.pos);
					boolean flip = newVal != same.val;

					if (flip) {
						for (Pair p : sames) {
							p.val = flip(p.val);
						}
					}
				}
				if (!diffs.isEmpty()) {
					// re-query diff pair
					Pair diff = diffs.get(0);
					char newVal = query(diff.pos);
					boolean flip = newVal != diff.val;
					
					if (flip) {
						for (Pair p : diffs) {
							p.val = flip(p.val);
						}
					}
				}
				if (round % 2 == 1) {
					// odd number, waste one
					query(1);
				}
			}
			else {
				// something horrible as happened
			}
				
		}
	}

	void findPairs() {
		while ((round == 0 || round % 10 != 0) && pos <= B/2) {
			char x = query(pos);
			char y = query(B-pos + 1);

			Pair p = new Pair(pos, x);
			if (x == y) {
				sames.add(p); 
			} else {
				diffs.add(p);
			}
			pos++;
		}
	}

	char flip(char c) {
		return (c == '0' ? '1': '0');
	}


	char query(int pos) {
		serr.println(">> "+round);
		sout.println(pos);
		round++;
		return nline().charAt(0);
	}

}