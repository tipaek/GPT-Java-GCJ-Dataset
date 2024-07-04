import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int pe = in.nextInt();
      int pn = in.nextInt();
      String pp = in.next();
      
      String timeToPic = converge(pe,pn,pp);
      System.out.println("Case #" + i + ": " + timeToPic);
    }
  }
  
  private static String converge(int x, int y, String path){
      //first intuition: use A*
      
      //another way would be to somehow 
      //determine the time it would take to 
      //intersect and try to shortest path there.
      
      //another way could be to do some dp voodoo
      //maybe that would be able to say if impossible
      
      //***
      //there may be something we can get from knowing the 
      //NE's translating to making time longer
      
      int totalTime = path.length();
      int time = 0;
      
      int ttt = Math.abs(x) + Math.abs(y);
      
      //direction to time
      Map<Character,Integer> dtt = new HashMap<>();
      
      dtt.put('N',1);
      dtt.put('E',1);
      dtt.put('S',-1);
      dtt.put('W',-1);
      
      for(int i = 0; i < totalTime; i++){
          if(time >= ttt){
              return String.valueOf(time);
          }
          time++;
          
          char dir = path.charAt(i);
          
          if(dir == 'N' || dir == 'S'){
              y += dtt.get(dir);
          }else{
              x += dtt.get(dir);
          }
          
          ttt = Math.abs(x) + Math.abs(y);
      }
      if(time >= ttt){
          return String.valueOf(time);
      }
      
      return "IMPOSSIBLE";
  }
} 