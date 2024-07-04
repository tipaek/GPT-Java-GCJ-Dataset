import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int T = in.nextInt();
    for (int n = 0; n < T; n ++) {
        int N = in.nextInt();
        int[][] task = new int[N][2];
        for (int i = 0; i < N; i ++) {
            int [] temp = new int[2];
            for (int j = 0; j < 2; j ++) {
                temp[j] = in.nextInt();
            }
            task[i] = temp;
        }
        sortbyColumn(task, 0);
        String schedule = find(task);
        System.out.println("Case #" + (n + 1) + ": " + schedule);
    }
  }
  
  public static String find(int[][] array) {
      Map<Character, Integer> start = new HashMap<>();
      Map<Character, Integer> end = new HashMap<>();
      char c = 'C', j = 'J';
      char current = ' ';
      StringBuilder pattern = new StringBuilder();
      for (int[] time: array) {
          if (pattern.length() == 0) {
              current = c;
              start.put(current, time[0]);
              end.put(current, time[1]);
              pattern.append(current);
          } else {
              char temp = (current == c) ? j : c;
              if(continueJob(current, start, end, time)) {
                  pattern.append(current);
              } else if (canTakeJob(temp, start, end, time)) {
                  current = temp;
                  pattern.append(current);
              } else {
                  return "IMPOSSIBLE";
              }
          }
      }
      return pattern.toString();
  }
  public static boolean continueJob(char curr, Map<Character, Integer> start, Map<Character, Integer> end, int[] time) {
      int s = start.get(curr);
      int e = end.get(curr);
      if (time[0] < e) {
          if (s < time[0]) return false;
          if (time[1] > s) return false;
      }
      if (time[0] < s) start.replace(curr, time[0]);
      end.replace(curr, time[1]);
      return true;
  }
  
  public static boolean canTakeJob(char curr, Map<Character, Integer> start, Map<Character, Integer> end, int[] time) {
      if (!start.containsKey(curr)) {
          start.put(curr, time[0]);
          end.put(curr, time[1]);
      } else {
          int s = start.get(curr);
          int e = end.get(curr);
          if (time[0] < e) {
              if (s < time[0]) return false;
              if (time[1] > s) return false;
          }
          if (time[0] < s) start.replace(curr, time[0]);
          end.replace(curr, time[1]);
      }
      return true;
  }
  public static void sortbyColumn(int arr[][], int col) {
        Arrays.sort(arr, new Comparator<int[]>() { 
            
          @Override
          public int compare(final int[] entry1, final int[] entry2) { 
            if (entry1[col] > entry2[col]) 
                return 1; 
            else
                return -1; 
          } 
        });   
    } 
}