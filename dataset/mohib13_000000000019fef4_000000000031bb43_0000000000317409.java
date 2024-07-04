import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int x = in.nextInt();
            int y = in.nextInt();

            int mx = 0;
            int my = 0;
            int ans = 0;
            String moves = in.next();
            for(int j = 0; j < moves.length(); j++) {
                char move = moves.charAt(j);
                switch(move) {
                    case 'S':
                        y--;
                        break;
                    case 'N':
                        y++;
                        break;
                    case 'E':
                        x++;
                        break;
                    case 'W':
                        x--;
                        break;
                }

                if(mx == x && my == y) {
                    ans = j + 1;
                    break;
                }
                //move closer in x
                if(x > mx){
                    mx++;
                    if(mx == x && my == y) {
                        ans = j + 1;
                        break;
                    }
                } else if(x < mx) {
                    mx--;
                    if(mx == x && my == y) {
                        ans = j + 1;
                        break;
                    }
                } else if (y > my) {
                    my++;
                    if(mx == x && my == y) {
                        ans = j + 1;
                        break;
                    }
                } else {
                    my--;
                    if(mx == x && my == y) {
                        ans = j + 1;
                        break;
                    }
                }
            }
            System.out.println("Case #" + i + ": " + ans == 0 ? "IMPOSSIBLE" : ans);
        }
    }
    
}
  