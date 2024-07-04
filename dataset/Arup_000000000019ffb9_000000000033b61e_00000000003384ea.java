import java.util.*;

public class Solution {

	public static void main(String[] args) {
	
		Scanner stdin = new Scanner(System.in);
		int nC = stdin.nextInt();
		
		for (int loop=1; loop<=nC; loop++) {
		
			long left = stdin.nextLong();
			long right = stdin.nextLong();
			long n = 0;
			
			if (left >= right) {
				
				long delta = left-right;
				n = solveLeft(delta);
				
				// special case.
				if ( n*(n+1)/2 > left) n--;
				
				left -= (n*(n+1)/2);
			}
			
			else {
				
				long delta = right - left;
				n = solveRight(delta);
				
				if ( n*(n+1)/2 > right) n--;
				
				right -= (n*(n+1)/2);
				
			}
			
			// Update n
			n++;
			
			// now left, right close. n is last customer.
			
			if (left >= right) {
				
				// left is n + (n+2) + (n+4)...
				long termsL = get(left, n);
				// right is n+1 + (n+3) + (n+5)
				long termsR = get(right, n+1);
				
				if (termsL > termsR + 1) termsL = termsR+1;
				
				left -= (n*termsL + (termsL-1)*termsL);
				right -= ((n+1)*termsR + termsR*(termsR-1));
				n += (termsL + termsR-1);
				
			}
			
			else {
				long termsR = get(right, n);
				long termsL = get(left, n+1);
				if (termsR > termsL+1) termsR = termsL+1;
				right -= (n*termsR + (termsR-1)*termsR);
				left -= ((n+1)*termsL + termsL*(termsL-1));
				n += (termsL + termsR - 1);
			}
			
			
			
			System.out.println("Case #"+loop+": "+n+" "+left+" "+right);
		}
	}
	
	public static long get(long items, long start) {
		
		long low = 0, high = items/start+1;
		
		while (low < high) {
			long mid = (low+high+1)/2;
			
			long res = mid*start + mid*(mid-1);
			
			if (res <= items)
				low = mid;
			else
				high = mid-1;
			
		}
		
		return low;
	}
	
	// find y such that y*(y+1) > x and y*(y-1)/2 <= x.
	public static long solveLeft(long x) {
		
		long low = 0, high = x;
		
		while (low < high) {
			
			long mid = (low+high)/2;
			
			long t = (mid*(mid+1))/2;
			
			if (t <= x)
				low = mid + 1;
			else
				high = mid;
			
		}
		
		return low;
	}
	
	// find y such that y*(y+1) >= x and y*(y-1)/2 < x.
	public static long solveRight(long x) {
		
		long low = 0, high = x;
		
		while (low < high) {
			
			long mid = (low+high)/2;
			
			long t = (mid*(mid+1))/2;
			
			if (t < x)
				low = mid + 1;
			else
				high = mid;
			
		}
		
		return low;
	}	
}