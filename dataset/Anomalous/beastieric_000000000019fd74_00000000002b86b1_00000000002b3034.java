import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int n = sc.nextInt();
            StringBuilder front = new StringBuilder(), middle = new StringBuilder(), back = new StringBuilder();
            boolean isValid = true;
            for (int i = 0; i < n; i++) {
                String curr = sc.next();
                String[] parts = curr.split("\\*");
                
                if (curr.charAt(curr.length() - 1) == '*') {
                    parts = Arrays.copyOf(parts, parts.length + 1);
                    parts[parts.length - 1] = "";
                }

                if (curr.charAt(0) != '*') {
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
                }

                if (curr.charAt(curr.length() - 1) != '*') {
                    if (back.length() < parts[parts.length - 1].length()) {
                        if (back.toString().endsWith(parts[parts.length - 1])) {
                            back = new StringBuilder(parts[parts.length - 1]);
                        } else {
                            isValid = false;
                        }
                    } else {
                        if (!back.toString().endsWith(parts[parts.length - 1])) {
                            isValid = false;
                        }
                    }
                }

                for (int j = 1; j < parts.length - 1; j++) {
                    middle.append(parts[j]);
                }
            }

            if (isValid) {
                System.out.println("Case #" + t + ": " + front.toString() + middle.toString() + back.toString());
            } else {
                System.out.println("Case #" + t + ": *");
            }
        }
        sc.close();
    }
}