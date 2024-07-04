import java.io.BufferedReader;
import java.io.InputStreamReader;
/*import java.util.ArrayList;
import java.util.List;*/
import java.util.Scanner;
import java.util.Stack;


public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*int[] array = new int[100];
		Character[] sChar = new Character[100];
		StringBuffer output = new StringBuffer("");*/
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCase = Integer.parseInt(in.nextLine().trim());

		for (int x = 1; x <= testCase; x++) {
			char[] param = in.nextLine().trim().toCharArray();
			Stack<String> s = new Stack<String>();
			Stack<Integer> l = new Stack<Integer>();
			for (int j = 0; j < param.length; j++) {
				int tmp = Integer.parseInt(String.valueOf(param[j]));
				stackPush(s, tmp, l);
			}
			
			Object[] obj = s.toArray();
			// s.copyInto(sChar);
			String a = "";

			for (Object c : obj) {
				a += c;
			}
			System.out.println("Case #" + x + ": " + a);
			//output = new StringBuffer("");
		}
	}

	static void stackPush(Stack<String> s, Integer number, Stack<Integer> intS) {
		String letter = number.toString();
		if (number == 0) {
			s.push("0");
			intS.push(number);
		} else {
			if (s.empty()) {
				pushSmallBracketString(s, number);
				s.push(letter);
				pushBiggerBracketString(s, number);
				intS.push(number);
			} else {
				if (number <= intS.peek()) {
					popBracketString(s, number);
					s.push(letter);
					pushBiggerBracketString(s, number);

				} else {
					pushSmallBracketString(s, number);
					s.push(letter);
					pushBiggerBracketString(s, number);
				}
				intS.push(number);
			}
		}
	}

	private static void pushSmallBracketString(Stack<String> s, Integer number) {
		for (int i = 0; i < number; i++) {
			s.push("(");
		}

	}

	private static void pushBiggerBracketString(Stack<String> s, Integer number) {
		for (int i = 0; i < number; i++) {
			s.push(")");
		}
	}

	private static void popBracketString(Stack<String> s, Integer number) {
		for (int i = 0; i < number; i++) {
			s.pop();
		}
	}
}