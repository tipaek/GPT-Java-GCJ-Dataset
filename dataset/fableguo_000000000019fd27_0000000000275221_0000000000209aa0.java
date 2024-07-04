import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        // String input = "";
        // input = in.nextLine();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
            int target = in.nextInt();
            String res = "IMPOSSIBLE";
            int[][] map = new int[n][n];
            if(dfs(map, target, 0, 0)){
                res = "POSSIBLE";
                System.out.println("Case #" + i + ": " + (res));
                for(int j = 0; j < n; j++){
                    System.out.print(map[j][0]+" ");
                    for(int k = 1; k < n; k++){
                        System.out.print(map[j][k]+" ");
                    }
                    System.out.println();
                }
            }else{
                System.out.println("Case #" + i + ": " + (res));
            }
        }
      }
      public static boolean dfs(int[][] map, int target, int curSum, int index){
          int n = map.length;
        //   System.out.println(curSum+" "+index);
          if(index == n*n && target == curSum)
            return true;
          if(index == n*n || target <= curSum)
            return false;
          int x = index/n;
          int y = index%n;
          for(int i = 1; i <= map.length; i++){
              if(isValid(map, target, curSum, i, index)){
                  map[x][y] = i;
                  if(x==y)
                    curSum = curSum+i;
                  if(dfs(map, target, curSum, index+1))
                    return true;
                  if(x==y)
                    curSum = curSum-i;
                  map[x][y] = 0;
              }
          }
          return false;
      }
      public static boolean isValid(int[][] map, int target, int curSum, int newInt, int index){
            int n = map.length;
            int x = index/n;
            int y = index%n;
            for(int i = 0; i < n; i++){
                if(map[x][i] == newInt) return false;
                if(map[i][y] == newInt) return false;
            }
        
            if(x == y && target < curSum+newInt)
                return false;
            return true;
      }
    }
  
  
  /*
  
  2431
  3142
  1324
  4213
  
  4 6 8 9 10 11 12 16
  
  
  */