
import java.util.*;
import java.io.*;


public class Solution {

    private static Scanner in;

    private static void solve(){
        int x,y;
        x=in.nextInt();
        y=in.nextInt();
        String m=in.next();
        int mov=0;
        for(char a: m.toCharArray()) {
            mov++;
            if(a=='E') {
                x++;
            } else if(a=='W') {
                x--;
            } else if(a=='N') {
                y++;
            } else if(a=='S') {
                y--;
            }
            if(Math.abs(x)+Math.abs(y)<=mov){
                System.out.println(mov);
                return;
            }
        }

        System.out.println("IMPOSSIBLE");
    }

    public static void main(String[] args) {
        in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            System.out.print("Case #" + i + ": ");
            solve();
        }
    }
}
