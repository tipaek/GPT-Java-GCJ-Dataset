import java.io.*;
import java.util.*;

public class Solution {
  static final int MAX = 30;
  
  static class Position {
    int r;
    int c;

    public Position(int r, int c) {
      this.r = r;
      this.c = c;
    }

    public String toString() {
      return this.r + " " + this.c;
    }
  }

  static List<Position> trivial(int n) {
    List<Position> output = new ArrayList<>();
    for(int i = 1; i <= n; i++) {
      output.add(new Position(i, 1));
    }
    return output;
  }

  public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(f.readLine());
		for(int num = 1; num <= t; num++) {
      int n = Integer.parseInt(f.readLine());
      List<Position> output = new ArrayList<>();
      if (n <= MAX) {
        output = trivial(n);
      } else {
        int target = n - MAX;
        int tail = MAX;
        boolean left = true;
        for(int r = 1; r <= MAX; r++) {
          if (target % 2 == 0) {
            tail--;
            int c = 1;
            if (!left) {
              c = r;
            }
            output.add(new Position(r, c));
          } else {
            if (left) {
              for (int c = 1; c <= r; c++) {
                output.add(new Position(r, c));
              }
            } else {
              for (int c = r; c >= 1; c--) {
                output.add(new Position(r, c));
              }
            }
            left = !left;
          }

          target /= 2;
          //System.out.println(output);
          //System.out.println(target);
        }
  
        for(int r = MAX + 1; r <= MAX + tail; r++) {
          int c = 1;
          if (!left) {
            c = r;
          } 
          output.add(new Position(r, c));
        }
      }

      System.out.println("Case #" + num + ":");
      for (Position p : output) {
        System.out.println(p);
      }
		}
		f.close();
	}
}