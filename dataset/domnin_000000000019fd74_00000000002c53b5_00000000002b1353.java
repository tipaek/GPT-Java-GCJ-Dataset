

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    int tc = 1;
    outer:
    while (t-- > 0) {
      int N = in.nextInt();
      System.out.println("Case #" + tc++ + ":");
      N--;
      System.out.println("1 1");
      int next = 1;
      int r=1;
      while(N>0){
        if(N-next<0){
          while (N>0){
            System.out.println(r+" "+1);
            r--;
            N--;
          }
        } else {
          r++;
          System.out.println(r+" "+2);
          N-=next;
          next++;
        }
      }


    }
    System.out.flush();
  }
}
