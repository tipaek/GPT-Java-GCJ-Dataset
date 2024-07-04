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
                if ('1' == s.charAt(i)){
                    if (open == 0) {
                        r += "(1";
                        open = 1;
                    }else {
                        r += "1";
                    }
                }else {//char is '0'
                    if (open == 0) {
                        r += "0";
                    }else {
                        r += ")0";
                        open = 0;
                    }
                }
            }
            if (open == 1) {
                r += ")";
            }

            System.out.println(String.format("Case #%d: %s", t, r));
        }
    }
}
