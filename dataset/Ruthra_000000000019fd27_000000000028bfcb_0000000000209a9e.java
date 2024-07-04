import java.util.Scanner;

public class Solution {
  public static String solve(Scanner input,int m) {
    System.out.println(m);
    int J = input.nextInt();
    if(J == 0){
        m = J;
    }
    System.out.println(m);
    String s = input.next();
    if (s.equals("Y")) {
      return s;
    } else if (s.equals("N")) {
      return s;
    } else {
      return ;
    }
  }

  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    int T = input.nextInt();
    int b = input.nextInt();
    String resp="";
    for (int s = 1; s <= T; s++) {
     resp = solve(input,1);
     if(resp =="N"){
         break;
     }
    }
  }
}