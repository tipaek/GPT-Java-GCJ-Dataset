import java.io.*;

public class Solution {

  private long R, S, a, b;

  public static void main(String[] args) throws Exception {
    FastReader sc = new FastReader();
    int T = sc.nextInt();

    for (int t = 1; t <= T; t++) {
      Solution obj = new Solution();
      obj.R = sc.nextInt();
      obj.S = sc.nextInt();

      System.out.println("Case #" + t + ": " + ((obj.R - 1) * (obj.S - 1)));
      long iterr = 0;
      for (int i = 0; i < obj.R; i++) {
        for (int j = 0; j < obj.S; j++) {
          obj.a = (obj.R * (obj.S - 1)) - iterr;
          obj.b = (obj.R - 1) - i;
          iterr++;
          System.out.print(obj.a + " " + obj.b + " ");
        }
        System.out.println();
      }
    }
  }
}

class FastReader {
  private static final int BUFFER_SIZE = 1 << 16;
  private DataInputStream din;
  private byte[] buffer;
  private int bufferPointer, bytesRead;

  public FastReader() {
    din = new DataInputStream(System.in);
    buffer = new byte[BUFFER_SIZE];
    bufferPointer = bytesRead = 0;
  }

  public FastReader(String fileName) {
    try {
      din = new DataInputStream(new FileInputStream(fileName));
      buffer = new byte[BUFFER_SIZE];
      bufferPointer = bytesRead = 0;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public String readLine() {
    StringBuilder sb = new StringBuilder();
    byte c;
    while ((c = read()) != -1) {
      if (c == '\n') {
        break;
      }
      sb.append((char) c);
    }
    return sb.toString();
  }

  public String readLine(int size) {
    byte[] buf = new byte[size];
    int cnt = 0, c;
    while ((c = read()) != -1) {
      if (c == '\n') {
        break;
      }
      buf[cnt++] = (byte) c;
    }
    return new String(buf, 0, cnt);
  }

  public int nextInt() {
    int n = 0;
    boolean neg = false;
    int c;
    while ((c = read()) <= ' ')
      ;
    neg = c == '-';
    if (neg) {
      c = read();
    }
    do {
      n = n * 10 + c - '0';
    } while ((c = read()) >= '0' && c <= '9');
    return neg ? -n : n;
  }

  public long nextLong() {
    long n = 0;
    boolean neg = false;
    int c;
    while ((c = read()) <= ' ')
      ;
    neg = c == '-';
    if (neg) {
      c = read();
    }
    do {
      n = n * 10 + c - '0';
    } while ((c = read()) >= '0' && c <= '9');
    return neg ? -n : n;
  }

  public double nextDouble() {
    double n = 0, div = 1;
    boolean neg = false;
    int c;
    while ((c = read()) <= ' ')
      ;
    neg = c == '-';
    if (neg) {
      c = read();
    }
    do {
      n = n * 10 + c - '0';
    } while ((c = read()) >= '0' && c <= '9');
    if (c == '.') {
      while ((c = read()) >= '0' && c <= '9') {
        n += (c - '0') / (div *= 10);
      }
    }
    return neg ? -n : n;
  }

  private void fillBuffer() {
    try {
      bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
      if (bytesRead == -1) {
        buffer[0] = -1;
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private byte read() {
    if (bufferPointer == bytesRead) {
      fillBuffer();
    }
    return buffer[bufferPointer++];
  }

  public void close() {
    try {
      if (din != null) {
        din.close();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}