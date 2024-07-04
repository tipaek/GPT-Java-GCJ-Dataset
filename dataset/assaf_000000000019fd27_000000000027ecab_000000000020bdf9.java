import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.function.*;
import java.util.logging.*;
import java.util.stream.*;

public class Solution {
  private static Logger log = Logger.getLogger("Solution");

  CaseInput input;

  public Solution(CaseInput input) {
    this.input = input;
  }

  public static void main(String[] args) {
    CaseReader in = new CaseReader(System.in);
    while (in.hasNext()) {
      CaseInput input = in.next();
      log.fine("case " + input.label);

      String result = new Solution(input).calculate();

      System.out.println(input.formatResult(result));
    }
  }

  public String calculate() {
    int parentCount = 2;
    int[] busyUntil = new int[parentCount];
    String[] parentId = new String[] { "C", "J" };

    List<Activity> activities = IntStream.range(0, input.activities.length)
            .mapToObj(id -> new Activity(id, input.activities[id]))
            .collect(Collectors.toList());

    // sort activities by start time
    List<Activity> sortedActivities = new ArrayList<>(activities);
    sortedActivities.sort(Comparator.comparing(activity -> activity.start));

    // iterate in sorted order
    for (Activity activity : sortedActivities) {
      for (int parent = 0; parent < parentCount; ++parent) {
        if (busyUntil[parent] <= activity.start) {
          busyUntil[parent] = activity.end;
          activity.parentId = parentId[parent];
          break;

        } else if (parent == parentCount - 1) {
          return "IMPOSSIBLE";
        }
      }
    }

    // print out the result in the original order
    StringBuilder output = new StringBuilder();
    activities.stream().forEach(activity -> output.append(activity.parentId));

    return output.toString();
  }

  class Activity {
    public Integer start;
    public Integer end;
    public int id;
    public String parentId;

    public Activity(int id, Integer[] activity) {
      this.id = id;
      this.start = activity[0];
      this.end = activity[1];
    }
  }

  public static class CaseReader {
    private Scanner scanner;
    private int cases;
    private int current = 0;

    public CaseReader(InputStream in) {
      this.scanner = new Scanner(new BufferedReader(new InputStreamReader(in)));
      this.cases = this.scanner.nextInt();
      log.finest("Cases: " + this.cases);
    }

    public boolean hasNext() {
      return current < cases;
    }

    public CaseInput next() {
      return CaseInput.read(scanner).label(String.valueOf(++current));
    }
  }

  public static class CaseInput {
    public String label;
    private Set<String> props = new LinkedHashSet<>();
    public Integer[][] activities;

    public CaseInput label(String label) {
      this.label = label;
      return this;
    }

    public String formatResult(String result) {
      return String.format("Case #%s: %s", label, result);
    }

    @Override
    public String toString() {
      String values = props.stream().map(prop -> {
        return String.format("%s=%s", prop, get(prop));
      }).collect(Collectors.joining(","));
      return String.format("%s: %s", label, values);
    }

    public Object get(String prop) {
      try {
        return this.getClass().getField(prop).get(this);
      } catch (ReflectiveOperationException x) {
        throw new RuntimeException(x);
      }
    }

    public void set(String prop, Object value) {
      try {
        this.getClass().getField(prop).set(this, value);
        props.add(prop);

      } catch (ReflectiveOperationException x) {
        throw new RuntimeException(x);
      }
    }

    public static CaseInput read(Scanner in) {
      CaseInput input = new CaseInput();

      input.set("activities", readIntegerArray2(in, 2));

      return input;
    }

    public static Integer[] readIntegerArray(Scanner in) {
      int length = in.nextInt();
      return readIntegerArray(in, length);
    }

    public static Integer[][] readIntegerArray2(Scanner in) {
      return readIntegerArray2(in, 0);
    }

    public static Integer[][] readIntegerArray2(Scanner in, int internalLength) {
      int length = in.nextInt();
      if (internalLength == 0) {
        internalLength = length;
      }
      Integer[][] array = new Integer[length][];
      for (int i = 0; i < array.length; ++i) {
        array[i] = readIntegerArray(in, internalLength);
      }
      return array;
    }

    public static Integer[] readIntegerArray(Scanner in, int length) {
      return readArray(in, Integer.class, in::nextInt, length);
    }

    public static String[] readStringArray(Scanner in) {
      int length =  in.nextInt();
      return readStringArray(in, length);
    }

    public static String[] readStringArray(Scanner in, int length) {
      return readArray(in, String.class, in::next, length);
    }

    public static <T> T[] readArray(Scanner in, Class<T> elementType, Supplier<T> each) {
      int length = in.nextInt();
      return readArray(in, elementType, each, length);
    }

    public static <T> T[] readArray(Scanner in, Class<T> elementType, Supplier<T> each, int length) {
      T[] values = (T[]) Array.newInstance(elementType, length);
      IntStream.range(0, length).
          forEach((i) -> values[i] = each.get());

      return values;
    }
  }
}
