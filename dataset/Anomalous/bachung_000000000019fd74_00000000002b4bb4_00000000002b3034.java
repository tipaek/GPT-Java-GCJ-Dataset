import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());

        for (int i = 0; i < T; i++) {
            processCase(reader, i + 1);
        }
    }

    static void processCase(BufferedReader reader, int caseNum) throws Exception {
        int N = Integer.parseInt(reader.readLine());
        String[] patterns = new String[N];

        for (int i = 0; i < N; i++) {
            patterns[i] = reader.readLine();
        }

        String startsWith = "";
        String endsWith = "";
        List<String> contains = new ArrayList<>();
        boolean isPossible = true;

        for (String pattern : patterns) {
            int firstAsterisk = pattern.indexOf('*');
            int lastAsterisk = pattern.lastIndexOf('*');

            if (firstAsterisk != -1) {
                String prefix = pattern.substring(0, firstAsterisk);
                if (prefix.length() >= startsWith.length()) {
                    if (prefix.startsWith(startsWith)) {
                        startsWith = prefix;
                    } else {
                        isPossible = false;
                        break;
                    }
                } else if (!startsWith.startsWith(prefix)) {
                    isPossible = false;
                    break;
                }
            }

            if (lastAsterisk != -1) {
                String suffix = pattern.substring(lastAsterisk + 1);
                if (suffix.length() >= endsWith.length()) {
                    if (suffix.endsWith(endsWith)) {
                        endsWith = suffix;
                    } else {
                        isPossible = false;
                        break;
                    }
                } else if (!endsWith.endsWith(suffix)) {
                    isPossible = false;
                    break;
                }
            }

            if (firstAsterisk != lastAsterisk) {
                contains.add(extractSubstring(pattern, firstAsterisk + 1, lastAsterisk));
            }
        }

        StringBuilder result = new StringBuilder();
        result.append(startsWith);
        for (String part : contains) {
            result.append(part);
        }
        result.append(endsWith);

        System.out.printf("Case #%d: %s%n", caseNum, isPossible ? result.toString() : "*");
    }

    static String extractSubstring(String input, int start, int end) {
        StringBuilder builder = new StringBuilder();
        for (int i = start; i < end; i++) {
            if (input.charAt(i) != '*') {
                builder.append(input.charAt(i));
            }
        }
        return builder.toString();
    }
}