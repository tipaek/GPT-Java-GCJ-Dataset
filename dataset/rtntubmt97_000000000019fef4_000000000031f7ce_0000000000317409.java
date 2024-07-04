import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int x = in.nextInt();
            int y = in.nextInt();
            String path = in.next();

            if (x < 0) x = -x;
            if (y < 0) y = -y;

            int pathLength = path.length();
            
            int j = 0;
            String result = "IMPOSSIBLE";
            for (; j < pathLength; j++){
              switch(path.charAt(j)){
                case 'N':
                  y++;
                  break;
                case 'S':
                  y--;
                  break;
                case 'W':
                  x--;
                  break;
                case 'E':
                  x++;
                  break;
              }
              if (Math.abs(x) + Math.abs(y) <= j + 1){
                result = String.valueOf(j + 1);
                break;
              }
            }

            System.out.println("Case #" + i + ": " +  result);
        }
    }
}