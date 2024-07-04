import java.util.*;
import java.io.*;
class Solution
{   
    public static int atLast(String str)
    {
        if(str.length()==0)
        return -1;
        else
        return Character.getNumericValue(str.charAt(str.length()-1));
        
    }
    public static void main(String ar[]) throws Exception
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int tcases=Integer.parseInt(br.readLine());
        int item;
        for(int t=0;t<tcases;t++)
        {
            String str=br.readLine();
            String ans="";
            for(int i=0;i<str.length();i++)
            {
                item=Character.getNumericValue(str.charAt(i));
                if(item==1)
                {
                    if(atLast(ans)==-1||atLast(ans)==0)
                    ans+="(1";
                    else if(atLast(ans)==1)
                    ans+="1";
                }
                if(item==0)
                {
                   if(atLast(ans)==-1)
                   ans+="0";
                   else if(atLast(ans)==1)
                   ans+=")0";
                   else if(atLast(ans)==0)
                   ans+="0";
                }
                
            }
            if(atLast(ans)==1)
            ans+=")";
            System.out.println("Case #"+(t+1)+": "+ans);
        }
    }
}