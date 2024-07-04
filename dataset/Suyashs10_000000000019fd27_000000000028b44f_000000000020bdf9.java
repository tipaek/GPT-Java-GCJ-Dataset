import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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

  // variable declaration
  int N, work[][], lastAssign = 1;
  String resultString = "";

  void addWork(int startTime, int endTime, int assign, int index) {
    int tempArray[][], tempIndex;

    if (work.length == 0) {
      work = new int[1][4];
      work[(work.length - 1)][0] = startTime;
      work[(work.length - 1)][1] = endTime;
      work[(work.length - 1)][2] = assign;
      work[(work.length - 1)][3] = index;
    } else {
      tempArray = work;
      tempIndex = 0;

      work = new int[(work.length + 1)][4];

      boolean newAdded = false;
      for (int i = 0; i < work.length; i++) {
        if (i == (work.length - 1) && newAdded == false) {
          work[i][0] = startTime;
          work[i][1] = endTime;
          work[i][2] = assign;
          work[i][3] = index;
          break;
        }

        if (startTime < tempArray[tempIndex][0] && newAdded == false) {
          work[i][0] = startTime;
          work[i][1] = endTime;
          work[i][2] = assign;
          work[i][3] = index;
          newAdded = true;
          continue;
        }

        work[i][0] = tempArray[tempIndex][0];
        work[i][1] = tempArray[tempIndex][1];
        work[i][2] = tempArray[tempIndex][2];
        work[i][3] = tempArray[tempIndex][3];
        tempIndex++;

      }
    }

  }

  void printArray() {
    for (int i = 0; i < work.length; i++) {
      for (int j = 0; j < 4; j++) {
        System.out.print(work[i][j] + " ");
      }
      System.out.println();
    }
  }

  void getResult() {
    boolean overlap = false, CConflict = false, JConflict = false;

    for (int i = 0; i < work.length; i++) {
      overlap = false;
      CConflict = false;
      JConflict = false;

      if (i == 0) {
        work[0][2] = 0;
        lastAssign = 0;
        if (resultString != "IMPOSSIBLE") {
          StringBuilder sb = new StringBuilder(resultString);
          sb.setCharAt(work[0][3], 'C');
          resultString = sb.toString();
        }
        continue;
      }
      for (int j = 0; j < i; j++) {
        // check for overlap
        if ((work[j][0] >= work[i][0] && work[j][0] < work[i][1])
            || (work[i][0] >= work[j][0] && work[i][0] < work[j][1])) {
          overlap = true;
          if (work[j][2] == 0) {
            CConflict = true;
          }
          if (work[j][2] == 1) {
            JConflict = true;
          }
        }
      }

      if (overlap) {
        if (CConflict == true && JConflict == true) {
          resultString = "IMPOSSIBLE";
          work[i][2] = 4;
        }
        if (CConflict && !JConflict) {
          work[i][2] = 1;
          lastAssign = 1;

          if (resultString != "IMPOSSIBLE") {
            StringBuilder sb = new StringBuilder(resultString);
            sb.setCharAt(work[i][3], 'J');
            resultString = sb.toString();
          }
          continue;
        }
        if (!CConflict && JConflict) {
          work[i][2] = 0;
          lastAssign = 0;

          if (resultString != "IMPOSSIBLE") {
            StringBuilder sb = new StringBuilder(resultString);
            sb.setCharAt(work[i][3], 'C');
            resultString = sb.toString();
          }
          continue;
        }
      } else {
        char assignChar;
        if (lastAssign == 1) {
          lastAssign = 0;
        }

        if (lastAssign == 1) {
          assignChar = 'J';
        } else {
          assignChar = 'C';
        }

        work[i][2] = lastAssign;
        if (resultString != "IMPOSSIBLE") {
          StringBuilder sb = new StringBuilder(resultString);
          sb.setCharAt(work[i][3], assignChar);
          resultString = sb.toString();
        }

      }

    }
  }

  public static void main(String[] args) {
    int t, T, startTime = 0, endTime = 0;

    FastReader sc = new FastReader();

    T = sc.nextInt();
    for (t = 1; t <= T; t++) {
      Solution obj = new Solution();
      obj.work = new int[0][4];

      // input
      obj.N = sc.nextInt();

      for (int i = 0; i < obj.N; i++) {
        obj.resultString += "B";
        startTime = sc.nextInt();
        endTime = sc.nextInt();
        obj.addWork(startTime, endTime, 2, i);
      }

      obj.getResult();

      // output
      System.out.println("Case #" + t + ": " + obj.resultString);
    }
    System.exit(0);
  }
}