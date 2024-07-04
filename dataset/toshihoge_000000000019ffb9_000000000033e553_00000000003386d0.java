import java.io.*;
import java.util.*;

class SmallSolverSimulator {
  final int n, drct1, drct2, start;
  final long[][] xys;
  final int[] pairs;

  int[] others;
  boolean[][] visited;  // 0: in, 1: out
  long dx, dy;

  SmallSolverSimulator(int n, long[][] xys, int[] pairs, int drct1, int drct2, int start) {
    this.n = n;
    this.xys = xys;
    this.pairs = pairs;
    this.drct1 = drct1;
    this.drct2 = drct2;
    this.start = start;
  }

  private int findNextHole(int position) {
    int nextPosition = -1;
    long nextPositionT = Long.MAX_VALUE - 1;
    long currentX = xys[position][0];
    long currentY = xys[position][1];
    for (int i = 0; i < n; i++) {
      if (i == position) {
        continue;
      }
      long x = xys[i][0];
      long y = xys[i][1];
      long diffX = x - currentX;
      long diffY = y - currentY;
      long t;

      if (dx == 0) {
        if (diffX != 0 || diffY / dy <= 0) {
          continue;
        }
        t = diffY / dy;
      } else if (dy == 0) {
        t = diffX / dx;
        if (diffY != 0 || diffX / dx <= 0) {
          continue;
        }
      } else if (diffX % dx != 0 || diffY % dy != 0 || diffX / dx < 0 || diffY / dy < 0 || diffX / dx != diffY / dy) {
        continue;
      } else {
        t = diffX / dx;
      }
      if (t <= 0 || t >= nextPositionT) {
        continue;
      }
//      System.err.printf("%d %d %d %d %d\n", dx, dy, diffX, diffY, t);
      nextPosition = i;
      nextPositionT = t;
    }
    return nextPosition;
  }

  private static long gcd(long a, long b) {
    if (a == 0 || b == 0) {
      return a + b;
    }
    return a % b == 0 ? b : gcd(b, a % b);
  }

  public int solve() {
//    System.err.println();
    others = new int[n];
    Arrays.fill(others, -1);
    for (int i = 0; i + 1 < n; i += 2) {
      int v1 = pairs[i];
      int v2 = pairs[i + 1];
      others[v1] = v2;
      others[v2] = v1;
    }

    long originalDx = xys[drct1][0] - xys[drct2][0];
    long originalDy = xys[drct1][1] - xys[drct2][1];
    long g = gcd(Math.abs(originalDx), Math.abs(originalDy));
    dx = originalDx / g;
    dy = originalDy / g;

    visited = new boolean[n][2];
    int position = start;

    visited[position][0] = true;
//    System.err.printf("dx: %d, dy: %d\n", dx, dy);
//    System.err.printf("start: %d\n", position);

    while (true) {
//      System.err.printf("holl in: %d\n", position);
      position = others[position];
//      System.err.printf("holl out: %d\n", position);
      if (position < 0) {
        break;
      }
      visited[position][1] = true;      
      position = findNextHole(position);
//      System.err.printf("walk: %d\n", position);
      if (position < 0 || visited[position][0]) {
        break;
      }
      visited[position][0] = true;
    }

    int count = 0;
    for (int i = 0; i < n; i++) {
      if (visited[i][0] || visited[i][1]) {
        count++;
      }
    }
    return count;
  }
}

class SmallSolver {
  final int n;
  final long[][] xys;

  boolean[] used;
  int[] pairs;

  SmallSolver(int n, long[][] xys) {
    this.n = n;
    this.xys = xys;
  }

  private int runSimulateWithPairs() {
    int maxValue = 0;
    for (int drct1 = 0; drct1 < n; drct1++) {
      for (int drct2 = 0; drct2 < n; drct2++) {
        if (drct2 == drct1) {
          continue;
        }
        for (int start = 0; start < n; start++) {
          maxValue = Math.max(maxValue, new SmallSolverSimulator(n, xys, pairs, drct1, drct2, start).solve());
          if (maxValue == n) {
            return n;
          }
        }
      }
    }
    return maxValue;
  }

  private int dfs(int index) {
    if (index == n) {
      return runSimulateWithPairs();
    }
    int maxValue = 1;
    for (int i = 0; i < n; i++) {
      if (used[i]) {
        continue;
      }
      used[i] = true;
      pairs[index] = i;
      maxValue = Math.max(maxValue, dfs(i + 1));
      used[i] = false;
    }
    return maxValue;
  }

  public int solve() {
    used = new boolean[n];
    pairs = new int[n];
    return dfs(0);
  }
}

public class Solution {
  private static void execute(ContestReader reader, ContestWriter out) {
    int t = reader.nextInt();
    for (int i = 1; i <= t; i++) {
      int n = reader.nextInt();
      long[][] xys = reader.nextLong(n, 2);
      out.printf("Case #%d: %d\n", i, new SmallSolver(n, xys).solve());
    }
  }
  
  public static void main(String[] args) {
    ContestReader reader = new ContestReader(System.in);
    ContestWriter out = new ContestWriter(System.out);
    execute(reader, out);
    out.flush();
  }
}

class ContestWriter extends PrintWriter {
  ContestWriter(PrintStream printeStream) {
    super(printeStream);
  }

