import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        for (int t = 1; t <= tests; t++) {
            String s = sc.next();
            StringBuilder ret = new StringBuilder();
            int open = 0;
            for (int i = 0; i < s.length(); i++) {
                int current = s.charAt(i) - '0';
                if (current > open) {
                    int toAdd = current - open;
                    open += toAdd;
                    for (int j = 0; j < toAdd; j++) {
                        ret.append('(');
                    }
                    ret.append(current);
                } else {
                    int toClose = open - current;
                    open -= toClose;
                    for (int j = 0; j < toClose; j++) {
                        ret.append(')');
                    }
                    ret.append(current);
                }
            }
            for(int j=0; j<open; j++)
                ret.append(')');
            System.out.printf("Case #%d: %s", t, ret.toString());
        }
    }
}
