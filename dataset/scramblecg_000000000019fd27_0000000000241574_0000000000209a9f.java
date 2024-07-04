//package qround.b;

import java.util.*;

import java.io.*;

public class Solution {

	static char OPEN_CH = '(';
	static char CLOSE_CH = ')';

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = Integer.parseInt(in.nextLine());
		for (int i = 0; i < t; ++i) {
			String inputText = in.nextLine();
//			System.out.println("###############################");
//			System.out.println(inputText);
			StringBuffer masterBuffer = new StringBuffer();
			try {
				for (int index = 0; index < inputText.length();) {
					inputText = inputText.substring(index);
					index = processSubSequence(inputText, masterBuffer);
					if (index == -1)
						break;
					index++;

				}
			} catch (Exception ex) {
				System.err.println(ex.getMessage());
			}

			System.out.println("Case #" + (i+1) + ": " + masterBuffer);

		}
	}

	private static int processSubSequence(String inputText, StringBuffer masterBuffer) {
		int processedIndex = -1;
		StringBuffer subSequence = new StringBuffer();

		boolean ascFlag = false;
		boolean printOrderFlag = false;
		boolean orderChange = false;
		int diff = 0;

		if (inputText.length() == 1) {
			print(inputText, ascFlag, masterBuffer);
			return -1;
		}

		// find initial order
		for (int charIndex = 0; charIndex < inputText.length() - 1; charIndex++) {
			int currentDigit = Integer.valueOf(String.valueOf(inputText.charAt(charIndex)));
			int nextDigit = Integer.valueOf(String.valueOf(inputText.charAt(charIndex + 1)));
			if (nextDigit == currentDigit) {
				subSequence.append(currentDigit);
				if (isIndexEndOfString(inputText, charIndex)) {
					subSequence.append(nextDigit);
				}
				continue;
			}
			ascFlag = nextDigit > currentDigit;
			printOrderFlag = ascFlag;
			break;
		}

		// break subsequences
		if (subSequence.length() != inputText.length()) {
			int subSeqIndex = subSequence.length() > 0 ? subSequence.length() : 0;
			for (int charIndex = subSeqIndex; charIndex < inputText.length() - 1; charIndex++) {
				int currentDigit = Integer.valueOf(String.valueOf(inputText.charAt(charIndex)));
				int nextDigit = Integer.valueOf(String.valueOf(inputText.charAt(charIndex + 1)));
				// ascFlag = !orderChange ? ascFlag : !ascFlag;
				if (nextDigit == currentDigit) {
					subSequence.append(currentDigit);
				} else {
					if (ascFlag) {
						if (nextDigit > currentDigit) {
							subSequence.append(currentDigit);
						} else {
							orderChange = true;
							ascFlag = false;
						}
					} else {
						if (nextDigit > currentDigit) {
							orderChange = true;
							ascFlag = true;
						} else {
							subSequence.append(currentDigit);
						}
					}
				}
				if (orderChange) {
					subSequence.append(currentDigit);
					print(subSequence.toString(), printOrderFlag, masterBuffer);
					subSequence = new StringBuffer();
					orderChange = false;
					processedIndex = charIndex;
					break;
				}
				if (isIndexEndOfString(inputText, charIndex)) {
					subSequence.append(nextDigit);
					// System.out.println(subSequence);
					print(subSequence.toString(), printOrderFlag, masterBuffer);
				}

			}
		} else {
			// System.out.println(subSequence);
			print(subSequence.toString(), printOrderFlag, masterBuffer);
		}
		return processedIndex;
	}

	private static void print(String subSeq, boolean ascMode, StringBuffer masterBuffer) {
		String copSeq = ascMode ? new StringBuffer(subSeq).reverse().toString() : subSeq;
		Stack<Character> chStack = new Stack<Character>();
		StringBuffer finalString = new StringBuffer();
		int diff = 0;
		int max = Integer.valueOf(String.valueOf(copSeq.charAt(0)));
		char co = ascMode ? CLOSE_CH : OPEN_CH;
		char cc = ascMode ? OPEN_CH : CLOSE_CH;
		for (int i = 0; i < max; i++) {
			finalString.append(co);
			chStack.push(cc);
		}
		finalString.append(max);

		for (int charIndex = 1; charIndex < copSeq.length(); charIndex++) {
			int currentDigit = Integer.valueOf(String.valueOf(copSeq.charAt(charIndex)));
			diff = max - currentDigit;
			for (int i = 0; i < diff; i++) {
				finalString.append(chStack.pop());
			}
			finalString.append(currentDigit);
			max = currentDigit;
		}
		while (!chStack.isEmpty()) {
			finalString.append(chStack.pop());
		}

		if (ascMode) {
			masterBuffer.append(finalString.reverse());
		} else {
			masterBuffer.append(finalString);
		}

	}

	private static boolean isIndexEndOfString(String inputText, int charIndex) {
		return (charIndex + 1) == inputText.length() - 1;
	}
}