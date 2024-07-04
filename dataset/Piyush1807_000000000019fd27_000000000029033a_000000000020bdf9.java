import java.util.Scanner;

class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		
		for(int i=0; i<t; i++) {
			int n = sc.nextInt();
			if(n<2 || n>1000) {
				break;
			}
			int rc[][] = new int[n][2];
			for(int j=0; j<n; j++) {
				for(int k=0; k<2; k++) {
					rc[j][k] = sc.nextInt();
				}
			}

			int flag=0;
			int a[] = new int[n];
			a[0]=0;
			
			for(int j=1;j<n;j++) {
				int item = rc[j][0];
				int item1 = rc[j][1];
				int count=0;
				for(int k=0;k<j;k++) {
					if((item>rc[k][0] && item<rc[k][1]) || (item1>rc[k][0] && item1<rc[k][1])) {
						if(a[k]==0) {
							a[j]=1;
							count++;
							
						}
						else if(a[k]==1) {
							a[j]=0;
							count++;
							
						}
						
					}
				}
				if(count>=2) {
					flag=1;
					break;
				}
			}
			if(flag==0) {
				System.out.print("Case #"+(i+1)+": ");
				for(int j=0;j<n;j++) {
					if(a[j]==0) {
						System.out.print("C");
					}
					else {
						System.out.print("J");
					}
				}
				System.out.println();
			}
			else {
				System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
			}
			
		}
	}

}
