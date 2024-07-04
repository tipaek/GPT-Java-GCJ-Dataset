import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int T = scanner.nextInt();
        int caseNumber = 0;
        while (caseNumber++ < T) {
            final int N = scanner.nextInt();

            String[] patterns = new String[N];
            for (int i = 0; i < N; i++) {
                patterns[i] = scanner.next();
            }
            int idx = 0;
            StringBuilder sb = new StringBuilder();
            while (true) {
                boolean allMatch = true;
                Character ch = null;
                for (int i = 0; i < N; i++) {
                    int currIdx = patterns[i].length() - idx - 1;
                    if (currIdx >= 1) {
                        if (ch == null) {
                            ch = patterns[i].charAt(currIdx);
                        } else {
                            if (!ch.equals(patterns[i].charAt(currIdx))) {
                                allMatch = false;
                            }
                        }
                    }
                }
                if (!allMatch) {
                    sb = new StringBuilder("*");
                    break;
                } else {
                    if (ch != null) {
                        sb.insert(0, ch);
                    }
                }
                ++idx;
                if (ch == null) break;
            }

            System.out.println(
                    String.format(
                            "Case #%d: %s", caseNumber, sb.toString()
                    )
            );
        }
    }
}
