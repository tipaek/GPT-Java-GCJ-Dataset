import java.util.*;
import java.io.*;
    
public class Solution {
   static long[][] pt;
   static boolean[][] visited;
   public static void main(String[] args) {
      Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
      int testCases = in.nextInt();
      for( int i=1; i<=testCases; i++ ) {
         int n = in.nextInt();          
         pt = new long[100][100];  
         visited = new boolean[100][100];
         
         pt[1][1] = 1;
         for( int r=2; r<pt.length-2; r++ ) {
            for( int c=1; c<=r; c++ ) {
               pt[r][c] = pt[r-1][c-1] + pt[r-1][c];
            }
         }
         List<List<Integer>> list = dfs(1, 1, n-1);
         
         
         System.out.println( "Case #" + i + ": ");
         if( list != null ) {
            for( int j=0; j<list.size(); j++ ) {
               System.out.println( list.get(j).get(0) + " " + 
                  list.get(j).get(1));// + ", val: " + 
                  //pt[list.get(j).get(0)][list.get(j).get(1)] );
            }
         }
         
         
         
         
      }
   }
   public static List<List<Integer>> dfs(int r, int c, long needed) {
      List<Integer> point = new ArrayList<>();
      point.add(r);
      point.add(c);

      List<List<Integer>> list = new ArrayList<>();
      if( needed < 0 || visited[r][c] ) return null;
      if( r<=0 || c<=0 || r>=pt.length-2 || c >= pt.length-2 ) return null;
      if( needed == 0 ) {
         list.add(point); 
         return list;  
      }     
      visited[r][c] = true;
      
      
      list = dfs(r+1,c, needed-pt[r+1][c]);
      if( list == null ) {
         list = dfs(r+1,c+1, needed-pt[r+1][c+1]);
         if( list == null ) {
            list = dfs(r,c+1, needed-pt[r][c+1]);
            if( list == null ) {
               list = dfs(r,c-1, needed-pt[r][c-1]);
               if( list == null ) {
                  list = dfs(r-1,c-1, needed-pt[r-1][c-1]);
                  if( list == null ) {
                     list = dfs(r-1,c, needed-pt[r-1][c]);
                  }               
               }
            }         
         }
      }
      if( list != null ) {
         list.add(0, point);
      }
      visited[r][c] = false;
      return list;      
   }
}
  