import java.io.*;
import java.util.*;
import static java.util.Arrays.*;

public class Solution {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st = new StringTokenizer("");

  static void FILL() { try { while(!st.hasMoreTokens()) st = new StringTokenizer(in.readLine()); } catch (Exception e) { throw new AssertionError(e); }}
  static int INT() { FILL(); return Integer.parseInt(st.nextToken()); }
  static String STR() { FILL(); return st.nextToken(); }

  public static void main(String... args) throws Exception {
    int T = INT();
    for (int i = 0; i < T; i++) {
      System.out.printf("Case #%d: ", i+1);
      new Solution().entry();
    }
  }

  void entry() {
    int r = INT();
    int s = INT();
    System.out.println((r-1)*(s-1));
    Card front = null;
    Card back = null;
    for(int i = 0; i < s; i++) {
      for(int j = 0; j < r; j++) {
        Card now = new Card(j);
        if (front == null) {
          front = now;
          back = now;
        } else {
          back.next = now;
          now.prev = back;
          back = now;
        }
      }
    }
  //  printCards(front);
    int left = s*r;
    for(int num = r-1; num > 0; num--) {
    //  System.out.println("Processing rank " + num);
      back = back.prev;
      back.next =  null;
      left--;
      for(int no = 0; no < s-1; no++) {
     //   System.out.printf("Looking for swap #%d%n", no+1);
        Card at = front;
        int pileA = 1;
        while(at.num != num) {
          pileA++;
          at = at.next;
        }
        int pileB = left - pileA;
        System.out.printf("%d %d%n", pileA, pileB);
        Card bFront = at.next;
        Card bBack = back;
        Card aFront = front;
        Card aBack = at;
        bFront.prev = null;
        bBack.next = aFront;
        aFront.prev = bBack;
        aBack.next = null;

        left--;
        front = bFront;
        back = aBack.prev;
      }
    }
  }

  void printCards(Card front) {
    while(front.next != null) {
      System.out.printf("%d ", front.num);
      front = front.next;
    }
    System.out.println(front.num);
  }

  class Card {
    Card next;
    Card prev;
    int num;
    Card(int n) { num = n;}
  }

}
