import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
  static BufferedReader reader;
  static int[] arr;

  public static void main(String... args) throws IOException {
    reader = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(reader.readLine());
    for (int i = 0; i < n; i++) {

      System.out.printf("Case #%d: %s\n", i + 1, do_Test());
    }
  }

  private static String do_Test() throws IOException {
    String s = reader.readLine();
    arr = new int[s.length()];
    int i = 0;
    for (char c : s.toCharArray()) {
      arr[i] = Integer.parseInt(String.valueOf(c));
      i++;
    }
    String result = recurse(0, s.length(), 0);
    return result;
  }

  private static String recurse(int start, int end, int offset) {
    StringBuilder builder = new StringBuilder();
    boolean sequenceStarted = false;
    int start_index = 0;
    for (int i = start; i < end; i++) {
      if (!sequenceStarted && arr[i] - offset > 0) {
        start_index = i;
        sequenceStarted = true;
        builder.append("(");
      } else if (!sequenceStarted && arr[i] - offset == 0) {
        builder.append(arr[i]);
      } else if (sequenceStarted && arr[i] - offset == 0) {
        builder.append(recurse(start_index, i, offset + 1));
        builder.append(")");
        builder.append(arr[i]);
        sequenceStarted = false;
      }
    }
    if (sequenceStarted) {
      builder.append(recurse(start_index, end, offset + 1));
      builder.append(")");
    }
    return builder.toString();
  }
}
