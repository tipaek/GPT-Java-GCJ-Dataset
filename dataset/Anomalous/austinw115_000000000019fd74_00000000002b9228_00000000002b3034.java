import java.io.*;
import java.util.*;

public class SolutionA {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 32768);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(br.readLine().trim());

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine().trim());
            String[] patterns = new String[N];
            String longestPattern = "";

            for (int j = 0; j < N; j++) {
                patterns[j] = br.readLine().trim();
                if (patterns[j].length() > longestPattern.length()) {
                    longestPattern = patterns[j];
                }
            }

            String result = longestPattern;

            for (String pattern : patterns) {
                if (!pattern.equals(longestPattern)) {
                    String subPattern = pattern.length() > 1 ? pattern.substring(1) : pattern;
                    if (!longestPattern.contains(subPattern)) {
                        result = "*";
                        break;
                    }
                }
            }

            pw.println("Case #" + i + ": " + result);
        }
        pw.close();
    }
}