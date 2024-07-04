

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

class Solution {// Rename class to Solution before submitting

  private static class Position {
    int x, y;

    public Position(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public int hashCode() {
      int result = 31 + x;
      result = 31 * result + y;
      return result;
    }

    @Override
    public boolean equals(Object obj) {
      Position other = (Position) obj;
      return this.x == other.x && this.y == other.y;
    }

    @Override
    public String toString() {
      return "[x=" + x + ", y=" + y + "]";
    }
  }

  private static final String CASES = "Case #";
  private static final String COLON = ": ";
  private static final String NEWLINE = "\n";

  public static void solve(final Input input, final PrintWriter output) throws IOException {
    final int numberOfTestCases = input.nextInt();
    final StringBuilder stringBuilder = new StringBuilder(2000 * numberOfTestCases);
    for (int z = 1; z <= numberOfTestCases; z++) {
      stringBuilder.append(CASES);
      stringBuilder.append(z);
      stringBuilder.append(COLON);
      // lets go
      int x = input.nextInt();
      int y = input.nextInt();
      Position position = new Position(x, y);
      String instruction = input.next();
      int count = 0;
      Queue<Position> positions = new ArrayDeque<>();
      Set<Position> visited = new HashSet<>();
      positions.add(new Position(0, 0));
      boolean found = false;
      if (x == 0 && y == 0) {
        found = true;
        instruction = "";
        count = 0;
      }
      for (char ch : instruction.toCharArray()) {
        int size = positions.size();
        while (size > 0) {
          Position currentPositon = positions.poll();
          visited.add(currentPositon);
          if (currentPositon.equals(position)) {
            found = true;
            break;
          }
          Position east = new Position(currentPositon.x + 1, currentPositon.y);
          Position west = new Position(currentPositon.x - 1, currentPositon.y);
          Position north = new Position(currentPositon.x, currentPositon.y + 1);
          Position south = new Position(currentPositon.x, currentPositon.y - 1);

          positions.add(east);
          positions.add(west);
          positions.add(north);
          positions.add(south);
          size--;
        }
        switch (ch) {
          case 'S':
            position.y -= 1;
            break;
          case 'N':
            position.y += 1;
            break;
          case 'E':
            position.x += 1;
            break;
          case 'W':
            position.x -= 1;
            break;
        }

        count++;
        if (visited.contains(position)) {
          found = true;
          break;
        }
      }
      int size = positions.size();
      while (size > 0) {
        Position currentPositon = positions.poll();
        if (currentPositon.equals(position)) {
          found = true;
          break;
        }
        positions.add(new Position(currentPositon.x + 1, currentPositon.y));
        positions.add(new Position(currentPositon.x - 1, currentPositon.y));
        positions.add(new Position(currentPositon.x, currentPositon.y + 1));
        positions.add(new Position(currentPositon.x, currentPositon.y - 1));
        positions.add(new Position(currentPositon.x, currentPositon.y));
        size--;
      }
      stringBuilder.append(found ? count : "IMPOSSIBLE");
      stringBuilder.append(NEWLINE);
    }
    output.println(stringBuilder);
  }

  public static void main(final String[] args) throws IOException {
    try (final PrintWriter output = new PrintWriter(System.out);
            final Input input = new Input(new BufferedReader(new InputStreamReader(System.in)))) {
      solve(input, output);
    }
  }

  private static final class Input implements Closeable {

    private final BufferedReader in;
    private final StringBuilder sb = new StringBuilder();

    public Input(final BufferedReader in) {
      this.in = in;
    }

    public String next() throws IOException {
      sb.setLength(0);
      while (true) {
        int c = in.read();
        if (c == -1) {
          return null;
        }
        if (c != ' ' && c != '\n' && c != '\r' && c != '\t') {
          sb.append((char) c);
          break;
        }
      }
      while (true) {
        int c = in.read();
        if (c == -1 || c == ' ' || c == '\n' || c == '\r' || c == '\t') {
          break;
        }
        sb.append((char) c);
      }
      return sb.toString();
    }

    public int nextInt() throws IOException {
      return Integer.parseInt(next(), 10);
    }

    public long nextLong() throws IOException {
      return Long.parseLong(next(), 10);
    }

    @Override
    public void close() throws IOException {
      in.close();
    }
  }
}
