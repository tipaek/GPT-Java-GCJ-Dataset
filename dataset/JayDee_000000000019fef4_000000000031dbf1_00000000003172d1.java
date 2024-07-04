import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    FS in = new FS(System.in); 

    int numT = in.nextInt(); 
    for(int t=0; t<numT; t++) {
      int numDigits = in.nextInt(); 
      
      int[] freq = new int[256];
      HashSet<Integer> charsUsed = new HashSet<>();
      for(int query=0; query<10_000; query++) {
        long maxVal = in.nextLong(); 

        char[] raw = in.next().toCharArray(); 
        int[] digits = new int[raw.length];
        for(int i=0; i<raw.length; i++) {
          digits[i] = (int)raw[i];
          charsUsed.add(digits[i]);
        }

        // If q = -1... odd.
        
        freq[digits[0]]++;
      }

      // char[] ans = new char[10];
      // Finding 0
      String ans = "";
      for(int usedLet : charsUsed) {
        if(freq[usedLet] == 0) {
          // ans[0] = (char)usedLet;
          ans += (char)usedLet;
        }
      }

      for(int digit=1; digit<10; digit++) {
        // find max
        int max = 0;
        int maxLet = 0;
        for(int i=0; i<256; i++) {
          if(max < freq[i]) {
            max = freq[i];
            maxLet = i;
          }
        }
        // ans[digit] = (char)max;
        ans += (char)maxLet;
        freq[maxLet] = 0;
      }

      System.out.printf("Case #%d: %s\n", (t+1), ans);


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

Test

welp too big

So what we can learn is that a given letter is <= the first letter of M
Then we could probably work up from that

This assumes we know what M is, though.

We'd probably take the smallest bound for any number
The worst data is if it's not the same magnitude.
Then back to q = -1


Regardless of M,

Noteably, from the test data, no leading zeroes I believe.
So we can probably guess that if all the data doens't use a letter for a leading digit
then it's 0

How do we work our way up from there?


We might be able to look at the frequency of the first digits
Based on the test data being a randomly selected number from 1-randomly selected number
The leading digits should(???) be roughly in frequency order
As in, 1 should be most common, then 2, then 3, then ...
0 wouldn't appear at all

Should I yeet that?
Wouldn't hurt.

Hand-wavy

10_000 maybe(?) has enough data for 10 different diigts spread out





*/