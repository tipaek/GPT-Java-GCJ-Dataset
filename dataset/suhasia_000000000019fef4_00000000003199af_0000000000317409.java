import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = in.nextInt();
        for (int p = 0; p < t; p++) {
            int x = in.nextInt();
            int y = in.nextInt();
            String s = in.next();
            int maxlength = s.length();

            int ans = recurse(x,y,s,0, maxlength);


            if(ans>=0) System.out.println("Case #" + (p + 1) + ": "+ans);
            else System.out.println("Case #" + (p + 1) + ": IMPOSSIBLE");
        }
    }

    static int recurse (int x, int y, String s, int moves, int maxlength){
        //System.out.println(x+", "+y+", "+s+", "+moves);
        if(moves==maxlength){
            if(Math.abs(x)+Math.abs(y)<=moves) return moves;
            else return -1;
        }
        if(x==0 && y==0) return moves;
        int xprime = x; int yprime = y;
        if(s.charAt(0)=='S') yprime--;
        if(s.charAt(0)=='N') yprime++;
        if(s.charAt(0)=='E') xprime++;
        if(s.charAt(0)=='W') xprime--;
        if(Math.abs(x)+Math.abs(y) <= moves){
            return moves;
        } else {
            return recurse(xprime, yprime, s.substring(1,s.length()), moves+1, maxlength);
        }
    }
}

