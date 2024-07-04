import java.util.*;
class Solution{
    public static void main(String args[])
    {
        Scanner in =new Scanner(System.in);
        int t=in.nextInt();
        for(int l=1;l<=t;l++)
        {
            int n=in.nextInt();
            String result="*";
            boolean ans=true;
            while(n-->0)
            {
                String g=in.next();
                int n1=result.length(),n2=g.length();
                if(n1>n2)
                {
                    n2--;
                    n1--;
                    while(n2>=0&&g.charAt(n2)!='*'&&g.charAt(n2)==result.charAt(n1))
                    {
                    n2--;
                    n1--;
                    }
                    if(n2!=0)
                    ans=false;
                }
                else
                {
                    n2--;
                    n1--;
                    while(n1>=0&&result.charAt(n1)!='*'&&g.charAt(n2)==result.charAt(n1))
                    {
                    n1--;
                    n2--;
                    }
                    if(n1!=0)
                    ans=false;
                    else
                    {
                        result=g;
                    }
                }
            }
            if(ans)
            System.out.println("Case #"+l+": "+result.substring(1));
            else
             System.out.println("Case #"+l+": "+"*");
            
        }
    }
}