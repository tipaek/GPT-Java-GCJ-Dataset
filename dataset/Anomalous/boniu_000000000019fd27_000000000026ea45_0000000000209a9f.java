import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int T = scanner.nextInt();
            for (int t = 1; t <= T; t++) {
                String s = scanner.next();
                StringBuilder r = new StringBuilder();
                int open = 0;

                for (int i = 0; i < s.length(); i++) {
                    char currentChar = s.charAt(i);
                    if (currentChar == '1') {
                        if (open == 0) {
                            r.append("(1");
                            open = 1;
                        } else {
                            r.append("1");
                        }
                    } else { // currentChar is '0'
                        if (open == 0) {
                            r.append("0");
                        } else {
                            r.append(")0");
                            open = 0;
                        }
                    }
                }
                if (open == 1) {
                    r.append(")");
                }

                System.out.println(String.format("Case #%d: %s", t, r.toString()));
            }
        }
    }
}