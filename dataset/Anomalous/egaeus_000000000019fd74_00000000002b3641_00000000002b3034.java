import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        StringBuilder result = new StringBuilder();

        for (int t = 1; t <= testCases; t++) {
            result.append("Case #").append(t).append(": ");
            int N = Integer.parseInt(reader.readLine());
            String longestSuffix = "";
            String[] suffixes = new String[N];

            for (int i = 0; i < N; i++) {
                String input = reader.readLine();
                String suffix = input.substring(1);
                if (suffix.length() > longestSuffix.length()) {
                    longestSuffix = suffix;
                }
                suffixes[i] = suffix;
            }

            boolean isValid = true;
            for (String suffix : suffixes) {
                if (!longestSuffix.endsWith(suffix)) {
                    isValid = false;
                    break;
                }
            }

            result.append(isValid ? longestSuffix : "*").append("\n");
        }

        System.out.print(result.toString());
    }
}