import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author csorbazoli
 */
public class Solution {

  private Map<String, Data> paths = new HashMap<>();
  private List<Data> shortestPaths = new ArrayList<>();

  private class Data {
    long x;
    long y;
    int len;
    char[] path;

    public Data(long x, long y, int len) {
      super();
      this.x = x;
      this.y = y;
      this.len = len;
    }

  }

  protected void processTestCase(int caseNum, Scanner scan, PrintWriter out) {
    // get input
    long targetX = scan.nextLong();
    long targetY = scan.nextLong();
    Data shortest = paths.get(targetX + ";" + targetY);
    if (shortest == null) {
      out.print("Case #" + caseNum + ": IMPOSSIBLE\n");
    } else {
      out.print("Case #" + caseNum + ": " + new String(shortest.path) + "\n");
    }
  }

  private void process(InputStream inStream, OutputStream outStream) {
    // process input file
    try (Scanner scan = new Scanner(inStream)) {
      // open output
      PrintWriter out = new PrintWriter(outStream);
      try {
        // number of test cases
        calculatePaths(10);
        int t = scan.nextInt();
        for (int i = 0; i < t; i++) {
          processTestCase(i + 1, scan, out);
        }
      } finally {
        out.close();
      }
    }

  }

  private void calculatePaths(int maxLen) {
    int curLen = 0;
    long curStep = 1L;
    Data next = new Data(0, 0, 0);
    next.path = new char[maxLen];
    paths.put("0;0", next);
    while (next.len < maxLen) {
      go(next, curStep, 0, 'E');
      go(next, -curStep, 0, 'W');
      go(next, 0, curStep, 'N');
      go(next, 0, -curStep, 'S');
      next = shortestPaths.remove(0);
      if (next.len > curLen) {
        curLen = next.len;
        curStep *= 2;
      }
    }
  }

  private void go(Data data, long horizontal, long vertical, char step) {
    long newX = data.x + horizontal;
    long newY = data.y + vertical;
    paths.computeIfAbsent(newX + ";" + newY, key -> {
      Data newPath = new Data(newX, newY, data.len + 1);
      newPath.path = Arrays.copyOf(data.path, data.path.length);
      newPath.path[data.len] = step;
      shortestPaths.add(newPath);
      return newPath;
    });
  }

  public static void main(String[] args) {
    new Solution().process(System.in, System.out);
  }

}
