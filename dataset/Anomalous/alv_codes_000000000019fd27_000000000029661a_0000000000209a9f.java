import java.util.*;
import java.io.*;

public class Solution {

	private static void addBrackets(Stack<Character> stack, char digit) {
		int num = Character.getNumericValue(digit);
		for (int i = 0; i < num; i++) {
			stack.push('(');
		}
		stack.push(digit);
		for (int i = 0; i < num; i++) {
			stack.push(')');
		}
	}

	private static void insertDigit(Stack<Character> stack, char digit) {
		int num = Character.getNumericValue(digit);
		for (int i = 0; i < num; i++) {
			stack.pop();
		}
		stack.push(digit);
		for (int i = 0; i < num; i++) {
			stack.push(')');
		}
	}

	private static int getLastDepth(Stack<Character> stack) {
		Stack<Character> tempStack = (Stack<Character>) stack.clone();
		if (tempStack.isEmpty()) {
			return 0;
		}

		char top = tempStack.peek();
		while (top == ')') {
			tempStack.pop();
			top = tempStack.peek();
		}

		return Character.getNumericValue(top);
	}

	private static void printStack(Stack<Character> stack) {
		if (stack.isEmpty()) {
			return;
		}

		char top = stack.pop();
		printStack(stack);
		System.out.print(top);
		stack.push(top);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCases = scanner.nextInt();

		for (int i = 1; i <= testCases; i++) {
			String digits = scanner.next();
			Stack<Character> stack = new Stack<>();

			for (char digit : digits.toCharArray()) {
				int currentDepth = getLastDepth(stack);
				int digitValue = Character.getNumericValue(digit);

				if (currentDepth < digitValue) {
					if (currentDepth == 1) {
						stack.pop();
					}
					addBrackets(stack, digit);
				} else {
					insertDigit(stack, digit);
				}
			}

			System.out.print("Case #" + i + ": ");
			printStack(stack);
			System.out.println();
		}
		scanner.close();
	}
}