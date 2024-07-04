import java.util.ArrayList;
import java.util.Scanner;


public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 1; i <= T; i++){
			long L = sc.nextLong();
			long R = sc.nextLong();
			
			long n = (long)Math.floor((-1+Math.sqrt(1+8*Math.abs(L-R)))/2.0);
			
			//System.out.println("n "+ n);
			
			boolean pref = L >= R;
			
			long A = Math.max(L,R);
			long B = Math.min(L,R);
			A-=n*(n+1)/2.0;
			
			//System.out.println("A " + A);
			if(A==B){
				pref = true;
			}
			long k = (long)Math.floor((-1-n+Math.sqrt(Math.pow(1+n,2)+4*B))/2.0);
			
			//System.out.println("k " + k);
			
			B -= (k*n+k*k+k);

			//System.out.println("B " + B);
			long r = 0;
			if(A-k*k-n*k >= n+2*k+1){
				r = 2*k+1;
				A -= k*k+n*k + n+2*k+1;
			}else{
				r = 2*k;
				A -= (k*k+n*k);
			}
			//System.out.println("r " + r);
			//System.out.println("A " + A);
			if(pref){
				L = A;
				R = B;
			}else{
				L = B;
				R = A;
			}
			System.out.println("Case #"+i+ ": " + (n+r)+ " " + L + " " + R);
			
		}
		sc.close();

	}

}
