import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int i = 1; i <= t; ++i) {
            String s = in.next();
            StringBuilder res = new StringBuilder();

            int open = 0;
            for (int k = 0; k < s.length(); k++) {
                int num = s.charAt(k) - '0';

                if (num > open) {
                    int toAdd = num - open;
                    for (int j = 0; j < toAdd; j++) {
                        res.append('(');
                    }
                }

                if (num < open) {
                    int toRemove = open - num;
                    for (int j = 0; j < toRemove; j++) {
                        res.append(')');
                    }
                }

                open = num;
                res.append(num);
            }

            for (int j = 0; j < open; j++) {
                res.append(')');
            }

            System.out.println("Case #" + i + ": " + res.toString());
        }
    }
}