import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();

    for (int case_t = 1; case_t <= t; case_t++) {
      
      int num = in.nextInt();

      boolean check = true;

      Map<Integer,int[]> map = new HashMap<Integer,int[]>();

      char[] output = new char[num]; 
      
      for (int i = 0; i < num; i++) {
      
        int start = in.nextInt();
        int stop = in.nextInt();

        map.put(i, new int[] {start,stop});      
      }

      ValueComparator bvc = new ValueComparator(map);
      TreeMap<Integer, int[]> sorted_map = new TreeMap<Integer, int[]>(bvc);
      TreeMap<Integer, int[]> sorted_map_2 = new TreeMap<Integer, int[]>(bvc);

      sorted_map.putAll(map);
      
      int round = 0;

      int start_1 = 0;
      int stop_1 = 0;

      int start_2 = 0;
      int stop_2 = 0;

      for(Integer key : sorted_map.keySet()){
        
        if(round == 0){

          //System.out.println("round 0");
          //System.out.println(key);
          //System.out.println(map.get(key)[0]);

          start_1 = map.get(key)[0];
          stop_1 = map.get(key)[1];
          
          output[key] = 'C';

          round++;

        } else {

          start_2 = map.get(key)[0];
          stop_2 = map.get(key)[1];

          if(start_2 < stop_1){

            sorted_map_2.put(key, new int[]{start_2, stop_2});

          } else {

            start_1 = start_2;
            stop_1 = stop_2;
          
            output[key] = 'C';            
          }
        }  
      }
      
      for(Integer key : sorted_map_2.keySet()){
      
        if(round == 1){

          start_1 = map.get(key)[0];
          stop_1 = map.get(key)[1];
          
          output[key] = 'J';

          round++;

        } else {

          start_2 = map.get(key)[0];
          stop_2 = map.get(key)[1];

          if(start_2 < stop_1){

            check = false;
            break;

          } else {

            start_1 = start_2;
            stop_1 = stop_2;
          
            output[key] = 'J';            
          }

        }
      
      }

      String final_out = "";
      for (int i = 0; i < num; i++) {
      
        final_out += output[i];
      
      }

      if(check==true)
        System.out.println("Case #" + case_t + ": " + final_out);
      else
        System.out.println("Case #" + case_t + ": IMPOSSIBLE" );
    }
  }
}

class ValueComparator implements Comparator<Integer> {
  Map<Integer, int[]> base;

  public ValueComparator(Map<Integer, int[]> base) {
      this.base = base;
  }

  public int compare(Integer a, Integer b) {
      if (base.get(a)[0] >= base.get(b)[0]) {
          return 1;
      } else {
          return -1;
      }
  }
}