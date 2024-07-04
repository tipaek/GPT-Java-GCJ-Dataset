import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class Solution {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
                Writer writer = new BufferedWriter(
                        new OutputStreamWriter(System.out))) {
            solve(reader, writer);
        }
    }

    private static void solve(BufferedReader reader, Writer writer)
            throws Exception {
        int testCount = Integer.parseInt(reader.readLine());
        for (int i = 0; i < testCount; i++) {
            solveTestCase(i, reader, writer);
        }
    }

	private static void solveTestCase(int t, BufferedReader reader,
			Writer writer) throws Exception {
		String inputString = reader.readLine();
		String eachDigitWithParenthesis = addParenthesisToEachDigit(inputString);
		String optimalString = optimalString(eachDigitWithParenthesis);
		writer.write(String.format("Case #%d: %s\n", t + 1, optimalString));
		writer.flush();
	}

	private static String addParenthesisToEachDigit(String inputString) {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < inputString.length(); i++) {
			int digit = Character.digit(inputString.charAt(i), 10);
			for (int j = 0; j < digit; j++) {
				buffer.append("(");
			}
			buffer.append(digit);
			for (int j = 0; j < digit; j++) {
				buffer.append(")");
			}
		}
		return buffer.toString();
	}

	private static String optimalString(String eachDigitWithParenthesis) {
		StringBuffer buffer = new StringBuffer(eachDigitWithParenthesis);
		int idx;
		while ((idx = buffer.indexOf(")(")) >= 0) {
			buffer.replace(idx, idx + 2, "");
		}
		return buffer.toString();
	}
}
