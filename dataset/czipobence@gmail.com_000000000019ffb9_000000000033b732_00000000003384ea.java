import java.util.*;
import java.io.*;
public class Solution {

    public static long estimateDiffCount(long l, long r) {
        long diff = Math.abs(l -r);
        if (diff == 0) {
            return 0;
        }
        long estim = (long) Math.sqrt(diff * 2);
        while ((estim * (estim + 1)/2 > diff)) {
            estim--;
        }
        return estim;
    }

    public static long doubleSum(long start, long end) {
        if (start %2 != end %2) {
            throw new IllegalStateException();
        }
        long n = (end - start) /2;
        return (n + 1) * start + n * (n+1);
    }

    public static long getCalls(long initValue, long startStep) {
        long estim = (long) (Math.sqrt(initValue));
        while (doubleSum(startStep, startStep + 2 *estim) > initValue) {
            estim--;
        }
        estim++;
        return estim;
    }

   public static void main(String[] args) {
       Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
       int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
       for (int i = 1; i <= t; ++i) {
           long l = in.nextLong();
           long r = in.nextLong();


           long newl, newr, totalCalls, estim;
           if (l > r) {
               estim = estimateDiffCount(l ,r);
               newl = l - estim * (estim + 1) / 2;
               newr = r;

           } else {
               estim = estimateDiffCount(l ,r);
               newl = l;
               newr = r - estim * (estim + 1) / 2;
           }

           if (newr > newl) {


               long calll = getCalls(newl, estim + 2);
               long callr = getCalls(newr, estim + 1);

               newl -= doubleSum(estim + 2, estim + 2 + 2 * (calll - 1));
               newr -= doubleSum(estim + 1, estim + 1 + 2 * (callr - 1));

               totalCalls = estim + calll + callr;
           } else {
               {
                   long calll = getCalls(newl, estim + 1);
                   long callr = getCalls(newr, estim + 2);

                   newl -= doubleSum(estim + 1, estim + 1 + 2 * (calll - 1));
                   newr -= doubleSum(estim + 2, estim + 2 + 2 * (callr - 1));

                   totalCalls = estim + calll + callr;
               }
           }

           System.out.println("Case #" + i + ": " + totalCalls + " " + newl + " " + newr);
       }
    }
}