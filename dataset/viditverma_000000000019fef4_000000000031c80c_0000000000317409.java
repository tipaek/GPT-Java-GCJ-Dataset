import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int test = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int cases = 1; cases <= test; ++cases) {
            int x = in.nextInt();
            int y = in.nextInt();
            String s = in.next();
            int originx = 0,originy = 0;
            int count = 0;
            boolean flag = false;
            int len = s.length();
            for(int i = 0;i<len;i++)
            {
                count++;
                char ch = s.charAt(i);
                if(ch=='S')
                {
                    y--;
                }
                else if(ch == 'N')
                {
                    y++;
                }
                else if(ch == 'E')
                {
                    x++;
                }
                else 
                {
                    x--;
                }
                if(x==originx && y==originy)
                {
                    flag = true;
                    break;
                }
                if(x>originx)
                {
                    originx++;
                }
                else if(x<originx)
                {
                    originx--;
                }
                else if(y>originy)
                {
                    originy++;
                }
                else if(y<originy)
                {
                    originy--;
                }
                if(x==originx && y==originy)
                {
                    flag = true;
                    break;
                }
            }
            if(flag)
            {
                System.out.println("Case #"+cases+": "+count);
            }
            else
            {
                System.out.println("Case #"+cases+": IMPOSSIBLE");
            }
        }
    }
}