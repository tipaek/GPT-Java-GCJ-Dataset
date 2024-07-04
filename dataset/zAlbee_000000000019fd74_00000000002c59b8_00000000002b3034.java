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
			sout.println("Case #" + t + ": " + String.valueOf(
					new Solution().doProblem()
			));
		}
	}

	static class Pair {
		int a, b;
		Pair(int aa, int bb) {a=aa;b=bb;}
	}

	int N;
	char[][] words;
	String[] swords;
	int[] curs;
	String ans = "";

	Object doProblem() {
		N = nint(); nline();
		words = new char[N][];
		swords = new String[N];
		curs = new int[N];
		//List<String> words = new ArrayList<>();
		for (int i=0;i<N;i++){
			//words.add(nline().trim());
			swords[i] = nline().trim();
			words[i] = swords[i].toCharArray();
		}
		String pre = findToStar();
		for (int i=0;i<N;i++){
			String s = swords[i];
			words[i] = rev(s);
			curs[i] = 0;
		}
		String post = findToStar();
		if (pre == null || post == null) {
			return "*";
		}
		return pre + String.valueOf(rev(post));
	}

	char[] rev(String s){
		char[] w = new char[s.length()];
		for (int j=0;j<s.length();j++){
			w[j] = s.charAt(s.length()-j-1);
		}
		return w;
	}
	String findToStar() {
		String ans = "";
		while (true) {
			char chosen = 0;
			int wilds = 0;

			for (int i=0;i<N;i++){
				if (words[i].length <= curs[i]) continue;  // done

				char[] word = words[i];
				char c= word[curs[i]];
				if (c == '*') {
					wilds++;
					continue; // match any
				}
				
				if (chosen == 0) {
					chosen = c;
					ans += c;
				}
				else {
					if (chosen != c) {
						return null;
					}
				}
				curs[i]++;
			}
			
			if (chosen == 0) {
				break;
			}
		}
		return ans;
	}
	
}