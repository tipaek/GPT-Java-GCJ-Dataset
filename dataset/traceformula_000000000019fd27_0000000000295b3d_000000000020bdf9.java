import java.util.*;

public class Solution {
  public static Scanner sc;
  public static void main(String[] args) {
    sc = new Scanner(System.in);
    int t = sc.nextInt();
    for(int i=1; i<=t; i++) {
      solve(i);
    }
  }

  public static void solve(int caseNumber) {
    StringBuilder sb = new StringBuilder();
    String result = null;

    int n = sc.nextInt();
    Pair[] pairs = new Pair[n];;
    for(int i=0; i<n; i++) {
      Pair pair = new Pair(sc.nextInt(), sc.nextInt(), i);
      pairs[i] = pair;
    }

    Arrays.sort(pairs, new Comparator<Pair>() {
      @Override
      public int compare(Pair _this, Pair _that) {
        if (_this.getKey() < _that.getKey()) {
          return -1;
        }
        if (_this.getKey() > _that.getKey()) {
          return 1;
        }
        if (_this.getValue() < _that.getValue()) {
          return 1;
        }
        if (_this.getValue() > _that.getValue()) {
          return -1;
        }
        return 0;
      }
    });

    char[] assignment = new char[n];
    int previousC = -1;
    int previousJ = -1;
    for(int i=0; i<n; i++) {
      Pair p = pairs[i];
      int start = p.getKey();
      int end = p.getValue();
      if (start >= previousC) {
        assignment[p.pos] = 'C';
        previousC = end;
      } else {
        if (start >= previousJ) {
          assignment[p.pos] = 'J';
          previousJ = end;
        } else {
          result = "IMPOSSIBLE";
          break;
        }
      }
    }

    if(result == null) {
      for(int i=0; i<n; i++) {
        sb.append(assignment[i]);
      }
      result = sb.toString();
    }

    System.out.println("Case #" + caseNumber + ": " + result);
  }

  private static class Pair {
    int key; int value; int pos;
    public Pair(int key, int value, int pos) {
      this.key = key; this.value = value; this.pos = pos;
    }

    public int getKey() { return key; }
    public int getValue() { return value; }
  }
}