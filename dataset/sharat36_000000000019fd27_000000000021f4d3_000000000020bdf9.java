import java.util.*;

class Sort implements Comparator<Time> {
      public int compare(Time a, Time b) {
            if (a.start == b.start)
                  return a.end - b.end;

            return a.start - b.start;
      }
}

class Time {
      int start, end;

      Time() {
      }

      Time(int start, int end) {
            this.start = start;
            this.end = end;
      }
}

public class Solution {
      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int test = sc.nextInt(), case_num = 1;

            while (test-- > 0) {
                  int size = sc.nextInt();

                  LinkedList<Time> list = new LinkedList<>();

                  for (int i = 0; i < size; i++) {
                        int start = sc.nextInt();
                        int end = sc.nextInt();

                        list.add(new Time(start, end));
                  }

                  list.sort(new Sort());

                  String ans = "";

                  Time c = new Time(-1, -1);
                  Time j = new Time(-1, -1);

                  for (Time t : list) {
                        if (t.start >= c.end) {
                              c.start = t.start;
                              c.end = t.end;

                              ans += "C";
                        } else if (t.start >= j.end) {
                              j.start = t.start;
                              j.end = t.end;

                              ans += "J";
                        } else {
                              ans = "IMPOSSIBLE";
                              break;
                        }
                  }

                  System.out.println("Case #" + case_num + ": " + ans);

                  case_num++;
            }
      }
}