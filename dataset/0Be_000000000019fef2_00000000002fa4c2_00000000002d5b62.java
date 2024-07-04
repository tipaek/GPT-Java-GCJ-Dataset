import java.util.*;
import java.io.*;

class Solution {

  public static void main(String[] args) throws Exception {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);

    int TT = Integer.parseInt(in.readLine());
    int currTT = 0;
    StringBuilder output = new StringBuilder();

    while (currTT++ < TT) {
      output.append("Case #" + currTT + ": ");

      String[] input = in.readLine().split("\\s+");
      int x = Integer.parseInt(input[0]);
      int y = Integer.parseInt(input[1]);

      char xM = x < 0 ? 'W' : 'E';
      char yM = y < 0 ? 'S' : 'N';

      x = x < 0 ? -x : x;
      y = y < 0 ? -y : y;

      StringBuilder ans = new StringBuilder();
      boolean possible = true;
      long _y = 0;
      int j = 0;
      if (x != 0) {
        char[] xB = Integer.toBinaryString(x).toCharArray();
        
        char d = yM == 'N' ? 'S' : 'N';
        for (int i = xB.length - 1; i >= 0; i--) {
          if (xB[i] == '0') {
            ans.append(d);
            _y -= 1 << j;
          } else {
            ans.append(xM);
          }
          j++;
        }
      }

      while (_y < y) {
        ans.append(yM);
        _y += 1 << j++;
      }


      if (_y == y) {
        output.append(ans);
      } else {
        output.append("IMPOSSIBLE");
      }
      
      output.append('\n');
    }

    out.print(output);

    in.close();
    out.close();
  }

}