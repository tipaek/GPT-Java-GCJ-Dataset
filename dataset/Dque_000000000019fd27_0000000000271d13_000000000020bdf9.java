//make sure to make new file!
import java.io.*;
import java.util.*;

public class Solution{
   
   public static void main(String[] args)throws IOException{
      BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter out = new PrintWriter(System.out);
      
      int t = Integer.parseInt(f.readLine());
      
      for(int q = 1; q <= t; q++){

         int n = Integer.parseInt(f.readLine());
      
         PriorityQueue<Task> pq = new PriorityQueue<Task>();
         for(int k = 0; k < n; k++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            pq.add(new Task(a,b,k));
         }
         
         char[] answer = new char[n];
         
         int j = -1;
         int c = -1;
         
         boolean fail = false;
         while(!pq.isEmpty()){
            Task tk = pq.poll();
            
            if(tk.s >= j){
               answer[tk.i] = 'J';
               j = tk.e;
            } else if(tk.s >= c){
               answer[tk.i] = 'C';
               c = tk.e;
            } else {
               fail = true;
               break;
            }
         }
         
         if(fail){
            out.println("Case #" + q + ": IMPOSSIBLE");
         } else {
            out.print("Case #" + q + ": ");
            for(int k = 0; k < n; k++){
               out.print(answer[k]);
            }
            out.println();
         } 

      }
      
      
      
      
      out.close();
   }
   
   public static class Task implements Comparable<Task>{
      int s;
      int e;
      int i;
      public Task(int a, int b, int c){
         s = a;
         e = b;
         i = c;
      }
      public int compareTo(Task t){
         return s-t.s;
      }
   }
      
}