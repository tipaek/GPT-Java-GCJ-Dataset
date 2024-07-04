import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // consume the remaining newline

        for (int y = 1; y <= t; y++) {
            int n = sc.nextInt();
            sc.nextLine(); // consume the remaining newline
            String[] s = new String[n];
            int maxLength = 0, maxIndex = 0;

            for (int i = 0; i < n; i++) {
                s[i] = sc.nextLine();
                if (s[i].length() > maxLength) {
                    maxLength = s[i].length();
                    maxIndex = i;
                }
            }

            StringBuilder st = new StringBuilder();
            for (int i = 0; i < maxLength; i++) {
                if (s[maxIndex].charAt(i) != '*') {
                    st.append(s[maxIndex].charAt(i));
                }
            }

            int l = st.length() - 1;
            boolean isValid = true;

            outer:
            for (int i = 0; i < n; i++) {
                for (int j = s[i].length() - 1; j >= 0; j--) {
                    if (s[i].charAt(j) != '*') {
                        if (st.charAt(l) != s[i].charAt(j)) {
                            System.out.println("Case #" + y + ": *");
                            isValid = false;
                            break outer;
                        }
                        l--;
                    }
                }
                l = st.length() - 1;
            }

            if (isValid) {
                System.out.println("Case #" + y + ": " + st.toString());
            }
        }
    }
}