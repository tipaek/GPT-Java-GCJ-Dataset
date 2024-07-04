import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int y=1;y<=t;y++)
        {
            int n=sc.nextInt();
            String[]r=new String[2*n];
            for(int x=0;x<2*n;x++)
            {
                String p="s";
                if(x%2==1){p="l";}
                p+=(x/2);
                int q=10000+sc.nextInt();
                p=(""+q).substring(1)+p;
                r[x]=p;
            }
            Arrays.sort(r);String a="";int c=-1;int j=-1;
            for(int x=0;x<n;x++)
            {
               a+="C"; 
            }
            for(int x=0;x<2*n;x++)
            {
               if(r[x].substring(4,5).equals("l"))
               {
                   if(r[x].substring(5).equals(""+c))
                   {c=-1;}
                   else
                   {
                       String s="";String m="";
                       if(!(j+1>=n)){s=a.substring(j+1);}
                       if(j>0){m=a.substring(0,j);}
                       a=m+"J"+s;
                       j=-1; 
                   }
               }
               else
               {
                   if(c>=0&&j>=0)
                   {a="IMPOSSIBLE";break;}
                   else if(c<0)
                   {c=Integer.parseInt(r[x].substring(5));}
                   else
                   {j=Integer.parseInt(r[x].substring(5));}
               }
            }
            System.out.println("Case #"+y+": "+a);
        }
    }
}