import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) {
		try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));) {
			int numberOfTests = in.nextInt();
			String[] nestingDepths = new String[numberOfTests];
			String s = in.nextLine();
			for (int t = 0; t < numberOfTests; t++) {
				s = in.nextLine();
				String nestingDepth = "";
				Stack closeParams = new Stack();
				for (int i = 0; i < s.length(); i++) {
					int n = Character.digit(s.charAt(i), 10);
					int openParanthesisCount = 0;
					for (int j = 0; j < nestingDepth.length(); j++) {
						if ("(".equals(nestingDepth.charAt(j) + "")) {
							openParanthesisCount++;
						} else if (")".equals(nestingDepth.charAt(j) + "")) {
							openParanthesisCount--;
						}
					}
					if (openParanthesisCount < n) {
						for (int k = 0; k < n - openParanthesisCount; k++) {
							nestingDepth += "(";
							closeParams.push(")");
						}
					} else if (openParanthesisCount > n) {
						for (int k = 0; k < openParanthesisCount - n; k++) {
							nestingDepth += closeParams.pop();
						}
					}
					nestingDepth += n;
				}
				while (!closeParams.isEmpty()) {
					nestingDepth += closeParams.pop();
				}
				nestingDepths[t] = nestingDepth;
			}
			for (int i = 0; i < numberOfTests; i++) {
				System.out.println("Case #" + (i + 1) + ": " + nestingDepths[i]);
			}
		}
	}
}
