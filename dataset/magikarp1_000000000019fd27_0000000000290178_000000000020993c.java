import java.util.*;
import java.io.*;
public class Solution{
   public static void main(String[] main) throws Exception{
      Scanner s = new Scanner(System.in);
      int t = s.nextInt();
      for(int trial = 1; trial <= t; trial++){
         int N = s.nextInt();
         int trace = 0;
         ArrayList<HashSet<Integer>> rows = new ArrayList<HashSet<Integer>>(N);
         ArrayList<HashSet<Integer>> columns = new ArrayList<HashSet<Integer>>(N);
         HashSet<Integer> er = new HashSet<Integer>(); 
         HashSet<Integer> ec = new HashSet<Integer>(); 
         for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++){
               int next = s.nextInt();
               if(j == 0)
                  rows.add(new HashSet<Integer>());
               if(i == 0)
                  columns.add(new HashSet<Integer>());
               if(rows.get(i).contains(next))
                  er.add(i);
               rows.get(i).add(next);
               if(columns.get(j).contains(next))
                  ec.add(j);
               columns.get(j).add(next);
               if(i == j)
                  trace += next;
            }
         System.out.println("Case #" + trial + ": " + trace + " " + er.size() + " " + ec.size());
      }
   }
}