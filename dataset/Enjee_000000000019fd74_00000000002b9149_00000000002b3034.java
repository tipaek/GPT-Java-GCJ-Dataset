import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for (int j = 1; j <= t; ++j) {
			int N = in.nextInt();

			List<StringPattern> patterns = new ArrayList<>();
			for(int i = 0; i < N; i++) {
				String next = in.next();
				StringPattern p = new StringPattern(next);
				patterns.add(p);
			}

			String result = "";

			boolean fault = false;

			boolean step1Done = false;

			String prefix = "";
			while(!step1Done && !fault) {
				boolean foundSomething = false;
				char c = '_';
				for(int i = 0; i < N; i++) {
					StringPattern p = patterns.get(i);
					if(!p.reachedForwardStar) {
						foundSomething = true;
						char cur = p.getForward();
						if(c != '_' && c != cur) {
							fault = true;
							break;
						}
						c = cur;
					}
				}
				if(!foundSomething) {
					step1Done = true;
				} else {
					prefix = prefix + c;
				}
			}

			boolean step2Done = false;
			String suffix = "";

			while(!step2Done && !fault) {
				boolean foundSomething = false;
				char c = '_';
				for(int i = 0; i < N; i++) {
					StringPattern p = patterns.get(i);
					if(!p.reachedReverseStar) {
						foundSomething = true;
						char cur = p.getReverse();
						if(c != '_' && c != cur) {
							fault = true;
							break;
						}
						c = cur;
					}
				}
				if(!foundSomething) {
					step2Done = true;
				} else {
					suffix = c + suffix;
				}
			}

			for(int i = 0; i < N; i++) {
				StringPattern p = patterns.get(i);
				result = result + p.getRemaining();
			}
			
			if(fault)
				System.out.println("Case #" + j + ": *");
			else
				System.out.println("Case #" + j + ": " + prefix + result + suffix);
			
			// System.out.println("Case #" + i + ": OK");
 			// NumberFormat formatter = new DecimalFormat("#0.000000");   
			// System.out.println("Case #" + i + ": " + formatter.format(D/max));
		}
		in.close();
	}
}

class StringPattern {
	String string;
	int beg;
	int end;

	boolean reachedForwardStar;
	boolean reachedReverseStar;

	public StringPattern (String s){
		string = s;
		beg = 0;
		end = s.length() - 1;
		reachedForwardStar = s.charAt(beg) == '*' ? true : false;
		reachedReverseStar = s.charAt(end) == '*' ? true : false;
	}

	char getForward() {
		beg++;
		reachedForwardStar = string.charAt(beg) == '*' ? true : false;
		return string.charAt(beg - 1);
	}

	char getReverse() {
		end--;
		reachedReverseStar = string.charAt(end) == '*' ? true : false;
		return string.charAt(end +1);
	}

	String getRemaining() {
		String ret = "";
		for(int i = beg; i <= end; i++) {
			if(string.charAt(i) != '*') {
				ret = ret + string.charAt(i);
			}
		}
		return ret;
	}

	@Override
	public String toString() {
		return "StringPattern{" +
				"string='" + string + '\'' +
				", beg=" + beg +
				", end=" + end +
				", reachedForwardStar=" + reachedForwardStar +
				", reachedReverseStar=" + reachedReverseStar +
				'}';
	}
}
