public class Solution {

	public static double series(double x, int n) {
		int temp = 0;
		int oddTerm = 1;
		int evenTerm = 2;
		double evenTermSum = 0;
		double oddTermSum = 0;

		while (temp < n) {
			if (n % 2 == 0) {
				evenTermSum = evenTermSum - evenTerm;
				if (n % 2 == 0 && n > 1) {
					evenTermSum = evenTermSum * x;
				}
			}
			// if(n % 2 != 0)
			else {
				oddTermSum = oddTermSum + oddTerm;
				if (n % 2 != 0 && n > 2) {
					oddTermSum = n * x * x;
				}
			}
			n--;
		}
		return evenTermSum + oddTermSum;
	}

	public static void main(String[] args) {
		System.out.print("series(0.5, 1) should be 1.0");
		System.out.println(": " + series(0.5, 4));
	}
}
