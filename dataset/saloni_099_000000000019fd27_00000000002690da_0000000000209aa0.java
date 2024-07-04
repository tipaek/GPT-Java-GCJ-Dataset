
import java.util.*;

import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Solution   
{
	
	
	
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner in=new Scanner(System.in);
		
		int T=in.nextInt();
		
		for(int i=0;i<T;i++){
			
			int x=in.nextInt();
			int y=in.nextInt();
			int[][] arr=new int[x][x];
			int trace=0;
			
				
				int temp=1;
				
				for(int k=0;k<x;k++) {
					temp=k+1;
					for(int b=0;b<x;b++) {
						if(k==b) {
							trace=trace+temp;
						}
						arr[k][b]=temp;
						temp=temp+1;
						if(temp==x+1) {
							temp=1;
						}
						
					}
					
				}
				if(trace==y) {
				System.out.println("Case #" + (i+1) + ": " + ("POSSIBE") );
				
				for(int h=0;h<x;h++) {
					for(int m=0;m<x;m++) {
						System.out.print(arr[h][m]);
						
					}
					System.out.println();
					
				}
				
				}
				else {
					System.out.println("Case #" + (i+1) + ": " + ("IMPOSSIBE") );
				}
				
			
		}
			
		}
		    
}    
		
	

