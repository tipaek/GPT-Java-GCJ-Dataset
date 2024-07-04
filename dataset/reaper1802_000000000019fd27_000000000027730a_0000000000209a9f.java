import java.util.*;
import java.io.*;

class Solution{

  public static void main(String args[]) throws Exception{
    DataInputStream in = new DataInputStream(System.in);
    String line = in.readLine();
    int a = Integer.parseInt(line.trim());

    for(int i = 0; i < a; i++)
    {
      line = in.readLine();
      String str = line.trim();
      String ans = "";
      for(int j = 0; j < str.length(); j++)
        {
         if(str.charAt(j)=='0')
            ans+=str.charAt(j);
          if(str.charAt(j)=='1')
            {
              String one = "";
              while( j < str.length() && str.charAt(j) == '1')
              {
                one+=str.charAt(j);
                j++;
              }
              j--;
              ans = ans + "(" + one + ")";
            }
        }
      System.out.println("Case #" + i + ": " + ans);
    }
  }
}
