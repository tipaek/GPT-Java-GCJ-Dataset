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
			int rows=0;
			for(int j=0;j<n;j++) {
				for(int k=0;k<n;k++) {
					int num = arr[j][k];
		            for (int m=k+1; m < n; m++)
		            {
		                if (num == arr[j][m])
		                {
		                   dup+=1;
		                   break;
		                }
		            }
		            
				}
				if(dup>=1) {
					rows+=1;
					dup=0;
				}

			
			}
			int dupc=0;
			int col=0;
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
		            
				}
				if(dupc>=1) {
					col+=1;
					dupc=0;
				}
	
			}
//			System.out.println(dupc);
		System.out.println("Case #"+i+": "+trace+" "+rows+" "+col);	
		
		}
	}
	

}
