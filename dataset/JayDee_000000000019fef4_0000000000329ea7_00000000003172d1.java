import java.util.*;
import java.io.*;

public class Solution {
  static boolean debug = true;
  public static void main(String[] args) {
    FS in = new FS(System.in);

    // Oi, use longs for angles, me.

    int numT = in.nextInt();
    for(int t=0; t<numT; t++) {
      int numSlices = in.nextInt(); 
      int numDiners = in.nextInt();

      TreeMap<Long, Integer> slices = new TreeMap<Long, Integer>(Collections.reverseOrder());  // <angle, freq>
      // long remSlice = 360_000_000_000l;
      long[] slicesOrdered = new long[numSlices];
      for(int i=0; i<numSlices; i++) {
        long sliceSize = in.nextLong();
        slicesOrdered[i] = sliceSize;
        slices.putIfAbsent(sliceSize, 0);
        slices.put(sliceSize, slices.get(sliceSize) + 1); 
        // remSlice -= sliceSize;
      }

      // slices.putIfAbsent(remSlice, 0);
      // slices.put(remSlice, slices.get(remSlice) + 1);


      int ans = numDiners-1; // worst case is you do numDiner cuts - 1 (take the ending cut and keep doing it)
      // wait isn't worst case = numDiners? if you have numDiner-1 cuts and each one non %50 == 0
      // and thus order matters oof.
      // well actually not really, still a larger set
      // wait you can have partial of a nano degree... oops
      // int otherSlicesEncountered = 0;
      // for(Map.Entry elem : slices.entrySet()) {
      //   long size = (long)elem.getKey();
      //   int freq = (int)elem.getValue();

      //   if (debug) System.out.printf("(%d, %d)\n", size, freq);

      //   if(freq >= numDiners) {
      //     ans = 0;  // Already cut, ayyy
      //   }

      //   // Here's the cheese,


      //   // if (debug) System.out.printf("%d, %d\n", size%2, size/2);
      //   if(numDiners == 3) {
      //     if(size%2 == 0) {
      //       // for 3 diners, see if we can find a slice to cut in half, and it already exists twice
      //       if(slices.containsKey(size/2)) {
      //         if(slices.get(size/2) >= 1) {
      //           if(ans > 1) {
      //             if(debug) System.out.printf("Can slice in half and get good\n");
      //             ans = 1;
      //           }
      //         }
      //       }
            
      //       // If there's 2 of me, and I can make one more out of something bigger
      //       if(freq >= 2) {
      //         if(otherSlicesEncountered >= 1) {
      //           if(ans > 1) {
      //             if(debug) System.out.printf("have two copies. make another from bigger\n");
      //             ans = 1;
      //           }
      //         }
      //       }
      //     }

      //   }
        

      //   if(numDiners == 2) {
      //     // can always cut in two
      //   }

      //   otherSlicesEncountered += freq;
      // }

      for(int targetAns = 0; targetAns<numDiners; targetAns++) {
        
        for(Map.Entry elem : slices.entrySet()) {
          long targetSize = (long)elem.getKey();
          
        }
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

newest idea:
Iterate from 0 to numDiners - 1. 
  For each one, you iterate through every single slice
  You'll attempt to make slices of that size. See how many are bigger that you can cut into that slice size
  But first you'll check all the things of that size*2 cause those cuts are super effective
  then you'll make sure it's possible.


// oh wait you can have partial nano degrees... oof

7
1 3
1
5 2
10 5 359999999999 123456789 10
2 3
8 4
3 2
1 2 3
1 3
4
2 3
2 2
3 3
2 2 3


Case #1: 2
Case #2: 0
Case #3: 1
Case #4: 1
Case #5: 2
Case #6: 2
Case #7: 1


Let's yeet the naive for n=2


1 
2 3
2 3

Case #1: 2


*/