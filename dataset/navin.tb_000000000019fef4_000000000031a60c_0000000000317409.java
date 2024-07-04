import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  
  public static class Pair{
    int x;
    int y;
    public Pair(int key, int value) {
      this.x = key;
      this.y = value;
    }
  }
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int testCases = in.nextInt();
    for(int t=1;t<=testCases;t++) {
      int x = in.nextInt();
      int y = in.nextInt();
      String path = in.next();
      System.out.println("Case #"+t+": "+minPath(x,y,path));
    }
  }
  
  public static String minPath(int x, int y, String path) {
    if(x==0 && y==0) {
      return "0";
    }
    int[][] moves = {{0,0}, {0,1}, {0,-1}, {1,0}, {-1,0}};
    LinkedList<Pair> q = new LinkedList<>();
    q.add(new Pair(0,0));
    for(int i=0;i<path.length();i++) {
      if(path.charAt(i) == 'N') {
        y++;
      }
      if(path.charAt(i) == 'S') {
        y--;
      }
      if(path.charAt(i) == 'E') {
        x++;
      }
      if(path.charAt(i) == 'W') {
        x--;
      }
      int size = q.size();
      for(int j=0;j<size;j++) {
        Pair pair = q.remove();
        for(int k=0;k<moves.length;k++) {
          
          Pair newPair = new Pair(pair.x + moves[k][0], pair.y + moves[k][1]);
          if(newPair.x == x && newPair.y == y) {
            return ""+(i+1);
          }
          q.add(newPair);
        }
      }
    }
    return "IMPOSSIBLE";
  }
}