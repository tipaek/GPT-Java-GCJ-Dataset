import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = Integer.parseInt(sc.nextLine());
        for (int tt = 1; tt <= t; tt++) {
            String digits = sc.nextLine();
            StringBuilder res = new StringBuilder();
            byte currentOpen = 0;
            for (int i = 0; i < digits.length(); i++) {
                char ch = digits.charAt(i);
                byte nr = (byte) (ch - '0');
                while (currentOpen < nr) {
                    res.append('(');
                    currentOpen++;
                }
                while (currentOpen > nr) {
                    res.append(')');
                    currentOpen--;
                }
                res.append(ch);
            }
            while (currentOpen > 0) {
                res.append(')');
                currentOpen--;
            }

            System.out.println("Case #" + tt + ": " + res);
        }
    }
}
