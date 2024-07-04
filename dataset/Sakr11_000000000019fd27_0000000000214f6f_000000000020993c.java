import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n;
		int indicator=0;
		int numberOfHouses;
		int nn;
		int counter=0;
		String A="",B="";
		int first=0,second=0;
		int sum=0;
		int rows=0,coulums=0;
		Scanner myObj = new Scanner(System.in);
		n=myObj.nextInt();
		
		
		
		for(int i=1 ; i<=n;i++) {
			
			nn=myObj.nextInt();
			int[][] finalarr=new int [nn][nn];
			for(int y=0; y<nn;y++) {
				for(int x=0; x<nn;x++) {
					finalarr[y][x]=myObj.nextInt();
					if(y==x)sum+=finalarr[y][x];
					
				}
			}
			int[][] column = new int[nn][nn];
			for(int y=0; y<nn;y++) {
					int arr[]=finalarr[y];
				
				    
					for(int u=0; u<nn;u++) {
						for(int uu=u+1; uu<nn;uu++) {
							if(arr[u]==arr[uu]) {
								if(indicator==0) {
								++rows;
								indicator=1;
								}
								
							}
						}
					}
					indicator=0;
			}	
					for(int u=0 ;u<nn;u++) {
						for(int uu=0; uu<nn;uu++) {
							column[uu][u]=finalarr[u][uu];
						}
					}
					for(int y=0; y<nn;y++) {
						int arr[]=column[y];
					
					    
						for(int u=0; u<nn;u++) {
							for(int uu=u+1; uu<nn;uu++) {
								if(arr[u]==arr[uu]) {
									if(indicator==0) {
										indicator=1;
									++coulums;
									break;
									}
								}
							}
						}
						indicator=0;
				}		
					
					System.out.println("Case #"+i+':'+' '+sum+' '+rows+' '+coulums);
					coulums=0;
					rows=0;
					sum=0;
			}
			
		
	}
}