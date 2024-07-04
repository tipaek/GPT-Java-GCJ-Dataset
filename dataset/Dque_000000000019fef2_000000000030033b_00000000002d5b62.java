//make sure to make new file!
import java.io.*;
import java.util.*;

public class Solution{
   
   public static void main(String[] args)throws IOException{
      BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter out = new PrintWriter(System.out);
      
      int t = Integer.parseInt(f.readLine());
      
      for(int q = 1; q <= t; q++){
      
         StringTokenizer st = new StringTokenizer(f.readLine());
      
         int n = Integer.parseInt(st.nextToken());
         int m = Integer.parseInt(st.nextToken());
         
         Queue<State> qs = new LinkedList<State>();
         
         boolean found = false;
         qs.add(new State(0,0,""));
         
         int THRESH = 9;
         
         int[] pow2 = new int[THRESH+1];
         pow2[0] = 1;
         for(int k = 1; k <= THRESH; k++){
            pow2[k] = 2*pow2[k-1];
         }
         
         
         
         while(!qs.isEmpty()){
            State s = qs.poll();
            if(s.x == n && s.y == m){
               out.println("Case #" + q + ": " + s.s);
               found = true;
               break;
            }
            
            if(s.s.length() >= THRESH){
               break;
            }
            
            int i = s.s.length();
         
            qs.add(new State(s.x-pow2[i],s.y,s.s+"W"));
            qs.add(new State(s.x+pow2[i],s.y,s.s+"E"));
            qs.add(new State(s.x,s.y-pow2[i],s.s+"S"));
            qs.add(new State(s.x,s.y+pow2[i],s.s+"N"));
         }
         
         if(!found){
            out.println("Case #" + q + ": IMPOSSIBLE");
         }
         
         
      }
      
      
      
      
      out.close();
   }
   
   public static class State{
      int x;
      int y;
      String s;
      public State(int a, int b, String c){
         x = a;
         y = b;
         s = c;
      }
   }
      
}