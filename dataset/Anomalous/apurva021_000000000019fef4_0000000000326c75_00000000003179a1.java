import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int testCaseCount = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            int u = Integer.parseInt(br.readLine());
            int[] letterValues = new int[26];
            Arrays.fill(letterValues, 10000);
            boolean[] visited = new boolean[26];

            for (int i = 0; i < 10000; i++) {
                String[] input = br.readLine().split(" ");
                char[] letters = input[1].toCharArray();
                char[] digits = input[0].toCharArray();

                if (digits[0] == '-') continue;

                if (letters.length == digits.length) {
                    letterValues[letters[0] - 'A'] = Math.min(letterValues[letters[0] - 'A'], digits[0] - '0');
                }

                for (char letter : letters) {
                    letterValues[letter - 'A'] = Math.min(letterValues[letter - 'A'], 9);
                }
            }

            StringBuilder answer = new StringBuilder();

            for (int i = 0; i < 10; i++) {
                int closestIndex = 26;
                int minValueDifference = 26;

                for (int j = 0; j < 26; j++) {
                    if (!visited[j]) {
                        int valueDifference = Math.abs(i - letterValues[j]);
                        if (valueDifference < minValueDifference) {
                            minValueDifference = valueDifference;
                            closestIndex = j;
                        }
                    }
                }

                visited[closestIndex] = true;
                answer.append((char) ('A' + closestIndex));
            }

            pw.println("Case #" + testCase + ": " + answer);
        }

        pw.flush();
        pw.close();
    }
}