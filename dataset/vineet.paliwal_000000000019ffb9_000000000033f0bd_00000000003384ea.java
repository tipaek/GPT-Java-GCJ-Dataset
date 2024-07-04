import java.util.Scanner;

class Solution {

	static long steps,sum;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		long L ;
		long R ;
		for(int i =1 ; i <= t ; i++) {
			long n = 0;
			long l = 0;
			long r = 0;
			L = scan.nextLong();
			R = scan.nextLong();
			long j = 1;
			while((j<=L)||(j<=R)) {
				
				if(L>=R) {
					long diff = L-R;
					findSteps(diff,j);
					L-=sum;
					j+= steps;
				} else {
					long diff = R-L;
					findSteps(diff,j);
					R-=sum;
					j+=steps;
				}
				sum = 0 ;
				steps = 0;
			}
			
			n = j - 1;
			l = L;
			r = R;
			System.out.print("Case #" + i + ": ");
			System.out.println(n + " " + l + " " + r);
		}
	}
	
	public static void findSteps(long diff,long j) {
		long k = 1;
		steps = 1;
		sum = j;
		double jump = 2;
		int trials = 1;
		while(sum<=diff) {
			trials++;
			if(trials>50) {
				break;
			}
			long kk = new Double(k * jump).longValue();
			if(kk<=k) {
				break;
			}
			k = kk;
			long mysum = (k*(2*j+k-1))/2;
			if(mysum<=diff) {
				sum = mysum;
				steps = k;
			} else {
				jump = (1+jump)/2;
			}
			
		}
	}

}
