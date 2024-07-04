import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= testCases; tc++) {
			String input = br.readLine();
			Deque<Character> intermediate = new ArrayDeque<>();
			for (int i = 0; i < input.length(); i++) {
				int a = input.charAt(i) - 48;
				for (int j = 0; j < a; j++) {
					if (intermediate.peek() != null && intermediate.peek() == ')') {
						intermediate.pop();
					} else {
						intermediate.push('(');
					}
				}
				intermediate.push((char) (a + 48));
				for (int j = 0; j < a; j++) {
					intermediate.push(')');
				}
			}
			StringBuilder answer = new StringBuilder();
			while(!intermediate.isEmpty()){
				answer.append(intermediate.pop());
			}
			answer.reverse();
			System.out.println("Case #" + tc + ": " + answer.toString());
		}
	}
}