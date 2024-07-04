import java.util.*;
public class Solution{
    public static void main(String args[])
    {
        Scanner in =new Scanner(System.in);
        int t=in.nextInt();
        for(int l=1;l<=t;l++)
        {
            String inp=in.next();
            // imp+="0";
            String result="";
            int n=inp.length();
            int i=0;
            char p='0';
            for(i=0;i<n;i++)
            {
                int cnt=inp.charAt(i)-p;
                if(cnt<0)
                {
                    for(int j=0;j<Math.abs(cnt);j++)
                    {
                        result+=")";
                    }
                    
                }
                else
                {
                    for(int j=0;j<cnt;j++)
                    result+="(";
                }
                result+=inp.charAt(i);
                p=inp.charAt(i);
            }
          int  cnt=inp.charAt(n-1)-'0';
             for(int j=0;j<Math.abs(cnt);j++)
                    {
                        result+=")";
                    }
            
            
            System.out.println("Case #"+l+": "+result);
        }
    }
}