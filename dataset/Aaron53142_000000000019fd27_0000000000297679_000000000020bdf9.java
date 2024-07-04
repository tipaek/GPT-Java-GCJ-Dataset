
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Scanner;

public class Solution {

  static class Point {
    int startTime;
    int isStart;
    int uid;

    Point(int t, int isS, int id) {
      startTime = t;
      isStart = isS;
      uid = id;
    }
  }
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    int totalNumber = 0;
    for(int i = 1; i <= t; ++i) {
      int eventN = in.nextInt();
      totalNumber = 0;
      // build list of point;
      List<Point> list = new ArrayList<>();
      for(int j = 0; j < eventN; j++) {
        int start = in.nextInt();
        int end = in.nextInt();
        list.add(new Point(start, 1, j));
        list.add(new Point(end, 0, j));
      }

      Collections.sort(list, (Point p1, Point p2) -> {
        if(p1.startTime == p2.startTime) {
          return p1.isStart - p2.isStart;
        }
        return p1.startTime - p2.startTime;
      });

      String res = "";
      int idJTaken = -1, idCTaken = -1;
      for(Point each : list) {
        if(totalNumber > 2) {
          res = "IMPOSSIBLE";
          break;
        }

        if(each.isStart == 0) {
          if(each.uid == idCTaken) {
            idCTaken = -1;
          }
          else if (each.uid == idJTaken) {
            idJTaken = -1;
          }
          totalNumber--;
          continue;
        }

        totalNumber++;
        if(idCTaken == -1 && each.isStart == 1) {
          res += "C";
          idCTaken = each.uid;
          continue;
        }
        if (idJTaken == -1 && each.isStart == 1) {
          res += "J";
          idJTaken = each.uid;
          continue;
        }
      }
      System.out.println("Case #" + i + ": " + res);
    }
  }
}
