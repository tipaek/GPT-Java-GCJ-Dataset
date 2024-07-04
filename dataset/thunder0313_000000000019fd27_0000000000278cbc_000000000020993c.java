import java.util.*;
import java.io.*;

public class Solution
{
   public static void main(String[] args) throws IOException
   {
      BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));                                         
      StringTokenizer star = new StringTokenizer(bf.readLine());
      int N = Integer.parseInt(star.nextToken());
      for(int case_num = 1; case_num <= N; case_num++) {
         star = new StringTokenizer(bf.readLine());
         
         int size = Integer.parseInt(star.nextToken());
         int trace = 0;
         int row_count = 0;
         int col_count = 0;
         ArrayList<ArrayList<Integer>> cols = new ArrayList<ArrayList<Integer>>(size);
         for(int j = 0; j < size; j++)
            cols.add(new ArrayList<Integer>());
         
         boolean[] repeat_cols = new boolean[size];
         for(int i = 0; i < size; i++) {
            star = new StringTokenizer(bf.readLine());
            ArrayList<Integer> row = new ArrayList<Integer>();
            boolean repeat_rows = false;
            for(int j = 0; j < size; j++) {
               int element = Integer.parseInt(star.nextToken());
               if(i == j)
                  trace += element;
               if(row.contains(element) && !repeat_rows) {
                  row_count += 1;
                  repeat_rows = true;
               } else {
                  row.add(element);
               }
               if(cols.get(j).contains(element) && !repeat_cols[j]) {
                  col_count += 1;
                  repeat_cols[j] = true;
               } else {
                  cols.get(j).add(element);
               }
            }
         }
         
         System.out.println("Case #" + case_num + ": " + trace + " " + row_count + " " + col_count);
      }    
   }
}