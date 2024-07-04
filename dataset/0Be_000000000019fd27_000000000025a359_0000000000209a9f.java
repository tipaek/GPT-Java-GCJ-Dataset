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
      char[] input = in.readLine().toCharArray();
      
      output.append("Case #" + currTT + ": ");

      int opened = 0;
      for (int i = 0; i < input.length; i++) {
        StringBuilder S = new StringBuilder();
        int curr = input[i] - '0';
        if (opened == curr) {
          S.append(curr);
        } else if (opened < curr) {
          for (int j = opened; j < curr; j++) {
            S.insert(0, '(');
          }
          opened = curr;
          S.append(curr);
        } else {
          for (int j = curr; j < opened; j++) {
            S.insert(0, ')');
          }
          opened = curr;
          S.append(curr);
        }
        output.append(S);
      }
      for (int i = 0; i < opened; i++) {
        output.append(')');
      }
      output.append('\n');
    }

    out.print(output);

    in.close();
    out.close();
  }

}