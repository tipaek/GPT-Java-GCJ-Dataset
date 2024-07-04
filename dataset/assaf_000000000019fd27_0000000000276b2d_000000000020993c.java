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
    int trace = IntStream.range(0, input.matrix.length)
            .map(i -> input.matrix[i][i])
            .sum();

    int rowDups = IntStream.range(0, input.matrix.length)
            .map(i -> {
              Set<Integer> set = new HashSet<>();
              IntStream.range(0, input.matrix.length)
                      .forEach(j -> set.add(input.matrix[i][j]));

              // if the set size is smaller than length than we have a dup
              return set.size() == input.matrix.length ? 0 : 1;
            })
            .sum();

    int colDups = IntStream.range(0, input.matrix.length)
            .map(i -> {
              Set<Integer> set = new HashSet<>();
              IntStream.range(0, input.matrix.length)
                      .forEach(j -> set.add(input.matrix[j][i]));

              // if the set size is smaller than length than we have a dup
              return set.size() == input.matrix.length ? 0 : 1;
            })
            .sum();

    return String.format("%d %d %d", trace, rowDups, colDups);
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
    public Integer[][] matrix;

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
      input.set("matrix", readIntegerArray2(in));

      return input;
    }

    public static Integer[] readIntegerArray(Scanner in) {
      int length = in.nextInt();
      return readIntegerArray(in, length);
    }

    public static Integer[][] readIntegerArray2(Scanner in) {
      int length = in.nextInt();
      Integer[][] array = new Integer[length][];
      for (int i = 0; i < array.length; ++i) {
        array[i] = readIntegerArray(in, length);
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
