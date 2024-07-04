import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	private Scanner scanner = new Scanner(System.in);

	private String solve() throws Exception {
		char[]	a	= scanner.next().toCharArray();
		StringBuffer	s	= new StringBuffer(a.length);
		for (int i = 0; i < a.length; i++) {
			s.append(a[i] - 48);
		}

		StringBuffer string = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < (s.charAt(i) - 48); j++) {
				string.append("(");
			}
			string.append((s.charAt(i) - 48));
			for (int j = 0; j < (s.charAt(i) - 48); j++) {
				string.append(")");
			}
		}

		StringBuffer	temp	= s;
		List<Integer>	path	= new ArrayList<Integer>();
		int				pos		= -1;

		for (int j = 0; j < s.length(); j++) {
			int z = 10;
			for (int i = 0; i < temp.length(); i++) {
				boolean skip = false;
				for (int k = 0; k < path.size(); k++) {
					if (i == path.get(k)) { skip = true; }
				}
				if (skip == false) {
					if (temp.charAt(i) - 48 < z) {
						z	= temp.charAt(i) - 48;
						pos	= i;
					}
				}
			}
			path.add(pos);
		}

		// Remove Parentheses
		for (int k = 0; k < s.length(); k++) {
			int	index		= 0;
			int	minIndex	= 0;
			int	maxIndex	= string.length() - 1;

			int bla = 0;
			for (int i = 0; i < string.length(); i++) {
				if (string.charAt(i) > 41) {
					if (path.get(k) == bla) {
						index = i;
						break;
					} else {
						bla++;
					}
				}
			}
			
			int currentSmallestLeft = 10;
			for (int i = index - 1; i >= 0; i--) {
				if (string.charAt(i) - 48 < currentSmallestLeft && string.charAt(i) > 41) {
					currentSmallestLeft = string.charAt(i) - 48;
					break;
				}
			}
			
			int currentSmallestRight = 10;
			for (int i = index + 1; i < string.length(); i++) {
				if (string.charAt(i) - 48 < currentSmallestRight && string.charAt(i) > 41) {
					currentSmallestRight = string.charAt(i) - 48;
					break;
				}
			}

			int amountClose = 0;
			for (int i = index + 1; i <= maxIndex; i++) {
				if (string.charAt(i) == 41) { amountClose++; }
			}

			int removedRight = 0;
			if (amountClose > (string.charAt(index) - 48)) {
				if (amountClose - (string.charAt(index) - 48) > (string.charAt(index) - 48)) {
					for (int i = 0; i < (string.charAt(index) - 48); i++) {
						if (removedRight < currentSmallestRight) {
							string.deleteCharAt(index + 1);
							removedRight++;
						}
					}
				} else {
					for (int i = 0; i < (amountClose - (string.charAt(index) - 48)); i++) {
						if (removedRight < currentSmallestRight) {
							string.deleteCharAt(index + 1);
							removedRight++;
						}
					}
				}

			}

			int amountOpen = 0;
			for (int i = index - 1; i >= minIndex; i--) {
				if (string.charAt(i) == 40) { amountOpen++; }
			}
			int offset = 0;
			int	removedLeft	= 0;
			if (amountOpen > (string.charAt(index) - 48)) {
				if (amountOpen - (string.charAt(index) - 48) > (string.charAt(index) - 48)) {
					for (int i = 0; i < (string.charAt(index - offset) - 48); i++) {
						if (removedLeft < currentSmallestLeft) {
							string.deleteCharAt((index - offset) - 1);
							offset++;
							removedLeft++;
						}
					}
				} else {
					for (int i = 0; i < (amountOpen - (string.charAt(index - offset) - 48)); i++) {
						if (removedLeft < currentSmallestLeft) {
							string.deleteCharAt((index - offset) - 1);
							offset++;
							removedLeft++;
						}
					}
				}

			}
		}
		return string.toString();
	}

	private void run() throws Exception {
		int t = scanner.nextInt();
		for (int i = 0; i < t; i++) {
			System.out.printf("Case #%d: %s%n", i + 1, solve());
		}
	}

	public static void main(String[] args) throws Exception { new Solution().run(); }
}
