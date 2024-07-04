import java.util.*;
class Solution
{
public static void main(String[] args)
{
 Scanner sc=new Scanner(System.in);
 int t=sc.nextInt();
 for(int l=1;l<=t;l++)
 {
  String s=sc.next();
  s+="0";
  String ans="";
 /* if(s.length()==1)
  ans=length1(s.charAt(0));
  else
  {
      for(int i=0;i<s.length();i++)
      {
          char c=s.charAt(i);
          if(c=='0')
          {ans+="0";continue;}
          if(c=='1')
          {
            ans+="(";
            int j=i;
            while(i<s.length()&&s.charAt(i)=='1')
            i++;
            ans+=s.substring(j,i);
            ans+=")";
            i--;
          }
      }
  }*/
  for(int i=0;i<s.length()-1;i++)
  {
    if(i==0)
    {
        for(int j=0;j<s.charAt(0)-'0';j++)
        ans=ans+"(";
    }
    ans=ans+s.charAt(i);
    int temp=s.charAt(i)-s.charAt(i+1);
    if(temp>0)
    {
        for(int j=0;j<temp;j++)
        ans=ans+')';
    }
    else if(temp<0)
    {
        for(int j=temp;j<0;j++)
        ans=ans+"(";
    }
  }
  print(l,ans);
 }
}
static String length1(char c)
{
    
    switch(c)
    {
    case '0':return "0";
    case '1':return "(1)";
    case '2':return "((2))";
    case '3':return "(((3)))";
    case '4':return "((((4))))";
    case '5':return "(((((5)))))";
    case '6':return "((((((6))))))";
    case '7':return "(((((((7)))))))";
    case '8':return "((((((((8))))))))";
    case '9':return "(((((((((9)))))))))";
    default:return " ";
    }
}
static void print(int i,String s)
{
    System.out.println("Case #"+i+": "+s);
}
}