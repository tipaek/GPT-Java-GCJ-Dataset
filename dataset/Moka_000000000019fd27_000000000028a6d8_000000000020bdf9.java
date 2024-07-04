
import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int m = in.nextInt(); //list size
      Map<Integer,List<Integer[]>> map = new TreeMap<Integer, List<Integer[]>>();
      fillMap(map, m, in);
      String res = calSlot(map, m);
      System.out.println("Case #" + i + ": " + res);
    }
  }
 
  public static void fillMap(Map<Integer,List<Integer[]>> map, int size, Scanner in){
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
        Integer k  = new Integer(row[0]);
        if (map.containsKey(k)){
           List<Integer[]> li = map.get(k);
           li.add(val);
           map.put(k,li);
        } else {
            List<Integer[]> lis = new ArrayList<>();
            lis.add(val);
            map.put(k,lis);
        }
    }
  }
 
  public static String calSlot(Map<Integer,List<Integer[]>> map, int size){
      StringBuffer s = new StringBuffer(size);
      int[] cjLimit = new int[2];
      Map<Integer, Character> resMap = new TreeMap<Integer,Character>();
      for (Map.Entry m: map.entrySet()) {
          List<Integer[]> li  = (List<Integer[]>)m.getValue();
          if (li.size() > 2) {
              return "IMPOSSIBLE";
          }
         
          for(int i=0; i<li.size(); i++){
              Integer[] val = li.get(i);
              String r = createString(cjLimit, (int) m.getKey(), val, resMap);
              if( r != null){
                  return r;
              }
          }
      }
      for(Map.Entry m: resMap.entrySet()){
          s.append((char)m.getValue());
      }
      return s.toString();
    }
   
  public static String createString(int[] cjLimit, int key, Integer[] value, Map<Integer, Character> resMap){
        if(cjLimit[0] <= key){
              cjLimit[0] = (int) value[0];
              resMap.put(value[1], 'C');
          } else if(cjLimit[1] <= key){
              cjLimit[1] = (int) value[0];
              resMap.put(value[1], 'J');
          } else {
              return "IMPOSSIBLE";
          }
          return null;
    }
}