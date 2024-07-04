

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Solution {
  public static void main(String[] args) throws FileNotFoundException {
    InputStream inputStream = System.in;
    // String file = "/Users/hshankar/learn/codejam2020/src/com/company/test";
    // InputStream inputStream = new FileInputStream(file);
    Scanner in =
        new Scanner(new BufferedReader(new InputStreamReader(inputStream)));
    int t = in.nextInt();
    in.nextLine();
    for (int i = 1; i <= t; ++i) {
      StringBuilder s = new StringBuilder();
      char[] line = in.nextLine().toCharArray();
      int d = 0;
      for (int j=0;j<line.length;++j) {
        int n = line[j] - '0';
        if (n > d) {
          for (int k=0;k<n-d;++k) {
            s.append('(');
          }
          s.append(line[j]);
        } else {
          for (int k=0;k<d-n;++k) {
            s.append(')');
          }
          s.append(line[j]);
        }
        d = n;
      }
      for (int k=0;k<d;++k) {
        s.append(')');
      }

      System.out.println("Case #" + i + ": " + s.toString());
    }
  }
}