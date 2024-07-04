import java.util.*;
import java.lang.*;

class Solution
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int m=1;
        int t=sc.nextInt();
        while(t!=0)
        {
            
            String s=sc.next();
            String[] sarr=new String[s.length()];
            
            sarr=s.split("");
            int nextt=0,curr=0;
            int prev=0;
            
            StringBuilder br=new StringBuilder();
             
              curr=Integer.parseInt(sarr[0]);
              
              for(int i=0;i<curr;i++)
                 br.append("(");
                 
                br.append(sarr[0]); 
              
            prev=curr;  
              
            for(int i=1;i<s.length();i++)
            {
             curr=Integer.parseInt(sarr[i]);
             
             if(curr<prev)
             {
                for(int k=0;k<prev-curr;k++)
                  br.append(")");
                  
                br.append(sarr[i]);  
             }
             else if(curr>prev)
             {
                 for(int k=0;k<curr-prev;k++)
                   br.append("(");
                  
                br.append(sarr[i]);
             }
             else
             {
                 br.append(sarr[i]);
             }
             
             prev=curr;
            }
            for(int k=0;k<curr;k++)
              br.append(")");
              
            System.out.println("Case #"+m+": "+br);
            m++;
            t--;
        }
    }
}