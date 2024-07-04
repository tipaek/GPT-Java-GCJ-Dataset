import java.util.*;
import java.io.*;
import java.util.ArrayList;

    public class Solution {
      static List<List<Integer>> trig = null;
      static List<List<Boolean>> visited = null;
      static int[][] dirs = {{1,1},{1,0},{0,1},{0, -1}, {-1,0}, {-1,-1}};
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        
        for (int i = 1; i <= t; ++i) {
          int N = in.nextInt();
          init();
          System.out.println("Case #" + i + ":"); 
          List<int[]> path = new ArrayList();
          helper(N, 0 , 0, path);
          output(path);
        }
    }
   public static void init(){
        trig = new ArrayList();
        trig.add(new ArrayList(Arrays.asList(1)));
        visited = new ArrayList();
        visited.add(new ArrayList(Arrays.asList(false)));
        
        for(int i = 1; i <= 100; ++i){
            List<Integer> pre = trig.get(i - 1);
            List<Integer> cur = new ArrayList(Arrays.asList(1));
            List<Boolean> cur_visited = new ArrayList(Arrays.asList(false));
            
            for(int j = 1; j < i; ++j){
                cur.add(pre.get(j - 1) + pre.get(j));
                cur_visited.add(false);
            }
            
            cur.add(1);
            cur_visited.add(false);
            trig.add(cur);
            visited.add(cur_visited);
        }
    }
    
    public static boolean helper(int N, int r, int c, List<int[]> path){
        if(N == 0){
            return true;
        }else{
            for(int d = 0; d < dirs.length; ++d){
                int next_r = r + dirs[d][0];
                int next_c = c + dirs[d][1];
                //System.out.println(next_r + " " + next_c + " " + visited.get(next_r).size() + " " + trig.get(next_r).size());
                if(next_r >= 0 && next_c >= 0 && next_r < trig.size() 
                      && next_c <= next_r && visited.get(next_r).get(next_c) == false){
                   path.add(new int[]{next_r, next_c});
                   visited.get(next_r).set(next_c, true);
                   boolean res = helper(N - trig.get(next_r).get(next_c), next_r, next_c, path);
                   if(res == true) return true;
                   visited.get(next_r).set(next_c, false);
                   path.remove(path.size() - 1);
                }
                
            }
        }
        
        return false;
    }
    
    public static void output(List<int[]> res){
        for(int i = 0; i < res.size(); ++i){
            System.out.println(res.get(i)[0] + " " + res.get(i)[1]);
        }
    }
    }