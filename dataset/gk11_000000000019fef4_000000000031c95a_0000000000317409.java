import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Math.abs;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();
        for (int t = 1; t <= T; t++) {
            doCase(scanner, t);
        }
    }

    public static void doCase(Scanner scanner, int t) {
        int X = scanner.nextInt();
        int Y = scanner.nextInt(); scanner.skip(" ");
        String s = scanner.nextLine();
        if (X==0 && Y==0) {
            System.out.println("Case #"+t+": 0");
            return;
        }
        for (int i=0,u=0;i<s.length();i++) {
            char c = s.charAt(i);
            if (c=='S') Y--;
            else if (c=='N') Y++;
            else if (c=='E') X++;
            else if (c=='W') X--;
            u++;
            if (d(X,Y)<=u) {
                System.out.println("Case #"+t+": "+u);
                return;
            }
        }
        System.out.println("Case #"+t+": IMPOSSIBLE");
    }
    private static int d(int x,int y) {
        return abs(x)+abs(y);
    }
}
