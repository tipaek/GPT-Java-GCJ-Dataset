import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
    public static void main (String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        int test = scan.nextInt();
		for(int t=0;t<test;t++){
			 int n = scan.nextInt();
			 int trace=0;
			 int r=0;
			 int c=0;
			int a[][]=new int [n][n];
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					a[i][j]=scan.nextInt();
					
				}
			}
			for(int i=0;i<n;i++){
				trace=trace+a[i][i];
			}
			for(int i=0;i<n;i++){
				Set<Integer> s=new HashSet<>();
				for(int j=0;j<n;j++){
					if(!s.contains(a[i][j])){
					s.add(a[i][j]);
				}
				else{
					r++;
					break;
				}
				}
			}
			for(int i=0;i<n;i++){
				Set<Integer> y=new HashSet<>();
				for(int j=0;j<n;j++){
					if(!y.contains(a[j][i])){
					y.add(a[j][i]);}
				
				else{
					r++;
					break;
				}
				}
			}
			System.out.println("Case #"+(test+1)+": "+trace+" "+r+" "+c);
    }
    }
    }