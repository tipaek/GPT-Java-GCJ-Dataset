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



      for(int j = 0; j < arr.size(); j++) {

        //System.out.println("Iteration "+ (j+1) + ": " + arr.get(j));

        int a1 = arr.get(j).get(0);
        int a2 = arr.get(j).get(1);
        //System.out.print("Start: " +a1 + " End: " +a2 +" ");

        for(int k = 0; k < arr.size(); k++) {

          //System.out.println("Activity being compared to: " + arr.get(k));

          if(arr.get(j) == arr.get(k)) {
            continue;
          }

          int b1 = arr.get(k).get(0);
          int b2 = arr.get(k).get(1);
          //System.out.println("Start: " + b1 + " End: " +b2);

          // If overlapping
          if(Math.max(a2,b2) - Math.min(a1,b1) < (a2-a1)+(b2-b1)) {
            //System.out.println(arr.get(j) + " overlaps with " + arr.get(k));
            if(map.get(arr.get(j)) == 'C') {
              //System.out.println("Change made to J");
              map.put(arr.get(k), 'J');
            }
            // If multiple conflicts
            if(map.get(arr.get(j)) == 'J' && map.get(arr.get(k)) == 'J') {
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
