import java.util.*;
import java.lang.Math;

class Solution{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    for(int i=1; i<=t; i++){
      int X = in.nextInt();
      int Y = in.nextInt();
      String M = in.next();
      System.out.println("Case #"+i+": "+solve(X,Y,M));
    }
  }

    private static String solve(int X, int Y, String M){
      int currentEast = X;
      int currentNorth = Y;
      int minDistance = Math.abs(X) + Math.abs(Y);
      int t = 1;
      for(int i=0; i<M.length(); i++){
        if(M.charAt(i) == 'N'){
          currentNorth += 1;
        }
        else if(M.charAt(i) == 'S'){
          currentNorth -= 1;
        }
        else if(M.charAt(i) == 'E'){
          currentEast += 1;
        }
        else if(M.charAt(i) == 'W'){
          currentEast -= 1;
        }

        int currentDistance = Math.abs(currentEast) + Math.abs(currentNorth);
        if(currentDistance <= t){
          return ""+t;
        }
        t++;
      }
      return "IMPOSSIBLE";
    }
}
