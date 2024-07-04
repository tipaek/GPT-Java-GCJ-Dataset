import java.lang.*;
import java.util.*;
import java.io.*;

class Solution{


	public static void main(String args[]){

		Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		int test=1;
		test=scan.nextInt();

		int x=1;
		if(test<=100 && test>=1){
			for(;x<=test;x++){

				int row=0;
				int col=0;
				int trace=0;

				int n=0;
				n=scan.nextInt();

				if(n<=100 && n>=2){

					int a[][]= new int[n][n];

					int i,j;
					//scanning the values into the matrix
					for(i=0;i<n;i++){
						for(j=0;j<n;j++){
							int t;
							t=scan.nextInt();
							if(t<=n && t>=1){
								a[i][j]=t;
							}
							else{
								break;
							}
						}
					}

					//i=1;
					//j=0;
					//for(;i<n;i++){
					//	for(;j<n;j++){
					//		System.out.print(" "+a[i][j]);
					//	}
					//	System.out.println("");
					//}

					//calculating the trace
					for(i=0;i<n;i++){
						trace=trace+a[i][i];
					}

					int temp;
					// checking all the columns
					int s;
					i=0;
					j=0;
					for(s=0;s<n;s++){
						
						int lis[]= new int[n];
						//saving column in a list
						for(i=0;i<n;i++){
							lis[i]=a[i][s];
						}

						//checking if list has duplication
						temp=0;
						int k=0,l=0;
						for(k=0;k<n-1;k++){

							int temp1=k;
							for(l=k+1;l<n;l++){
								if(lis[l]==lis[temp1]){
									temp=1;
									break;
								}
							}
						}
						
						//if duplication exists adding
						if(temp==1){
							col++;
						}
					}

					//checking all the rows
					s=0;
					for(;s<n;s++){
						
						int lis[]= new int[n];
						//saving row in a list
						for(i=0;i<n;i++){
							lis[i]=a[s][i];
						}

						//checking if list has duplication
						temp=0;
						int k=0,l=0;
						for(;k<n;k++){

							int temp1=k;
							for(l=k+1;l<n;l++){
								if(lis[l]==lis[temp1]){
									temp=1;
									break;
								}
							}
						}

						// if duplication exists adding
						if(temp==1){
							row++;
						}
					}

					System.out.println("Case #"+x+":"+" "+trace+" "+row+" "+col);
				}

			}
		}
		

	}
}