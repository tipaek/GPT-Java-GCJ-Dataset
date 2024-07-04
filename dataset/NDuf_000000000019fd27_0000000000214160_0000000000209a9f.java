import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Solution {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		final int nbTestCases = sc.nextInt();
		for(int t = 1 ; t <= nbTestCases ; ++t) {
			System.out.println(
				"Case #" + t + ": " + testCase(sc)
			);
		}
		sc.close();
	}
	
	public static String testCase(Scanner sc) throws Exception {
		String input = sc.next();
		StringBuilder output = new StringBuilder();
		int depth = 0;
		for(Integer codePoint : input.chars().toArray()) {
			Integer number = Integer.valueOf(new String(Character.toChars(codePoint)));
			while(depth != number) {
				if(depth < number) {
					output.append("(");
					++depth;
				} else {
					output.append(")");
					--depth;
				}
			}
			output.append(number);
		}
		while(depth != 0) {
			output.append(")");
			--depth;
		}
		return output.toString();
	}
	
}
