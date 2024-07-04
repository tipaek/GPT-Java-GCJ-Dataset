import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline

        for (int j = 0; j < t; j++) {
            String s = sc.nextLine();
            StringBuilder res = new StringBuilder();
            int len = s.length();

            for (int i = 0; i < len; ) {
                char c = s.charAt(i);
                if (c == '1') {
                    res.append("(1");
                    int k = 1;
                    while (i + k < len && s.charAt(i + k) == '1') {
                        res.append('1');
                        k++;
                    }
                    res.append(')');
                    i += k;
                } else {
                    res.append(c);
                    i++;
                }
            }

            System.out.println("Case #" + (j + 1) + ": " + res.toString());
        }
    }
}