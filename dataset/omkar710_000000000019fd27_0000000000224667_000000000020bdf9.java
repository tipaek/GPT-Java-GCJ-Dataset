import java.util.*;
import java.io.*;


public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();

    for (int i = 0; i < t; i++) {

      int n = in.nextInt();

      List<List<Integer>> arr = new ArrayList<>(); // arraylist to preserve order
      HashMap<List<Integer>, Character> map = new HashMap<>(); // to know who's assigned an activity

      for(int j = 0; j < n; j++) {

        ArrayList<Integer> time = new ArrayList<>();
        time.add(in.nextInt());
        time.add(in.nextInt());
        time.add(j);
        arr.add(time);
        map.put(time, 'C');
      }

      boolean imp_flag = false; // To check impossibilities


      for(int j = 0; j < arr.size(); j++) {

        int a1 = arr.get(j).get(0);
        int a2 = arr.get(j).get(1);

        for(int k = j+1; k < arr.size(); k++) {

          int b1 = arr.get(k).get(0);
          int b2 = arr.get(k).get(1);

          if (Math.max(a2, b2) - Math.min(a1, b1) < (a2 - a1) + (b2 - b1)) {
            if(map.get(arr.get(j)) == 'J' && map.get(arr.get(k)) == 'J') {
              imp_flag = true;
              break;
            } else if (map.get(arr.get(j)) == 'C'){
              map.put(arr.get(k), 'J');
            }
          }
        }
        if(imp_flag) {
          break;
        }
      }

      System.out.printf("Case #%d: ", i+1);

      if(imp_flag) {
        System.out.println("IMPOSSIBLE");
      } else {
        StringBuilder sb = new StringBuilder();

        for(int j = 0; j < arr.size(); j++) {
          sb.append(map.get(arr.get(j)));
        }
        System.out.println(sb);
      }
    }
  }
}