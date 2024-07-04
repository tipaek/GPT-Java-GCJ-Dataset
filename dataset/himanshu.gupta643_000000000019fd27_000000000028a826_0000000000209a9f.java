import java.util.Scanner;

/**
 * @author himanshugupta - created on 05/04/20
 */
public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    sc.nextLine();
    while (t-- != 0) {
      String s = sc.nextLine();
      char prev = '0';
      StringBuilder res = new StringBuilder();
      for (int i = 0; i < s.length(); i++) {
        if(i==0){
          appendBrackets(res, -Integer.parseInt(s.charAt(i) + ""));
          res.append(s.charAt(i));
          prev = s.charAt(i);
        }else{
          if(s.charAt(i)==prev){
            res.append(s.charAt(i));
          }else{
            int a = Integer.parseInt(prev + "");
            int b = Integer.parseInt(s.charAt(i) + "");
            appendBrackets(res, a - b);
            res.append(s.charAt(i));
            prev = s.charAt(i);
          }
        }
      }
      appendBrackets(res, Integer.parseInt(s.charAt(s.length() - 1) + ""));
      System.out.println(res);
    }
  }

  private static void appendBrackets(StringBuilder res, int cnt) {
    char c = cnt > 0 ? ')' : '(';
    cnt = cnt > 0 ? cnt : -cnt;
    for (int i = 0; i < cnt; i++){
      res.append(c);
    }
  }
}
