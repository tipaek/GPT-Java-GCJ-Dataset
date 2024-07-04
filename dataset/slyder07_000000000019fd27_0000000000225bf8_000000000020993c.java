import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
      result.append(solveTest());
      result.append("\n");
    }
    out.write(result.toString().getBytes());
    out.flush();
  }

  public String solveTest(){
    //solve here
    return null;
  }

  static class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
      br = new BufferedReader(new
          InputStreamReader(System.in));
    }

    String next() {
      while (st == null || !st.hasMoreElements()) {
        try {
          st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }

    int nextInt() {
      return Integer.parseInt(next());
    }

    long nextLong() {
      return Long.parseLong(next());
    }

    double nextDouble() {
      return Double.parseDouble(next());
    }

    String nextLine() {
      String str = "";
      try {
        str = br.readLine();
      } catch (IOException e) {
        e.printStackTrace();
      }
      return str;
    }
  }

}
