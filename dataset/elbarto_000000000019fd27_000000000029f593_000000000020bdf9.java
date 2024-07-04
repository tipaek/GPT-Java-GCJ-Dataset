import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long cases = scanner.nextLong();

        for (long index = 1; index <= cases; index++) {
            boolean[] cameron = new boolean[24 * 60 + 1];
            boolean[] jamie = new boolean[24 * 60 + 1];
            int activities = scanner.nextInt();

            boolean isPossible = true;
            StringBuilder sb = new StringBuilder();

            for (int a = 0; a < activities; a++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                // has do cameron
                boolean hasDoCameron = true;
                for (int i = start; i < end; i++) {
                    if (cameron[i]) {
                        hasDoCameron = false;
                        break;
                    }
                }

                if (hasDoCameron) {
                    sb.append("C");
                    for (int i = start; i < end; i++) {
                        cameron[i] = true;
                    }
                }

                boolean hasDoJamie = false;
                if (!hasDoCameron) {
                    hasDoJamie = true;
                    // has do Jamie
                    for (int i = start; i < end; i++) {
                        if (jamie[i]) {
                            hasDoJamie = false;
                            break;
                        }
                    }
                    for (int i = start; i < end; i++) {
                        jamie[i] = true;
                    }
                    if (hasDoJamie) {
                        sb.append("J");
                    }
                }

                if (!hasDoCameron && !hasDoJamie) {
                    isPossible = false;
                }
            }
            if (isPossible) {
                System.out.println(String.format("Case #%d: %s", index, sb.toString()));
            } else {
                System.out.println(String.format("Case #%d: IMPOSSIBLE", index));
            }
        }
    }
}