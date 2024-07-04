import java.util.*;
import java.io.*;
public class CodeJamVestigium {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; i++) {
      String s=in.next();
      String r="";
      int l=s.length();
      for(int j=0;j<l;j++)
      {
          int x=0,y=0;
          char arr[];
          char ch=s.charAt(j);
          x=Integer.parseInt(Character.toString(ch));
          if(l>0&&j<l-1)
          {
            x=Integer.parseInt(Character.toString(ch));
            y=Integer.parseInt(Character.toString(s.charAt(j+1)));
          }
          if(Character.isDigit(ch)&&j==0)
          {
              if(ch!='0')
              {
                 arr = new char[x];
                Arrays.fill(arr, '(');
                r+=String.valueOf(arr)+ch;
                if(l>1&&y<x)
                {
                    Arrays.fill(arr, ')');
                    r+=String.valueOf(arr).substring(0, x-y);
                }
                else if(l>1&&y>x)
                {
                    arr = new char[y];
                    Arrays.fill(arr, '(');
                    r+=String.valueOf(arr).substring(0, y-x);
                }
              }
              else
              {
                   r+=ch;
                   arr = new char[x];
                    if(l>1&&y<x)
                    {
                        Arrays.fill(arr, ')');
                        r+=String.valueOf(arr).substring(0, x-y);
                    }
                    else if(l>1&&y>x)
                    {
                        arr = new char[y];
                        Arrays.fill(arr, '(');
                        r+=String.valueOf(arr).substring(0, y-x);
                    }
              }
          }
          else if(Character.isDigit(ch)&&j>0)
          {
              r+=ch;
                if(y<x||j==l-1)
                 {
                     arr = new char[x];
                     Arrays.fill(arr, ')');
                     r+=String.valueOf(arr).substring(0, x-y);
                 }
                 else if(y>x)
                 {
                     arr = new char[y];
                     Arrays.fill(arr, '(');
                     r+=String.valueOf(arr).substring(0, y-x);
                 }
          }
      }
      System.out.println("Case #" + i + ": "+r );
    }
  }
}