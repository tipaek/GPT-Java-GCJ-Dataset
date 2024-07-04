import java.util.*;
import java.io.*;
public class Solution {

public static int powerTwo(int step){
    int val = 1;
    for(int i = 0 ; i < step-1 ; i++){
        val = val*2;
    }
    return val;
}

public static void printPath(int x, int y,int caseNum){
    for(int i = 1 ; i <=30 ; i++){
        String ans = findPath(x, y, i);
        if(ans!=null){
            System.out.println("Case #"+caseNum+": "+ans);
            return;
        }
    }
    System.out.println("Case #"+caseNum+": "+"IMPOSSIBLE");
}

public static String findPath(int x, int y, int step){
    
    if(step < 1){
        if(x == 0 && y == 0){
            return "";
        }
        else
            return null;
    }
    int val = powerTwo(step);
    // System.out.println(x+" "+y+"  "+step);
    if(x >= 2*val){
        return null;
    }
    if(y >= 2*val){
        return null;
    }
    if( x <= -2*val){
        return null;
    }
    if( y <= -2*val){
        return null;
    }
    String ans = new String();
    ans = findPath(x-val, y, step-1);
    if(ans!=null){
        return ans+'E';
    }
    ans = findPath(x+val, y, step-1);
    if(ans!=null){
        return ans+'W';
    }
    ans = findPath(x, y-val, step-1);
    if(ans!=null){
        return ans+'N';
    }
    ans = findPath(x, y+val, step-1);
    if(ans!=null){
        return ans+'S';
    }
    return null;
}
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int x = in.nextInt();
      int y = in.nextInt();
      printPath(x, y, i);
    //   System.out.println(powerTwo(3));
    //   System.out.println("Case #" + i + ": " + (n + m) + " " + (n * m));
    }
  }
}