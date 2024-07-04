import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    for (int i = 0; i < T; i++) {
      int X = sc.nextInt();
      int Y = sc.nextInt();
      System.out.print("Case #" + (i + 1) + ": ");
      solve(X, Y);
    }
    sc.close();
  }

  static class Tree {
    Points points;
    Tree t1;
    Tree t2;
    Tree t3;
    Tree t4;
    String direction;

    Tree parent;

    public Tree(Points points, String direction) {
      this.points = points;
      this.parent = null;
      this.direction = direction;
    }
  }

  static class Points {
    int x;
    int y;

    @Override
    public String toString() {
      return "Points{" + "x=" + x + ", y=" + y + '}';
    }

    public Points(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof Points)) {
        return false;
      }
      Points points = (Points) o;
      return x == points.x && y == points.y;
    }

    @Override
    public int hashCode() {
      return Objects.hash(x, y);
    }
  }

  private static void solve(int x, int y) {
    int x1 = 0;
    int y1 = 0;
    int count = 0;
    String s = Integer.toBinaryString(Math.abs(x) ^ Math.abs(y));
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '0') {
        System.out.println("IMPOSSIBLE");
        return;
      }
    }
    LinkedList<Tree> p = new LinkedList<>();
    LinkedList<Tree> q = new LinkedList<>();
    Points p1 = new Points(x1, y1);
    Tree tr = new Tree(p1, "");
    p.add(tr);
    Set<Points> pointsAlreadyVisited = new HashSet<>();
    pointsAlreadyVisited.add(p1);
    while (!p.isEmpty()) {
      int step = (int) Math.pow(2, count);
      while (!p.isEmpty()) {
        q.add(p.poll());
      }
      while (!q.isEmpty()) {
        Tree tree = q.poll();
        Points poll = tree.points;

        Points n1 = new Points(poll.x, poll.y + step);
        Points s1 = new Points(poll.x, poll.y - step);
        Points e1 = new Points(poll.x + step, poll.y);
        Points w1 = new Points(poll.x - step, poll.y);

        Tree t1 = null;
        if (!pointsAlreadyVisited.contains(n1)) {
          t1 = new Tree(n1, "N");
          tree.t1 = t1;
          t1.parent = tree;
        }

        Tree t2 = null;
        if (!pointsAlreadyVisited.contains(s1)) {
          t2 = new Tree(s1, "S");
          tree.t3 = t2;
          t2.parent = tree;
        }

        Tree t3 = null;
        if (!pointsAlreadyVisited.contains(e1)) {
          t3 = new Tree(e1, "E");
          tree.t3 = t3;
          t3.parent = tree;
        }

        Tree t4 = null;
        if (!pointsAlreadyVisited.contains(w1)) {
          t4 = new Tree(w1, "W");
          tree.t4 = t4;
          t4.parent = tree;
        }
        Tree t = check(t1, t2, t3, t4, x, y);
        if (t != null) {
          printPathToRoot(t);
          return;
        } else {
          if (crossedThePoint(n1, s1, e1, w1, x, y)) {
            System.out.println("IMPOSSIBLE");
            return;
          }
          if (!pointsAlreadyVisited.contains(n1)) {
            p.add(t1);
            pointsAlreadyVisited.add(n1);
          }
          if (!pointsAlreadyVisited.contains(s1)) {
            p.add(t2);
            pointsAlreadyVisited.add(s1);
          }
          if (!pointsAlreadyVisited.contains(e1)) {
            p.add(t3);
            pointsAlreadyVisited.add(e1);
          }
          if (!pointsAlreadyVisited.contains(w1)) {
            p.add(t4);
            pointsAlreadyVisited.add(w1);
          }
        }
      }
      count++;
    }
  }

  private static boolean crossedThePoint(Points n1, Points s1, Points e1, Points w1, int x, int y) {
    return false;
  }

  private static void printPathToRoot(Tree t) {
    StringBuilder ans = new StringBuilder();
    while (t.parent != null) {
      ans.insert(0, t.direction);
      t = t.parent;
    }
    System.out.println(ans);
  }

  private static Tree check(Tree n1, Tree s1, Tree e1, Tree w1, int x, int y) {
    Points p = new Points(x, y);
    if (n1 != null && p.equals(n1.points)) {
      return n1;
    } else if (s1 != null && p.equals(s1.points)) {
      return s1;
    } else if (e1 != null && p.equals(e1.points)) {
      return e1;
    } else if (w1 != null && p.equals(w1.points)) {
      return w1;
    } else {
      return null;
    }
  }
}
