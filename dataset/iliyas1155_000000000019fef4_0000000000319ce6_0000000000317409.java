import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = scanner.nextInt();
        for(int testCase=1; testCase<=cases; testCase++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String m = scanner.next();
            String res = calc(x, y, m);
            System.out.println("Case #" + testCase + ": " + res);
        }
    }

    public static String calc(int x, int y, String m) {

        for(int i=0; i<m.length(); i++) {
            char c = m.charAt(i);
            if(c=='N') y++;
            if(c=='S') y--;
            if(c=='E') x++;
            if(c=='W') x--;
            int dist = Math.abs(x) + Math.abs(y);
            if(dist <= i+1) {
                return "" + (i+1);
            }
        }
        return "IMPOSSIBLE";
    }

}
