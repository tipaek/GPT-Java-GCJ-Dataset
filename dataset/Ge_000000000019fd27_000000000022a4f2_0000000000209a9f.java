import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
Scanner nerd = new Scanner (System.in);
int t = nerd.nextInt();
for (int i = 0; i < t; i++)
{
  int c = i+1;
  String x = nerd.next();
  for (int j = 0; j < x.length() - 1; j++)
  {
    String added = "";
    int diff = Integer.parseInt(x.substring(j, j+1)) - Integer.parseInt(x.substring(j+1, j+2));
    if (diff < 0)
    {
      diff *= -1;
      for (int k = 0; k < diff; k++)
      {
        added += "(";
      }
    }
    else
    {
      for (int k = 0; k < diff; k++)
      {
        added += ")";
      }
    }
    x = x.substring(0,j+1) + added + x.substring(j+1);
    j+= added.length();
  }
  String begin = "";
  for (int j = 0; j < Integer.parseInt(x.substring(0,1)); j++)
  {
    begin += "(";
  }
  String end = "";
    for (int j = 0; j < Integer.parseInt(x.substring(x.length()-1)); j++)
  {
    end += ")";
  }
  System.out.println("Case #" + c + ": " + begin + x + end);
 //0((2(3(4(5)))))
//0((((4))2((((6)))3((5)))))
}

  }
}
