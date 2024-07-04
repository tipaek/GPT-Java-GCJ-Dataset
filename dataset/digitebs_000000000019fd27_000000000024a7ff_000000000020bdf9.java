import java.util.*;
import java.io.*;
public class Solution {
      static String schedule(List<int[]> orig) {
    int[] j = null; // empty;
    int[] c = null; // empty

    List<int[]> lists = new ArrayList<>(orig); // clone object
    Collections.sort(lists, (a,b) -> {
      int  r = a[0] - b[0];
      if(r == 0) return a[1]-b[1];
      else return r;
    });

    Map<int[], String> hm = new HashMap<>();
   // lists.forEach(x -> System.out.println(Arrays.toString(x)));
    StringBuilder sb = new StringBuilder();
    for (int[] i : lists) {
      if (j == null || j[1] <= i[0]) {
        j = i;
        hm.put(i, "C");
        //sb.append("C"); // okay
      }
      else if (c == null || c[1] <= i[0]) {
        c = i;
        hm.put(i, "J");
       // sb.append("J"); // okay
      }
      else return "IMPOSSIBLE";
    }

    for(int[] i: orig){
      sb.append(hm.get(i)); //match using equals?
    }
    return sb.toString();
  }
  
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int k = in.nextInt();
      List<int[]> lists = new ArrayList<>();
      while(k-- > 0){
        int[] arr = new int[2];
        arr[0] = in.nextInt();
        arr[1] = in.nextInt();
        lists.add(arr);
      }
      String r = schedule(lists);
      System.out.println("Case #" + i + ": "+ r);
    }
  }
}