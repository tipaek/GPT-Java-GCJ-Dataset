import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Solution {

  public static void main(String[] args) throws IOException {
    Scan input = new Scan();
    Print print = new Print();
    int noOfTestCases = input.scanInt();
    int[][] ans = new int[noOfTestCases][3];
    for (int t = 0; t < noOfTestCases; t++) {
      int[] res = new int[3];

      int n = input.scanInt();
      int[][] matrix= new int[n][n];
      int[][] colMatrix = new int[n][n];
      for (int i=0;i<n;i++){
        for(int j=0;j<n;j++){
          matrix[i][j] = input.scanInt();
          colMatrix[j][i] = matrix[i][j];
        }
      }

      int traces = 0;
      for(int i=0;i<n;i++){
        traces += matrix[i][i];
      }

      for(int i=0;i<n;i++){
        Arrays.sort(matrix[i]);
        Arrays.sort(colMatrix[i]);
      }

      int r = 0;
      boolean flag = false;

      for(int i=0;i<n;i++){
        for(int j=0;j<n-1;j++){
          if(matrix[i][j]==matrix[i][j+1]) {
            flag = true;
          }
          if(flag){
            r++;
            break;
          }

        }
        flag = false;
      }

      int c =0;
      boolean flag2 = false;
      for(int i=0;i<n;i++){
        for(int j=0;j<n-1;j++){
          if(colMatrix[i][j]==colMatrix[i][j+1]) {
            flag2 = true;
          }
          if(flag2){
            c++;
            break;
          }
        }
        flag2 = false;
      }

      res[0] = traces;
      res[1] = r;
      res[2] = c;
      ans[t] = res;
    }

    for(int i=0;i<noOfTestCases;i++){

      int testcase = i+1;
        print.println("Case #"+testcase+": "+ans[i][0]+ " "+ans[i][1]+ " "+ans[i][2]);
    }

    print.close();
  }

  static class Scan {
    private byte[] buf = new byte[1024 * 1024];
    private int index;
    private InputStream in;
    private int total;

    public Scan() {
      in = System.in;
    }

    public int scan() throws IOException {
      if (total < 0)
        throw new InputMismatchException();
      if (index >= total) {
        index = 0;
        total = in.read(buf);
        if (total <= 0)
          return -1;
      }
      return buf[index++];
    }

    public int scanInt() throws IOException {
      int integer = 0;
      int n = scan();
      while (isWhiteSpace(n))
        n = scan();
      int neg = 1;
      if (n == '-') {
        neg = -1;
        n = scan();
      }
      while (!isWhiteSpace(n)) {
        if (n >= '0' && n <= '9') {
          integer *= 10;
          integer += n - '0';
          n = scan();
        } else
          throw new InputMismatchException();
      }
      return neg * integer;
    }

    public double scanDouble() throws IOException {
      double doub = 0;
      int n = scan();
      while (isWhiteSpace(n))
        n = scan();
      int neg = 1;
      if (n == '-') {
        neg = -1;
        n = scan();
      }
      while (!isWhiteSpace(n) && n != '.') {
        if (n >= '0' && n <= '9') {
          doub *= 10;
          doub += n - '0';
          n = scan();
        } else
          throw new InputMismatchException();
      }
      if (n == '.') {
        n = scan();
        double temp = 1;
        while (!isWhiteSpace(n)) {
          if (n >= '0' && n <= '9') {
            temp /= 10;
            doub += (n - '0') * temp;
            n = scan();
          } else
            throw new InputMismatchException();
        }
      }
      return doub * neg;
    }

    public long scanLong() throws IOException {
      long ret = 0;
      long c = scan();
      while (c <= ' ') {
        c = scan();
      }

      boolean neg = (c == '-');
      if (neg) {
        c = scan();
      }

      do {
        ret = ret * 10 + c - '0';
      } while ((c = scan()) >= '0' && c <= '9');

      if (neg) {
        return -ret;
      }
      return ret;
    }

    public String scanString() throws IOException {
      StringBuilder sb = new StringBuilder();
      int n = scan();
      while (isWhiteSpace(n))
        n = scan();
      while (!isWhiteSpace(n) || n == ' ') {
        sb.append((char) n);
        n = scan();
      }
      return sb.toString();
    }

    private boolean isWhiteSpace(int n) {
      if (n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1)
        return true;
      return false;
    }
  }
  static class Print {
    private final BufferedWriter bw;

    public Print() {
      this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public void print(Object object) throws IOException {
      bw.append("" + object);
    }

    public void println(Object object) throws IOException {
      print(object);
      bw.append("\n");
    }

    public void close() throws IOException {
      bw.close();
    }


  }


}
