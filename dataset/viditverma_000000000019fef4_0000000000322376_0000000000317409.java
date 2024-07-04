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
            int index[]=new int[1001];
            int indexy[]=new int[1001];
            int value[] = new int[1001];
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
                index[i] = x;
                indexy[i] = y;
                value[i] = count;
            }
            int max = 500000;
            for(int i = 0;i<len;i++)
            {
                int time = Math.abs(index[i])+Math.abs(indexy[i]);
                if(time<=value[i])
                {
                    
                    max = Math.min(max,value[i]);
                    flag = true;
                }
            }
            
            if(flag)
            {
                System.out.println("Case #"+cases+": "+max);
            }
            else
            {
                System.out.println("Case #"+cases+": IMPOSSIBLE");
            }
        }
    }
}