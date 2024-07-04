import java.io.BufferedInputStream;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int t = sc.nextInt();
        sc.nextLine();
        for (int i = 1; i <= t; i++) {
            String s = sc.nextLine();
            StringBuilder res = new StringBuilder();
            int d = 0;
            for (int j = 0; j < s.length(); j++) {
                int num = s.charAt(j) - '0';
                while (num > d) {
                    res.append('(');
                    d++;
                }
                while (num < d) {
                    res.append(')');
                    d--;
                }
                res.append(num);
            }
            while (d > 0) {
                res.append(')');
                d--;
            }
            print(i, res.toString());
        }
        sc.close();
    }

    private static void print(int caseNum, String s) {
        System.out.println("Case #" + caseNum + ": " + s);
    }
}
