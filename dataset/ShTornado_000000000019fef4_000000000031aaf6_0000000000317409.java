import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {
public static void findPath(int x, int y, String M, int caseNum){
    if(x ==0 && y == 0){
        System.out.println("Case #"+caseNum+": "+"0");
    }
    for(int i = 0 ; i < M.length(); i++){
        if(M.charAt(i) == 'S'){
            y--;
        }
        if(M.charAt(i) == 'N'){
            y++;
        }
        if(M.charAt(i) == 'E'){
            x++;
        }
        if(M.charAt(i) == 'W'){
            x--;
        }
        if(Math.abs(x) + Math.abs(y) <= i+1){
            System.out.println("Case #"+caseNum+": "+(i+1));
            return;
        }
    }
    System.out.println("Case #"+caseNum+": IMPOSSIBLE");
    
}
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int x = in.nextInt();
      int y = in.nextInt();
      String M = in.next();
      findPath(x, y, M, i);
    }
  }
}