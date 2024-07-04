import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        NestingDepth.Run();
    }
}

class NestingDepth {
    public static Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    public static void Run() {
        int t = sc.nextInt();
        for (int i=1; i<=t; i++) {
            String ip = sc.next();
            printOutput(i, Solve(ip));
        }
    }

    public static void printOutput(int test, String op) {
        System.out.printf("Case #%d: %s\n", test, op);
    }

    public static String Solve(String ip) {
        int closing = 0;
        String op = "";
        for (int i=0; i<ip.length(); i++) {
            int digit = Integer.parseInt(ip.charAt(i) + "");
            if (digit > closing) {
                int opening = digit - closing;
                for (int j=0; j<opening; j++) {
                    op = op + "(";
                }
                op = op + digit;
                closing = digit;
            } else if (digit == closing) {
                op += digit;
            } else {
                int closeAdditional = closing - digit;
                for (int j=0; j<closeAdditional; j++) {
                    op = op + ")";
                }
                op += digit;
                closing = digit;
            }
        }
        if (closing > 0) {
            for (int i=0; i<closing; i++) {
                op += ")";
            }
        }
        return op;
    }
}