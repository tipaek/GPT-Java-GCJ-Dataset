import java.util.Scanner;

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

                if (curr.endsWith("*")) {
                    parts = Arrays.copyOf(parts, parts.length + 1);
                    parts[parts.length - 1] = "";
                }

                if (!updateFront(front, parts[0])) {
                    isValid = false;
                }

                if (!updateBack(back, parts[parts.length - 1])) {
                    isValid = false;
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

    private static boolean updateFront(StringBuilder front, String newFront) {
        if (front.length() < newFront.length()) {
            if (front.toString().equals(newFront.substring(0, front.length()))) {
                front.setLength(0);
                front.append(newFront);
            } else {
                return false;
            }
        } else if (!front.toString().startsWith(newFront)) {
            return false;
        }
        return true;
    }

    private static boolean updateBack(StringBuilder back, String newBack) {
        if (back.length() < newBack.length()) {
            if (back.toString().equals(newBack.substring(newBack.length() - back.length()))) {
                back.setLength(0);
                back.append(newBack);
            } else {
                return false;
            }
        } else if (!back.toString().endsWith(newBack)) {
            return false;
        }
        return true;
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