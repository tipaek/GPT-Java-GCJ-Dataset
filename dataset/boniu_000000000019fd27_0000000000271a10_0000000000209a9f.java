
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 1; t <= T; t++) {
            String s = scanner.next();
            String r = "";
            //either 0 or 1
            int open = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                int n = c - '0';
                if (c == '0'){
                    while(open > 0) {
                        r += ")";
                        open--;
                    }
                }else {
                    while (open - n > 0) {
                        r += ")";
                        open--;
                    }
                    while (open - n < 0) {
                        r += "(";
                        open++;
                    }
                }
                r += c;
            }
            while(open-- > 0) r += ")";

            System.out.println(String.format("Case #%d: %s", t, r));
        }
    }
}
