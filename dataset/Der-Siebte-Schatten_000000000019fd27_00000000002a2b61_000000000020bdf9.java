import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) {
//Scanner nerd = new Scanner (System.in);
int t = nerd.nextInt();
for (int i = 0; i < t; i++)
{
  int n = nerd.nextInt();
  String[] answer = new String[n];
  boolean busy = false;
  for (int j = 0; j < n; j++)
  {
    answer[j] = "nobody";
  }
  int[] start = new int[n];
  int[] end = new int[n];
  for (int j = 0; j < n; j++)
  {
    start[j] = nerd.nextInt();
    end[j] = nerd.nextInt() - 1;
  }
  for (int j = 0; j <= 1440; j++)
  {
    boolean cameron = false;
    boolean jamie = false;
    
    for (int k = 0; k < n; k++)
    {
      if (!answer[k].equals("nobody") && i <= end[k] && i >= start[k])
      {
        if (answer[k].equals("C"))
        {
          if (cameron == true)
          {
            busy = true;
          }
          else
          {
            cameron = true;
          }
        }
        if (answer[k].equals("J"))
        {
          if (jamie == true)
          {
            busy = true;
          }
          else
          {
            jamie = true;
          }          
        }
      }
    }
    for (int k = 0; k < n; k++)
    {
      if (answer[k].equals("nobody") && i <= end[k] && i >= start[k])
      {
        if (cameron == true && jamie == true)
        {
          busy = true;
        }
        else if (cameron == true && jamie == false)
        {
          jamie = true;
          answer[k] = "J";
        }
        else
        {
          cameron = true;
          answer[k] = "C";
        }
      }
    }
    }
    if (busy == true)
    {
      System.out.println("IMPOSSIBLE");
    }
    else
    {
      for (int j = 0; j < n; j++)
      {
        System.out.print(answer[j]);
      }
  }
}

  }
}
