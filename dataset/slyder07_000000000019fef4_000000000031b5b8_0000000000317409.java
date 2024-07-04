import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

public class Solution {

  FastReader in = new FastReader();
  OutputStream out = System.out;

  public static void main(String[] args) throws IOException{
    new Solution().solveTests();
  }

  public void solveTests() throws IOException {
    int T = in.nextInt();
    StringBuilder result = new StringBuilder();
    for(int i = 0; i < T; i++){
      result.append("Case #").append(i+1).append(": ").append(solveTest());
      result.append("\n");
    }
    out.write(result.toString().getBytes());
    out.flush();
  }

  public String solveTest() throws IOException{
    String s = in.readLine();
    String[] splits = s.split(" ");
    int x = Integer.parseInt(splits[0]);
    int y = Integer.parseInt(splits[1]);
    String m = splits[2];
    if(x == 0 && y == 0){
      return "0";
    }
    int dist = Math.abs(x) + Math.abs(y);

    for(int i = 1; i <= m.length(); i++){
      switch (m.charAt(i-1)){
        case 'S':
          y--;
          break;
        case 'N':
          y++;
          break;
        case 'E':
          x--;
          break;
        case 'W':
          x++;
          break;
      }

      int newDist = Math.abs(x) + Math.abs(y);
      if(newDist <= i){
        return String.valueOf(i);
      }
    }


    return "IMPOSSIBLE";
  }

  static class FastReader {

    private final int BUFFER_SIZE = 1 << 24;
    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;

    public FastReader() {
      din = new DataInputStream(System.in);
      buffer = new byte[BUFFER_SIZE];
      bufferPointer = bytesRead = 0;
    }

    public FastReader(String file_name) throws IOException {
      din = new DataInputStream(new FileInputStream(file_name));
      buffer = new byte[BUFFER_SIZE];
      bufferPointer = bytesRead = 0;
    }

    public String readLine() throws IOException {
      byte[] buf = new byte[1001]; // line length
      int cnt = 0, c;
      while ((c = read()) != -1) {
        if (c == '\n')
          break;
        buf[cnt++] = (byte) c;
      }
      return new String(buf, 0, cnt);
    }

    public int nextInt() throws IOException {
      int ret = 0;
      byte c = read();
      while (c <= ' ')
        c = read();
      boolean neg = (c == '-');
      if (neg)
        c = read();
      do {
        ret = ret * 10 + c - '0';
      } while ((c = read()) >= '0' && c <= '9');

      if (neg)
        return -ret;
      return ret;
    }

    public long nextLong() throws IOException {
      long ret = 0;
      byte c = read();
      while (c <= ' ')
        c = read();
      boolean neg = (c == '-');
      if (neg)
        c = read();
      do {
        ret = ret * 10 + c - '0';
      } while ((c = read()) >= '0' && c <= '9');
      if (neg)
        return -ret;
      return ret;
    }

    public double nextDouble() throws IOException {
      double ret = 0, div = 1;
      byte c = read();
      while (c <= ' ')
        c = read();
      boolean neg = (c == '-');
      if (neg)
        c = read();

      do {
        ret = ret * 10 + c - '0';
      } while ((c = read()) >= '0' && c <= '9');

      if (c == '.') {
        while ((c = read()) >= '0' && c <= '9') {
          ret += (c - '0') / (div *= 10);
        }
      }

      if (neg)
        return -ret;
      return ret;
    }

    private void fillBuffer() throws IOException {
      bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
      if (bytesRead == -1)
        buffer[0] = -1;
    }

    private byte read() throws IOException {
      if (bufferPointer == bytesRead)
        fillBuffer();
      return buffer[bufferPointer++];
    }

    public void close() throws IOException {
      if (din == null)
        return;
      din.close();
    }

    //    String[] fillStringArray(int n) throws IOException {
    //      String[] array = new String[n];
    //      for (int i = 0; i < n; i++) array[i] = next();
    //      return array;
    //    }

    int[] fillIntegerArray(int n) throws IOException {
      int[] array = new int[n];
      for (int i = 0; i < n; i++)
        array[i] = nextInt();
      return array;
    }

    long[] fillLongArray(int n) throws IOException {
      long[] array = new long[n];
      for (int i = 0; i < n; i++)
        array[i] = nextLong();
      return array;
    }

    <T extends List<Long>> T fillList(T list, int n) throws IOException {
      for (int i = 0; i < n; i++)
        list.add(nextLong());
      return list;
    }

  }

}
