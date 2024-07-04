import java.io.*;
import java.util.*;

public class Vestigium
{
   public static void main(String [] args)
   {
      Scanner in = new Scanner(System.in);
      int t = in.nextInt();

      for (int i = 1; i <= t; i++)
      {
         int n = in.nextInt();


         int [][] matrix = new int[n][n];
         for (int j = 0; j < n; j++)
         {
            for (int k = 0; k < n; k++)
            {
               matrix[j][k] = in.nextInt();
            }
         }

         int k = 0, r = 0, c = 0;
         for (int j = 0; j < n; j++)
         {
            HashSet<Integer> row = new HashSet<>();
            HashSet<Integer> col = new HashSet<>();
            boolean rowflag = false, colflag = false;
            for (int l = 0; l < n; l++)
            {
               if (j == l)
               {
                  k += matrix[j][l];
               }

               if (!rowflag && row.contains(matrix[j][l]))
               {
                  r++;
                  rowflag = true;
               }
               else if (!rowflag)
               {
                  row.add(matrix[j][l]);
               }

               if (!colflag && col.contains(matrix[l][j]))
               {
                  c++;
                  colflag = true;
               }
               else if (!colflag)
               {
                  col.add(matrix[l][j]);
               }
            }
         }

         System.out.printf("Case #%d: %d %d %d\n", i, k, r, c);
      }
   }
}
