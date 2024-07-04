import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Stream;

public class NestingDepth {

	private static Stack<Integer> stk = new Stack<Integer>();
	private static String openOne = "(";
	private static String openTwo = "((";
	private static String openThree = "(((";
	private static String openFour = "((((";
	private static String openFive = "(((((";
	private static String openSix = "((((((";
	private static String openSeven = "(((((((";
	private static String openEight = "((((((((";
	private static String openNine = "(((((((((";

	private static String closeOne = ")";
	private static String closeTwo = "))";
	private static String closeThree = ")))";
	private static String closeFour = "))))";
	private static String closeFive = ")))))";
	private static String closeSix = "))))))";
	private static String closeSeven = ")))))))";
	private static String closeEight = "))))))))";
	private static String closeNine = ")))))))))";

	public static void main(String[] args) {

		Scanner stdin = new Scanner(System.in);
		String line = stdin.nextLine();
		int N = Integer.parseInt(line);
		int mainCounter = 0;

		while (mainCounter < N && stdin.hasNext()) {
			mainCounter++;
			String str = stdin.nextLine();
			Stream.of(str.split("")).mapToInt(Integer::parseInt).forEach(x -> stk.push(x));
			int first = (int) stk.pop();
			System.out.println(append("", 0, first));
		}

	}

	private static String append(String str, int pre, int current) {
		String result = null;

		switch (current - pre) {
		case -9:
			result = current + openNine + str;
			break;
		case -8:
			result = current + openEight + str;
			break;
		case -7:
			result = current + openSeven + str;
			break;
		case -6:
			result = current + openSix + str;
			break;
		case -5:
			result = current + openFive + str;
			break;
		case -4:
			result = current + openFour + str;
			break;
		case -3:
			result = current + openThree + str;
			break;
		case -2:
			result = current + openTwo + str;
			break;
		case -1:
			result = current + openOne + str;
			break;
		case 0:
			result = current + str;
			break;
		case 1:
			result = current + closeOne + str;
			break;
		case 2:
			result = current + closeTwo + str;
			break;
		case 3:
			result = current + closeThree + str;
			break;
		case 4:
			result = current + closeFour + str;
			break;
		case 5:
			result = current + closeFive + str;
			break;
		case 6:
			result = current + closeSix + str;
			break;
		case 7:
			result = current + closeSeven + str;
			break;
		case 8:
			result = current + closeEight + str;
			break;
		case 9:
			result = current + closeNine + str;
			break;
		default:
			return result;

		}

		if (stk.isEmpty()) {
			if (current != 0 && current == pre) {
				switch (current) {
				case 1:
					result = openOne + current + str;
					break;
				case 2:
					result = openTwo + current + str;
					break;
				case 3:
					result = openThree + current + str;
					break;
				case 4:
					result = openFour + current + str;
					break;
				case 5:
					result = openFive + current + str;
					break;
				case 6:
					result = openSix + current + str;
					break;
				case 7:
					result = openSeven + current + str;
					break;
				case 8:
					result = openEight + current + str;
					break;
				case 9:
					result = openNine + current + str;
					break;
				default:
					return result;

				}
			} else {
				switch (current - pre) {
				case 0:
					result = current + str;
					break;
				case 1:
					result = openOne + current + closeOne + str;
					break;
				case 2:
					result = openTwo + current + closeTwo + str;
					break;
				case 3:
					result = openThree + current + closeThree + str;
					break;
				case 4:
					result = openFour + current + closeFour + str;
					break;
				case 5:
					result = openFive + current + closeFive + str;
					break;
				case 6:
					result = openSix + current + closeSix + str;
					break;
				case 7:
					result = openSeven + current + closeSeven + str;
					break;
				case 8:
					result = openEight + current + closeEight + str;
					break;
				case 9:
					result = openNine + current + closeNine + str;
					break;
				case -1:
					result = openOne + current + openOne + str;
					break;
				case -2:
					result = openTwo + current + openTwo + str;
					break;
				case -3:
					result = openThree + current + openThree + str;
					break;
				case -4:
					result = openFour + current + openFour + str;
					break;
				case- 5:
					result = openFive + current + openFive + str;
					break;
				case -6:
					result = openSix + current + openSix + str;
					break;
				case -7:
					result = openSeven + current + openSeven + str;
					break;
				case -8:
					result = openEight + current + openEight + str;
					break;
				case -9:
					result = openNine + current + openNine + str;
					break;
				default:
					return result;

				}
			}

		} else {
			return append(result, current, (int) stk.pop());
		}
		return result;
	}

}
