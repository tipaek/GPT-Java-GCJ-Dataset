import java.io.*;
import java.util.*;

public class Solution {
  static class ArrayComparator implements Comparator<int[]> {
    public int compare(int[] o1, int[] o2) {
      if (o1[1] != o2[1]) {
        return o1[1] - o2[1];
      }
      return o1[0] - o2[0];
    } 
  }
  public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(f.readLine());
		for(int num = 1; num <= t; num++) {
      int n = Integer.parseInt(f.readLine());
      int[][] times = new int[n][3];
      char[] assign = new char[n];
      for(int i = 0; i < n; i++) {
        StringTokenizer st = new StringTokenizer(f.readLine());
        times[i][0] = 2 * Integer.parseInt(st.nextToken()) + 1;
        times[i][1] = 2 * Integer.parseInt(st.nextToken());
        times[i][2] = i;
      }
      Arrays.sort(times, new ArrayComparator());

      boolean possible = true;
      int counter = 0;
      while (counter < n) {
        if (!possible) {
          break;
        }

        int end = times[counter][1];
        assign[times[counter][2]] = 'C';
        counter++;
      
        int seen = 0;
        while (counter < n && times[counter][0] < end) {
          assign[times[counter][2]] = 'J';

          seen++;
          if (seen > 1 && times[counter][0] < times[counter - 1][1]) {
            possible = false;
            break;
          }

          counter++;
        }
      }

      String output = "IMPOSSIBLE";
      if (possible) {
        StringBuffer out = new StringBuffer();
        for(int i = 0; i < n; i++) {
          out.append(assign[i]);
        }
        output = out.toString();
      }
      System.out.println("Case #" + num + ": " + output);
		}
		f.close();
	}
}