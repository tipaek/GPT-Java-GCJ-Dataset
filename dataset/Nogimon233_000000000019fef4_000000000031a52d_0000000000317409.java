import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        //.out.println("codejam");
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        String temp = in.nextLine();

        for (int i = 1; i <= t; ++i) {
            String line = in.nextLine();
            String[] ss = line.split(" ");
            int x = Integer.parseInt(ss[0]);
            int y = Integer.parseInt(ss[1]);
            String route = ss[2];
            String ans = solve(x, y, route);
            System.out.println("Case #" + i + ": " + ans);
        }
    }


    private static String solve(int x, int y, String s) {
        char[] route = s.toCharArray();
        int t = 0;
        int n = route.length;

        for (int i = 0; i < n; i++) {
            int curr = Math.abs(x) + Math.abs(y);
            if (curr <= t) {
                return String.valueOf(i);
            }

            if (route[i] == 'S') {
                y--;
            } else if (route[i] == 'N') {
                y++;
            } else if (route[i] == 'E') {
                x++;
            } else {
                x--;
            }
            t++;

        }
        if (Math.abs(x) + Math.abs(y) <= t) {
            return String.valueOf(n);
        } else {

            return "IMPOSSIBLE";
        }
    }




}




class TrieNode{
    char c;
    int count;
    TrieNode[] next;
    public TrieNode(char _c){
        c = _c;
        next = new TrieNode[26];
        count = 0;
    }
}
