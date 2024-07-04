

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Solution{
	
	public static int[] count(int[][] mat,int n) {
		int countr[]=new int[2];
		Arrays.fill(countr,0);
		HashMap hm=new HashMap(); 
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(!hm.containsKey(mat[i][j])) {
					hm.put(mat[i][j],1);
				}
				else {
					 int r=(int)hm.get(mat[i][j]);
					 hm.put(mat[i][j],++r);
				}
				
				
				
			}
			int flag=0;
			
			for(int j=0;j<hm.size();j++) {
				if((int)hm.get(mat[i][j])>1) {
					
					flag=1;
					break;
				}
				
					
			}
			

			if(flag==1) {++countr[0];
				
			}
			hm.clear();
			flag=0;
		}
		hm.clear();
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(!hm.containsKey(mat[j][i])) {
					hm.put(mat[j][i],1);
				}
				else {
					 int r=(int)hm.get(mat[j][i]);
					 hm.put(mat[j][i],++r);
				}
				
				
			}
			int flag1=0;
			
			for(int j=0;j<hm.size();j++) {
				if((int)hm.get(mat[j][i])>1) {
					flag1=1;
					break;
				}
				
				
			}
			if(flag1==1)
				countr[1]++;
			flag1=0;
			hm.clear();
		}
		
		return countr;
		
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		int n;
		for(int i=0;i<t;i++) {
			n=sc.nextInt();
			int sum=0;
			int mat[][]=new int[n][n];
			for(int j=0;j<n;j++) {
				for(int z=0;z<n;z++) {
					mat[j][z]=sc.nextInt();
					if(j==z) {
						sum+=mat[j][z];
					}
				}
			}
			int rol[]=count(mat,n);
			
			System.out.println("Case #"+(i+1)+": "+sum+" "+rol[0]+" "+rol[1]);
			sum=0;
		}
	}

}
