import java.io.*;
import java.util.*;

class Position {
  final int i, j;

  Position(int i, int j) {
    this.i = i;
    this.j = j;
  }
}

class Solver {
  private static final int[] DI = new int[]{1, 0, -1, 0};
  private static final int[] DJ = new int[]{0, 1, 0, -1};

  final int r, c;
  final long[][] sm;
//  int[][] eliminatedRound;
  boolean[][] eliminated;
  List<TreeMap<Integer, Long>> iToJToSMap;
  List<TreeMap<Integer, Long>> jToIToSMap;

  Solver(int r, int c, long[][] sm) {
    this.r = r;
    this.c = c;
    this.sm = sm;
  }

  private boolean alive(int i, int j) {
    return 0 <= i && i < r && 0 <= j && j < c && !eliminated[i][j];
  }

  public long solve() {
    iToJToSMap = new ArrayList<>();
    for (int i = 0; i < r; i++) {
      iToJToSMap.add(new TreeMap<>());
    }
    jToIToSMap = new ArrayList<>();
    for (int j = 0; j < c; j++) {
      jToIToSMap.add(new TreeMap<>());
    }
    eliminated = new boolean[r][c];
    long sum = 0;
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        iToJToSMap.get(i).put(j, sm[i][j]);
        jToIToSMap.get(j).put(i, sm[i][j]);
        sum += sm[i][j];
      }
    }

    Deque<Position> eliminatedPreviousRound = new ArrayDeque<>();
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        eliminatedPreviousRound.addLast(new Position(i, j));
      }
    }

    long answer = sum;
    boolean first = true;
//    System.err.println(answer);
    for (int round = 0; true; round++) {
      Deque<Position> eliminatedThisRound = new ArrayDeque<>();
      for (Position position : eliminatedPreviousRound) {
        List<Position> nextPositions = new ArrayList<>();
        Integer v;
        v = iToJToSMap.get(position.i).higherKey(position.j);
        if (v != null) {
          nextPositions.add(new Position(position.i, v));
        }
        v = iToJToSMap.get(position.i).lowerKey(position.j);
        if (v != null) {
          nextPositions.add(new Position(position.i, v));
        }
        v = jToIToSMap.get(position.j).higherKey(position.i);
        if (v != null) {
          nextPositions.add(new Position(v, position.j));
        }
        v = jToIToSMap.get(position.j).lowerKey(position.i);
        if (v != null) {
          nextPositions.add(new Position(v, position.j));
        }
        for (Position nextPosition : nextPositions) {
          int nextI = nextPosition.i;
          int nextJ = nextPosition.j;
          if (!alive(nextI, nextJ)) {
            continue;
          }
          int count = 0;
          long sumNeighbor = 0;
          Map.Entry<Integer, Long> entry;

          entry = iToJToSMap.get(nextI).higherEntry(nextJ);
          if (entry != null) {
            count++;
            sumNeighbor += entry.getValue();
          }
          entry = iToJToSMap.get(nextI).lowerEntry(nextJ);
          if (entry != null) {
            count++;
            sumNeighbor += entry.getValue();
          }
          entry = jToIToSMap.get(nextJ).higherEntry(nextI);
          if (entry != null) {
            count++;
            sumNeighbor += entry.getValue();
          }
          entry = jToIToSMap.get(nextJ).lowerEntry(nextI);
          if (entry != null) {
            count++;
            sumNeighbor += entry.getValue();
          }
//          System.err.println(count);

          if (count > 0 && sm[nextI][nextJ] * count < sumNeighbor) {
            eliminated[nextI][nextJ] = true;
            sum -= sm[nextI][nextJ];
            eliminatedThisRound.addLast(new Position(nextI, nextJ));
          }
        }
      }
      if (eliminatedThisRound.isEmpty()) {
        break;
      }

      for (Position position : eliminatedThisRound) {
        iToJToSMap.get(position.i).remove(position.j);       
        jToIToSMap.get(position.j).remove(position.i);       
      }

      answer += sum;
      eliminatedPreviousRound = eliminatedThisRound;
    }
    return answer;
  }
}

public class Solution {
  private static void execute(ContestReader reader, ContestWriter out) {
    int t = reader.nextInt();
    for (int i = 1; i <= t; i++) {
      int r = reader.nextInt();
      int c = reader.nextInt();
      long[][] sm = reader.nextLong(r, c);
      out.printf("Case #%d: %d\n", i, new Solver(r, c, sm).solve());
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
