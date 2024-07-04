import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        StringBuilder result = new StringBuilder();

        for (int t = 1; t <= testCases; t++) {
            result.append("Case #").append(t).append(": ");
            int N = Integer.parseInt(reader.readLine());
            String prefix = "";
            String suffix = "";
            String[] prefixes = new String[N];
            String[] suffixes = new String[N];
            StringBuilder middle = new StringBuilder();

            for (int i = 0; i < N; i++) {
                String pattern = reader.readLine();
                int firstAsterisk = pattern.indexOf('*');
                int lastAsterisk = pattern.lastIndexOf('*');

                if (firstAsterisk > prefix.length())
                    prefix = pattern.substring(0, firstAsterisk);
                if (pattern.length() - lastAsterisk - 1 > suffix.length())
                    suffix = pattern.substring(lastAsterisk + 1);

                prefixes[i] = pattern.substring(0, firstAsterisk);
                suffixes[i] = pattern.substring(lastAsterisk + 1);
                if (firstAsterisk + 1 < lastAsterisk)
                    middle.append(pattern, firstAsterisk + 1, lastAsterisk);
            }

            boolean isValid = true;
            for (String s : suffixes) {
                if (!suffix.endsWith(s)) {
                    isValid = false;
                    break;
                }
            }
            for (String p : prefixes) {
                if (!prefix.startsWith(p)) {
                    isValid = false;
                    break;
                }
            }

            if (prefix.length() + suffix.length() + middle.length() > 10000) {
                throw new Exception("Pattern too long");
            }

            result.append(isValid ? prefix + middle + suffix : "*").append("\n");
        }

        System.out.print(result);
    }
}