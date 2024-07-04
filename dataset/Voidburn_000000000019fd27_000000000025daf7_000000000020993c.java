import java.util.Scanner;
public class Solution {
	public static void main(String[]args){
		Scanner reader = new Scanner(System.in);		
		int t = 1,T;			//index of matrix, the number of matrix
		int dimension; 			//dimension of matirx
		int b,i,j,k;
		int x=0;
		T = reader.nextInt();
		if(T<1||T>100) System.exit(0);
		while(t <= T) {
			dimension = reader.nextInt();
			int[][] mat = new int[dimension][dimension];
			for(i = 0; i < dimension; i++)
				for(j = 0; j < dimension; j++) {
					mat[i][j] = reader.nextInt();
				}
			int trace = 0; 
			for(i = 0; i < dimension; i++) {
				 trace = trace + mat[i][i];
			 }
			int r = 0;
			int c = 0;
			 
			for(i = 0; i < dimension; i++) {	
				for(j = 0; j < dimension - 1; j++)
		         {
		    	   b = mat[i][j];
		    	   for(k = j + 1; k < dimension; k++)
		    	       if(b == mat[i][k]) break;
		    	   if(k < dimension) break;
		    	  
		         }
				if(j < dimension -1) r = r + 1;
			
			}
			for(i = 0; i < dimension; i++){
				for(j = 0; j < dimension-1; j++) {
					b = mat[j][i]; 
					for(k = j + 1; k < dimension; k++)
		    	       if(b == mat[k][i]) break;
					if(k < dimension) break;
				}
				if(j < dimension -1) c = c + 1;	 
		     }
			x=x+1;
			System.out.print("Case #" +x+":"+ " " + trace + " "+r + " "+c);
			
		}
	}
}
		
		
		
		
		
		
		
		
		
		