import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=1;i<=t;i++)
        {
             int str1=0;
             String str2="";
            int n=in.nextInt();
            int a[][]=new int[n][2];
            int ar[]=new int [n];
            String s1[]=new String[n];
            int cl=0,cu=0,jl=0,ju=0;
            for (int j=0;j<n;j++)
            {
                a[j][0]=in.nextInt();
                ar[j]=a[j][0];
                a[j][1]=in.nextInt();
            }
            Arrays.sort(ar);
            for(int g=0;g<n;g++)
            {
            for (int j=0;j<n;j++)
            {
               if(ar[g] == a[j][0])
               {
            if(a[j][0]>=cu || a[j][1]<=cl)
            {
                    cu=a[j][1];
                    //if(cl==0)
                    cl=a[j][0];
                    s1[j]="C";
                 
            }
            else if( a[j][0] < cu && ( a[j][0]>=ju || a[j][1]<=jl ))
            {
                ju=a[j][1];
                //if(jl==0)
                jl=a[j][0];
               s1[j]="J";
                
            }
            else
            {
                str1=7;
                
            }
            }
            }
            }
            if(str1 == 7)
            System.out.println("Case #"+i+": IMPOSSIBLE");
            else
            {
            for (int g=0;g<n;g++)
            {
                str2+=s1[g];
            }
            System.out.println("Case #"+i+": "+str2);
            }
        }
    }
}
                
                