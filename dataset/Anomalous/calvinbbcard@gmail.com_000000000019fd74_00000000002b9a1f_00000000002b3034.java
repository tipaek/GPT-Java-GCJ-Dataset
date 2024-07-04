import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int q = reader.nextInt();
        int caseNumber = 1;

        while (caseNumber <= q) {
            int n = reader.nextInt();
            String[] patterns = new String[n];
            for (int i = 0; i < n; i++) {
                patterns[i] = reader.next();
            }

            String suffix = "";
            String prefix = "";
            boolean possible = true;
            boolean[] considered = new boolean[n];

            for (int i = 0; i < n; i++) {
                int starCount = 0;
                for (int j = 0; j < patterns[i].length(); j++) {
                    if (patterns[i].charAt(j) == '*') {
                        starCount++;
                    }
                }

                if (starCount == 1) {
                    String[] parts = patterns[i].split("\\*");
                    String end = parts.length == 1 ? "" : parts[1];
                    String start = parts[0];
                    considered[i] = true;

                    if (end.length() > suffix.length() && end.contains(suffix)) {
                        suffix = end;
                    } else if (!suffix.contains(end)) {
                        possible = false;
                    }

                    if (start.length() > prefix.length() && start.contains(prefix)) {
                        prefix = start;
                    } else if (!prefix.contains(start)) {
                        possible = false;
                    }
                }
            }

            if (!possible) {
                System.out.printf("Case #%d: *\n", caseNumber);
                caseNumber++;
                continue;
            }

            boolean allConsidered = true;
            for (boolean consider : considered) {
                if (!consider) {
                    allConsidered = false;
                    break;
                }
            }

            if (allConsidered) {
                System.out.printf("Case #%d: %s\n", caseNumber, prefix + suffix);
            }

            caseNumber++;
        }

        reader.close();
    }
}