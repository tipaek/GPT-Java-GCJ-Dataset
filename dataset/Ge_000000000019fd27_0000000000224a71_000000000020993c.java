import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) {
Scanner nerd = new Scanner (System.in);
int t = nerd.nextInt();
for (int i = 0; i < t; i++)
{
  int c = i + 1;
  int a = nerd.nextInt();
  int[][] x = new int[a][a];
  for (int j = 0; j < a; j++)
  {
    for (int k = 0; k < a; k++)
    {
      x[j][k] = nerd.nextInt();
    }
  }
  int[][] y = new int[a][a];
  for (int j = 0; j < a; j++)
  {
    for (int k = 0; k < a; k++)
    {
      y[j][k] = x[k][j];
    }
  }
  int sum = 0;
  for (int j = 0; j < a; j++)
  {
    sum += x[j][j];
  }
  int rowpeat = 0;
  for (int j = 0; j < a; j++)
  {
    if (isRepeat(x[j]))
    rowpeat++;
  }
  int colpeat = 0;
  for (int j = 0; j < a; j++)
  {
    if (isRepeat(y[j]))
    colpeat++;
  }

  System.out.println("Case #" + c + ": " + sum + " " + rowpeat + " " + colpeat);
}


  }
  public static boolean isRepeat(int[] x)
  {
    Arrays.sort(x);
    for (int i = 1; i < x.length; i++)
    {
      if (x[i-1] == x[i])
      return true;
    }
    return false;
  }
}
