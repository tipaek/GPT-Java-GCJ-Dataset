
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution implements CJSolution {

  public static class MyList extends ArrayList<Integer> {

  }

  public static void main(String[] args) {
    new Solution().run();
  }

  Scanner in = null;
  private InputStream inStream;
  private PrintStream outStream;

  public Solution(InputStream stream) {
    inStream = stream;
    outStream = System.out;
  }

  public Solution() {
    this(System.in);
  }

  public void setInput(InputStream inputStream) {
    this.inStream = inputStream;
  }

  public void setOutput(PrintStream outputStream) {
    this.outStream = outputStream;
  }

  public void run() {
    Scanner in = null;
    try {
      in = new Scanner(new BufferedReader(new InputStreamReader(inStream)));
      int t = in.nextInt();
      for (int tCase = 1; tCase <= t; ++tCase) {
        int x = in.nextInt();
        int y = in.nextInt();
        String path = in.nextLine().trim();
        int l = path.length();

        MyList[][] grid = new MyList[x + 2 * l + 2][y + 2 * l + 2];

        int px = x + l, py = y + l;
        grid[px][py] = new MyList();
        grid[px][py].add(0);
        for (int i = 0; i < path.length(); ++i) {
          switch (path.charAt(i)) {
          case 'N':
            ++py;
            break;
          case 'S':
            --py;
            break;
          case 'E':
            ++px;
            break;
          case 'W':
            --px;
            break;
          }
          if (grid[px][py] == null)
            grid[px][py] = new MyList();
          grid[px][py].add(i + 1);
        }

        px = 0 + l;
        py = 0 + l;
        int solution = Integer.MAX_VALUE;
        if (grid[px][py] != null) {
          for (Integer time : grid[px][py]) {
            if (0 <= time) {
              solution = Math.min(solution, time);
            }
          }
        }
        py++;
        for (int mytime = 1; mytime <= l; ++mytime) {
          do {
            if (grid[px][py] != null) {
              for (Integer time : grid[px][py]) {
                if (mytime <= time) {
                  solution = Math.min(solution, time);
                }
              }
            }
            if (py - l > 0 && px - l >= 0) {
              py--;
              px++;
            } else if (px - l > 0 && py - l <= 0) {
              py--;
              px--;
            } else if (px - l <= 0 && py - l < 0) {
              px--;
              py++;
            } else {
              px++;
              py++;
            }
          } while (px - l != 0 || py - l < mytime);
          py++;
        }

        outStream.println("Case #" + tCase + ": " + (solution < Integer.MAX_VALUE ? solution : "IMPOSSIBLE"));
      }

    } finally {
      if (in != null)
        in.close();
    }
  }

}

interface CJSolution {

  void setInput(InputStream inputStream);

  void setOutput(PrintStream outStream);

  void run();

}
