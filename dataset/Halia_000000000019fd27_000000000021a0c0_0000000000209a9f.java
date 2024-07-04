import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    private static final String RESULT_PATTERN = "Case #%d: %s";

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int testCasesNumber = Integer.parseInt(tokenizer.nextToken());
            for (int t = 1; t <= testCasesNumber; ++t) {
                String origin = reader.readLine();
                solve(t, origin);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void solve(int testCaseId, String origin) {
        String result = "";
        int balance = 0;

        for (char currentChar : origin.toCharArray()) {
            int currentInt = currentChar - '0';
            while (balance < currentInt) {
                result += '(';
                ++balance;
            }
            while (balance > currentInt) {
                result += ')';
                --balance;
            }
            result += currentChar;
        }

        while (balance < 0) {
            result += '(';
            ++balance;
        }
        while (balance > 0) {
            result += ')';
            --balance;
        }

        System.out.println(String.format(RESULT_PATTERN, testCaseId, result));
    }
}
