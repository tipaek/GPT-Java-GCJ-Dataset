import java.util.*;
import java.io.*;

class Solution {
  static int queries = 10000;

  public static void main(String[] args) throws Exception {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);

    int TT = Integer.parseInt(in.readLine());
    int currTT = 0;
    StringBuilder output = new StringBuilder();

    while (currTT++ < TT) {
      output.append("Case #" + currTT + ": ");

      int U = Integer.parseInt(in.readLine());

      int[][] boundaries = new int[26][2];
      for (int i = 0; i < 26; i++) {
        boundaries[i][1] = 10;
      }

      PriorityQueue<Query> q = new PriorityQueue<Query>();
      for (int i = 0; i < queries; i++) {
        String[] input = in.readLine().split("\\s+");
        q.add(new Query(input[0].toCharArray(), input[1].toCharArray(), Long.parseLong(input[0])));
      }

      HashSet<Character> c = new HashSet<Character>();
      char[] ans = new char[10];
      for (int i = 0; i < 10; i++) {
        ans[i] = '-';
      }

      while (!q.isEmpty()) {
        Query _q = q.poll();

        if (_q.lQ < 10) {
          boundaries[_q.A[0] - 'A'][1] = _q.Q[0] - '0';
          boundaries[_q.A[0] - 'A'][0] = 1;
        } else {
          if (ans[0] == '-') {
            for (int i = 0; i < 26; i++) {
              if (boundaries[i][0] == 0) {
                ans[0] = (char) ('A' + i);
              }
            }
          }

          if (_q.A.length == U) {
            for (int i = 0; i < U; i++) {
              int cI = _q.A[i] - 'A';
              if (boundaries[cI][0] == boundaries[cI][1]) {
                continue;
              }

              int tmp = _q.Q[i] - '0';
              if (tmp < boundaries[cI][1]) {
                boundaries[cI][1] = tmp;
              }

              if (boundaries[cI][0] != boundaries[cI][1]) {
                break;
              } else {
                for (int j = 0; j < 26; j++) {
                  if (boundaries[j][0] != boundaries[j][1]) {
                    boundaries[j][0]++;
                  }
                }
              }

              i++;
            }
          }
        }

        if (c.size() < 10) {
          for (char _c : _q.A) {
            c.add(_c);
          }
        }
      }

      for (char _c : c) {
        char tmpC = '-';
        if (boundaries[_c - 'A'][0] == boundaries[_c - 'A'][1]) {
          if (ans[boundaries[_c - 'A'][0]] != '-') {
            tmpC = ans[boundaries[_c - 'A'][0]];
          }
          ans[boundaries[_c - 'A'][0]] = _c;
        } else {
          tmpC = _c;
        }

        if (tmpC != '-') {
          for (int i = 0; i < 10; i++) {
            if (ans[i] != '-') {
              ans[i] = tmpC;
              break;
            }
          }
        }
      }

      for (int i = 0; i < 10; i++) {
        output.append(ans[i]);
      }

      output.append('\n');
    }

    out.print(output);

    in.close();
    out.close();
  }

}

class Query implements Comparable<Query> {
  char[] Q;
  char[] A;
  long lQ;

  public Query(char[] Q, char[] A, long lQ) {
    this.Q = Q;
    this.A = A;
    this.lQ = lQ;
  }

  public int compareTo(Query q) {
    // if (this.A.length() < q.A.length()) {
    // return -1;
    // }
    // if (this.A.length() > q.A.length()) {
    // return 1;
    // }
    return Long.compare(this.lQ, q.lQ);
  }
}