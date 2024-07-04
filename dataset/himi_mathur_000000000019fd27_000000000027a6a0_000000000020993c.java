import java.util.Scanner;


class Solution {
	public static void main(String args[]) {
		Scanner input=new Scanner(System.in);
		int cases=input.nextInt();
		for(int i=1;i<=cases;i++) {
			int n=input.nextInt();
			int[][] arr=new int[n][n];
			for(int j=0;j<n;j++) {
				for(int k=0;k<n;k++) {
					int x=input.nextInt();
					arr[j][k]=x;
				}
			}
			int trace=0;
			for(int j=0;j<n;j++) {
				for(int k=0;k<n;k++) {
					if(j==k) {
						trace+=arr[j][k];
					}
				}
			}
	
	
			int dup=0;
			for(int j=0;j<n;j++) {
				for(int k=0;k<n;k++) {
					int num = arr[j][k];
		            for (int m=k+1; m < n; m++)
		            {
		                if (num == arr[j][m])
		                {
//		                   System.out.println(j+"dfg"+k);
		                   dup+=1;
		                   break;
		                }
		            }
		            break;

				}
				continue;
			
			}
			int dupc=0;
			for(int k=0;k<n;k++) {
				for(int j=0;j<n;j++) {
					int num = arr[j][k];
		            for (int m=j+1; m < n; m++)
		            {
		                if (num == arr[m][k])
		                {
		                   dupc+=1;
		                   break;
		                }
		            } 
		            break;
				}
				continue;
	
			}
//			System.out.println(dupc);
		System.out.println("Case #"+i+": "+trace+" "+dup+" "+dupc);	
		
		}
	}
	

}
