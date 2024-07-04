import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;

public class Solution {
  private static boolean hasNeighbours(int[][] danceFloor, int r, int c, int i, int j) {
    int up = i - 1;
    while (up >= 0) {
      if (danceFloor[up][j] != -1) {
        return true;
      }
      up--;
    }
    int down = i + 1;
    while (down < r) {
      if (danceFloor[down][j] != -1) {
        return true;
      }
      down++;
    }
    int left = j - 1;
    while (left >= 0) {
      if (danceFloor[i][left] != -1) {
        return true;
      }
      left--;
    }
    int right = j + 1;
    while (right < c) {
      if (danceFloor[i][right] != -1) {
        return true;
      }
      right++;
    }
    return false;
  }

  private static double getAverageOfNeighbours(int[][] danceFloor, int r, int c, int i, int j) {
    double numNeighbours = 0;
    double total = 0;
    int up = i - 1;
    while (up >= 0) {
      if (danceFloor[up][j] != -1) {
        numNeighbours += 1;
        total += danceFloor[up][j];
        break;
      }
      up--;
    }
    int down = i + 1;
    while (down < r) {
      if (danceFloor[down][j] != -1) {
        numNeighbours += 1;
        total += danceFloor[down][j];
        break;
      }
      down++;
    }
    int left = j - 1;
    while (left >= 0) {
      if (danceFloor[i][left] != -1) {
        numNeighbours += 1;
        total += danceFloor[i][left];
        break;
      }
      left--;
    }
    int right = j + 1;
    while (right < c) {
      if (danceFloor[i][right] != -1) {
        numNeighbours += 1;
        total += danceFloor[i][right];
        break;
      }
      right++;
    }
    return total / numNeighbours;
  }

  private static int getInterestLevelOfFloor(int[][] danceFloor, int r, int c) {
    int total = 0;
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        if (danceFloor[i][j] != -1) {
          total += danceFloor[i][j];
        }
      }
    }
    return total;
  }

  public static int getInterestLevel(int[][] danceFloor, int r, int c) {
    boolean hasElimination = false;
    int interestLevel = 0;
    do {
      interestLevel += getInterestLevelOfFloor(danceFloor, r, c);
      hasElimination = false;
      ArrayList<Pair> toEliminate = new ArrayList<>();
      // printMatrix(danceFloor, r, c);
      for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++) {
          if (danceFloor[i][j] == -1) {
            continue;
          }
          boolean hasNeighbours = hasNeighbours(danceFloor, r, c, i, j);
          if (!hasNeighbours) {
            continue;
          }
          double averageOfNeighbours = getAverageOfNeighbours(danceFloor, r, c, i, j);
          if (averageOfNeighbours > danceFloor[i][j]) {
            toEliminate.add(new Pair(i, j));
            hasElimination = true;
          }
        }
      }
      for (Pair p : toEliminate) {
        danceFloor[p.r][p.c] = -1;
      }
    } while (hasElimination);
    return interestLevel;
  }

  public static void main(String[] args) {
    Kattio sc = new Kattio(System.in, System.out);
    int tc = sc.getInt();
    for (int i = 0; i < tc; i++) {
      int r = sc.getInt();
      int c = sc.getInt();
      int[][] danceFloor = new int[r][c];
      for (int j = 0; j < r; j++) {
        for (int k = 0; k < c; k++) {
          String word = sc.getWord();
          danceFloor[j][k] = Integer.parseInt(word);
        }
      }
      int interestLevel = getInterestLevel(danceFloor, r, c);
      sc.println("Case #" + (i + 1) + ": " + interestLevel);
    }
    sc.close();
  }

  private static void printMatrix(int[][] matrix, int r, int c) {
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println("");
    }
  }
}

class Pair {
  public int r;
  public int c;

  public Pair(int r, int c) {
    this.r = r;
    this.c = c;
  }
}

class Kattio extends PrintWriter {
  public Kattio(InputStream i) {
    super(new BufferedOutputStream(System.out));
    r = new BufferedReader(new InputStreamReader(i));
  }

  public Kattio(InputStream i, OutputStream o) {
    super(new BufferedOutputStream(o));
    r = new BufferedReader(new InputStreamReader(i));
  }

  public boolean hasMoreTokens() {
    return peekToken() != null;
  }

  public int getInt() {
    return Integer.parseInt(nextToken());
  }

  public double getDouble() {
    return Double.parseDouble(nextToken());
  }

  public long getLong() {
    return Long.parseLong(nextToken());
  }

  public String getWord() {
    return nextToken();
  }

  private BufferedReader r;
  private String line;
  private StringTokenizer st;
  private String token;

  private String peekToken() {
    if (token == null)
      try {
        while (st == null || !st.hasMoreTokens()) {
          line = r.readLine();
          if (line == null)
            return null;
          st = new StringTokenizer(line);
        }
        token = st.nextToken();
      } catch (IOException e) {
      }
    return token;
  }

  private String nextToken() {
    String ans = peekToken();
    token = null;
    return ans;
  }
}
