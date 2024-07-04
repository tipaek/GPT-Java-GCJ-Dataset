import java.util.*;
public class Solution
{
  public static void main(String[] args) {
    Scanner in=new Scanner(System.in);
    int t=in.nextInt();
    int f=1;
    while(t-->0)
    {
      String s=in.next();
      int o=0;
      StringBuilder sb=new StringBuilder();

      for(char c:s.toCharArray())
      {
        int a=Integer.valueOf(""+c);
        if(o>a)
        {
          while(o>a)
          {
            sb.append(")");
            o--;
          }
        }
        if(o<a)
        {
          while(o<a)
          {
            sb.append("(");
            o++;
          }
        }
        sb.append(c);
      }
      while(o>0)
      {
        sb.append(")");
        o--;
      }
      System.out.println("Case #"+f+": "+sb.toString());
      f++;
    }
  }
}
