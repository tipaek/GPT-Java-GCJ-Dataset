import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution  {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY

    public static void main(String args[]) throws java.lang.Exception
    {
        Scanner sc=new Scanner(System.in);

        int t=sc.nextInt();
        int st=1;

        while(t>0)
        {
            int x=sc.nextInt();
            int y=sc.nextInt();

            int ans=-1;

            String s=sc.next();

            for(int i=0;i<s.length();i++)
            {
               // System.out.println(x+""+y+""+x1+""+y1+"");
                char ch=s.charAt(i);

                if(ch=='N')
                {
                    y++;
                }
                else
                {
                    if(ch=='E')
                    {
                        x++;
                    }
                    else
                    {
                        if(ch=='W')
                        {
                            x--;
                        }
                        else
                        {
                            y--;
                        }

                    }

                    
                }
                
                
                int val=(int)(Math.abs(x)+Math.abs(y));
                
                if(val<=i+1)
                {
                    ans=i+1;
                    break;
                }
            }

            if(ans==-1)
            {
                System.out.println("Case #"+st+": "+"IMPOSSIBLE");
            }
            else
            {
                System.out.println("Case #"+st+": "+ans);
            }
            
            
            t--;
            st++;

        }
    }
}
