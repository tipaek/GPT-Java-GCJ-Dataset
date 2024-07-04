import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int test = in.nextInt();
        for (int t = 1; t<= test; t++) {
            String s = in.next();
            String result = "";
            int duplicate = 1;
            int start = 0;
            if (s.charAt(0) == '0')
                result += "0";
            else {
                result += "(1";
                start = 1;
            }
            for (int i = 1; i<s.length(); i++) {
                if (s.charAt(i) == '0') {
                    if (duplicate >= 1 && start == 1) {
                        result += ")";
                    }
                    result += "0";
                    duplicate = 1;
                    start = 0;
                } else if(s.charAt(i) == '1') {
                    if (duplicate == 1 && start == 0) {
                        result += "(";
                        start = 1;
                    }
                        duplicate += 1;
                        result += "1";
                }
            }
            if (duplicate >= 1 && start == 1) {
                result += ")";
            }
            System.out.println("Case #" + t + ": " + result);
        }
    }
}
