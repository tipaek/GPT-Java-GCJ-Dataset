import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			long answer = 0;
			long L = sc.nextLong();
			long R = sc.nextLong();
			
			while(Math.max(L, R)>=answer+1){
				answer++;
				if(L>=R){
					L-=answer;
				}
				else{
					R-=answer;
				}
			}
		
			System.out.printf("Case #%d: %d %d %d%n", t, answer, L, R);
		}
	}


	private static long solve(long min, long max, long base) {
		long low = 0;
		long high = (long)Math.sqrt(max-(base*base));
		long mid = 42;
		long ans = -1;
		while(low<=high){
			mid = (low+high)/2;
			long temp = calc(base+mid); 
			if(max-temp<min || temp < 0){
					ans = mid;
					high = mid-1;
				}
				else{
					low = mid+1;
				}
			}
		return ans;
	}

	
	private static long calc(long L) {
		return (L*(L+1))>>1;
	}

}
    