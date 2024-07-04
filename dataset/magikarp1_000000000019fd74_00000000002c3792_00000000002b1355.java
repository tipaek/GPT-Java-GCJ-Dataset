import java.util.*;
import java.io.*;
public class Solution{
   static HashMap<Integer,HashSet<Integer>> nb = new HashMap<Integer,HashSet<Integer>>();
   public static void main(String[] main) throws Exception{
      BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
      //StringTokenizer st = new StringTokenizer(b.readLine());
      int t = Integer.parseInt(b.readLine());
      for(int trial = 1; trial <= t; trial++){
         StringTokenizer st = new StringTokenizer(b.readLine());
         HashMap<Integer,HashSet<Integer>> nb = new HashMap<Integer,HashSet<Integer>>();
         int R = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken());
         int[][] floor = new int[R][C];
         int sum = 0;
         int total = 0;
         for(int i = 0; i < R; i++){
            st = new StringTokenizer(b.readLine());
            for(int j = 0; j < C; j++){
               floor[i][j] = Integer.parseInt(st.nextToken());
               sum += floor[i][j];
               HashSet<Integer> temp = new HashSet<Integer>();
               if(j < C-1)
                  temp.add(C*i + j+1);
               if(j > 0)
                  temp.add(C*i + j - 1);
               if(i < R-1)
                  temp.add(C*i + j+C);
               if(i > 0)
                  temp.add(C*i + j - C);
               nb.put(C*i + j, temp);
            }
         }
         int removed = 1;
         do{total += sum;
         removed = round(floor);
         /*for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++)
               System.out.print(floor[i][j]);
            System.out.println();
         }*/
         sum -= removed;}while(removed != 0);
         System.out.println("Case #" + trial + ": " + total);
      }
   }
   public static int round(int[][] floor){
      int R = floor.length, C = floor[0].length;
      int removed = 0;
      HashSet<Integer> willrem = new HashSet<Integer>();
      for(int i = 0; i < R; i++)
         for(int j = 0; j < C; j++)
            if(floor[i][j] != 0 && nb.get(i*C + j).size() > 0){
               int sum = 0;
               for(int k: nb.get(i*C + j)){
                  sum += floor[k/C][k%C];
               }
               if(sum > floor[i][j]*nb.get(i*C+j).size()){
                  willrem.add(i*C + j);
                  //remove(i,j, floor);
                  //removed += floor[i][j];
                  //floor[i][j] = 0;
               }
            }
      for(int k: willrem){
         int i = k/ C, j = k%C;
         remove(i,j, floor);
         removed += floor[i][j];
         floor[i][j] = 0;
      }
      return removed;
   }
   public static void remove(int i, int j, int[][] floor){
      int R = floor.length, C = floor[0].length;
      for(int k:nb.get(i*C + j)){
         //System.out.println(k);
         int diff = k - i*C - j;
         nb.get(k).remove(i*C + j);
         if(diff > 0 && diff < C)
            for(int l:nb.get(i*C + j)){
               int diff1 = l-i*C - j;
               if(diff1 < 0 && diff1 > -C){
                  //System.out.println(l + "asf");
                  nb.get(k).add(l);
               }
            }
         else if(diff < 0 && diff > -C)
            for(int l:nb.get(i*C + j)){
               int diff1 = l-i*C - j;
               if(diff1 > 0 && diff1 < C){
                  nb.get(k).add(l);
               }
            }
         else if(diff > 0)
            for(int l:nb.get(i*C + j)){
               int diff1 = k-i*C - j;
               if(diff1 <= -C){
                  nb.get(k).add(l);
               }
            }
         else if(diff < 0)
            for(int l:nb.get(i*C + j)){
               int diff1 = k-i*C - j;
               if(diff1 >= C){
                  nb.get(k).add(l);
               }
            }
        }
        
   }
}