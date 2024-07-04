
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long T = Integer.parseInt(sc.nextLine());
    for (int i = 0; i < T; i++) {
      int N = sc.nextInt();
      int D = sc.nextInt();
      long[] slices = new long[N];
      Long maxSize = Long.MIN_VALUE;
      boolean noNeedToSlice = false;
      Map<Long, Integer> sliceAngleCount = new HashMap<>();
      for (int j = 0; j < N; j++) {
        slices[j] = sc.nextLong();
        maxSize = Math.max(maxSize, slices[j]);
        Integer orDefault = sliceAngleCount.getOrDefault(slices[j], 0);
        orDefault++;
        sliceAngleCount.put(slices[j], orDefault);
        if (orDefault == D) {
          noNeedToSlice = true;
        }
      }
      if (!noNeedToSlice) {
        System.out.println("Case #" + (i + 1) + ": " + solve(N, D, slices, maxSize));
      } else {
        System.out.println("Case #" + (i + 1) + ": " + 0);
      }
    }
    sc.close();
  }

  private static String solve(int n, int d, long[] slices, double maxSize) {
    int ans = Integer.MAX_VALUE;
    double secondMax = 0;
    while (maxSize-secondMax >=0.001) {
      int cut = 0;
      double midMax = secondMax + (maxSize - secondMax) / 2;
      int sliceObtained = 0;
      for (int i = 0; i < slices.length; i++) {
        if (midMax > slices[i]) {
          cut += 0;
          sliceObtained += 0;
        } else {
          cut += Math.ceil(slices[i] / (double) midMax) - 1;
          sliceObtained += cut + 1;
        }
      }
      if (sliceObtained >= d) {
        ans = Math.min(ans, cut);
        secondMax = midMax;
      } else {
        maxSize = midMax;
      }
    }
    return String.valueOf(ans);
  }
}
