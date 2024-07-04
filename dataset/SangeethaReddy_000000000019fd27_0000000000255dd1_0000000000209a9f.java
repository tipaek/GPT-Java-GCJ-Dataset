import java.util.*;
class Solution
{
    public static void main(String[] args)
    {
        int n;
        Scanner ip=new Scanner(System.in);
        n=ip.nextInt();
        ip.nextLine();
        int i;
        for(i=0;i<n;i++)
        {
            String s=ip.nextLine();
            int j=0,k=0;
            String res="";
            for(j=0;j<s.length();j++)
            {
                if(s.charAt(j)=='0')
                 {
                   if(k!=0)
                   {
                       res=res+"(";
                       while(k>0)
                       {
                           res=res+"1";
                           k--;
                       }
                       res=res+")";
                       k=0;
                   }
                   res=res+s.charAt(j);
                 }
                else 
                  {
                       k=k+1;                      
                  }
            }
            if(k!=0)
                   {
                       res=res+"(";
                       while(k>0)
                       {
                           res=res+"1";
                           k--;
                       }
                       res=res+")";
                       k=0;
                   }
            System.out.println("Case #"+(i+1)+":"+" "+res);
        }
    }
}