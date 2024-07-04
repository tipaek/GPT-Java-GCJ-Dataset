

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCases=scan.nextInt();
		for(int i=1;i<=testCases;i++) {
			String result="";
			int N=scan.nextInt();
			int[][] arr=new int[N][2];
			for( int u=0;u<N;u++) {
				for(int k=0;k<2;k++) {
				arr[u][k]=scan.nextInt();
			}
		}
			boolean flag=false;
			int counter=1;
			int[][] arr2=new int[N][N+1];
			for(int j=0;j<N;j++) {
				arr2[j][j]=1;
				counter=1;
				for(int k=j+1;k<N;k++) {
					if(arr[j][0]>=arr[k][1]||arr[j][1]<=arr[k][0]) {
						arr2[j][k]=1;
						counter++;
					}
				}
				arr2[j][N]=counter;
			}int sol=N+1;
			int []finale=new int [N];
			for(int l=0;l<N;l++) {
			for(int f=l+1;f<N;f++) {
				flag=false;
				if((arr2[l][N]+arr2[f][N])>=N) {
					for(int co=0;co<N;co++) {
					finale[co]=arr2[l][co]+arr2[f][co];
					if (finale[co]==0) {
						flag=true;
					}
					}
					if(flag==false) {
						sol=l;
					}
				}
			}
			}
			if(sol==N+1) {
				System.out.println("Case #"+i+": IMPOSSIBLE");
			}
			else {
				for(int d=0;d<N;d++) {
					if(arr2[sol][d]==1) {
						result=result.concat("C");
					}
					else {
						result=result.concat("J");
					}
				}
				System.out.println("Case #"+i+": "+result);
			}
			
		
		}

	}

	}


