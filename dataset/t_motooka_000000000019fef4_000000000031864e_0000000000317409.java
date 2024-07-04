import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            System.out.print("Case #" + i + ": ");
            int x = in.nextInt();
            int y = in.nextInt();
            String m = in.next();
            testCase(x, y, m);
        }
    }
    private static void testCase(int x, int y, String m) {
        int len = m.length();
        for(int i=0; i<len; i++) {
            char c = m.charAt(i);
            switch(c) {
                case 'N':
                    y++;
                    break;
                case 'S':
                    y--;
                    break;
                case 'E':
                    x++;
                    break;
                case 'W':
                    x--;
                    break;
            }
            if(Math.abs(x) + Math.abs(y) <= i+1) {
                System.out.println(i+1);
                return;
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}