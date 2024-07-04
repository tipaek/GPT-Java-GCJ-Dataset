import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Scanner;


public class Solution {
	
	private static class State {
		long left;
		long right;
		long nextCustomer = 1;
		public State(long left, long right) {
			super();
			this.left = left;
			this.right = right;
		}
		boolean step() {
			if (!stepPossible()) {
				return false;
			}
			if (left >= right) {
				left -= nextCustomer;
			} else {
				right -= nextCustomer;
			}
			nextCustomer++;
			return true;
		}
		boolean stepPossible() {
			if (left >= right) {
				return left >= nextCustomer;
			} else {
				return right >= nextCustomer;
			}
		}
		void stepsLeft(long n) {
			long delta = (n * (nextCustomer + nextCustomer + n - 1)) / 2;
			left -= delta;
			nextCustomer += n;
		}
		void stepsRight(long n) {
			long delta = (n * (nextCustomer + nextCustomer + n - 1)) / 2;
			right -= delta;
			nextCustomer += n;
		}
		void stepsLeftRight(long nPairs) {
			long firstL = nextCustomer;
			long lastL = nextCustomer + 2 * (nPairs - 1);
			long deltaL = ((firstL + lastL) * nPairs) / 2;
			long deltaR = ((firstL+1 + lastL+1) * nPairs) / 2;
			left -= deltaL;
			right -= deltaR;
			nextCustomer += 2*nPairs;
		}
		String solve() {
			if (left >= right) {
				long delta = left - right;
				long steps = (long) Math.floor(Math.sqrt(2.0 * delta)) - 1;
				if (steps > 0) {
					stepsLeft(steps);
				}
			} else {
				long delta = right - left;
				long steps = ((long) Math.sqrt(2.0 * delta)) - 1;
				if (steps > 0) {
					stepsRight(steps);
				}
			}
			while (!((left - nextCustomer < right) && (left >= right))) {
				if (!step()) {
					return toString();
				}
			}
			long term = (nextCustomer - 2) / 2;
			long nPairs = - nextCustomer/2 + 1 + ((long) Math.sqrt(term * term + left / 2)) - 2;
			if (nPairs > 0) {
				stepsLeftRight(nPairs);
			}
			while(stepPossible()) {
				step();
			}
			return toString();
		}
		@Override
		public String toString() {
			return String.format(Locale.ROOT, "%d %d %d", nextCustomer-1, left, right);
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for (int tc=1; tc<=t; tc++) {
			long left0 = in.nextLong();
			long right0 = in.nextLong();
			State state = new State(left0, right0);
			

			String solution = state.solve();
			System.out.format(Locale.ROOT, "Case #%d: %s%n", tc, solution);
		}
		in.close();
	}
	
	
}
