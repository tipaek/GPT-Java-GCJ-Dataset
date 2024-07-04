import java.util.*;
import java.lang.*;
import java.io.*;

class Solution{

  static Scanner in;
	public static void main(String[] args) {
	    in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
      String[] tokens = in.nextLine().split(" ");
	    int t = Integer.parseInt(tokens[0]); // Scanner has functions to read ints, longs, strings, chars, etc.
      int a = Integer.parseInt(tokens[1]);
      int b = Integer.parseInt(tokens[2]);
	    for (int i = 1; i <= t; ++i) {
	      solve(a, b);
	    }
  	}

  	public static void solve(int a, int b){
      String query = "0 0";
      System.out.println(query);
      String reply = in.nextLine();
      if (reply.equals("CENTER")) return;

      if (reply.equals("HIT")) {
        // left intersection
        long lBound = binSearchLeft((long) -1e9, 0, 0);
        long rBound = binSearchRight(0, (long) 1e9, 0);
        long dBound = binSearchDown((long) -1e9, 0, 0);
        long uBound = binSearchUp(0, (long) 1e9, 0);
        query = (lBound + rBound) / 2 + " " + (dBound + uBound) / 2;
        System.out.println(query);
        // System.err.println(query);
        reply = in.nextLine();
        if (reply.equals("CENTER")) return;
        else {
          // System.err.println("ERROR");
          System.exit(0);
        }
      } else {
        long x = 0, y = 0;
        query = ((long) -1e9) / 2 + " " + 0;
        System.out.println(query);
        reply = in.nextLine();
        if (reply.equals("CENTER")) return;
        else if (reply.equals("HIT")) {
          long lBound = binSearchLeft((long) -1e9, ((long) -1e9) / 2, 0);
          long rBound = binSearchRight(((long) -1e9) / 2, 0,  0);
          x = (lBound + rBound) / 2;
        } else {
          long lBound = binSearchLeft(0, ((long) 1e9) / 2, 0);
          long rBound = binSearchRight(((long) 1e9) / 2, (long) 1e9,  0);
          x = (lBound + rBound) / 2;
        }

        query =  0 + " " + ((long) -1e9) / 2;
        System.out.println(query);
        reply = in.nextLine();
        if (reply.equals("CENTER")) return;
        else if (reply.equals("HIT")) {
          long dBound = binSearchDown((long) -1e9, ((long) -1e9) / 2, 0);
          long uBound = binSearchUp(((long) -1e9) / 2, 0,  0);
          y = (dBound + uBound) / 2;
        } else {
          long dBound = binSearchDown(0, ((long) 1e9) / 2, 0);
          long uBound = binSearchUp(((long) 1e9) / 2, (long) 1e9,  0);
          y = (dBound + uBound) / 2;
        }

        query = x + " " + y;
        System.out.println(query);
        // System.err.println(query);
        reply = in.nextLine();
        if (reply.equals("CENTER")) return;
        else {
          // System.err.println("ERROR");
          System.exit(0);
        }
      }
  	}

    private static long binSearchLeft(long l, long r, long y) {
      while (l < r) {
        long mid = l + (r-l) / 2;
        String query = mid + " " + y;
        System.out.println(query);
        // System.err.println(query);
        String reply = in.nextLine();
        // System.err.println("reply = " + reply);
        if (reply.equals("CENTER")) {
          return -1;
        }
        else if (reply.equals("WRONG")) {
          // System.err.println("ERROR");
          System.exit(0);
        }
        else if (reply.equals("HIT")) {
          r = mid;
        } else {
          l = mid+1;
        }
      }
      return l;
    }

    private static long binSearchRight(long l, long r, long y) {
      while (l < r) {
        long mid = r - (r-l) / 2;
        String query = mid + " " + y;
        System.out.println(query);
        // System.err.println(query);
        String reply = in.nextLine();
        // System.err.println("reply = " + reply);
        if (reply.equals("CENTER")) {
          return -1;
        }
        else if (reply.equals("WRONG")) {
          // System.err.println("ERROR");
          System.exit(0);
        }
        else if (reply.equals("HIT")) {
          l = mid;
        } else {
          r = mid-1;
        }
      }
      return l;
    }

    private static long binSearchDown(long l, long r, long x) {
      while (l < r) {
        long mid = l + (r-l) / 2;
        String query = x + " " + mid;
        System.out.println(query);
        // System.err.println(query);
        String reply = in.nextLine();
        // System.err.println("reply = " + reply);
        if (reply.equals("CENTER")) {
          return -1;
        }
        else if (reply.equals("WRONG")) {
          // System.err.println("ERROR");
          System.exit(0);
        }
        else if (reply.equals("HIT")) {
          r = mid;
        } else {
          l = mid+1;
        }
      }
      return l;
    }

    private static long binSearchUp(long l, long r, long x) {
      while (l < r) {
        long mid = r - (r-l) / 2;
        String query = x + " " + mid;
        System.out.println(query);
        // System.err.println(query);
        String reply = in.nextLine();
        // System.err.println("reply = " + reply);
        if (reply.equals("CENTER")) {
          return -1;
        }
        else if (reply.equals("WRONG")) {
          // System.err.println("ERROR");
          System.exit(0);
        }
        else if (reply.equals("HIT")) {
          l = mid;
        } else {
          r = mid-1;
        }
      }
      return l;
    }
}
