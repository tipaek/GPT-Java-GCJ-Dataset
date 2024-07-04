import java.util.Scanner;
public class Solution
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=1;i<=t;i++)
        {
           String str1="";
            int n=in.nextInt();
            int l=0,u=0,cl=0,cu=0,jl=0,ju=0;
            for (int j=0;j<n;j++)
            {
                l=in.nextInt();
                u=in.nextInt();
            if(l>=cu || u<=cl)
            {
                    cu=u;
                    if(cl==0)
                    cl=l;
                  str1+="C";
            }
            else if( l < cu && ( l>=ju || u<=jl ))
            {
                ju=u;
                if(jl==0)
                jl=l;
                str1+="J";
            }
            else
            {
                str1="IMPOSSIBLE";
            }
            }
            System.out.println("Case #"+i+": "+str1);
        }
    }
}
                
                