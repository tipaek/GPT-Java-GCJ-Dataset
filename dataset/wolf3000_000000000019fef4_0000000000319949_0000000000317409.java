import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {

            int x = in.nextInt();
            int y = in.nextInt();
            String s = in.next();
            System.out.println("Case #" + i + ": " + solve(x, y, s));
        }

    }

    static int[] delta(char ch){
        switch (ch){
            case('S') : return new int[]{0,-1};
            case('N') : return new int[]{0,1};
            case('W') : return new int[]{-1,0};
            case('E') : return new int[]{1,0};
        }
        throw new IllegalArgumentException();
    }

    private static String solve(int x, int y, String s) {

        for(int i=0;i<s.length();++i){
            char ch = s.charAt(i);
            int nx = x + delta(ch)[0];
            int ny = y + delta(ch)[1];
            if(Math.abs(ny) + Math.abs(nx) <= i+1){
               return (i + 1)+"";
            }
            x = nx;
            y = ny;
        }

        return "IMPOSSIBLE";
    }

}