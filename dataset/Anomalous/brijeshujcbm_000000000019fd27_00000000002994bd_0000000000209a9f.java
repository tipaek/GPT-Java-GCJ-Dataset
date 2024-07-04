import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        for (int m = 1; m <= t; m++) {
            String str = sc.nextLine();
            StringBuilder req = new StringBuilder();
            int co = 0;

            for (int k = 0; k < str.length(); k++) {
                char ch = str.charAt(k);
                int asc = ch - '0';

                // Add opening parenthesis
                for (int i = 0; i < asc; i++) {
                    co++;
                    req.append('(');
                }

                req.append(ch);

                int i = k + 1;
                while (i < str.length() && str.charAt(i) == ch) {
                    req.append(str.charAt(i));
                    i++;
                }

                while (i < str.length() && str.charAt(i) <= ch) {
                    asc = str.charAt(i) - '0' - co;
                    if (asc >= 0) {
                        while (asc-- > 0) {
                            req.append('(');
                            co++;
                        }
                    } else {
                        asc = str.charAt(i - 1) - str.charAt(i);
                        while (asc-- > 0) {
                            req.append(')');
                            co--;
                        }
                    }
                    req.append(str.charAt(i));
                    i++;
                }

                int r = co;
                while (r-- > 0) {
                    req.append(')');
                    co--;
                }

                k = i - 1;
            }

            System.out.println("Case #" + m + ": " + req.toString());
        }

        sc.close();
    }
}