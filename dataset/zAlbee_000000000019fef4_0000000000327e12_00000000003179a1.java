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

	public static void main(String[] args) {
		int T = nint(); nline();
		for (int t=1; t<=T; t++) {
			sout.print("Case #" + t + ": ");
			new Solution().doProblem();
		}
	}

	static class Pair {
		int[] qdigits;
		char[] rdigits;
		Pair(String q, String r) {
			char[] qarray = q.toCharArray();
			qdigits = new int[qarray.length];
			int i=0;
			for (char c : qarray) {
				qdigits[i++] = c-'0';
			}
			rdigits = r.toCharArray();
		}
	}

	int U;
	List<Pair> data = new ArrayList<>();
	boolean[] cseen = new boolean[26];
	int uniq = 0;
	Map<Character, Set<Integer>> choices = new HashMap<>();


	void doProblem() {
		U = nint(); nline();
		for (int i=0;i<10000;i++){
			Pair p = new Pair(in.next().trim(), nline().trim());
			data.add(p);
		}

		for (Pair p : data) {
			if (uniq < 10) {
				for (char c : p.rdigits) {
					if (!cseen[c-'A']) {
						cseen[c-'A'] = true;
						uniq++;
						Set<Integer> set = new HashSet<>(); 
						choices.put(c, set);
						for (int i=0; i<10; i++){
							set.add(i);
						}
						serr.println(c);
					}
				}
			}

			if (p.qdigits.length > p.rdigits.length) {
				continue;
			}

			char rfirst = p.rdigits[0];
			int qfirst = p.qdigits[0];

			Set<Integer> rset = choices.get(rfirst);
			// can't be 0
			if (rset.remove(0)) {
				serr.println(rfirst + " remove " + 0 + " remain: " + rset);
			}

			boolean firstValid = true;
			// look for AAA... in response
			for (int i=1; i<p.qdigits.length; i++) {
				char r2 = p.rdigits[i];
				if (r2 != rfirst) break;
				if (p.qdigits[i] < qfirst) {
					firstValid = false;
					break;
				}
			}

			// can't be larger than first digit of q
			//				for (char c = (char) (qfirst+1); c <='9'; c++) {
			//					int d = c-'0';
			for (int d = qfirst; d<=9; d++) {
				if (firstValid) continue; // may be equal to first digit
				if (rset.remove(d)) {
					serr.println(rfirst + " remove " + d + " remain: " + rset);
				}
			}
			// other rules... not sure how to code them :/
		}
		serr.println("first pass done");
		serr.println(choices);

		Map<Integer, Set<Character>> nchoices = new HashMap<>();
		for (int i=0; i<10; i++) {
			Set<Character> set = nchoices.computeIfAbsent(i, (ii)->new HashSet<>());
			for (char c : choices.keySet()) {
				if (choices.get(c).contains(i))
					set.add(c);
			}
		}

		boolean changed = true;
		while (changed) {
			changed = false;


			{
				Iterator<Entry<Integer, Set<Character>>> it = nchoices.entrySet().iterator();
				while (it.hasNext()) {
					Entry<Integer, Set<Character>> e = it.next();
					if (e.getValue().size() == 1) {
						char c = e.getValue().iterator().next();
						int d = e.getKey();
						answer[d] = c; 
						for (Entry<Integer, Set<Character>> ee : nchoices.entrySet()) {
							ee.getValue().remove(c);
						}
						changed = true;
						it.remove();
						choices.remove(c);
						serr.println(choices);
						serr.println(nchoices);
					}
				}
			}
			serr.println();
			{
				Iterator<Entry<Character, Set<Integer>>> it = choices.entrySet().iterator();
				while (it.hasNext()) {
					Entry<Character, Set<Integer>> e = it.next();
					if (e.getValue().size() == 1) {
						int d = e.getValue().iterator().next();
						char c = e.getKey();
						answer[d] = c; 
						for (Entry<Character, Set<Integer>> ee : choices.entrySet()) {
							ee.getValue().remove(d);
						}
						changed = true;
						it.remove();
						nchoices.remove(d);
						serr.println(choices);
						serr.println(nchoices);
					}
				}
			}
	
			serr.println();
		}
		serr.println(choices);
		serr.println(nchoices);
		serr.println("SOLVED? " + solved());
		sout.println(String.valueOf(answer));
	}
	
	char[] answer = new char[10];

	boolean solved() {
		for (Entry<Character, Set<Integer>> e : choices.entrySet()) {
			if (e.getValue().size() > 1) {
				return false;
			}

		}
		return true;
	}
}