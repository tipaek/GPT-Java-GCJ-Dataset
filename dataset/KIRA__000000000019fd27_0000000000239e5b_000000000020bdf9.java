import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;


public class Solution {


  public static void main(String[] args) throws NumberFormatException, IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t1 = Integer.parseInt(br.readLine());
    for (int t = 0; t < t1; ++t) {
      StringBuilder answer = new StringBuilder();
      int n = Integer.parseInt(br.readLine());
      ArrayList<Integer> sj = new ArrayList<>();
      ArrayList<Integer> ej = new ArrayList<>();
      ArrayList<Integer> sc = new ArrayList<>();
      ArrayList<Integer> ec = new ArrayList<>();
      String s[] = br.readLine().trim().split(" ");
      answer.append('J');
      sj.add(Integer.parseInt(s[0]));
      ej.add(Integer.parseInt(s[1]));
      int jn = 1;
      int cn = 0;
      int a, b;
      int breaks = 0;
      for (int i = 1; i < n; ++i) {
        s = br.readLine().trim().split(" ");
        a = Integer.parseInt(s[0]);
        b = Integer.parseInt(s[1]);
        int flagj = 0;
        int flagc = 0;
        for (int j = 0; j < jn; ++j) {
          if ((a < ej.get(j) && a >= sj.get(j)) || (b > sj.get(j) && b <= ej.get(j)) || (
              a <= sj.get(j) && b >= ej.get(j))) {
            flagj = 1;
          }
        }
        for (int j = 0; j < cn; ++j) {
          if ((a < ec.get(j) && a >= sc.get(j)) || (b > sc.get(j) && b <= ec.get(j)) || (
              a <= sc.get(j) && b >= ec.get(j))) {
            flagc = 1;
          }
        }
        if (flagj == 0) {
          answer.append('J');
          sj.add(a);
          ej.add(b);
          ++jn;
        } else if (flagc == 0) {
          answer.append('C');
          sc.add(a);
          ec.add(b);
          ++cn;
        } else {
          System.out.println("IMPOSSIBLE");
          breaks = 1;
          break;
        }

      }
      if (breaks == 0) {
        System.out.println(answer);
      }
    }


  }
}