import java.util.*;

class Solution{
	public static void main(String a[]) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt(),test=1;
		while(t-->0) {
			int n=sc.nextInt(),exp=sc.nextInt();
			int arr[][]=new int[n][n];
			ArrayList<Integer> ar=new ArrayList<Integer>();
			if(exp<=n*n) {
				for(int i=0;i<n;i++) {
					ar.add(i+1);				
				}
				if(exp%n==0) {
					while(ar.get(0)!=(exp/n))
					{						
						Collections.rotate(ar,-1);					
						//System.out.print(ar.get(0));
					}for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							arr[i][j]=ar.get(j);
						}
						Collections.rotate(ar,1);
					}
					System.out.println("Case #"+test+": POSSIBLE");
					test++;
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							System.out.print(arr[i][j] + " ");
						}
						System.out.println();
					}
				}
				else {
					System.out.println("Case #"+test+": IMPOSSIBLE");
					test++;
				}
			}
			else {
					System.out.println("Case #"+test+": IMPOSSIBLE");
					test++;
			}
		}
	}
}