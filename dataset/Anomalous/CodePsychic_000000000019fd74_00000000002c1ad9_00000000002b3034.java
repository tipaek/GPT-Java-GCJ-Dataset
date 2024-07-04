import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Read the number of test cases
        for (int x = 1; x <= t; ++x) {
            int p = in.nextInt(); // Read the number of patterns for this test case
            List<String> patterns = new ArrayList<>();
            for (int y = 0; y < p; y++) {
                patterns.add(in.next());
            }
            solve(x, patterns);
        }
    }

    public static void solve(int caseNumber, List<String> patterns) {
        StringBuilder start = new StringBuilder();
        StringBuilder end = new StringBuilder();
        boolean possible = true;

        for (String pattern : patterns) {
            String[] parts = pattern.split("\\*", 2);
            String prefix = parts.length > 0 ? parts[0] : "";
            String suffix = parts.length > 1 ? parts[1] : "";

            if (start.length() == 0) {
                start.append(prefix);
            } else if (prefix.length() >= start.length()) {
                if (prefix.startsWith(start.toString())) {
                    start.setLength(0);
                    start.append(prefix);
                } else {
                    possible = false;
                    break;
                }
            } else if (!start.toString().startsWith(prefix)) {
                possible = false;
                break;
            }

            if (end.length() == 0) {
                end.append(suffix);
            } else if (suffix.length() >= end.length()) {
                if (suffix.endsWith(end.toString())) {
                    end.setLength(0);
                    end.append(suffix);
                } else {
                    possible = false;
                    break;
                }
            } else if (!end.toString().endsWith(suffix)) {
                possible = false;
                break;
            }
        }

        System.out.println("Case #" + caseNumber + ": " + (possible ? start.toString() + end.toString() : "*"));
    }
}