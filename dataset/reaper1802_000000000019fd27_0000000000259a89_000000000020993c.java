import java.util.*;
import java.io.*;

class GCJ{

  public static void main(String args[]) throws Exception{
    DataInputStream in = new DataInputStream(System.in);
    String line = in.readLine();
    int a = Integer.parseInt(line.trim());

    for(int i = 0; i < a; i++)
    {
      String input = in.readLine();
      int n = Integer.parseInt(input.trim());
      int m[][] = new int[n][n];
      for(int j = 0; j < n; j++)
        {
          line = in.readLine();
          String b[] = line.trim().split("\\s+");
          for(int k = 0; k < n; k++)
          {
            m[j][k] = Integer.parseInt(b[k]);
          }
        }

      int trace = 0;
      for(int j = 0; j < n; j++)
        trace+=m[j][j];


      int row_count = 0;
      for(int row_index = 0; row_index < n; row_index++)
      {
        int freq[] = new int[n+1];
        int flag = 0;
        for(int col_index = 0; col_index < n; col_index++)
          {
            if(freq[m[row_index][col_index]] == 0)
              freq[m[row_index][col_index]]++;
            else
              {
                flag = 1;
                break;
              }
          }

        if(flag == 1)
              row_count++;
      }

      int col_count = 0;
      for(int col_index = 0; col_index < n; col_index++)
      {
        int freq[] = new int[n+1];
        int flag = 0;
        for(int row_index = 0; row_index < n; row_index++)
          {
            if(freq[m[row_index][col_index]] == 0)
              freq[m[row_index][col_index]]++;
            else
              {
                flag = 1;
                break;
              }
          }


        if(flag == 1)
              col_count++;
      }

      System.out.println("Case #" + (i+1) + ": " + trace + " " + row_count + " " + col_count);

    }
  }
}
