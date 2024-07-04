 import java.util.*;
import java.io.*;
public class Solution {
    
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int tc = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= tc; ++i) {
      int x = in.nextInt();
      int y = in.nextInt();
      String tour = in.next();
      int rtime = 0;
      
      if(x!=0||y!=0){
        rtime = -1;
        for(int j = 0;j<tour.length();j++){
          char t = tour.charAt(j);
          if(t=='N')y++;
          if(t=='S')y--;
          if(t=='E')x--;
          if(t=='W')x++;
          int sum =  Math.abs(x)+Math.abs(y);
          if(sum<=j+1){
              rtime = j+1;
              break;
          }
        }
      }
      
      if(rtime!=-1)
        System.out.println("Case #" + i + ": " +rtime);
      else
        System.out.println("Case #" + i + ": IMPOSSIBLE");
    }
  }
  
} 