import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

/** Built using CHelper plug-in Actual solution is at the top */
public class Solution {
  public static void main(String[] args) {
    InputStream inputStream = System.in;
    OutputStream outputStream = System.out;
    Scanner in = new Scanner(inputStream);
    PrintWriter out = new PrintWriter(outputStream);
    PascalWalk solver = new PascalWalk();
    int testCount = Integer.parseInt(in.next());
    for (int i = 1; i <= testCount; i++) solver.solve(i, in, out);
    out.close();
  }

  static final class PascalWalk {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
      int N = in.nextInt();

      final List<PascalWalk.Position> moves;
      if (N <= 100) {
        moves = strategy100(testNumber, N);
      } else if (N <= 10000) {
        moves = strategy10000(testNumber, N);
      } else if (N <= 1000000) {
        moves = strategy1000000(testNumber, N);
      } else if (N <= 100000000) {
        moves = strategy100000000(testNumber, N);
      } else {
        moves = strategy1000000000(testNumber, N);
      }

      out.println(String.format("Case #%d:", testNumber));
      moves.forEach(position -> out.println(String.format("%d %d", position.row, position.column)));
    }

    private static List<PascalWalk.Position> strategy100(int testNumber, int N) {
      int remain = N;
      ArrayList<PascalWalk.Position> moves = new ArrayList<>();
      for (int i = 0; i < N; ++i) {
        moves.add(new PascalWalk.Position(i + 1, 1));
        --remain;
      }
      verify(testNumber, remain);
      return moves;
    }

    private static List<PascalWalk.Position> strategy10000(int testNumber, int N) {
      int remain = N;
      ArrayList<PascalWalk.Position> moves = new ArrayList<>();
      moves.add(new PascalWalk.Position(1, 1));
      --remain;
      moves.add(new PascalWalk.Position(2, 2));
      --remain;
      int row = 2;
      while (remain >= column2(row + 1)) {
        ++row;
        remain -= column2(row);
        moves.add(new PascalWalk.Position(row, 2));
      }
      while (remain > 0) {
        --remain;
        moves.add(new PascalWalk.Position(row, 1));
        ++row;
      }
      verify(testNumber, remain);
      return moves;
    }

    private static List<PascalWalk.Position> strategy1000000(int testNumber, int N) {
      int remain = N;
      ArrayList<PascalWalk.Position> moves = new ArrayList<>();
      moves.add(new PascalWalk.Position(1, 1));
      --remain;
      moves.add(new PascalWalk.Position(2, 2));
      --remain;
      moves.add(new PascalWalk.Position(3, 3));
      --remain;
      int row = 3;
      while (remain >= column3(row + 1) + column2(row + 1)) {
        ++row;
        remain -= column3(row);
        moves.add(new PascalWalk.Position(row, 3));
      }
      moves.add(new PascalWalk.Position(row, 2));
      remain -= column2(row);
      while (remain >= column2(row + 1)) {
        ++row;
        remain -= column2(row);
        moves.add(new PascalWalk.Position(row, 2));
      }
      while (remain > 0) {
        --remain;
        moves.add(new PascalWalk.Position(row, 1));
        ++row;
      }
      verify(testNumber, remain);
      return moves;
    }

    private static List<PascalWalk.Position> strategy100000000(int testNumber, int N) {
      int remain = N;
      ArrayList<PascalWalk.Position> moves = new ArrayList<>();
      moves.add(new PascalWalk.Position(1, 1));
      --remain;
      moves.add(new PascalWalk.Position(2, 2));
      --remain;
      moves.add(new PascalWalk.Position(3, 3));
      --remain;
      moves.add(new PascalWalk.Position(4, 4));
      --remain;
      int row = 4;
      while (remain >= column2(row + 1) + column3(row + 1) + column4(row + 1)) {
        ++row;
        remain -= column4(row);
        moves.add(new PascalWalk.Position(row, 4));
      }
      moves.add(new PascalWalk.Position(row, 3));
      remain -= column3(row);
      while (remain >= column3(row + 1) + column2(row + 1)) {
        ++row;
        remain -= column3(row);
        moves.add(new PascalWalk.Position(row, 3));
      }
      moves.add(new PascalWalk.Position(row, 2));
      remain -= column2(row);
      while (remain >= column2(row + 1)) {
        ++row;
        remain -= column2(row);
        moves.add(new PascalWalk.Position(row, 2));
      }
      while (remain > 0) {
        --remain;
        moves.add(new PascalWalk.Position(row, 1));
        ++row;
      }
      verify(testNumber, remain);
      return moves;
    }

    private static List<PascalWalk.Position> strategy1000000000(int testNumber, int N) {
      int remain = N;
      ArrayList<PascalWalk.Position> moves = new ArrayList<>();
      moves.add(new PascalWalk.Position(1, 1));
      --remain;
      moves.add(new PascalWalk.Position(2, 2));
      --remain;
      moves.add(new PascalWalk.Position(3, 3));
      --remain;
      moves.add(new PascalWalk.Position(4, 4));
      --remain;
      moves.add(new PascalWalk.Position(5, 5));
      --remain;
      int row = 5;
      while (remain >= column2(row + 1) + column3(row + 1) + column4(row + 1) + column5(row + 1)) {
        ++row;
        remain -= column5(row);
        moves.add(new PascalWalk.Position(row, 5));
      }
      moves.add(new PascalWalk.Position(row, 4));
      remain -= column4(row);
      while (remain >= column2(row + 1) + column3(row + 1) + column4(row + 1)) {
        ++row;
        remain -= column4(row);
        moves.add(new PascalWalk.Position(row, 4));
      }
      moves.add(new PascalWalk.Position(row, 3));
      remain -= column3(row);
      while (remain >= column3(row + 1) + column2(row + 1)) {
        ++row;
        remain -= column3(row);
        moves.add(new PascalWalk.Position(row, 3));
      }
      moves.add(new PascalWalk.Position(row, 2));
      remain -= column2(row);
      while (remain >= column2(row + 1)) {
        ++row;
        remain -= column2(row);
        moves.add(new PascalWalk.Position(row, 2));
      }
      while (remain > 0) {
        --remain;
        moves.add(new PascalWalk.Position(row, 1));
        ++row;
      }
      verify(testNumber, remain);
      return moves;
    }

    private static void verify(int testNumber, int N) {
      //    if (N != 0) {
      //      System.err.println(String.format("Wrong: #%s - %s", testNumber, N));
      //    }
    }

    private static long column2(int N) {
      return N;
    }

    private static long column3(int N) {
      return N * (N + 1L) / 2;
    }

    private static long column4(int N) {
      return N * (N + 1L) * (N + 2L) / 6;
    }

    private static long column5(int N) {
      return N * (N + 1L) * (N + 2L) * (N + 3L) / 24;
    }

    private static final class Position {
      private final int row;
      private final int column;

      private Position(int row, int column) {
        this.row = row;
        this.column = column;
      }
    }
  }
}
