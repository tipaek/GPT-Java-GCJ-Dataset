import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        StringBuilder result = new StringBuilder();

        for (int t = 1; t <= T; t++) {
            result.append("Case #").append(t).append(": ");
            int N = Integer.parseInt(in.readLine());
            String prefix = "", suffix = "";
            String[] prefixes = new String[N];
            String[] suffixes = new String[N];
            StringBuilder middle = new StringBuilder();

            for (int i = 0; i < N; i++) {
                String input = in.readLine();
                int firstAsterisk = input.indexOf('*');
                int lastAsterisk = input.lastIndexOf('*');

                if (firstAsterisk > prefix.length()) {
                    prefix = input.substring(0, firstAsterisk);
                }
                if (input.length() - lastAsterisk - 1 > suffix.length()) {
                    suffix = input.substring(lastAsterisk + 1);
                }

                prefixes[i] = input.substring(0, firstAsterisk);
                suffixes[i] = input.substring(lastAsterisk + 1);

                if (firstAsterisk + 1 < lastAsterisk) {
                    middle.append(input.substring(firstAsterisk + 1, lastAsterisk).replace("*", ""));
                }
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

            if (isValid) {
                result.append(prefix).append(middle).append(suffix);
            } else {
                result.append("*");
            }
            result.append("\n");
        }

        System.out.print(result.toString());
    }
}