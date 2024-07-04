import java.util.*;
public class Solution
{
    static int n;
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
         int t=sc.nextInt();String s10=sc.nextLine();
         for(int i=1;i<=t;i++)
         {
             String st[]=sc.nextLine().split("");
             n=st.length;String s="";int c=0;
             for(int j=0;j<n;j++)
             {
                 char ch=st[j].charAt(0);
                 if((int)ch-48>c)
                 {
                     for(int k=1;k<=(int)ch-c-48;k++)
                     s=s+"(";
                     s=s+st[j];
                     c=(int)ch-48;
                 }
                 else if((int)ch-48==c)
                 s=s+st[j];
                 else
                 {
                     for(int k=1;k<=c-((int)ch-48);k++)
                     s=s+")";
                     s=s+st[j];
                     c=(int)ch-48;
                 }
                 
             }
             for(int j=1;j<=c;j++)
             {s=s+")";}
             System.out.println("Case #"+i+": "+s);
         }
    }
}