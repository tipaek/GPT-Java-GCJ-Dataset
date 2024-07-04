import java.io.*;
import java.util.*;
public class Main {
  public static void main(String[] args) throws IOException{
  Scanner sc = new Scanner(System.in);
  int T = sc.nextInt();
  for(int r = 1; r <= T; r++) {
    System.out.print("Case #" +  r + ": ");
    String l= sc.next();
    String ans = "";
    int val = 0;
    for(int i = 0; i < l.length(); i++) {
        while(val > Integer.parseInt(l.substring(i,i+1))) {
          ans += ")";
          val--;
        }
        while(val < Integer.parseInt(l.substring(i,i+1))) {
          ans += "(";
          val++;
        }
      ans += l.substring(i,i+1);
    }
    while(val > 0) {
      ans += ")";
      val--;
    }
    System.out.println(ans);
  }
}
  }