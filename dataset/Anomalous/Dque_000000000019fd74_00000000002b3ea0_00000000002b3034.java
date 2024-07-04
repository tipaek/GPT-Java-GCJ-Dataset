import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringJoiner;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            int n = Integer.parseInt(reader.readLine());
            String[] patterns = new String[n];

            for (int i = 0; i < n; i++) {
                patterns[i] = reader.readLine();
            }

            String start = "";
            StringJoiner middle = new StringJoiner("");
            String end = "";
            boolean isFailed = false;

            for (String pattern : patterns) {
                int firstAsterisk = pattern.indexOf('*');
                int lastAsterisk = pattern.lastIndexOf('*');

                if (firstAsterisk > 0) {
                    String startSub = pattern.substring(0, firstAsterisk);
                    if (isMatchingStart(startSub, start)) {
                        start = merge(startSub, start);
                    } else {
                        isFailed = true;
                        break;
                    }
                }

                if (lastAsterisk < pattern.length() - 1) {
                    String endSub = pattern.substring(lastAsterisk + 1);
                    if (isMatchingEnd(endSub, end)) {
                        end = merge(endSub, end);
                    } else {
                        isFailed = true;
                        break;
                    }
                }

                for (int j = firstAsterisk + 1; j < lastAsterisk; j++) {
                    if (pattern.charAt(j) != '*') {
                        middle.add(String.valueOf(pattern.charAt(j)));
                    }
                }
            }

            if (isFailed) {
                writer.println("Case #" + t + ": *");
            } else {
                writer.println("Case #" + t + ": " + start + middle.toString() + end);
            }
        }

        writer.close();
    }

    private static boolean isMatchingStart(String a, String b) {
        for (int i = 0; i < Math.min(a.length(), b.length()); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isMatchingEnd(String a, String b) {
        int minLength = Math.min(a.length(), b.length());
        for (int i = 0; i < minLength; i++) {
            if (a.charAt(a.length() - 1 - i) != b.charAt(b.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    private static String merge(String a, String b) {
        return a.length() >= b.length() ? a : b;
    }
}