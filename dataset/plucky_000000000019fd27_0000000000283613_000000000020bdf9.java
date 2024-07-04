import java.util.*;

public class Solution {
    static class Schedule implements Comparable<Schedule>{
        int[] times;
        int index;

        Schedule (int start, int end, int i) {
            times = new int[] {start, end};
            index = i;
        }
        @Override
        public int compareTo(Schedule s) {
            // usually toString should not be used,
            // instead one of the attributes or more in a comparator chain
            return times[0] - s.times[0];
        }
    }

    public static String solve(Schedule[] schedules, int N) {
        int[] C = new int[2]; //store start and end times
        int[] J = new int[2];
        char[] result = new char[N];
        for (int i = 0; i < schedules.length; i ++) {
            int start = schedules[i].times[0];
            int end = schedules[i].times[1];
            int index = schedules[i].index;

            if (start >= C[1]) { //C can handle
                result[index] = 'C';
                C[0] = start;
                C[1] = end;
            }
            else if (start >= J[1]) { //J can handle
                result[index] = 'J';
                J[0] = start;
                J[1] = end;
            }
            else { //impossible case
                return "IMPOSSIBLE";
            }
        }
        return String.valueOf(result);
    }  
    public static void main(String args[]) {
      Scanner input = new Scanner(System.in);
      int T = input.nextInt();
      for (int ks = 1; ks <= T; ks++) {
        List<Integer> schedule = new ArrayList<>();
        int N = input.nextInt();
        Schedule[] schedules= new Schedule[N];

        for (int i = 0; i < N; i++) {
            int start = input.nextInt();
            int end = input.nextInt();
            schedules[i] = new Schedule(start, end, i);
        }
        Arrays.sort(schedules);
        System.out.println("Case #" + ks + ": " + solve(schedules, N));
      }
    }
  }
  