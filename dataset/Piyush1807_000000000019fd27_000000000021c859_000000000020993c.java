import java.util.Scanner;

class Sol {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int i=0; i<t;i++) {
			int rcn = sc.nextInt();
			if(2>rcn || rcn>100) {
				break;
			}
			
			int rc[][]= new int[rcn][rcn];
			for(int j=0;j<rcn; j++) {
				for(int k=0; k<rcn; k++) {
					rc[j][k] = sc.nextInt();
					if((rc[j][k]<1) || (rc[j][k]>rcn)) {
						k--;
					}
					
				}
			}
			
			int count=0, rflag = 0, cflag = 0,rcount=0, ccount=0;
			for(int j=0;j<rcn; j++) {
				rflag=0;
				cflag=0;
				for(int k=0; k<rcn; k++) {
					if(j==k) {
						count = count + rc[j][k];
					}
					
					for(int ll=k+1;ll<rcn && k<rcn-1;ll++) {
						if(rc[j][k] == rc[j][ll]) {
							rflag =1;
						}
						if(rc[k][j] == rc[ll][j]) {
							cflag=1;
						}
					}
				}
				if(rflag ==1) {
					rcount++;
				}
				if(cflag ==1){
					ccount++;
				}
				
			}
			System.out.println(count+ " " + rcount+ " " + ccount);
			
		}

	}

}
