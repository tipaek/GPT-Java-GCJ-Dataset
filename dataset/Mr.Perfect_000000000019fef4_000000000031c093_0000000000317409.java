import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = Integer.parseInt(s.nextLine());
        int c = 0;
        while(c++<t) {
            String xym[] = s.nextLine().split(" ");
            int x = Integer.parseInt(xym[0]);
            int y = Integer.parseInt(xym[1]);
            char m[] = xym[2].toCharArray();
            int l = m.length;

            int minute = 0;
            if(x!=0 || y!=0) {
                minute++;
                while(minute <= l) {
                    switch(m[minute-1]) {
                        case 'N': y++; break;
                        case 'S': y--; break;
                        case 'E': x++; break;
                        case 'W': x--; break;
                    }
                    if(minute>=(Math.abs(x)+Math.abs(y))) {
                        break;
                    }
                    minute++;
                }
            }
            System.out.println("Case #" + c + ": " + (minute > l ? "IMPOSSIBLE": minute));
        }
    }


}
