import java.util.*;
import java.lang.*;
import java.io.*;

class Solution{

  static Scanner in;
	public static void main(String[] args) {
	    in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    String line = in.nextLine();
      String[] tokens = line.split(" ");
      int t = Integer.parseInt(tokens[0]);
      int b = Integer.parseInt(tokens[1]);
	    for (int i = 1; i <= t; ++i) {
	      solve(b);
	    }
  	}

    static int count = 0;
  	public static void solve(int b){
      // System.err.println("new test case");
      int curIndex = 0;
      boolean[] bits = new boolean[b];

      int firstDiff = -1, firstEqual = -1;
      boolean firstDiffBit = false, firstEqualBit = false;
      
      while (curIndex < b/2) {
        boolean[] curBits = new boolean[b];

        count = 10;
        if (curIndex == 0) {
          boolean tempLeft = test(curIndex);
          boolean tempRight = test(b-curIndex-1);
          curBits[0] = tempLeft;
          curBits[b-1] = tempRight;
          curIndex++;
          if (tempLeft != tempRight) {
            firstDiff = 0;
            firstDiffBit = tempLeft;
          } else {
            firstEqual = 0;
            firstEqualBit = tempLeft;
          }
        } else {
          // check first diff to see if reverted
          if (firstEqual == -1) {
            boolean curDiffBit = test(firstDiff);
            if (curDiffBit != firstDiffBit) {
              for (int i = 0; i < b/2; i++) {
                curBits[i] = !bits[i];
                curBits[b-i-1] = !curBits[i];
              }
              firstDiffBit = curDiffBit;
            } else {
              for (int i = 0; i < b/2; i++) {
                curBits[i] = bits[i];
                curBits[b-i-1] = !curBits[i];
              }
            }
          }
          else if (firstDiff == -1) {
            boolean curEqualBit = test(firstEqual);
            // System.err.println("cur equal bit = " + curEqualBit);
            if (curEqualBit != firstEqualBit) {
              for (int i = 0; i < b/2; i++) {
                curBits[i] = !bits[i];
                curBits[b-i-1] = curBits[i];
              }
              firstEqualBit = curEqualBit;
            } else {
              for (int i = 0; i < b/2; i++) {
                curBits[i] = bits[i];
                curBits[b-i-1] = curBits[i];
              }
            }
          }
          else {
            boolean curDiffBit = test(firstDiff);
            boolean curEqualBit = test(firstEqual);
            if (curDiffBit == firstDiffBit && curEqualBit == firstEqualBit) {
              for (int i = 0; i < b; i++) curBits[i] = bits[i];
            } else if (curDiffBit != firstDiffBit && curEqualBit != firstEqualBit){
              for (int i = 0; i < b; i++) curBits[i] = !bits[i];
            } else if (curDiffBit != firstDiffBit) {
              for (int i = 0; i < b; i++) curBits[i] = bits[b-i-1];
            } else {
              for (int i = 0; i < b; i++) curBits[i] = !bits[b-i-1];
            } 
            firstEqualBit = curEqualBit;
            firstDiffBit = curDiffBit;
          }
        }

        bits = curBits;
        
        while (count > 1) {
          curBits[curIndex] = test(curIndex);
          curBits[b-curIndex-1] = test(b-curIndex-1);
          if (curBits[curIndex] != curBits[b-curIndex-1]) {
            if (firstDiff == -1) {
              firstDiff = curIndex;
              firstDiffBit = curBits[curIndex];
            } 
          } else {
            if (firstEqual == -1) {
              firstEqual = curIndex;
              firstEqualBit = curBits[curIndex];
            }
          }

          curIndex++;
          if (curIndex == b/2) {
            break;
          }
        }

        if (curIndex == b/2) {
          break;
        }
        while (count > 0) {
          test(0);
        }
      }

      StringBuilder solution = new StringBuilder();
      for (int i = 0; i < b; i++) {
        if (bits[i]) {
          solution.append('1');
        } else {
          solution.append('0');
        }
      }

      System.out.println(solution.toString());
  		System.out.flush();

  		String judge = in.nextLine();
  		if (judge.equals("N"))
  			System.exit(0);
  	}

    private static boolean test(int i) {
      System.out.println(i+1);

      String reply = in.nextLine();
      // System.err.println("query = " + i + " reply = " + reply);

      count--;

      return reply.equals("1") ? true : false;
    }
}
