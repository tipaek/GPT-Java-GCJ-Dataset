import java.util.*;

public class Solution {
      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int test = sc.nextInt(), case_num = 1;
            sc.nextLine();

            while (test-- > 0) {
                  String[] str = sc.nextLine().split("");

                  for (int i = 0; i < str.length; i++) {
                        int size = Integer.parseInt(str[i]);

                        String curr = "";

                        for (int j = 0; j < size; j++) {
                              curr += "(";
                        }

                        curr += size;

                        for (int j = 0; j < size; j++) {
                              curr += ")";
                        }

                        str[i] = curr;
                  }

                  String ans = "";

                  for (String s : str)
                        ans += s;

                  ans = ans.replaceAll("\\)\\(", "");

                  System.out.println("Case #" + case_num + ": " + ans);

                  case_num++;
            }
      }
}