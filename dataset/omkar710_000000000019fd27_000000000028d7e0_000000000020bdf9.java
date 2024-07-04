import java.io.*;
import java.util.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();

    for (int i = 0; i < t; i++) {

      int n = in.nextInt();

      List<List<Integer>> arr = new ArrayList<>(); // arraylist to preserve order
      HashMap<List<Integer>, Character> map = new HashMap<>(); // to know who's assigned an activity
      boolean imp_flag = false; // To check impossibilities

      for(int j = 0; j < n; j++) {

        ArrayList<Integer> time = new ArrayList<>();
        time.add(in.nextInt());
        time.add(in.nextInt());
        time.add(j);
        arr.add(time);
        map.put(time, 'C');

        if(time.get(0) >= time.get(1)) {
          imp_flag = true;
        }
      }

      List<List<Integer>> cloned = (List<List<Integer>>) ((ArrayList<List<Integer>>) arr).clone();

      Collections.sort(cloned, new Comparator<List<Integer>>() {
        @Override
        public int compare(List<Integer> o1, List<Integer> o2) {
          return o1.get(0).compareTo(o2.get(0));
        }
      });


      for(int j = 0; j < cloned.size(); j++) {

        //System.out.println("Iteration "+ (j+1) + ": " + cloned.get(j));

        int a1 = cloned.get(j).get(0);
        int a2 = cloned.get(j).get(1);
        //System.out.println("Start: " +a1 + " End: " +a2 +" ");

        for(int k = 0; k < cloned.size(); k++) {

          if(cloned.get(j) == cloned.get(k)) {
            continue;
          }

          //System.out.println("Activity being compared to: " + cloned.get(k));

          int b1 = cloned.get(k).get(0);
          int b2 = cloned.get(k).get(1);
          //System.out.println("Start: " + b1 + " End: " +b2);

          // If overlapping
          if(Math.max(a2,b2) - Math.min(a1,b1) < (a2-a1)+(b2-b1)) {
            //System.out.println(cloned.get(j) + " overlaps with " + cloned.get(k));
            if(map.get(cloned.get(j)) == 'C') {
              //System.out.println("Change made to J");

              map.put(cloned.get(k), 'J');
            }

            // If multiple conflicts
            if(map.get(cloned.get(j)) == 'J' && map.get(cloned.get(k)) == 'J') {
              imp_flag = true;
              break;
            }
          }
        }
        if(imp_flag) {
          break;
        }
      }

      String output = "";

      if(imp_flag) {
        output = "IMPOSSIBLE";
      } else {
        StringBuffer sb = new StringBuffer();

        for(int j = 0; j < arr.size(); j++) {
          sb.append(map.get(arr.get(j)));
        }
        output = sb + "";
      }

      System.out.printf("Case #%d: ", i+1);
      System.out.println(output);

    }
  }
}
