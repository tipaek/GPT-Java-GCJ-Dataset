import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.function.*;
import java.util.logging.*;
import java.util.stream.*;

public class Solution {
  private static Logger log = Logger.getLogger("Solution");

  CaseInput input;
  PrintWriter out;

  public Solution(CaseInput input) {
    this(input, new PrintWriter(System.out));
  }

  public Solution(CaseInput input, PrintWriter out) {
    this.input = input;
    this.out = out;
  }

  public static void main(String[] args) {
    CaseReader in = new CaseReader(System.in);

    while (in.hasNext()) {
      CaseInput input = in.next();
      log.fine("case " + input.label);

      Solution solution = new Solution(input);

      solution.interact();
    }
  }

  public void interact() {
    // find the longest prefix/suffix
    out.println(String.format("Case #%s:", input.label));

    int sum = input.sum;
    if (sum == 1) {
      out.println("1 1");

    } else {
      int line = 1;
      while (sum > line) {
        out.println(String.format("%d %d", line, 1));
        sum--;
        line++;
      }
      if (sum > 0) {
        out.println(String.format("%d %d", line, 2));
      }
    }

    out.flush();
  }

  public static class CaseReader {
    private Scanner scanner;
    private int cases;
    private int current = 0;
    //public int bits;

    public CaseReader(InputStream in) {
      this.scanner = new Scanner(new BufferedReader(new InputStreamReader(in)));
      this.cases = this.scanner.nextInt();
      log.finest("Cases: " + this.cases);
      //this.bits =  this.scanner.nextInt();
    }

    public boolean hasNext() {
      return current < cases;
    }

    public CaseInput next() {
      CaseInput input = CaseInput.read(scanner).label(String.valueOf(++current));
      return input;
    }
  }

  public static class CaseInput {
    public String label;
    private Set<String> props = new LinkedHashSet<>();
    protected Scanner in;
    public int sum;

    public CaseInput(Scanner in) {
      this.in = in;
    }

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
      CaseInput input = new CaseInput(in);
      //input.set("rows", in.nextInt());
      input.set("sum", in.nextInt());

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
