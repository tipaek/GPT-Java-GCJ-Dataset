import java.util.*; 

public class Solution {
  static boolean debug = false;
  static boolean debugBrute = false;
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in); 

    int numT = in.nextInt(); 
    for(int t=0; t<numT; t++) {
      long l = in.nextLong(); 
      long r = in.nextLong(); 

      if(debugBrute) brute(l, r, t);

      // keep on taking from greater stack until it's <= the other stack
      // then you do a binary search on the other stack

      // Make two stacks roughly equal (to become alternating)
      long big = (l >= r) ? l : r;
      long small = (l < r) ? l : r;
      long lo = 0;
      long hi = 2_200_000_000l;  // double check max case
      long numNeededToEqual = search(lo, hi, big, small);
      long valChangeToEqual = ((1+numNeededToEqual)*numNeededToEqual)/2;
      // Now we swap again and binary search on both stacks
      if(l >= r) {
        l -= valChangeToEqual;
      } else {
        r -= valChangeToEqual; 
      }
      big = (l >= r) ? l : r; 
      small = (l < r) ? l : r;
      // if(debug) System.out.printf("NumNeededToEqual=%4d, ")
      if(debug) System.out.printf("After first search lo=%d hi=%d\n", lo, hi);
      long bigAns = search2(lo, hi, big, numNeededToEqual+1); // will first take from big
      long smallAns = search2(lo, hi, small, numNeededToEqual+2); // then from small

      // update the two values
      long bigDx = bigAns*(numNeededToEqual+1 + bigAns - 1);
      long smallDx = smallAns*(numNeededToEqual+2 + smallAns - 1); 
      if(l >= r) {
        l -= bigDx;
        r -= smallDx;
      } else {
        l -= smallDx;
        r -= bigDx;
      }
      
      if(debug) System.out.printf("numNeeded=%d bigAns=%d smallAns=%d\n", numNeededToEqual, bigAns, smallAns);

      // Made it so now it's the total
      // big ans is if your final take is big, small ans is if final take is small
      bigAns = bigAns + (bigAns-1);
      smallAns = smallAns + smallAns; 
      if(debug) System.out.printf("numNeeded=%d bigAns=%d smallAns=%d\n", numNeededToEqual, bigAns, smallAns);
      // If they're apart by 1, take the bigger one. Else take smaller
      long dif = bigAns - smallAns; 
      dif = (dif >= 0) ? dif : -dif;
      long ans = 0;
      if(dif == 1) {
        // if(bigAns > smallAns) {
        //   ans = bigAns;
        //   ans += bigAns-1;
        // } else {
        //   ans = smallAns;
        //   ans += smallAns;
        // }
        ans = (bigAns > smallAns) ? bigAns : smallAns;
      } else { 
        // if(bigAns < smallAns) {
        //   ans = bigAns;
        //   ans += bigAns-1;
        // } else {
        //   ans = smallAns;
        //   ans += smallAns;
        // }
        ans = (bigAns < smallAns) ? bigAns : smallAns;
      }
      ans += numNeededToEqual;

      System.out.printf("Case #%d: %d %d %d\n", (t+1), ans, l, r);
    }
  }

  static long search(long lo, long hi, long big, long small) {
    while(lo < hi) {
      long mid = (lo + hi+1)/2;
      
      long val = ((1+mid)*mid)/2; // (mid/2)*(1+mid)

      // It's good if big - val >= small (makes approximate equal, with big still bigger)
      if((big - val) >= small) {
        lo = mid;
      } else {
        hi = mid-1;
      }
    } 

    return lo;
  }

  static long search2(long lo, long hi, long x, long a) {
    while(lo < hi) {
      long mid = (lo + hi+1)/2;
      
      long val = mid*(a+mid-1); // (n/2)*(2*(a+n-1)) = n*(a+n-1)
      // if(debug) System.out.printf("%4d %4d %4d | val=%4d x=%4d\n", lo, hi, mid, val, x);

      // It's good if x - val >= 0 (can take all those days)
      if((x - val) >= 0) {
        lo = mid;
      } else {
        hi = mid-1;
      }
    }

    return lo;
  }

  static void brute(long l, long r, long t) {
    // brute force to make sure that it really does alternate
    // in hindsight it's because swapping back and forth will make the dx increase by 2
    // thus it won't mismatch
    int n = 1;
    boolean prev = false;
    boolean cur = true;
    int numL = 0;
    int numR = 0;
    while(l >= n || r >= n) {
      if(l >= r) {
        l -= n;
        if(debug) System.out.print("L ");
        numL++;
        cur = true;
      } else { 
        r -= n;
        if(debug) System.out.print("R ");
        numR++;
        cur = false;
      }
      n++;
      if(debug) System.out.printf("%4d %4d | %3d | %b\n", l, r, n, cur != prev);
      prev = cur;
    }
    n--;
    if(debug) System.out.printf("numL=%d numR=%d\n", numL, numR);
    System.out.printf("Case #%d: %d %d %d\n", (t+1), n, l, r);
  }

}
/* 

basically keep on taking from one stack until they're roughly equal
then you alternate from each stack

Can probably math/binary search it out.

1 + 2 + 3 + ... + n = (n/2)*(1+n)

a + (a+2) + (a+4) + ... + (a + 2*(n-1)) = (n/2)*(a + a + 2*(n-1)) 
a+2*0 + a+2*1 + ... + a+2(n-1)
                                        = (n/2)*(2*(a+n-1))

Test cases:


3
1 2
2 2
8 11

Case #1: 1 1 1
Case #2: 2 1 0
Case #3: 5 0 4


8 11
8 10
8 8
5 8
5 4
0 4
0 -2


1
100 100


1 
1000 1000

R   39    8 |  63 | true


3
1000000000000000000 1000000000000000000
1000000000000000000 0  
0 1000000000000000000


4
1000 1000
1000 0
0 1000
583 296



*/ 