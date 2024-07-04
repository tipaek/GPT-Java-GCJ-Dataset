import java.util.*;
import java.io.*;
public class vestigium{
   public static void main(String[] main) throws Exception{
      Scanner s = new Scanner(System.in);
      int t = s.nextInt();
      for(int trial = 1; trial <= t; i++){
         int N = s.nextInt();
         int trace = 0;
         HashSet<Integer>[] rows = new HashSet<Integer>()[N];
         HashSet<Integer>[] columns = new HashSet<Integer>()[N];
         HashSet<Integer> er = new HashSet<Integer>(); 
         HashSet<Integer> ec = new HashSet<Integer>(); 
         for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++){
               int next = s.nextInt();
               if(rows[i].contains(next))
                  er.add(i);
               rows[i].add(next);
               if(column[j].contains(next))
                  ec.add(j);
               columns[j].add(next);
               if(i == j)
                  trace += s;
            }
         System.out.println("Case #" + trial + ": " + trace + " " + er.size() + " " + ec.size());
      }
   }
}
  