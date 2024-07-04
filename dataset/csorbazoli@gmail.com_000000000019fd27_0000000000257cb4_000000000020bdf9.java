import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * @author csorbazoli
 */
public class Solution {

  private class Slot {
    Integer activity1;
    Integer activity2;
  }

  public class Data {
    int n;
    boolean impossible;
    Slot[] slotsByMinute = new Slot[24 * 60];

    Data() {
      IntStream.range(0, 24 * 60).forEach(idx -> slotsByMinute[idx] = new Slot());
    }

    void init(int activites) {
      n = activites;
      impossible = false;
      for (Slot s : slotsByMinute) {
        s.activity1 = null;
        s.activity2 = null;
      }
    }
  }

  private String calculateOutput(Data data) {
    StringBuilder ret = new StringBuilder();
    if (data.impossible) {
      ret.append("IMPOSSIBLE");
    } else {
      int[] schedule = new int[data.n];
      calculateSchedule(data, schedule);
      for (int parent : schedule) {
        ret.append(parent == 1 ? 'C' : 'J');
      }
    }
    return ret.toString();
  }

  private void calculateSchedule(Data data, int[] schedule) {
    Integer parent1 = null;
    Integer parent2 = null;
    for (Slot slot : data.slotsByMinute) {
      parent1 = updateAvailability(parent1, slot);
      parent2 = updateAvailability(parent2, slot);
      if (slot.activity1 != null && schedule[slot.activity1] == 0) {
        if (parent1 == null) {
          parent1 = slot.activity1;
          schedule[slot.activity1] = 1;
        } else {
          parent2 = slot.activity1;
          schedule[slot.activity1] = 2;
        }
      }
      if (slot.activity2 != null && schedule[slot.activity2] == 0) {
        if (parent1 == null) {
          parent1 = slot.activity2;
          schedule[slot.activity2] = 1;
        } else {
          parent2 = slot.activity2;
          schedule[slot.activity2] = 2;
        }
      }
    }
  }

  private Integer updateAvailability(Integer curActivity, Slot slot) {
    if (curActivity != null && !curActivity.equals(slot.activity1) && !curActivity.equals(slot.activity2)) {
      return null;
    }
    return curActivity;
  }

  protected void processTestCase(Data data, int caseNum, Scanner scan, PrintWriter out) {
    // get input
    if (data == null) {
      data = new Data();
    }
    data.init(scan.nextInt()); // number of activities
    final Data finalData = data;
    IntStream.range(0, data.n)
        .forEach(idx -> processActivity(finalData, idx, scan.nextInt(), scan.nextInt()));
    out.print("Case #" + caseNum + ": " + calculateOutput(data) + "\n");
  }

  private void processActivity(Data data, int idx, int start, int end) {
    if (!data.impossible) {
      IntStream.range(start, end)
          .mapToObj(min -> data.slotsByMinute[min])
          .filter(slot -> !updateSlot(slot, idx, data))
          .findFirst();
    }
  }

  private boolean updateSlot(Slot slot, int idx, Data data) {
    if (slot.activity1 == null) {
      slot.activity1 = idx;
    } else if (slot.activity2 == null) {
      slot.activity2 = idx;
    } else {
      data.impossible = true;
    }
    return !data.impossible;
  }

  private void process(InputStream inStream, OutputStream outStream) {
    Data data = new Data();
    // process input file
    try (Scanner scan = new Scanner(inStream)) {
      // open output
      PrintWriter out = new PrintWriter(outStream);
      try {
        // number of test cases
        int t = scan.nextInt();
        for (int i = 0; i < t; i++) {
          processTestCase(data, i + 1, scan, out);
        }
      } finally {
        out.close();
      }
    }

  }

  public static void main(String[] args) {
    new Solution().process(System.in, System.out);
  }

}
