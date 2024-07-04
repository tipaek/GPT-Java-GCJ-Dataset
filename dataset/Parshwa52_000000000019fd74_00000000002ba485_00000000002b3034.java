import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int j1 = 1; j1 <= t; ++j1)
        {
          int n = in.nextInt();
          String s[]=new String[n];
          for(int i=0;i<n;i++)
          {
              s[i]=in.next();
                
          }
          Arrays.sort(s, new java.util.Comparator<String>() {
    @Override
    public int compare(String s1, String s2) {
        // TODO: Argument validation (nullity, length)
        return s1.length() - s2.length();// comparision
    }
});
            int m=s.length-1;boolean b=true;String st="";
            for(int i=m;i>=0;i--)
            {
                if(i==m)
                st=s[i].substring(1,s[i].length());
                else
                {
                    if(st.contains(s[i].substring(1,s[i].length()))==false)
                    {
                        b=false;break;
                    }
                }
            }
            if(b==false)
          //int m = in.nextInt();
          System.out.println("Case #" + j1 + ": *" );
          else
          System.out.println("Case #"+j1+": "+st);
        }
      }
    }