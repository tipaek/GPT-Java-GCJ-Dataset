import java.util.*;
import java.io.*;
public class Solution {
  

public static String process(int[][] interval, int activites){
  Arrays.sort(interval, (a,b) -> a[0] - b[0]);
  
    StringBuilder out = new StringBuilder();
    HashMap<Integer, Integer> map = new HashMap<>();
    Stack<Integer> stack = new Stack<>();
    map.put(1,interval[0][1]);
    stack.push(1);
    for(int i = 1; i < activites;i++){
      
      //int curr = interval[i-1][0];
      //int curr_end = interva[i-1][1];
      int curr_begin = interval[i][0];
      int curr_end = interval[i][1];
      
      int jCounter = map.get(1);
      int cCounter = map.getOrDefault(0, Integer.MAX_VALUE);
      int  samplej = Math.abs(curr_begin - jCounter);
      int samplec = Math.abs(curr_begin - cCounter);
      int see = 0;
      int num = 0;
      if(samplej < samplec){
        num = jCounter;
        see = 1;
      }else{
        num = cCounter;
        see = 0;
      }

      if(curr_begin < num)
      { 
        if(see == 1 && curr_begin < num){
          stack.push(0);
          map.put(0, curr_end);
        }else if(see == 0 && curr_begin > num){
          stack.push(1);
          map.put(1, curr_end);
        }
        else {
        	return "IMPOSSIBLE";
        }
      }

      else if(curr_begin >= num){
            if(see == 1){
              stack.push(1);
              map.put(1, curr_end);
          }else{
            stack.push(0);
            map.put(0, curr_end);
          }
      }
    }

    int crepeat = 0;
    int jrepeat = 0;
    while(!stack.isEmpty()){
      int e = stack.pop();
      if(crepeat == 3 || jrepeat == 3)
      {
        return "IMPOSSIBLE";
      } 
      if(e == 1){
        jrepeat++;
        if(crepeat != 0) crepeat = 0;
        out.append('J');
      }else{
        crepeat++;
        if(jrepeat != 0) jrepeat = 0;
        out.append('C');
      }
    }




    //dfs(interval, n, out, stack, map, 1);
/*  
  System.out.println();
    for(int a=0; a<activites; a++){
      for(int b=0; b<2;b++){
        System.out.print(interval[a][b]+ " ");
      }
      System.out.println();
    }
    */  
    return out.reverse().toString();
}


  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

    ArrayList<int[][]> asdf = new ArrayList<>();
    int[] act = new int[t];
    for (int i = 1; i <= t; ++i) {
      int activites = in.nextInt();
      int[][] interval = new int[activites][2];
      for(int a = 0; a<activites;a++ ){
        for(int b = 0; b < 2; b++){
            interval[a][b] = in.nextInt();
        }
      }
      asdf.add(interval);
      act[i-1] = activites;
      
    /*
      System.out.println("OUTPUTHERE");
      System.out.println(activites);
      for(int a=0; a<activites; a++){
        for(int b=0; b<2;b++){
          System.out.print(interval[a][b]+ " ");
        }
        System.out.println();
      }
      //int m = in.nextInt();
     //System.out.println("Case #" + i + ": " + (n + m) + " " + (n * m));
    }
    */
    }
    for(int i = 1;i <= t; i++){
      String ans = process(asdf.get(i-1), act[i-1]);
      System.out.println("Case #" + i + ": " + ans.trim());
    }
    
    
  }
}