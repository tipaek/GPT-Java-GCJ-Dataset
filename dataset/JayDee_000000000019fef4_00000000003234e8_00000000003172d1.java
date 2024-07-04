import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    FS in = new FS(System.in);

    // Oi, use longs for angles, me.

    int numT = in.nextInt();
    for(int t=0; t<numT; t++) {
      int numSlices = in.nextInt(); 
      int numDiners = in.nextInt();

      TreeMap<Long, Integer> slices = new TreeMap<Long, Integer>(Collections.reverseOrder());  // <angle, freq>
      long remSlice = 360_000_000_000l;
      long[] slicesOrdered = new long[numSlices];
      for(int i=0; i<numSlices; i++) {
        long sliceSize = in.nextLong();
        slicesOrdered[i] = sliceSize;
        slices.putIfAbsent(sliceSize, 0);
        slices.put(sliceSize, slices.get(sliceSize) + 1); 
        remSlice -= sliceSize;
      }

      // slices.putIfAbsent(remSlice, 0);
      // slices.put(remSlice, slices.get(remSlice) + 1);


      int ans = numDiners-1; // worst case is you do numDiner cuts - 1 (take the ending cut and keep doing it)
      // wait isn't worst case = numDiners? if you have numDiner-1 cuts and each one non %50 == 0
      // and thus order matters oof.
      // well actually not really, still a larger set
      int otherSlicesEncountered = 0;
      for(Map.Entry elem : slices.entrySet()) {
        long size = (long)elem.getKey();
        int freq = (int)elem.getValue();

        if(freq >= numDiners) {
          ans = 0;  // Already cut, ayyy
        }

        // Here's the cheese,


        if(numDiners == 3) {
          if(size%2 == 0) {
            // for 3 diners, see if we can find a slice to cut in half, and it already exists twice
            if(slices.containsKey(size/2)) {
              if(slices.get(size/2) >= 1) {
                if(ans > 1) {
                  ans = 1;
                }
              }
            }
            // If there already exists a slice
            if(otherSlicesEncountered >= 1) {
              if(ans > 1) {
                ans = 1;
              }
            }
          }

          if(size%3 == 0) {
            //slice a slice into thirds
            if(ans > 2) {
              ans = 2;
            }
          }


        }
        

        if(numDiners == 2) {
          if(size%2 == 0) {
            if(ans > 1) {
              ans = 1;
            }
          }
          if(otherSlicesEncountered >= 1) {
            if(ans > 1) {
              ans = 1;
            }
          }
        }

        otherSlicesEncountered += freq;
      }

      System.out.printf("Case #%d: %d\n", (t+1), ans);
    }

  }
  static class FS {
    BufferedReader in;
    StringTokenizer token; 
    public FS(InputStream stream) {
      in = new BufferedReader(new InputStreamReader(stream));
    }
    public String next() {
      if(token == null || !token.hasMoreElements()) {
        try {
          token = new StringTokenizer(in.readLine()); 
        } catch(Exception e) {} 
        return next();
      }
      return token.nextToken(); 
    }
    public int nextInt() {
      return Integer.parseInt(next());
    }
    public long nextLong() {
      return Long.parseLong(next());
    }
  }
}

/* 

Pretty sure this isn't binary searchable (on the size)
Like it may be optimal to have them at size X, and we have a slice at X*2, then slicing 
that slice in half is optimal. Not optimal for size X-1. oof

Notably: numDiners <= 50.


Worst case: 49 slices necessary
Hold up. binary search on the number of slices?
  wait a sec... may not be possible for a given number of slices

Hold up again, worst case is log(50) + 1? // take 64, divide up into segments.
  hold up... nope that's still 50 cuts. ya doof

How about we check only critical spots?
Meaning... things that are multiples of eachother
You only do a slice size, sliceSize%NumDiners, and maybe(?) other sizes.

4
1 3
1
5 2
10 5 359999999999 123456789 10
2 3
8 4
3 2
1 2 3

Case #1: 2
Case #2: 0
Case #3: 1
Case #4: 1

Let's yeet the naive for n=2

*/