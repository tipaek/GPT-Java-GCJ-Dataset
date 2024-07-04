import java.util.*;

public class Solution{
  public static void solve10(Scanner input) {
    String s = "";
    for (int i = 1; i <= 10; i ++){
      System.out.println(i);
      String response = input.next();
      s += response;
    }
    System.out.println(s);
    if (s.equals("Y") || s.equals("N")) return;
  }

  public static void solve20(Scanner input){
    return;
  }

  public static void solve100(Scanner input){
    return;
  }

  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    int T = input.nextInt();
    int B = input.nextInt();
    if (B == 10){
      for (int ks = 1; ks <= T; ks++) {
        solve10(input);
      }
    }else if (B == 20){
      for (int ks = 1; ks <= T; ks++) {
        solve20(input);
      }
    }else{
      for (int ks = 1; ks <= T; ks++) {
        solve100(input);
      }
    }
  }
}