import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int T = scanner.nextInt();
            scanner.nextLine();

            for (int t = 1; t <= T; t++) {
                String s = scanner.nextLine();
                StringBuilder sDash = new StringBuilder();
                int depth = 0;

                for (char c : s.toCharArray()) {
                    int digit = Character.getNumericValue(c);

                    while (depth < digit) {
                        sDash.append('(');
                        depth++;
                    }

                    while (depth > digit) {
                        sDash.append(')');
                        depth--;
                    }

                    sDash.append(c);
                }

                while (depth > 0) {
                    sDash.append(')');
                    depth--;
                }

                System.out.println("Case #" + t + ": " + sDash.toString());
            }
        }
    }
}