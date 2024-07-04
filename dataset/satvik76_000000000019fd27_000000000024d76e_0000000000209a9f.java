import java.util.*;
class Solution
{
    public static void main(String[] args)
    {
        int t,k,i,j,g,l,o=0;
        String s,h;
        Scanner sc=new Scanner(System.in);
        t=sc.nextInt();
        while(t!=0)
        {
          s=sc.next();
          k=0;h="";
          for(i=0;i<s.length();i++)
          {
          l=(int)s.charAt(i)-48;
          for(j=1;j<=(l-k);j++)
          h=h+"(";
          g=l-k;
          while(g<0)
          {
          h=h+")";
          g++;
          }
          h=h+s.charAt(i);
          k=k+(l-k);
          }
          while((k--)!=0)
          h=h+")";
          o++;
          System.out.println("Case #"+o+": "+h);
          t--;
        }
    }
}