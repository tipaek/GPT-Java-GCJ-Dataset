

import java.io.*;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    private static final String IMPOSSIBLE = "IMPOSSIBLE";
    private static final char STAR = '*';

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = in.nextInt();
        in.nextLine();
        for (int i = 0; i < t; ++i) {
            int x = in.nextInt();
            int y = in.nextInt();
            String s = in.next();
            String result = solve(x, y, s);
            String answer = "Case #" + (i + 1) + ": " + result;
            System.out.println(answer);
        }
        in.close();
        out.close();
    }

    static String solve(int x, int y, String s) {
        int a[] = md(x, y, s);
        for (int i = 0; i< a.length; i++) {
            if (a[i] <= i) {
                return "" + i;
            }
        }
        return IMPOSSIBLE;
    }

    static int[] md(int x, int y, String s) {
        int[] a= new int[s.length()+1];
        a[0] = md(x,y);
        for (int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            x = (c == 'E') ? x-1 : (c=='W') ? x+1 : x;
            y = (c == 'S') ? y-1 : (c=='N') ? y+1 : y;
            a[i+1] = md(x,y);
        }
        return a;
    }
    static int md(int x, int y) {
        return Math.abs(x) + Math.abs(y);
    }


}