import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Solution {

	private static final String VALUES_TO_SKIP = "(\r\n|[\n\r\u2028\u2029\u0085])?";

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int numberOfCases = in.nextInt();
		in.skip(VALUES_TO_SKIP);

		for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
			String s = in.nextLine();

			List<Integer> digits = Pattern.compile("").splitAsStream(s)
							.map(Integer::valueOf)
							.collect(Collectors.toList());

			StringBuilder stringBuilder = new StringBuilder();
			int openParenthesis = 0;

			for(int i = 0; i< digits.size(); i++) {
				
				if(digits.get(i) == 0) {
					stringBuilder.append(digits.get(i));
					continue;
				}

				if(i==0 || digits.get(i) > digits.get(i-1)) {
					int counter = digits.get(i) - openParenthesis;
					for(int j = 0; j < counter; j++) {
						stringBuilder.append("(");
						openParenthesis++;
					}
				}

				stringBuilder.append(digits.get(i));

				if(i + 1 < digits.size() && digits.get(i) > digits.get(i+1)) {
					for(int j = 0; j < digits.get(i) - digits.get(i+1); j++) {
						stringBuilder.append(")");
						openParenthesis--;
					}
				}

			}

			for(int j = 0; j < openParenthesis; j++) {
				stringBuilder.append(")");
			}

			System.out.println("Case #" + caseIndex +  ": " + stringBuilder.toString());
		}
	}
	
}
