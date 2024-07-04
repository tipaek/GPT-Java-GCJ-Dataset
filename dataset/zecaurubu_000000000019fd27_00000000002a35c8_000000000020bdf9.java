import java.util.*;
import java.io.*;

class Solution {

    static class Task {
    final int start;
    final int end;

    Task(int start, int end) {
      this.start = start;
      this.end = end;
    }
    public String toString() {
      return start + "/" + end;
    }
  }

  enum Parent {C, J};

  static class Entry {
    final Task t;
    final boolean start;

    Entry(Task t, boolean start) {
      this.t = t;
      this.start = start;
    }

    @Override
    public String toString() {
      return "{" +
          "t=" + t +
          ", s=" + start +
          '}';
    }
  }


  static String process(Task[] tasks) {
    Set<Task> seen = new HashSet<Task>();
    Map<Parent,Task> mapping = new HashMap<>();

    List<Entry> timeline = new ArrayList<Entry>();
    for (Task t : tasks) {
      timeline.add(new Entry(t,false));
      timeline.add(new Entry(t,true));
    }
    timeline.sort((c1,c2) -> {
      int valC1 = c1.start ? c1.t.start : c1.t.end;
      int valC2 = c2.start ? c2.t.start : c2.t.end;
      int diff = valC1 - valC2;
      if (diff == 0) {
        if (c1.start) {
          return 1;
        }
        return -1;
      }
      return diff;
    });
//    System.out.println(timeline);
    Map<Task,Parent> schedule = new HashMap<>();

    for (Entry e : timeline) {
      if (seen.add(e.t)) { //first time - start
        if (mapping.size() == 2) {
          return "IMPOSSIBLE";
        }
        Parent available;
        if (mapping.containsKey(Parent.C)) {
          available = Parent.J;
        } else {
          available = Parent.C;
        }
        mapping.put(available,e.t);
        schedule.put(e.t,available);
      } else { //end of task
        Parent freed = null;
        for (Map.Entry<Parent,Task> entry : mapping.entrySet()) {
          if (entry.getValue() == e.t) {
            freed = entry.getKey();
          }
        }
        mapping.remove(freed);
      }
    }
    StringBuilder sb = new StringBuilder();
    for (Task t : tasks) {
      sb.append(schedule.get(t));
    }
    return sb.toString();

  }

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int ntests = in.nextInt();
    for (int i = 1; i <= ntests; i++) {
      int ntasks = in.nextInt();
      Task[] tasks = new Task[ntasks];
      for (int j = 0; j < ntasks; j++) {
        int start = in.nextInt();
        int end = in.nextInt();
        tasks[j] = new Task(start,end);
      }
      String answer = process(tasks);
      System.out.printf("Case #%d: %s\n",i,answer);
    }
  }
}