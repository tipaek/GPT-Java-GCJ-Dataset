import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Soulution {
  public static void main(String[] args) throws Exception {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
    int n = Integer.parseInt(bf.readLine());
    for (int i = 0; i < n; i++) {
      int x = 0;
      int temp;
      StringBuilder sb = new StringBuilder();
      for (char a : bf.readLine().toCharArray()) {
        temp = Character.getNumericValue(a);
        while (temp != x) {
          if (temp < x) {
            sb.append("(");
          } else {
            sb.append(")");
          }
        }
        sb.append(a);
      }
      while (x > 0) {
        sb.append(")");
        x--;
      }
      System.out.println("Case #" + (i + 1) + ": " + sb.toString());
    }

  }
}