import java.util.Scanner;

public class Solution {

	private static String solveProblem(char[] array, int sIdx) {

		if(sIdx > array.length) {
			return "";
		}

		StringBuilder builder = new StringBuilder();

		boolean isStarted=false;
		int pCount = -1;

		for(int i=sIdx;i<array.length;i++) {

			int value = array[i] - '0';

			if(!isStarted) {

				for(int j=0;j<value;j++) {
					builder.append("(");
				}
				builder.append(array[i]);

				isStarted = true;
				pCount = value;

			}
			else if(value<=pCount) {

				int counter = pCount - value;

				for(int j=0;j<counter;j++) {
					builder.append(")");
				}
				builder.append(array[i]);

				pCount = value;

			}
			else {

				for(int j=0;j<pCount;j++) {
					builder.append(")");
				}
				sIdx = i;

				builder.append(solveProblem(array, sIdx));

				break;

			}

		}

		for(int j=0;j<pCount;j++) {
			builder.append(")");
		}

		return builder.toString();

	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int T = Integer.parseInt(scanner.nextLine());

		for(int k=1;k<=T;k++) {

			String input = scanner.nextLine();
			String result = solveProblem(input.toCharArray(), 0);
			System.out.println(String.format("Case #%s: %s", k, result));
		}

		scanner.close();

	}

}
