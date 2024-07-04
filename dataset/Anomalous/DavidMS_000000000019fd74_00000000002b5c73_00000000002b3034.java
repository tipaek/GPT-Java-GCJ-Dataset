import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String findMatchingString(String curr, String newS, boolean isPrefix) {
        if (curr.isEmpty()) return newS;
        if (newS.isEmpty()) return curr;
        if (isPrefix) {
            if (curr.startsWith(newS)) return curr;
            if (newS.startsWith(curr)) return newS;
        } else {
            if (curr.endsWith(newS)) return curr;
            if (newS.endsWith(curr)) return newS;
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = Integer.parseInt(reader.readLine());
            String prefix = "", suffix = "";
            boolean isPossible = true;

            for (int i = 0; i < n; i++) {
                String[] parts = reader.readLine().split("\\*");
                if (isPossible) {
                    prefix = findMatchingString(prefix, parts.length > 0 ? parts[0] : "", true);
                    suffix = findMatchingString(suffix, parts.length > 1 ? parts[1] : "", false);
                    if (prefix == null || suffix == null) {
                        isPossible = false;
                    }
                }
            }

            String result = prefix + suffix;
            if (!isPossible) {
                System.out.println("Case #" + caseNum + ": *");
            } else if (result.isEmpty()) {
                System.out.println("Case #" + caseNum + ": A");
            } else {
                System.out.println("Case #" + caseNum + ": " + result);
            }
        }
    }
}