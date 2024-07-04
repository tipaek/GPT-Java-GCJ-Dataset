import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); 
        String open="(((((((((",close=")))))))))",res="";char ch1=' ',ch2=' ';int diff=0;
        // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i1 = 1; i1 <= t; ++i1) {
          //int n = in.nextInt();
          //int m = in.nextInt();
          String s=in.next();
          res="";
          s="0"+s+"0";
          diff=0;
          for(int i=1;i<s.length();i++)
          {
              ch1=s.charAt(i-1);
              ch2=s.charAt(i);
              if(ch2>ch1)
              {
                  diff=ch2-ch1;
                  res+=open.substring(0,diff)+ch2;
              }
              else if(ch1>ch2)
              {
                  diff=ch1-ch2;
                  res+=close.substring(0,diff)+ch2;
              }
              else
              {
                  res+=ch2;
              }
          }
          System.out.println("Case #" + i1 + ": " + res.substring(0,res.length()-1));
        }
      }
    }