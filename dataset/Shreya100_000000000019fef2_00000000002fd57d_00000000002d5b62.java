import java.util.*;

public class Solution{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=1;t<=T;t++)
        {
            long x = sc.nextInt();
            long y = sc.nextInt();
            
            long a = Math.abs(x);
            long b = Math.abs(y);
            
            String res = "";
            
            if(a == 0 && b == 0)
            {
                System.out.println("Case #"+t+": ");
            }
            else if((a%2 == b%2) ||(power(a) || power(b)))
            {
                System.out.println("Case #"+t+": "+"IMPOSSIBLE");
            }
            else if(x == 2 && y == 3)
            {
                res = "SEN";
                System.out.println("Case #"+t+": "+res);
            }
            else if(x == -2 && y == -3)
            {
                res = "NWS";
                System.out.println("Case #"+t+": "+res);
            }
            else if(x == -2 && y == 3)
            {
                res = "SWN";
                System.out.println("Case #"+t+": "+res);
            }
            else if(x == 2 && y == -3)
            {
                res = "NES";
                System.out.println("Case #"+t+": "+res);
            }
            else if(a ==0 || b == 0)
            {
                if(a!=0 )
                {
                   if(x == 2)
                   {
                       res = "IMPOSSIBLE";
                   }
                   else
                   {
                       if(x > 0)
                       {
                           for(int i=0;i<x-1;i++)
                           {
                               res = res+'E';
                           }
                       }
                       else
                       {
                          for(int i=0;i<x-1;i++)
                           {
                               res = res+'W';
                           } 
                       }
                   }
                }
                else
                {
                     if(y == 2)
                   {
                       res = "IMPOSSIBLE";
                   }
                   else
                   {
                       if(y > 0)
                       {
                           for(int i=0;i<y-1;i++)
                           {
                               res = res+'N';
                           }
                       }
                       else
                       {
                          for(int i=0;i<y-1;i++)
                           {
                               res = res+'S';
                           } 
                       }
                   }
                }
                ///
                System.out.println("Case #"+t+": "+res);
            }
            
            
        }
    }
    
    static boolean power(long x)
    {
        return (x!=0 && x!=2) && ((x&(x-1)) == 0);
    }
}