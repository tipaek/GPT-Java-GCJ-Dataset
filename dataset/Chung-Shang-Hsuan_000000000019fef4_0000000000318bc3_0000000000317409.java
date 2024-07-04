import java.util.*;
import java.lang.Math;

public class Solution{

  int x;
  int y;
  String s;

  public Solution(int east, int north, String tour){
    x = east;
    y = north;
    s = tour;
  }

  public String calculate(){
    int curx = x;
    int cury = y;
    for (int i = 0; i <= s.length(); i ++){
      if (Math.abs(curx) + Math.abs(cury) <= i) return Integer.toString(i);
      if (i == s.length()) break;
      if (s.charAt(i) == 'N'){
        cury ++;
      }else if (s.charAt(i) == 'S'){
        cury --;
      }else if (s.charAt(i) == 'E'){
        curx ++;
      }else if (s.charAt(i) == 'W'){
        curx --;
      }
    }
    return "IMPOSSIBLE";
  }

  public static void main(String args[]){
    Scanner sc1 = new Scanner(System.in);
    int cases = sc1.nextInt();
    for (int c = 1; c < cases+1; c ++){
      int x = sc1.nextInt();
      int y = sc1.nextInt();
      String s = sc1.nextLine();
      Solution b = new Solution(x,y,s);
      System.out.println("Case #" + c + ": " + b.calculate());
    }
  }
}
