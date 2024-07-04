import java.util.*;
import java.io.*;

import static java.lang.Math.*;

public class Solution {
	public static void main(String[] args) {
		Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter w = new PrintWriter(System.out);

        
        int t = input.nextInt();
        int count =1;
        while(t-->0)
        {
            int x = input.nextInt();
            int y = input.nextInt();
            
            
            
            
            String s = input.next();
            
            
            if(x==0 && y==0)
            {
                 w.println("Case #" + "" + count + ":" + " " + "0");
                continue;
            }
            
            int ans =-1;
            
            
            for(int i=0;i<s.length();i++)
            {
              if(s.charAt(i)=='S')
              {
                  y--;
              }
              else if(s.charAt(i)=='N')
              {
                  y++;
              }
              else if(s.charAt(i)=='E')
              {
                  x++;
              }
              else
              {
                  x--;
              }
              
              int x1 = Math.abs(x);
              
              int y1 = Math.abs(y);
              
              if((i+1) >= (x1+y1))
              {
                  ans = i+1;
                  break;
              }
              
            }
            
            if(ans == -1)
            {
                w.println("Case #" + "" + count + ":" + " " + "IMPOSSIBLE");
                 
            }
            else
            {
                w.println("Case #" + "" + count + ":" + " " + ans);
                 
            }
            
            
            
            
            count++;
            
            
            
            
            
        }
        
		w.close();
	}
}



