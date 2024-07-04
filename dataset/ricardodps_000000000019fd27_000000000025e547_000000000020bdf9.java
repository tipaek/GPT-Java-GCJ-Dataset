
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.*;

import static java.util.Arrays.asList;

public class Solution {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    //Scanner sc = new Scanner(new File("java/src/codejam/parenting/input.in"));

    int T = sc.nextInt();



    for (int t = 0; t < T; t++) {
      int N = sc.nextInt();
      ArrayList<Tuple> activities = new ArrayList<>();

      for (int n = 0; n < N; n++) {
        activities.add(new Tuple(n, sc.nextInt(), 0));
        activities.add(new Tuple(n, sc.nextInt(), 1));
      }


      activities.sort((a1, a2) -> a1.time == a2.time ? a2.isEnd - a1.isEnd : a1.time - a2.time );

      HashMap<Integer, Character> selected = new HashMap<>();
      Deque<Character> people = new LinkedList<>();
      people.addFirst('J');
      people.addFirst('C');

      String[] assignments = new String[N];

      boolean imposible = false;
      for (Tuple activity : activities) {
        if (selected.containsKey(activity.id)) {
          Character p = selected.remove(activity.id);
          people.addLast(p);
        } else {
          if (people.isEmpty()) {
            imposible = true;
            break;
          }
          assignments[activity.id] = people.peekFirst().toString();
          selected.put(activity.id, people.pollFirst());
        }
      }

      if(imposible) System.out.printf("Case #%d: IMPOSSIBLE%n", t + 1);
      else {
        System.out.printf("Case #%d: %s%n", t + 1, String.join("", assignments));
      }

    }

  }


  static public class Tuple {
    final int id, time, isEnd;

    public Tuple(int id, int time, int isEnd) {
      this.id = id;
      this.time = time;
      this.isEnd = isEnd;
    }

    public List<Integer> toList() {
      return asList(id, time);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Tuple t = (Tuple) o;
      return id == t.id &&
          time == t.time;
    }

    @Override
    public int hashCode() {
      return Objects.hash(id, time);
    }
  }
}