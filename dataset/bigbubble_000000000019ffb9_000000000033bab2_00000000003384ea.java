	import java.io.BufferedReader;
	import java.io.InputStreamReader;
	import java.util.*;
	import java.util.Scanner;
	
	public class Solution  {
		static Scanner sc;
	    // Driver method 
		public static void main(String args[]) 
		{ 
			sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
			
			int t = sc.nextInt();
			for (int i = 1; i <= t; i++) {
				long L = sc.nextLong();
				long R = sc.nextLong();
				
				boolean Lmax = false;
				if (L >= R) Lmax = true;
				long min = Math.min(L,  R);
				long max = Math.max(L,  R);
				
				long dif = max - min;
				long prefix = ((long)(Math.sqrt(8*dif + 1)) - 1)/2;
				max = max - prefix*(prefix + 1)/2;
				
				if (min == max) Lmax = true;
				long k = (-1)*prefix + ((long)Math.sqrt(prefix*prefix + 4*max)) - 1;
				long minLeft = -1;
				long maxLeft = -1;
				long customers = prefix;

				if (k == -1 || k == 0) {
					minLeft = min;
					maxLeft = max;
				}
				else {
					
					if (k % 2 == 0) k = k - 1;
					long kforMax = (k+1)*(2*prefix + k + 1)/4;
					long kforMin = (k+1)*(2*prefix + k + 3)/4;
					
					if (min >= kforMin) {
						customers += k+1;
					}
					else {
						kforMin = kforMin - (prefix + k+1);
						customers += k;
					}
					
					minLeft = min - kforMin;
					maxLeft = max - kforMax;
					
				}
				if (Lmax) {
					L = maxLeft;
					R = minLeft;
				}else {
					L = minLeft;
					R = maxLeft;
				}
				System.out.println("Case #" + i + ": " + customers + " " + L + " " + R);
			}
		}
		
	
	}
