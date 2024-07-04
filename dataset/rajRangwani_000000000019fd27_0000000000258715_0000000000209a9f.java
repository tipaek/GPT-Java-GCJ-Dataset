import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    PrintWriter out = new PrintWriter(System.out);
    int t = sc.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int test = 1; test <= t; ++test) {
        out.print("Case #" + test + ": ");
      String s = sc.next();
      int arr[] = new int[s.length()];
      for(int i=0;i<s.length();i++) arr[i]=(int)s.charAt(i)-48;
      //for(int i=0;i<s.length();i++) out.print(arr[i]+" ");
      //out.println();
      for(int i=0;i<arr[0];i++) out.print("(");
      out.print(arr[0]);
      for(int i=1;i<arr.length;i++)
      {
          if(arr[i]>arr[i-1])
          {
              int diff=arr[i]-arr[i-1];
              while(diff-->0) out.print("(");
          }
          else if(arr[i]<arr[i-1])
          {
              int diff=arr[i-1]-arr[i];
              while(diff-->0) out.print(")");
          }
          out.print(arr[i]);
      }
      for(int i=0;i<arr[s.length()-1];i++) out.print(")");
      out.println();
      //System.out.println("Case #" + test + ": " + trace + " " + row+" "+column);
    }
    out.close();
  }
}