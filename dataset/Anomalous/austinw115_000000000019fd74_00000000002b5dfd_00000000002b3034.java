import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("A.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("A.out"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            String[] patterns = new String[N];
            String longestPattern = "*";

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                String pattern = st.nextToken();
                if (pattern.length() > longestPattern.length()) {
                    longestPattern = pattern;
                }
                patterns[j] = pattern;
            }

            String result = longestPattern.substring(1);
            for (String pattern : patterns) {
                String trimmedPattern = pattern.length() > 1 ? pattern.substring(1) : pattern;

                if (!longestPattern.contains(trimmedPattern)) {
                    result = "*";
                    break;
                }
            }

            pw.println("Case #" + i + ": " + result);
        }
        pw.close();
    }
}