/*1 100
2 5
99 150
100 301
150 250*/
import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int m = in.nextInt(); //list size
      Map<Integer,Integer> map = new TreeMap<Integer, Integer>();
      fillMap(map, m, in);
      String res = calSlot(map, m);
      System.out.println("Case #" + i + ": " + res);
    }
  }
  
  public static void fillMap(Map<Integer,Integer> map, int size, Scanner in){
    String scan;
    String[] row;
    in.nextLine();
    for(int i=0; i<size; i++){
        scan = in.nextLine();
        row = scan.split(" ");
        map.put(new Integer(row[0]),new Integer(row[1]));
    }
  }
  
  public static String calSlot(Map<Integer,Integer> map, int size){
      StringBuffer s = new StringBuffer(size);
      int[] cjLimit = new int[2];
      for (Map.Entry m: map.entrySet()) {
          if(cjLimit[0] < (int) m.getKey()){
              cjLimit[0] = (int) m.getValue();
              s.append('C');
          } else if(cjLimit[1] < (int)m.getKey()){
              cjLimit[1] = (int)m.getValue();
              s.append('J');
          } else {
              return "IMPOSSIBLE";
          }
      }
      return s.toString();
    } 
}