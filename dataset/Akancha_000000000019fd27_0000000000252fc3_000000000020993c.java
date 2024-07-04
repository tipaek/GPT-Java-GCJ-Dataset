import java.util.*;
import java.io.*;

class Matrix{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt(); int dimension;
		int trace[]=new int[t];int r[]=new int[t];int c[]=new int[t];
		for(int i=0;i<t;i++){
			dimension=sc.nextInt();
			int[][] a= new int[dimension][dimension];
			r[i]=0;c[i]=0;
			for(int j=0;j<dimension;j++){
				int rcheck[]=new int[dimension];
				boolean dup=false;
				for(int k=0;k<dimension;k++){
					a[j][k]=sc.nextInt();
					if(k==j)	trace[i]+=a[j][k];
					if(rcheck[a[j][k]-1]==1)  dup=true;
					else rcheck[a[j][k]-1]=1;
				}
				if(dup==true)	r[i]+=1;
			}
			for(int j=0;j<dimension;j++){
				int ccheck[]=new int[dimension];
				boolean dup=false;
				for(int l=0;l<dimension;l++){
					if(ccheck[a[l][j]-1]==1)  dup=true;
					else ccheck[a[l][j]-1]=1;				
				}
				if(dup==true)	c[i]+=1;	
			}
		}
		for(int i=0;i<t;i++)
			System.out.println("Case #"+(i+1)+": "+trace[i]+" "+r[i]+" "+c[i]);
	}
}