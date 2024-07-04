import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();

            int trace = 0;
            int repline = 0;
            int repcol = 0;

            Set<Integer>[] numColTrack = new HashSet[n+1];
            boolean cflag[] = new boolean[n+1];
            for(int j = 0; j<n; j++)
            {
                boolean[] lflag = new boolean[n+1];
                boolean hasShowinLine = false;
                for(int k = 0; k<n; k++)
                {
                    int m = in.nextInt();
                    if(!lflag[m])
                        lflag[m] = true;
                    else        
                        hasShowinLine = true;

                    if(numColTrack[m] == null) numColTrack[m] = new HashSet<>();
                    if(numColTrack[m].contains(k))
                    {
                        cflag[k] = true;
                    }
                    else
                        numColTrack[m].add(k);

                    if(j == k) trace += m;
                }
                if(hasShowinLine) repline++;
            }
            for(boolean c : cflag)
            {
                if(c) repcol++;
            }
            System.out.println("Case #" + i + ": " + trace + " " + repline + " " + repcol);
        }
    }
}
