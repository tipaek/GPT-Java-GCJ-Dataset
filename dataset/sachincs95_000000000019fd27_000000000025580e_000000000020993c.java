/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Vestigium
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i=0;i<t;i++){
			int s = Integer.parseInt(br.readLine());
			int sq[][] = new int[s][s];
			for(int j=0;j<s;j++){
				String s1[] = br.readLine().split(" ");
				for(int k=0;k<s;k++){
					sq[j][k] = Integer.parseInt(s1[k]);
				}
			}
			int sum=0;
			int ar[] = new int[s];
			
			int c = 0;
			int r = 0;
			for(int j=0;j<s;j++){
				sum += sq[j][j];
			}
			
			for(int j=0;j<s;j++){
				for(int l=0;l<s;l++){
				ar[l] = 0;
				}
				for(int k=0;k<s;k++){
					int idx = sq[j][k] - 1;
					if(ar[idx] == 0){
						ar[idx] = 1;
					}
					else{
						r++;
						break;
					}
				}
			}
			
			for(int j=0;j<s;j++){
				for(int l=0;l<s;l++){
				ar[l] = 0;
				}
				for(int k=0;k<s;k++){
					int idx = sq[k][j] - 1;
					if(ar[idx] == 0){
						ar[idx] = 1;
					}
					else{
						c++;
						break;
					}
				}
			}
			
			
			System.out.println("Case #"+(i+1)+": "+sum+" "+r+" "+c);
		}
	}
}