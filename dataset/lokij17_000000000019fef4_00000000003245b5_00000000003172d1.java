import java.util.*;

import static java.lang.Math.abs;
import static java.lang.Math.min;
import static java.lang.Math.pow;

class Solution {

  static class  Pair {
    int a,b;

    public Pair(int a, int b) {
      this.a = a;
      this.b = b;
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int T = in.nextInt();
    for (int t = 0; t < T; t++) {
      int N = in.nextInt();
      int D = in.nextInt();

      ArrayList<Long> arr = new ArrayList<>();
      for (int i = 0; i < N; i++) {
        arr.add(in.nextLong());
      }

      Collections.sort(arr);

      TreeMap<Long, Long> sliceMap = new TreeMap<>();
      for (int i = 0; i < arr.size(); i++) {
        sliceMap.compute(arr.get(i), (k, v) -> v != null ? v + 1 : 1);
      }

      //print(sliceMap);
      long cuts = D - 1;
      for (Map.Entry<Long, Long> entry : sliceMap.entrySet()) {
        cuts = min(getSlices(entry.getKey(), sliceMap, D), cuts);
      }
      System.out.println("Case #" + (t + 1) + ": " + cuts);
    }
  }

  private static void print(TreeMap<Long, Long> sliceMap) {
    for (Map.Entry<Long, Long> entry : sliceMap.entrySet()) {
      System.err.println("k "+entry.getKey() + " v "+entry.getValue());
    }
  }

  private static long getSlices(Long key, TreeMap<Long, Long> sliceMap, int D) {
    Long val = sliceMap.get(key);
    if (val >= D) {
      return 0;
    }
    long cuts = 0;
    for (Map.Entry<Long, Long> entry : sliceMap.entrySet()) {
      if (entry.getKey() % key == 0 && entry.getKey() > key) {
        long slicePerKey = (entry.getKey()/key);
        long keysReqd = ((D - val)/slicePerKey);
        cuts += (slicePerKey - 1) * Math.min(entry.getValue(), keysReqd);
        val += slicePerKey*Math.min(entry.getValue(), keysReqd);
//        System.err.println(
//            "k " + key + " " + entry.getKey() + " slicePErKey " + slicePerKey
//                + " keysReqd " + keysReqd + " cuts " + cuts + " val " + val);
      }
    }
    if (val < D) {
      cuts += D - val;
    }
    return cuts;
  }

}