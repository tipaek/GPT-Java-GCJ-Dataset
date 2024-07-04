import java.util.*;
import java.io.*;

class Matrix{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt(); int dimension;
		int trace[]=new int[t];
		for(int i=0;i<t;i++){
			dimension=sc.nextInt();
			int sum=(dimension*(dimension+1))/2;
			int[][] a= new int[dimension][dimension];
			int r=0,c=0;
			//input matrix for each test case
			for(int j=0;j<dimension;j++){
				int rsum=0;
				// boolean dup=false;
				for(int k=0;k<dimension;k++){
					a[j][k]=sc.nextInt();
					if(k==j)	trace[i]+=a[j][k];
					rsum+=a[j][k];
					// for(int l=0;l<k;l++){
					// 	if(a[j][l]==a[j][k])	dup=true;
					// }
				}
				if(sum!=rsum)	r+=1;
			}
			for(int j=0;j<dimension;j++){
				int csum=0;
				for(int l=0;l<dimension;l++){
					csum+=a[l][j];					
				}
				if(csum!=sum)	c+=1;	
			}
			System.out.println(trace[i]+" "+r+" "+c);
		}
	}
}