import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String args[]) {
		Scanner kb=new Scanner(System.in);
		
		int cases=kb.nextInt();
		
		
		for(int i=0; i<cases; i++) {
		    
		    
			int N=kb.nextInt();
			
			int matrix[][]= new int[N][N];
			
			for(int j=0; j<N; j++) {
				for(int k=0; k<N; k++) {
					matrix[j][k]=kb.nextInt();
				}
			}
			
			int dia=0;
			
			for(int y=0; y<N; y++) {
				dia+=matrix[y][y];
			}
			
			System.out.print("Case #" + (i+1) +": " + dia + " ");
			
			int rowCount=0;
			int columnCount=0;
			
			for(int j=0; j<N; j++) {
			    boolean rReset=true;
		     boolean cReset=true;
				boolean rowC[]=new boolean[N];
				boolean colC[]=new boolean[N];
				
				for(int k=0; k<N; k++) {
					rowC[matrix[j][k]-1]=true;
					colC[matrix[k][j]-1]=true;
				}
				
				for(int k=0; k<N; k++) {
					if(rowC[k]==false&&rReset) {
						rowCount++;
						rReset=false;
					}
					if(colC[k]==false&&cReset) {
						columnCount++;
						cReset=false;
					}
				}
				
			}
			
			System.out.println(rowCount + " " + columnCount);
			
		}
	}
}
