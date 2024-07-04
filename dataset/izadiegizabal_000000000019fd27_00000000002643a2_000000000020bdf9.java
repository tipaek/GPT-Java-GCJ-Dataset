import java.util.*;
import java.io.*;
  public class Solution {
    public static void main(String[] args) {
      Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
      int x = in.nextInt();
      for (int i = 1; i <= x; ++i) {
        int n = in.nextInt(); // number of chores
        String result = "";
        in.nextLine();

        int S = -1, E = -1, newS = -1, newE = -1;
        int endTaskJ = -1, endTaskC = -1;
        int[][] tasks = new int[n][2];
        // get tasks
        for (int j = 0; j < n; j++) {
            String[] times = in.nextLine().split(" ");
            // System.out.println(times[0] + " & " + times[1]);
            tasks[j][0] = Integer.parseInt(times[0]);
            tasks[j][1] = Integer.parseInt(times[1]);
        }
        // order tasks
        Arrays.sort(tasks, new Comparator<int[]>() {
            public int compare(final int[] entry1, final int[] entry2) { 
                if (entry1[0] > entry2[0]) {
                    return 1; 
                } else {
                    return -1;  
                }
            } 
        });

        // assign tasks
        for (int j = 0; j < n; j++) {
            if (endTaskC <= tasks[j][0]) {
                endTaskC = tasks[j][1];
                result += "C";
            } else if (endTaskJ <= tasks[j][0]) {
                endTaskJ = tasks[j][1];
                result += "J";
            } else {
                result = "IMPOSSIBLE";
                break;
            }
        }

        System.out.println("Case #" + i + ": " + result);
      }
      in.close();
    }
  }
  