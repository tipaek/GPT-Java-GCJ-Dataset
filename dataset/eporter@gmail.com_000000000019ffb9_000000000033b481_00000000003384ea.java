import java.io.IOException;
import java.util.Scanner;

public class Solution {
    final Scanner in;

	public static void main(String [] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
        Solution.run(scanner);
		scanner.close();
	}
    
    public static void run(Scanner in) {
        int cases = in.nextInt();
        for (int cs = 1; cs <= cases; cs++) {
            new Solution(in).runCase(cs);
        }
    }
	
	public Solution(Scanner in) {
	    this.in = in;
	}
	
	private void runCase(int cs) {
	    long left = in.nextLong();
	    long right = in.nextLong();
	    long i = 1; 
	    /*for ( ; i <= left || i <= right; i++) {
	        if (left >= right) {
	            left -= i;
	        } else {
	            right -= i;
	        }
	    }*/
	    
	    if (left >= right) {
	        long diff = left - right;
	        long init = binSearch(0, 1_000_000_000L, diff);
	        left -= init * (init+1) / 2;
	        for (i = init+1 ; i <= left || i <= right || Math.abs(left - right) > i; i++) {
	            if (left >= right) {
	                left -= i;
	            } else {
	                right -= i;
	            }
	        }
	    } else {
            long diff = right - left;
            long init = binSearch(0, 1_000_000_000L, diff);
            right -= init * (init+1) / 2;
            for (i = init+1 ; i <= left || i <= right || Math.abs(left - right) > i; i++) {
                if (left >= right) {
                    left -= i;
                } else {
                    right -= i;
                }
            }
	    }
	    long n = binSearch2(i, 0, 1_000_000_000L, Math.min(left, right));
	    if (n > 0) { n--; }
	    
	    if (n > 0) {
	        if (left >= right) {
	            long lStart = i;
	            long lEnd = lStart + (n-1)*2;
	            long lSum = (lStart + lEnd) * n / 2;
	            left -= lSum;
	            
                long rStart = i+1;
                long rEnd = rStart + (n-1)*2;
                long rSum = (rStart + rEnd) * n / 2;
                right -= rSum;
	        } else {
                long lStart = i+1;
                long lEnd = lStart + (n-1)*2;
                long lSum = (lStart + lEnd) * n / 2;
                left -= lSum;
                
                long rStart = i;
                long rEnd = rStart + (n-1)*2;
                long rSum = (rStart + rEnd) * n / 2;
                right -= rSum;
	        }
	        i += n * 2;
	    }
	    for ( ; i <= left || i <= right; i++) {
            if (left >= right) {
                left -= i;
            } else {
                right -= i;
            }
        }
	    println(String.format("Case #%s: %s %s %s", cs, i-1, left, right));
	}
    
    private static long binSearch2(long i, long lo, long hi, long tgt) {
        if (lo + 1 >= hi) {
            return lo;
        }
        long mid = (lo + hi) / 2;
        long iEnd = i + (mid - 1) * 2;
        long msum = (i + iEnd) * mid / 2;
        long msump = msum + msum + 1;
        if (msum <= tgt && msump >= tgt) {
            return mid;
        }
        if (msum > tgt) {
            return binSearch2(i, lo, mid, tgt);
        }
        return binSearch2(i, mid, hi, tgt);
    }
	
	private static long binSearch(long lo, long hi, long tgt) {
	    if (lo + 1 >= hi) {
	        return lo;
	    }
	    long mid = (lo + hi) / 2;
	    long msum = mid * (mid + 1) / 2;
	    long msump = msum + msum + 1;
	    if (msum <= tgt && msump >= tgt) {
	        return mid;
	    }
	    if (msum > tgt) {
	        return binSearch(lo, mid, tgt);
	    }
	    return binSearch(mid, hi, tgt);
	}
    
    private static void println(String s) {
        System.out.println(s);
        System.out.flush();
    }
}