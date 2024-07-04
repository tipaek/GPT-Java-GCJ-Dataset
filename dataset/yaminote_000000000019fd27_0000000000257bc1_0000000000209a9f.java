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
        if(o==1&&c=='0')
        {
          sb.append(")");
          sb.append(c);
          o=0;
          continue;
        }
        if(o==1&&c=='1')
        {
          sb.append(c);
          continue;
        }
        if(o==0&&c=='1')
        {
          sb.append("(");
          sb.append(c);
          o=1;
          continue;
        }
        sb.append(c);
      }
      if(o==1)
      sb.append(")");
      System.out.println("Case #"+f+": "+sb.toString());
      f++;
    }
  }
}
