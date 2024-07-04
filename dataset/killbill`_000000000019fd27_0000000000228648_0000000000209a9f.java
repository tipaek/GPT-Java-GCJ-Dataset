
import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
    public static void main(String args[])
    {Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int tt=1;
        sc.nextLine();
        while(tt<=t){
            int open=0;
            String ans="";
            String k=sc.nextLine();
          for(int j=0;j<k.length();j++)
            {           // System.out.println(k.charAt(j));

                int n=Integer.parseInt(String.valueOf(k.charAt(j)));
                if(open==n){
                    ans+=Integer.toString(n);
                }
                else if(n>open)
                {
                    for(int i=0;i<(n-open);i++)
                    {
                        ans+="(";
                        
                    }
                    open+=(n-open);
                    ans+=Integer.toString(n);

                }
                else if(n<open){
                    for(int i=0;i<(open-n);i++)
                    {
                        ans+=")";
                        
                    }
                    open-=(open-n);
                    ans+=Integer.toString(n);

                }
            }
            if(open!=0){
                while(open!=0){
                    ans+=")";
                    open--;
                }
                //sc.nextLine();
            }
            System.out.println("Case #"+tt+": "+ans);
            tt++;
        }
      sc.close();
    }
}