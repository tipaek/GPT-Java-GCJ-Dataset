import java.util.Scanner;
import java.io.*;
class Solution
{

  static void openBracket(int num)
  {
    for(int i=0;i<num;i++)
      System.out.print("(");
  }

  static void closeBracket(int num)
  {
    for(int i=0;i<num;i++)
      System.out.print(")");
  }

  public static void main(String args[])
  {
  Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
  int t = sc.nextInt();

  for (int k=0;k<t;k++)
  {

  String num = sc.next();
  int l = num.length();

  System.out.print("Case #"+(k+1)+": ");

  openBracket(num.charAt(0)-'0');//starting brackets


    for(int i=0;i<l-1;i++)//mid brackets and numbers
    {
      System.out.print(num.charAt(i));
      if(num.charAt(i)<num.charAt(i+1))
      openBracket(Math.abs((num.charAt(i)-'0') - (num.charAt(i+1)-'0')));

      if(num.charAt(i)>num.charAt(i+1))
      closeBracket(Math.abs((num.charAt(i)-'0') - (num.charAt(i+1)-'0')));
    }


    System.out.print(num.charAt(num.length()-1));
    closeBracket(num.charAt(num.length()-1)-'0');//closing brackets
    System.out.println();
  }
  }
}
