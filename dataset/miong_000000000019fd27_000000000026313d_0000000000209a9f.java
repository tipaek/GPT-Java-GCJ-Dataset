import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        String[] res = new String[t];

        for (int ti = 0; ti < t; ti++) {
            String s = sc.next();
            boolean isNesting = false;

            res[ti] = "";
            for (int i = 0; i < s.length(); i++) {
                if (!isNesting) {
                    if (s.charAt(i) == '1') {
                        res[ti] += "(1";
                        if (i == (s.length() - 1)) res[ti] += ")";
                        isNesting = true;
                    } else {
                        res[ti] += s.charAt(i);
                    }
                } else {
                    if (s.charAt(i) == '0') {
                        res[ti] += ")0";
                        isNesting = false;
                    } else {
                        res[ti] += s.charAt(i);
                    }
                }
            }
        }

        for (int i = 0; i < t; i++) {
            System.out.println("Case #" + (i + 1) + ": " + res[i]);
        }
    }
}
