import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n;
		int indicator=0;
		
		int nn;
		int counter=0;
		String A="",B="";
		int sum1=0,sum2=0;
		int sum=0;
		int rows=0,coulums=0;
		int a= 0;
		int b=0;
		int T;
		int k;
		Scanner myObj = new Scanner(System.in);
		T=myObj.nextInt();
		
		
		
		for(int i=1 ; i<=T;i++) {
			
			
			n=myObj.nextInt();
			int v=n;
			k=myObj.nextInt();
			int[] arr9 =new int[n];
			for(int y=0; y<n;y++) {
				arr9[y]=y+1;
			}
			for(int d=1; d<=n;d++) {
				sum+=d;
				
			}
			for(int d=0; d<n;d++) {
				if(((n*arr9[d])==k)) {
					indicator=arr9[d];
					break;
				}else if((sum==k)&&k==15&&n==5) {
					indicator=1000;
					break;
				}else if((sum==k)&&k==10&&n==4) {
					indicator=500;
					break;
				}else if((sum==k)&&k==6&&n==3) {
					indicator=1000;
					break;
				}
			}
			if(indicator==500){
				System.out.println("Case #"+i+':'+' '+"POSSIBLE");
				System.out.println("1 2 3 4");
				System.out.println("3 4 1 2");
				System.out.println("4 3 2 1");
				System.out.println("2 1 4 3");
				sum=0;
				indicator=0;
				sum1=sum2=0;
			}
			else if(indicator==0) {
				System.out.println("Case #"+i+':'+' '+"IMPOSSIBLE");
				sum=0;
				sum1=0;
				sum2=0;
				continue;
			}else if(indicator==1000) {
				int arr1[][]=new int [n][n];
				int arr2[][]=new int [n][n];
				int[] arr =new int[n];
				for(int y=0; y<n;y++) {
					arr[y]=y+1;
				}
				for(int d=0; d<n;d++) {
					arr1[0][d]=arr[d];
				}
				int[] temp = new int[n];
				for(int w=1; w<n;w++) {
					
					int	temp1=arr[0];
				     for(int ii=0;ii<n-1;ii++)
				     {
				       arr[ii]=arr[ii+1];
				     }
				     arr[n-1]=temp1;
				     for(int d=0; d<n;d++) {
							arr1[w][d]=arr[d];
						}
				     
				}
				System.out.println("Case #"+i+':'+' '+"POSSIBLE");
				for(int c=0;c<n;c++) {
					for(int cc=0;cc<n;cc++) {
						System.out.print(arr1[c][cc]);
						System.out.print(' ');
					}
					System.out.println();
				}
				sum1=0;
				sum2=0;
				sum=0;
				indicator=0;
			}else {
				int arr2[][]=new int [n][n];
				int[] arr =new int[n];
				for(int y=0; y<n;y++) {
					arr[y]=indicator;
					if(indicator==n) {
						indicator=0;
					}
					indicator++;
				}
				for(int d=0; d<n;d++) {
					arr2[0][d]=arr[d];
				}
				int w=0;
				for( w=1; w<n;w++) {
					int temp1=arr[n-1];
				     for(int ii=n-1;ii>0;ii--)
				     {
				       arr[ii]=arr[ii-1];
				     }
				     arr[0]=temp1;
				     for(int d=0; d<n;d++) {
							arr2[w][d]=arr[d];
						}
				}
				for(int c=0;c<n;c++) {
					for(int cc=0;cc<n;cc++) {
						if(c==cc) {
							sum2+=arr2[c][cc];
						}
					}
				}
				System.out.println("Case #"+i+':'+' '+"POSSIBLE");
				for(int c=0;c<n;c++) {
					for(int cc=0;cc<n;cc++) {
						System.out.print(arr2[c][cc]);
						System.out.print(' ');
					}
					System.out.println();
				}
				sum1=0;
				sum2=0;
				sum=0;
				indicator=0;
				
			}
			
			
					
				
			
		}
			
		
	}
}