  public void printList(List<? extends Object> list) {
    for (Object object : list) {
      println(object);
    }
  }

  public void printListOneLine(List<? extends Object> list) {
    List<String> stringList = new ArrayList<>();
    for (Object object : list) {
      stringList.add(object.toString());
    }
    println(String.join(" ", stringList));
  }
}

class ContestReader {
  private static final int BUFFER_SIZE = 1024;
  
  private final InputStream stream;
  private final byte[] buffer;
  private int pointer;
  private int bufferLength;
  
  ContestReader(InputStream stream) {
    this.stream = stream;
    this.buffer = new byte[BUFFER_SIZE];
    this.pointer = 0;
    this.bufferLength = 0;
  }
  
  private boolean hasNextByte() {
    if (pointer < bufferLength) {
      return true;
    }
    
    pointer = 0;
    try {
      bufferLength = stream.read(buffer);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return bufferLength > 0;
  }
  
  private int readByte() {
    if (hasNextByte()) {
      return buffer[pointer++];
    } else {
      return -1;
    }
  }
  
  private static boolean isPrintableChar(int c) {
    return 33 <= c && c <= 126;
  }
  
  public boolean hasNext() {
    while (hasNextByte() && !isPrintableChar(buffer[pointer])) {
      pointer++;
    }
    return hasNextByte();
  }
  
  public String next() {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    StringBuilder sb = new StringBuilder();
    while(true) {
      int b = readByte();
      if (!isPrintableChar(b)) {
        break;
      }
      sb.appendCodePoint(b);
    }
    return sb.toString();
  }
  
  public String nextLine() {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    StringBuilder sb = new StringBuilder();
    while(true) {
      int b = readByte();
      if (!isPrintableChar(b) && b != 0x20) {
        break;
      }
      sb.appendCodePoint(b);
    }
    return sb.toString();
  }
  
  public char nextChar() {
    return next().charAt(0);
  }
  
  public int nextInt() {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    
    int n = 0;
    boolean minus = false;
    
    {
      int b = readByte();
      if (b == '-') {
        minus = true;
      } else if ('0' <= b && b <= '9') {
        n = b - '0';
      } else {
        throw new NumberFormatException();
      }
    }
    
    while(true){
      int b = readByte();
      if ('0' <= b && b <= '9') {
        n *= 10;
        n += b - '0';
      } else if (b == -1 || !isPrintableChar(b)) {
        return minus ? -n : n;
      } else {
        throw new NumberFormatException();
      }
    }
  }
  
  public long nextLong() {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    
    long n = 0;
    boolean minus = false;
    
    {
      int b = readByte();
      if (b == '-') {
        minus = true;
      } else if ('0' <= b && b <= '9') {
        n = b - '0';
      } else {
        throw new NumberFormatException();
      }
    }
    
    while(true){
      int b = readByte();
      if ('0' <= b && b <= '9') {
        n *= 10;
        n += b - '0';
      } else if (b == -1 || !isPrintableChar(b)) {
        return minus ? -n : n;
      } else {
        throw new NumberFormatException();
      }
    }
  }
  
  public double nextDouble() {
    return Double.parseDouble(next());
  }
  
  public String[] next(int n) {
    String[] array = new String[n];
    for (int i = 0; i < n; i++) {
      array[i] = next();
    }
    return array;
  }
  
  public String[] nextLine(int n) {
    String[] array = new String[n];
    for (int i = 0; i < n; i++) {
      array[i] = nextLine();
    }
    return array;
  }
  
  public char[] nextChar(int n) {
    char[] array = new char[n];
    for (int i = 0; i < n; i++) {
      array[i] = nextChar();
    }
    return array;
  }
  
  public int[] nextInt(int n) {
    int[] array = new int[n];
    for (int i = 0; i < n; i++) {
      array[i] = nextInt();
    }
    return array;
  }
  
  public long[] nextLong(int n) {
    long[] array = new long[n];
    for (int i = 0; i < n; i++) {
      array[i] = nextLong();
    }
    return array;
  }
  
  public double[] nextDouble(int n) {
    double[] array = new double[n];
    for (int i = 0; i < n; i++) {
      array[i] = nextDouble();
    }
    return array;
  }
  
  public char[] nextCharArray() {
    return next().toCharArray();
  }
  
  public String[][] next(int n, int m) {
    String[][] matrix = new String[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        matrix[i][j] = next();
      }
    }
    return matrix;
  }
  
  public int[][] nextInt(int n, int m) {
    int[][] matrix = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        matrix[i][j] = nextInt();
      }
    }
    return matrix;
  }
  
  public char[][] nextChar(int n, int m) {
    char[][] matrix = new char[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        matrix[i][j] = nextChar();
      }
    }
    return matrix;
  }
  
  public long[][] nextLong(int n, int m) {
    long[][] matrix = new long[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        matrix[i][j] = nextLong();
      }
    }
    return matrix;
  }
  
  public double[][] nextDouble(int n, int m) {
    double[][] matrix = new double[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        matrix[i][j] = nextDouble();
      }
    }
    return matrix;
  }
  
  public char[][] nextCharArray(int n) {
    char[][] matrix = new char[n][];
    for (int i = 0; i < n; i++) {
      matrix[i] = next().toCharArray();
    }
    return matrix;
  }
}
