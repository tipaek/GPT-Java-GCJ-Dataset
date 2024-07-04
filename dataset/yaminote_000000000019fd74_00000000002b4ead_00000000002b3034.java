import java.util.*;
class Solution
{
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);

  int t=in.nextInt();
        int f=1;
        while(t-->0)
        {
            int n=in.nextInt();
            String ar[]=new String[n];
            for(int i=0;i<n;i++)
                ar[i]=in.next();
            String s="";
            int c=0;
            for(int i=0;i<n;i++)
            {
                if(ar[i].length()>c)
                {
                    c=ar[i].length();
                    s=ar[i];
                }
            }
            s=s.substring(1);
            c=0;
            for(int i=0;i<n;i++)
            {
                String st=ar[i].substring(1);
                for(int j=0;j<s.length();j++)
                {
                  String k=s.substring(j);
                  if(k.equals(st))
                  {
                    c++;
                    break;
                  }
                }
            }
            if(c==n)
                System.out.println("Case #"+f+": "+s);
            else
                System.out.println("Case #"+f+": "+"*");
            f++;
        }
    }
}
