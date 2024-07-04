import  java.util.*;
class Vestigium{
	public static void main(String[] arhs){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int a[][]=new int[n][n];
			int sum=0;
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					a[i][j]=sc.nextInt();
					if(i==j)
						sum+=a[i][j];
				}
			}
			int row=0;
			for(int i=0;i<n;i++){
				int flag=0;
				for(int j=0;j<n-1;j++){
					for(int k=j+1;k<n;k++){
						if(a[i][j]==a[i][k]){
							row++;
							flag=1;
							break;
						}
					}
					if(flag==1)
						break;
				}
			}
			int col=0;
			for(int i=0;i<n;i++){
				int flag=0;
				for(int j=0;j<n-1;j++){
					for(int k=j+1;k<n;k++){
						if(a[j][i]==a[k][i]){
							col++;
							flag=1;
							break;
						}
					}
					if(flag==1)
						break;
				}
			}
			System.out.println(sum+" "+row+" "+col);
		}
	}
}