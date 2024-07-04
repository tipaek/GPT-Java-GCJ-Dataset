import java.util.*;
import java.io.*;

class Solution {

  public static void main(String[] args) throws Exception {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);

    String[] input = in.readLine().split("\\s+");
    int TT = Integer.parseInt(input[0]);
    int A = Integer.parseInt(input[1]);
    int B = Integer.parseInt(input[2]);
    int currTT = 0;
    StringBuilder output = new StringBuilder();

    while (currTT++ < TT) {
      boolean solved = false;
      for (int i = -5; i <= 5 && !solved; i++) {
        for (int j = -5; j <= 5 && !solved; j++) {
          out.println(i + " " + j);
          out.flush();
          solved = in.readLine().equals("CENTER");
        }
      }
    }

    out.print(output);

    in.close();
    out.close();
  }

}