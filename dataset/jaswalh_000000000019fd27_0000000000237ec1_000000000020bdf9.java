import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int tests = in.nextInt(); 
    for (int i = 1; i <= tests; ++i) {
        int n = in.nextInt();
        boolean[] cameron = new boolean[60*24];
        boolean[] jamie = new boolean[60*24];
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < n; j++) {
            int start = in.nextInt();
            int end = in.nextInt();
            boolean available = true;
            if (isAvailable(cameron, start, end)) {
                assignTask(cameron, start, end);
                sb.append("C");
            } else if (isAvailable(jamie, start, end)) {
                assignTask(jamie, start, end);
                sb.append("J");
            } else {
                sb.setLength(0);
                sb.append("IMPOSSIBLE");
                break;
            }
            
        }
        
        System.out.println("Case #" + i + ": " + sb.toString());
    }
  }
  
  private static boolean isAvailable(boolean[] person, int start, int end) {
      for (int x = start; x < end; x++) {
        if (person[x] != false) {
            return false;
        }
      }
      return true;
  }
  
  private static void assignTask(boolean[] person, int start, int end) {
      for (int x = start; x < end; x++) {
            person[x] = true;
      }
  }
}