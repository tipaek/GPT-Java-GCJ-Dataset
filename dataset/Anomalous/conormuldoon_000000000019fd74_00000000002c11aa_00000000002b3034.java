import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solveCases();
        solution.close();
    }

    private void solveCases() {
        int t = readInt();
        for (int i = 1; i <= t; i++) {
            pw.println("Case #" + i + ": " + solve());
        }
    }

    private String solve() {
        int n = readInt();
        Set<String> patterns = new HashSet<>();
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            String pattern = readLine();
            maxLength = Math.max(maxLength, pattern.length());
            patterns.add(pattern);
        }

        String prefix = "", suffix = "";
        for (String pattern : patterns) {
            int length = pattern.length();
            for (int i = 0; i < length; i++) {
                if (pattern.charAt(i) == '*') {
                    if (i > prefix.length()) {
                        prefix = pattern.substring(0, i);
                    }
                    break;
                }
            }
            for (int i = length - 1; i >= 0; i--) {
                if (pattern.charAt(i) == '*') {
                    if (length - (i + 1) > suffix.length()) {
                        suffix = pattern.substring(i + 1);
                    }
                    break;
                }
            }
        }

        int prefixLength = prefix.length();
        int suffixLength = suffix.length();
        Set<String> newPatterns = new HashSet<>();

        if (!prefix.isEmpty()) {
            for (String pattern : patterns) {
                if (pattern.startsWith(prefix)) {
                    newPatterns.add(pattern.substring(prefixLength));
                } else {
                    for (int i = 0; i < pattern.length(); i++) {
                        if (pattern.charAt(i) == '*') {
                            newPatterns.add(pattern.substring(i));
                            break;
                        } else if (pattern.charAt(i) != prefix.charAt(i)) {
                            return "*";
                        }
                    }
                }
            }
            patterns = newPatterns;
            newPatterns = new HashSet<>();
        }

        if (!suffix.isEmpty()) {
            for (String pattern : patterns) {
                if (pattern.endsWith(suffix)) {
                    newPatterns.add(pattern.substring(0, pattern.length() - suffixLength));
                } else {
                    int patternLength = pattern.length();
                    for (int i = suffixLength - 1; i >= 0; i--) {
                        if (pattern.charAt(patternLength - (suffixLength - i)) == '*') {
                            newPatterns.add(pattern.substring(0, patternLength - (suffixLength - i) + 1));
                            break;
                        } else if (pattern.charAt(patternLength - (suffixLength - i)) != suffix.charAt(i)) {
                            return "*";
                        }
                    }
                }
            }
            patterns = newPatterns;
        }

        StringBuilder result = new StringBuilder(prefix);
        for (String pattern : patterns) {
            result.append(pattern.replace("*", ""));
        }
        result.append(suffix);

        return result.toString();
    }

    private void close() {
        pw.close();
    }

    private String readLine() {
        try {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private int readInt() {
        return Integer.parseInt(readLine());
    }

    private String[] stringArray() {
        StringTokenizer st = new StringTokenizer(readLine());
        int n = st.countTokens();
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[i] = st.nextToken();
        }
        return result;
    }

    private int[] readIntArr() {
        String[] str = stringArray();
        int[] arr = new int[str.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        return arr;
    }

    private double[] readDoubleArr() {
        String[] str = stringArray();
        double[] arr = new double[str.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Double.parseDouble(str[i]);
        }
        return arr;
    }

    private long[] readLongArr() {
        String[] str = stringArray();
        long[] arr = new long[str.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Long.parseLong(str[i]);
        }
        return arr;
    }

    private double readDouble() {
        return Double.parseDouble(readLine());
    }
}