import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    private static final int MAX = 10;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        for (int caseIndex = 1; caseIndex <= testCases; caseIndex++) {
            int n = Integer.parseInt(br.readLine());
            int[] answers = new int[MAX];
            Arrays.fill(answers, Integer.MAX_VALUE);

            for (int i = 0; i < n; i++) {
                String[] input = br.readLine().split(" ");
                String value = input[0];
                String s = input[1];

                if (value.length() == 1 && Integer.parseInt(value) != -1) {
                    int index = Integer.parseInt(value);
                    int mapping = s.charAt(0) - 'A';
                    answers[index] = Math.min(answers[index], mapping);
                }
            }

            boolean[] visited = new boolean[26];
            for (int i = 0; i < MAX; i++) {
                int index = answers[i];
                if (index != Integer.MAX_VALUE) {
                    visited[index] = true;
                }
            }

            int j = 0;
            while (j < visited.length && visited[j]) {
                j++;
            }

            for (int i = 0; i < MAX; i++) {
                if (answers[i] == Integer.MAX_VALUE) {
                    answers[i] = j;
                    visited[j] = true;
                    while (j < visited.length && visited[j]) {
                        j++;
                    }
                }
            }

            StringBuilder result = new StringBuilder();
            for (int i = 0; i < MAX; i++) {
                result.append((char) (answers[i] + 'A'));
            }

            System.out.println("Case #" + caseIndex + ": " + result);
        }
    }
}