import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
  static BufferedReader reader;

  public static void main(String... args) throws IOException {
    reader = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(reader.readLine());
    for (int i = 0; i < n; i++) {
      int[] result = do_Test();
      System.out.printf("Case #%d: %d %d %d\n", i + 1, result[0], result[1], result[2]);
    }
  }

  private static int[] do_Test() throws IOException {
    int N = Integer.parseInt(reader.readLine());
    int k = 0;
    int r = 0;
    int c = 0;
    HashSet<Integer>[] rowSets = new HashSet[N];
    HashSet<Integer>[] colSets = new HashSet[N];
    boolean[] rowbad = new boolean[N];
    boolean[] colbad = new boolean[N];
    for (int i = 0; i < N; i++) {
      rowSets[i] = new HashSet<>();
      colSets[i] = new HashSet<>();
    }
    for (int i = 0; i < N; i++) {
      StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
      for (int j = 0; j < N; j++) {
        int val = Integer.parseInt(tokenizer.nextToken());
        if (i == j) {
          k += val;
        }
        if (!rowbad[i]) {
          int oriSize = rowSets[i].size();
          rowSets[i].add(val);
          int newSize = rowSets[i].size();
          if (oriSize == newSize) {
            r += 1;
            rowbad[i] = true;
          }
        }
        if (!colbad[j]) {
          int oriSize = colSets[j].size();
          colSets[j].add(val);
          int newSize = colSets[j].size();
          if (oriSize == newSize) {
            c += 1;
            colbad[j] = true;
          }
        }
      }
    }
    int[] result = new int[3];
    result[0] = k;
    result[1] = r;
    result[2] = c;
    return result;

  }
}
