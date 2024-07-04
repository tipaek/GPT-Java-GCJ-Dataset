import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    private static final int MAX = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            int n = Integer.parseInt(reader.readLine());
            int[] ans = new int[10];
            Arrays.fill(ans, Integer.MAX_VALUE);

            for (int i = 0; i < MAX; i++) {
                String[] input = reader.readLine().split(" ");
                String val = input[0];
                String s = input[1];

                if (val.length() == 1 && Integer.parseInt(val) != -1) {
                    int index = Integer.parseInt(val);
                    int mapping = s.charAt(0) - 'A';
                    ans[index] = Math.min(ans[index], mapping);
                }
            }

            boolean[] visited = new boolean[26];
            for (int i = 0; i < 10; i++) {
                int index = ans[i];
                if (index != Integer.MAX_VALUE) {
                    visited[index] = true;
                }
            }

            int j = 0;
            while (j < 26 && visited[j]) {
                j++;
            }

            for (int i = 0; i < 10; i++) {
                if (ans[i] == Integer.MAX_VALUE) {
                    ans[i] = j;
                    visited[j] = true;
                    while (j < 26 && visited[j]) {
                        j++;
                    }
                }
            }

            StringBuilder result = new StringBuilder();
            for (int i = 0; i < 10; i++) {
                char c = (char) (ans[i] + 'A');
                result.append(c);
            }

            System.out.println("Case #" + t + ": " + result);
        }
    }
}