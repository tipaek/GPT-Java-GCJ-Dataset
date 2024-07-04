import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Solution
 */
public class Solution {
  static class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
      br = new BufferedReader(new InputStreamReader(System.in));
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

  // global variables
  int N, pascal[][];

  void arrayPush(int limit) {
    int tempArray[][];

    if (limit == 1) {
      pascal = new int[limit][limit];
      pascal[0][0] = 1;
    } else {
      tempArray = pascal;
      pascal = new int[limit][limit];
      for (int i = 0; i < limit; i++) {
        if (i != limit - 1) {
          for (int j = 0; j < limit - 1; j++) {
            pascal[i][j] = tempArray[i][j];
          }
        } else {
          for (int j = 0; j < limit; j++) {
            if (j == 0) {
              pascal[i][j] = 1;
            } else {
              pascal[i][j] = pascal[i - 1][j] + pascal[i - 1][j - 1];
            }
          }
        }
      }
    }
  }

  void printPascal() {
    for (int i = 0; i < pascal.length; i++) {
      System.out.println();
      for (int j = 0; j < pascal.length; j++) {
        System.out.print(pascal[i][j]);
      }
    }
  }

  void getResult() {
    boolean cal = true, innerCal = true;
    int i = 1, j = 0, sum = 0, middle = 0;
    while (cal) {
      if (i == 1) {
        arrayPush(i);
        sum += 1;
        System.out.println(i + " " + i);
      } else {
        arrayPush(i);

        // getting middle;
        j = ((i / 2) + (i % 2)) - (i % 2);

        innerCal = true;
        while (innerCal) {
          sum += pascal[i - 1][j];
          System.out.println(i + " " + (j + 1));
          if (j != 0 && sum < N) {
            if (pascal[i - 1][j - 1] < pascal[i - 1][j]) {
              j--;
            } else if (j > 1) {
              if (pascal[i - 1][j - 1] == pascal[i - 1][j]) {
                j -= 2;
              } else {
                innerCal = false;
              }
            } else {
              innerCal = false;
            }

          } else {
            innerCal = false;
          }

        }
      }
      i++;
      if (i > 500) {
        cal = false;
      }
      if (sum >= N) {
        cal = false;
      }
    }
  }

  public static void main(String[] args) {
    int t, T;

    FastReader sc = new FastReader();

    T = sc.nextInt();
    for (t = 1; t <= T; t++) {
      Solution obj = new Solution();

      // input
      obj.N = sc.nextInt();
      obj.pascal = new int[0][0];

      // output
      System.out.println("Case #" + t + ":");
      obj.getResult();
      System.out.println();
    }
    System.exit(0);
  }
}