import java.io.*;
import java.util.*;

public class Solution {

private static char[] wrap(char c, int n) {
  StringBuilder sb = new StringBuilder();
  for (int i = 0; i < n; ++i) {
    sb.append('(');
  }
  sb.append(c);
  for (int i = 0; i < n; ++i) {
    sb.append(')');
  }
  return sb.toString().toCharArray();
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
     ArrayList<Character> res = new ArrayList<Character>();
     int p = 0;
     for (int i = 0; i < inp.length; ++i) {
       int curr = Character.getNumericValue(inp[i]);
       if (inp[i] == '0') {
         res.add(inp[i]);
         p = 0;
       } else {
         if (p == 0) {
           char[] nest = wrap(inp[i], curr);
           for (int j = 0; j < nest.length; ++j) {
             res.add(nest[j]);
           }
           p = curr;
         } else {
           int diff = curr - p;
           if (diff == 0) {
             res.add((res.size() - p), inp[i]);
           } else if (diff > 0) {
              char[] nest = wrap(inp[i], diff);
              int index = res.size() - p;
              for (int j = 0; j < nest.length; ++j) {
                res.add((index + j), nest[j]);
              }
              p = curr;
           } else if (diff < 0) {
             res.add((res.size() + diff), inp[i]);
           }
         }
       }
     }
     String pr = convertToString(res);
     System.out.println("Case #" + cs + ": " + pr);
     ++cs;
    }
  }
}
