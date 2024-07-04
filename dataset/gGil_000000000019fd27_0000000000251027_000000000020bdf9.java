import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      solve(in, i);
      //System.out.println("Case #" + i + ": " + (n + m) + " " + (n * m));
    }
  }
  
  public static void solve(Scanner in, int cases){
     int size = in.nextInt();
     
     ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
     int[][] values = new int[size][2];
     int[] colors = new int[size];
     for(int i = 0; i < size; i++){
         graph.add(new ArrayList<Integer>());
         values[i][0] = in.nextInt();
         values[i][1] = in.nextInt();
         colors[i] = -1;
     }
     
     for(int i = 0; i < size; i++){
         for(int j = 0; j < size; j++){
             if(values[j][0] < values[i][0] && values[i][0] < values[j][1]){
                 if(!graph.get(i).contains(j)){
                     graph.get(i).add(j);
                     graph.get(j).add(i);
                 }
                 
             }else if(values[j][0] < values[i][1] && values[i][1] < values[j][1]){
                 if(!graph.get(i).contains(j)){
                     graph.get(i).add(j);
                     graph.get(j).add(i);
                 }
             }else if(values[j][0] == values[i][0] && values[i][1] == values[j][1] && j != i){
                if(!graph.get(i).contains(j)){
                     graph.get(i).add(j);
                     graph.get(j).add(i);
                 }
             } 
             
             
        }
     }
     boolean check = true;
     
     for(int i = 0; i < size; i++){
         if(colors[i] == -1){
             colors[i] = 0;
             check = explore(colors, i, graph);
         }
         if(!check){
            System.out.println("Case #" + cases + ": IMPOSSIBLE"); 
            return;
         }
         
     }
     String ans = "";
     for(int i = 0; i < size; i++){
         if(colors[i] == 0) ans += "C";
         if(colors[i] == 1) ans += "J";
         
     }
     
     System.out.println("Case #" + cases + ": " + ans); 
     
  }
  
  public static boolean explore(int[] colors, int index, ArrayList<ArrayList<Integer>> graph){
      for(int i = 0; i < graph.get(index).size(); i++){
          if(colors[graph.get(index).get(i)] != -1){
              if(colors[index] == colors[graph.get(index).get(i)]){
                  return false;
              }else{
                  continue;
              }
          }
          if(colors[graph.get(index).get(i)] == -1){
              colors[graph.get(index).get(i)] = (colors[index] + 1)%2;
              if(!explore(colors, i, graph)){
                  return false;
              }
          }
      }
      return true;
  }
}