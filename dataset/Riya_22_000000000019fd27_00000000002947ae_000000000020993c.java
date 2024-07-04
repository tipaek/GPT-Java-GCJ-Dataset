import java.util.Scanner;
import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		int t= s.nextInt();
		for(int y=0; y<t; ++y) {
			int n= s.nextInt();
			int mat[][]= new int[n][n];
			for(int i=0; i<n; ++i) {
				for(int j=0; j<n; ++j) {
					mat[i][j]=s.nextInt();
				}
			}
			int row=0;
			int rep=1;
			for(int i=0; i<n; ++i) {
				HashMap<Integer,Integer> map= new HashMap<>();
				rep=1;
				for(int j=0; j<n; ++j) {
					if(map.containsKey(mat[i][j])) {
						rep=0;
						break;
					}
					else {
						map.put(mat[i][j], 1);
					}	
				}
				if(rep==0) {
					
					row++;
				}
					
			}
			int col=0;
			int c=1;
			for(int i=0; i<n; ++i) {
				HashMap<Integer,Integer> map= new HashMap<>();
				c=1;
				for(int j=0; j<n; ++j) {
					if(map.containsKey(mat[j][i])) {
						//System.out.println(i);
						c=0;
						break;
					}
					else {
						map.put(mat[j][i], 1);
					}
					
				}
				if(c==0) {
					col++;	
				}	
			}
			int sum=0;
			for(int i=0,j=0; i<n && j<n; ) {
				sum+=mat[i][j];
				j++;
				i++;
			}
			
			System.out.println("Case #"+ (y+1)+ ": "+ sum+ " "+ row+ " "+ col); 
			
		}
	}
}
