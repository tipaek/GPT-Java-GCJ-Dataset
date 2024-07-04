import java.util.*;
import java.io.*;
import java.lang.*;
public class Solution
{
    public static void main(String args[])
    {
      Scanner in =new Scanner(new BufferedReader(new InputStreamReader(System.in)));
      int t=in.nextInt();
      String op[]={"","(","((","(((","((((","(((((","((((((","(((((((","((((((((","((((((((("};
      String cl[]={"",")","))",")))","))))",")))))","))))))",")))))))","))))))))",")))))))))"};
      
      for (int case_num = 1; case_num <= t; case_num ++){
        String s=in.next();
        String rs="";
        rs =rs+op[Character.getNumericValue(s.charAt(0))];
        rs =rs+Character.getNumericValue(s.charAt(0));
        int len = s.length();
        for(int i=1;i<len;i++){
        if(Character.getNumericValue(s.charAt(i-1))-Character.getNumericValue(s.charAt(i))>0)
        {rs=rs+cl[Character.getNumericValue(s.charAt(i-1))-Character.getNumericValue(s.charAt(i))];
        rs=rs+Character.getNumericValue(s.charAt(i));}
        else if(Character.getNumericValue(s.charAt(i-1))-Character.getNumericValue(s.charAt(i))<0)
        {
        rs=rs+op[Character.getNumericValue(s.charAt(i))-Character.getNumericValue(s.charAt(i-1))];
        rs = rs+Character.getNumericValue(s.charAt(i));}
        else rs=rs+Character.getNumericValue(s.charAt(i));
        }
        rs=rs+cl[Character.getNumericValue(s.charAt(len-1))];
        System.out.println("Case #"+case_num+": "+rs);
        }}}
