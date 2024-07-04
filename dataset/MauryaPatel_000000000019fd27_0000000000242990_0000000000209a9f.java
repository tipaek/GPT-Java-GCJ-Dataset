import java.util.*;
class Solution
{
  public static void main(String args[])
  {
    Scanner in = new Scanner(System.in);
    int n;
    int m;
    n=in.nextInt();
    String s=in.nextLine();

    for(m=1;m<=n;m++)
    {
      StringBuffer str = new StringBuffer();
      str=str.append(in.nextLine());
      StringBuffer res = new StringBuffer();
      int i,j,l,open=0,num=0,max=0;
      char c;
      l=str.length();
      for(i=0;i<l;i++)
      {
        c=str.charAt(i);
        num=c-48;
        if(num>open)
        {
          for(j=0;j<num-open;j++)
          {
            res=res.append('(');
          }
          open=num;
          res.append(c);
        }
        else if(num==open)
        {
          res.append(c);
        }
        else
        {
          for(j=0;j<(open-num);j++)
          {
            res.append(')');
          }
          open=num;
          res.append(c);
        }
      }
    if(open!=0)
    {
      for(i=0;i<open;i++)
        res.append(')');
    }
    System.out.print("Case #"+m+": "+res);
    System.out.println();
  }
}
}
