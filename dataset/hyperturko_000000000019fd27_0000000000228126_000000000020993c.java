import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Solution {

  public static void main(final String[] args) {
    final Reader in = new Reader();

    for (int i = 1; in.hasNext(); i++) {
      final List<List<Integer>> t = in.next();

      final int k = calcTrace(t);
      int r = calcDuplRow(t);
      int c = calcDuplCol(t);

      System.out.println("Case #" + i + ": " + k + " " + r + " " + c);
    }
  }

  private static int calcTrace(final List<List<Integer>> matrix) {
    int trace = 0;
    for (int i = 0; i < matrix.size(); i++) {
      trace += matrix.get(i).get(i);
    }
    return trace;
  }
  
  private static int calcDuplRow(final List<List<Integer>> matrix) {
    int count = 0;
    final Set<Integer> lookup = new HashSet<>();
    for (final List<Integer> row : matrix) {
      lookup.clear();
      for (final Integer n : row) {
        if (!lookup.add(n)) {
          count++;
          break;
        }
      }
    }
    return count;
  }

  private static int calcDuplCol(final List<List<Integer>> matrix) {
    int count = 0;
    final Set<Integer> lookup = new HashSet<>();
    for (int col = 0; col < matrix.size(); col++) {
      lookup.clear();
      for (List<Integer> row : matrix) {
        if (!lookup.add(row.get(col))) {
          count++;
          break;
        }
      }
    }
    return count;
  }

  private static class Reader implements Iterator<List<List<Integer>>> {
    private final Scanner in;
    private final int T;

    public Reader() {
      in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
      T = in.nextInt();
    }

    @Override
    public boolean hasNext() {
      return in.hasNext();
    }

    @Override
    public List<List<Integer>> next() {
      final int n = in.nextInt();

      return IntStream
          .range(0, n)
          .mapToObj(igr -> IntStream.range(0, n))
          .map(s -> s.mapToObj(igr -> in.nextInt()))
          .map(s -> s.collect(Collectors.toList()))
          .collect(Collectors.toList());
    }
  }

}