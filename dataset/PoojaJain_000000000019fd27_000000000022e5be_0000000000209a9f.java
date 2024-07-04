
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		int noOfTestCases = in.nextInt();
		StringBuilder ans = new StringBuilder();
		for (int i = 0; i < noOfTestCases; i++) {
			String s = in.next();

			s = s.replace("1", "(1)");
			s = s.replace("2", "((2))");
			s = s.replace("3", "(((3)))");
			s = s.replace("4", "((((4))))");
			s = s.replace("5", "(((((5)))))");
			s = s.replace("6", "((((((6))))))");
			s = s.replace("7", "(((((((7)))))))");
			s = s.replace("8", "((((((((8))))))))");
			s = s.replace("9", "(((((((((9)))))))))");

			s = s.replace(")(", "");

			ans.append("Case #" + (i + 1) + ": " + s);
			ans.append('\n');

		}

		System.out.println(ans.toString().trim());
		in.close();
	}

}
