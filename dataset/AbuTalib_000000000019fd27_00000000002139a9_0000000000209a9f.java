import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int rr = in.nextInt();
    in.nextLine();
    for (int welp = 1; welp <= rr; welp++) {
      int counter = 0;
      StringBuilder sb = new StringBuilder();
      char[] line = in.nextLine().toCharArray();
      for(int c : line){
        c-=48;
        while(c>counter){
          sb.append("(");
          counter++;
        }
        while(c<counter){
          sb.append(")");
          counter--;
        }
        sb.append(c);
      }
      while(counter!=0){
        sb.append(")");
        counter--;
      }
      System.out.printf("Case #%d: %s%n", welp, sb);
    }
  }
}