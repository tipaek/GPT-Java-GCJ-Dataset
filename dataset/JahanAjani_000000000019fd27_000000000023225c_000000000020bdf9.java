import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int m = in.nextInt(); //list size
      Map<Integer,Integer[]> map = new TreeMap<Integer, Integer[]>();
      fillMap(map, m, in);
      String res = calSlot(map, m);
      System.out.println("Case #" + i + ": " + res);
    }
  }
  
  public static void fillMap(Map<Integer,Integer[]> map, int size, Scanner in){
    String scan;
    String[] row;
    in.nextLine();
    int cnt = 0;
    for(int i=0; i<size; i++){
        scan = in.nextLine();
        row = scan.split(" ");
        Integer[] val = new Integer[2];
        val[0] = new Integer(row[1]);
        val[1] = ++cnt;
        map.put(new Integer(row[0]),val);
    }
  }
  
  public static String calSlot(Map<Integer,Integer[]> map, int size){
      StringBuffer s = new StringBuffer(size);
      int[] cjLimit = new int[2];
      Map<Integer, Character> resMap = new TreeMap<Integer,Character>();
      for (Map.Entry m: map.entrySet()) {
          if(cjLimit[0] <= (int) m.getKey()){
              Integer[] val = (Integer[])m.getValue();
              cjLimit[0] = (int) val[0];
              resMap.put(val[1], 'C');
          } else if(cjLimit[1] <= (int)m.getKey()){
              Integer[] val = (Integer[])m.getValue();
              cjLimit[1] = (int) val[0];
              resMap.put(val[1], 'J');
          } else {
              return "IMPOSSIBLE";
          }
      }
      for(Map.Entry m: resMap.entrySet()){
          s.append((char)m.getValue());
      }
      return s.toString();
    } 
}