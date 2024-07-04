import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int testCases = in.nextInt();
    for(int i=1;i<=testCases;i++) {
      long x = in.nextLong();
      long y = in.nextLong();
      System.out.println("Case #" + i + ": " + findPath(x,y));
    }
  }
  
  public static String findPath(long x, long y) {
    if(x % 2 !=0 && y%2 != 0) {
      return "IMPOSSIBLE";
    }
    int[][] moves = {
      {0,1},{0,-1},{1,0},{-1,0}
    };
    char[] directions = {'N','S','E','W'};
    Map<Pair, String> map = new HashMap<>();
    LinkedList<Pair> queue = new LinkedList<>();
    Pair first = new Pair(0,0);
    map.put(first, "");
    queue.add(first);
    long distance = 1;
    loop:
    while(!queue.isEmpty()) {
      int size = queue.size();
      for(int t=0;t<size;t++) {
        Pair pair = queue.remove();
        String path = map.get(pair);
        if(path.length() >= 9) {
          break loop;
        }
        for(int i=0;i<4;i++) {
          long newX = pair.x + moves[i][0] * distance;
          long newY = pair.y + moves[i][1] * distance;
          String newPath = path + directions[i];
          // System.out.println(newPath +" "+newX+" "+newY);
          if(newX == x && newY ==y) {
            return newPath;
          }
          if(!map.containsKey(new Pair(newX, newY))){
            Pair newPair = new Pair(newX, newY);
            map.put(newPair, newPath);
            queue.add(newPair);
          }
                      
        }
      }
      distance *=2;
      
    }
    return "IMPOSSIBLE";
  }
  
  public static boolean distance(long x1, long y1, long x2, long y2, long x, long y ) {
    if(y!=y1 && Math.abs(x-x1) > Math.abs(x-x2)) {
      return false;
    }
    if(x != x1 && Math.abs(y-y1) > Math.abs(y-y2)) {
      return false;
    }
    return true;
  }
  
  public static class Pair {
    long x;
    long y;
    Pair(long x, long y) {
      this.x = x;
      this.y = y;
    }
    
    public boolean equals(Pair pair){
      return this.x==pair.x && y == pair.y;
    }
    
    public int hashCode(){
      return toString().hashCode();
    }
    
    public String toString(){
      return x +":"+y;
    }
  }
}
