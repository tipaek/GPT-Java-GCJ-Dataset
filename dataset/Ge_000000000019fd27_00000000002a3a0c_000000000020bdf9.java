import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
  Scanner nerd = new Scanner (System.in);
int t = nerd.nextInt();
//ctrl-shift-v
for (int i = 1; i <= t; i++)
{
  int n = nerd.nextInt();
  String[] answer = new String[n];
  boolean busy = false;
  int[] start = new int[n];
  int[] end = new int[n];
  for (int j = 0; j < n; j++)
  {
    answer[j] = "nobody";
    start[j] = nerd.nextInt();
    end[j] = nerd.nextInt() - 1;
  }
  for (int j = 0; j <= 1440; j++)
  {
    boolean cameron = false;
    boolean jamie = false;
    
    for (int k = 0; k < n; k++)
    {
      if (!answer[k].equals("nobody") && j <= end[k] && j >= start[k])
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
      if (answer[k].equals("nobody") && j <= end[k] && j >= start[k])
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
    
    System.out.print("Case #" + i + ": " );
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
      System.out.println();
  }
}

  }
}
