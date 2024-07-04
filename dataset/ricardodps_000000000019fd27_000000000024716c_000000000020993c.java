import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.*;

public class Vestigium {

  public static void main(String[] args) throws FileNotFoundException {
    String currentDirectory = System.getProperty("user.dir");
    System.out.println(currentDirectory);

    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    //Scanner sc = new Scanner(new File("java/src/codejam/vestigium.in"));

    int T = sc.nextInt();

    for (int t = 0; t < T; t++) {
      Set<Tuple> rows = new HashSet<>();
      Set<Tuple> cols = new HashSet<>();
      TreeSet<Integer> rowReps =  new TreeSet<>(), colReps = new TreeSet<>();
      int trace = 0;
      int N = sc.nextInt();
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          int c = sc.nextInt();
          if (i == j) trace += c;

          if(rows.contains(new Tuple(i, c)))
            rowReps.add(i);
          rows.add(new Tuple(i, c));

          if(cols.contains(new Tuple(j, c)))
            colReps.add(j);
          cols.add(new Tuple(j, c));
        }
      }
      System.out.printf("Case #%d: %d %d %d\n", t + 1, trace, rowReps.size(), colReps.size());
    }

  }


  static class Tuple {
    final int a, b;

    public Tuple(int a, int b) {
      this.a = a;
      this.b = b;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Tuple t = (Tuple) o;
      return a == t.a &&
          b == t.b;
    }

    @Override
    public int hashCode() {
      return Objects.hash(a, b);
    }
  }
}
