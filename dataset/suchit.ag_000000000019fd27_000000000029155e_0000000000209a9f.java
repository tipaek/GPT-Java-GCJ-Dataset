import java.util.Collections;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		for (int x = 0; x < t; x++) {
			String st = sc.nextLine();
			StringBuilder sb = new StringBuilder();
			int noOfBrackets = 0;
			for (int i = 0; i < st.length(); i++) {
				int val = Integer.parseInt(st.substring(i, i + 1));
				if (val == noOfBrackets) {
					sb.append(st.charAt(i));
				} else if (val > noOfBrackets) {
					int diff = val - noOfBrackets;
					sb.append(addStartingPara(diff)).append(st.charAt(i));
					noOfBrackets = noOfBrackets + diff;
				} else {
					int diff = noOfBrackets - val;
					sb.append(addEndingPara(diff)).append(st.charAt(i));
					noOfBrackets = noOfBrackets - diff;
				}

			}
			if (noOfBrackets > 0) {
				sb.append(addEndingPara(noOfBrackets));
			}
			System.out.println("Case #" + (x + 1) + ": " + sb.toString());
		}
		sc.close();
	}

	public static String addStartingPara(int n) {
		return String.join("", Collections.nCopies(n, "("));
	}

	public static String addEndingPara(int n) {
		return String.join("", Collections.nCopies(n, ")"));
	}

}
