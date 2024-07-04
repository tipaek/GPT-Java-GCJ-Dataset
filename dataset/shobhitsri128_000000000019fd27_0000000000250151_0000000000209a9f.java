import java.util.*;
class Solution
{
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int T=sc.nextInt();
    for(int t=0;t<T;t++)
    {
      String s=sc.next();
      System.out.println("Case #"+(t+1)+": "+convert(s));
    }
  }
  public static String convert(String s)
  {
    String newS="";
    for(int i=0;i<s.length();i++)
    {
      int c=Integer.parseInt(s.charAt(i)+"");
      String b=s.charAt(i)+"";
      for(int j=1;j<=c;j++)
      {
        b="("+b+")";
      }
      newS+=b;
    }
    int index=newS.indexOf(")(");
    while(index!=-1)
    {
      newS=newS.substring(0,index)+newS.substring(index+2);
      index=newS.indexOf(")(");
    }
    return newS;
  }
}
