import java.util.*;
class Solution {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int numCases = in.nextInt();
		in.nextLine();
		for (int curCase = 1; curCase <= numCases; curCase++) {
			String curString = in.nextLine();
			Digit[] digits = new Digit[curString.length()];
			for (int i = 0; i < curString.length(); i++) {
				digits[i] = new Digit(curString.charAt(i));
			}
			solve(digits, 0, digits.length);
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < digits.length; i++) {
				for (int i1 = 0; i1 < digits[i].open; i1++)
					sb.append('(');
				sb.append(digits[i].original);
				for (int i2 = 0; i2 < digits[i].close; i2++)
					sb.append(')');
			}
			System.out.println("Case #" + curCase + ": " + sb.toString());
		}
	}
	
	public static void solve(Digit[] digits, int start, int end) {
		if (start == end)
			return;
		if (start == end - 1) {
			digits[start].open += digits[start].current;
			digits[start].close += digits[start].current;
			digits[start].current = 0;
		} else {
			ArrayList<Integer> minimums = findMinimum(digits, start, end);
			digits[start].open += minimums.get(minimums.size()-1);
			digits[end-1].close += minimums.get(minimums.size()-1);
			for (int i = start; i < end; i++) {
				digits[i].current -= minimums.get(minimums.size()-1);
			}
			
			int startIndex = start;
			for (int i = 0; i <= minimums.size()-2; i++) {
				int endIndex = minimums.get(i);
				solve(digits, startIndex, endIndex);
				startIndex = minimums.get(i) + 1;
			}
		}
	}
	
	// start inclusive, end exclusive
	public static ArrayList<Integer> findMinimum(Digit[] digits, int start, int end) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		int minimum = Integer.MAX_VALUE;
		for (int i = start; i < end; i++) {
			if (digits[i].current == minimum) {
				res.add(i);
			} else if (digits[i].current < minimum) {
				minimum = digits[i].current;
				res = new ArrayList<Integer>();
				res.add(i);
			}
		}
		res.add(end);
		res.add(minimum);
		return res;
	}
	
	static class Digit {
		int original;
		int current;
		int open;
		int close;
		
		public Digit(char digit) {
			this.original = digit - '0';
			this.current = digit - '0';
			this.open = 0;
			this.close = 0;
		}
	}
}