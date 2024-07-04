import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int n = sc.nextInt();
            StringBuilder front = new StringBuilder();
            StringBuilder back = new StringBuilder();
            boolean isValid = true;

            for (int i = 0; i < n; i++) {
                String curr = sc.next();
                String[] parts = curr.split("\\*");

                // Handle case where the string ends with '*'
                if (curr.endsWith("*")) {
                    parts = Arrays.copyOf(parts, parts.length + 1);
                    parts[parts.length - 1] = "";
                }

                // Process the front part
                if (front.length() < parts[0].length()) {
                    if (front.toString().equals(parts[0].substring(0, front.length()))) {
                        front = new StringBuilder(parts[0]);
                    } else {
                        isValid = false;
                    }
                } else {
                    if (!front.toString().startsWith(parts[0])) {
                        isValid = false;
                    }
                }

                // Process the back part
                String lastPart = parts[parts.length - 1];
                if (back.length() < lastPart.length()) {
                    if (back.toString().equals(lastPart.substring(lastPart.length() - back.length()))) {
                        back = new StringBuilder(lastPart);
                    } else {
                        isValid = false;
                    }
                } else {
                    if (!back.toString().endsWith(lastPart)) {
                        isValid = false;
                    }
                }
            }

            if (isValid) {
                System.out.println("Case #" + t + ": " + combine(front.toString(), back.toString()));
            } else {
                System.out.println("Case #" + t + ": *");
            }
        }
        sc.close();
    }

    public static String combine(String s1, String s2) {
        String result = s1 + s2;
        for (int i = 0; i <= Math.min(s1.length(), s2.length()); i++) {
            if (s1.endsWith(s2.substring(0, i))) {
                result = s1.substring(0, s1.length() - i) + s2;
            }
        }
        return result.length() > 10000 ? "*" : result;
    }
}