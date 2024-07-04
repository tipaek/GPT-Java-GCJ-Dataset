import java.util.*;

class Solution {

  static class Pair {
    int a, b;
    private char current;

    Pair(int a, int b) {
      this.a = a;
      this.b = b;
    }

    static Comparator<Pair> startComparator() {
      return Comparator.comparingInt(o -> o.a);
    }

    static Comparator<Pair> endComparator() {
      return Comparator.comparingInt(o -> o.b);
    }

    static char next(char current) {
      return current == 'C' ? 'J' : 'C';
    }

    void setCurrent(char current) {
      this.current = current;
    }

    @Override public String toString() {
      return "" + a + " " + b;
    }
  }
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int T = in.nextInt();
    for (int t = 0; t < T; t++) {
      int n = in.nextInt();
      ArrayList<Pair> arr = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        arr.add(new Pair(in.nextInt(), in.nextInt()));
      }

      ArrayList<Pair> orig = new ArrayList<>(arr);
      char current = 'C';
      boolean impossible = false;
      arr.sort(Pair.startComparator());
//      arr.forEach(System.out::println);
//      System.out.println("AA");
      TreeSet<Pair> set = new TreeSet<>(Pair.endComparator());
      for (int i = 0; i < n; i++) {
        Pair p = arr.get(i);
        set.removeIf(tmp -> tmp.b <= p.a);
//        set.forEach(System.out::println);
//        System.out.println("PP");
        if (set.size() > 1) {
          impossible = true;
          //break;
        } else if (set.size() == 1) {
          current = Pair.next(set.first().current);
        }
        p.setCurrent(current);
        set.add(p);
      }
      if (impossible) {
        System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
      } else {
        System.out.print("Case #" + (t + 1) + ": ");
        for (Pair p : orig) {
          System.out.print(p.current);
        }
        System.out.println();
      }
    }
  }
}


