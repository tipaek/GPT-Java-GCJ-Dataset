import java.io.*;
import java.util.*;

public class Solution {

private static String wrap(char c, int n) {
  StringBuilder sb = new StringBuilder();
  for (int i = 0; i < n; ++i) {
    sb.append('(');
  }
  sb.append(c);
  for (int i = 0; i < n; ++i) {
    sb.append(')');
  }
  return sb.toString();
}

private static String convertToString(ArrayList<Character> res) {
  StringBuilder sb = new StringBuilder();
  for(int i = 0; i < res.size(); ++i) {
    sb.append(res.get(i));
  }
  return sb.toString();
}

public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tc = Integer.parseInt(br.readLine());

    int cs = 1;
    while (tc-- > 0) {
      char[] inp = br.readLine().toCharArray();
      StringBuilder big = new StringBuilder();
      for (int i = 0; i < inp.length; ++i) {
        big.append(wrap(inp[i], Character.getNumericValue(inp[i])));
      }

      String res = big.toString();
      for (int j = 0; j < 10; ++j) {
        res = res.replace(")(", "");
      }


     System.out.println("Case #" + cs + ": " + res);
     ++cs;
    }
  }
}
