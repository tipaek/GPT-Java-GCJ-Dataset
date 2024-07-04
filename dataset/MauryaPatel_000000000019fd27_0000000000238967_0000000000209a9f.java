import java.util.*;
class Solution
{
  public static void main(String args[])
  {
    Scanner in = new Scanner(System.in);
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
      if(num>max)
      {
        for(j=0;j<num;j++)
        {
          res=res.append('(');
        }
        open=num;
        res.append(c);
        max=num;
      }
      else if(num==max)
      {
        res.append(c);
      }
      else
      {
        for(j=0;j<(max-num);j++)
        {
          res.append(')');
        }
        open=open-(max-num);
        max=num;
        res.append(c);
      }
    }
    if(open!=0)
    {
      for(i=0;i<open;i++)
      res.append(')');
    }
    System.out.println(res);
  }
}
