//Pranav Mishra Vestigium  
import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        int matrix[][];
        int r;
        int c;
        int k;
        Set<Integer> vals = new HashSet<Integer>();
        for (int i = 1; i <= t; ++i) {
          r = 0;
          c = 0;
          k = 0;
          vals.clear();
          int size = in.nextInt();
          matrix = new int[size][size];
          
          for(int x = 0; x < size; x++)
           {
            for(int y = 0; y < size; y++)
             {
              matrix[x][y] = in.nextInt();

             }
           }
          
  //         for(int x = 0; x < size; x++)
//            {
//             for(int y=0; y < size; y++) 
//              {
//               System.out.println(matrix[x][y]);
//              }
//            }
           
//           int n = in.nextInt();
//           int m = in.nextInt();

          for(int x = 0; x < size; x++)
           {
            k+= matrix[x][x];
           }
          r = 0;
          c = 0;
          
          for(int x = 0; x < size; x++)
           {
            vals.clear();
            for(int y = 0; y < size; y++)
             {
              if(vals.contains(matrix[x][y]))
                {
                 r+=1;
                 break;
                }
              vals.add(matrix[x][y]);
             }
             vals.clear();
           }
          vals.clear();
          for(int y = 0; y < size; y++)
           {
            vals.clear();
            for(int x = 0; x < size; x++)
             {
              if(vals.contains(matrix[x][y]))
               { 
                c+=1;
                break;
               }
              vals.add(matrix[x][y]);
             }
            vals.clear();
           }
          vals.clear();
          System.out.println("Case #" + i + ": " + k + " " + r + " " + c);
        }
      }
    }