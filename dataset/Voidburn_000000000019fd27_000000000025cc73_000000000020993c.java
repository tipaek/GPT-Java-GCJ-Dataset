import java.util.Scanner;
public class Solution{
	public static void main(String[]args){
		Scanner reader = new Scanner(System.in);		
		int t = 1,T;			//index of matrix, the number of matrix
		int dimension; 			//dimension of matirx
		int a,b,i,j,k;
		int x=0,N=0;
		T = reader.nextInt();
		if(T<1||T>100) System.exit(0);		
		while(t <= T) {
			N = reader.nextInt();
			int[][] mat = new int[N][N];
			for(i = 0; i < N; i++)
				for(j = 0; j < N; j++) {
					mat[i][j] = reader.nextInt();
				}
			int trace = 0; 
			for(i = 0; i < N; i++) {
				 trace = trace + mat[i][i];
			 }
			int r = 0;
			int c = 0;
			 
			for(i = 0; i < N; i++) {		
				for(j = 0; j < N - 1; j++)
		         {
		    	   b = mat[i][j];
		    	   for(k = j + 1; k < N; k++)
		    	       if(b == mat[i][k]) break;
		    	   if(k < N) break;
		    	  
		         }
				if(j < N -1) r = r + 1;
			
			}
			for(i = 0; i < N; i++){
				for(j = 0; j < N-1; j++) {
					b = mat[j][i]; 
					for(k = j + 1; k < N; k++)
		    	       if(b == mat[k][i]) break;
					if(k < N) break;
				}
				if(j < N -1) c = c + 1;	 
		     }
			x=x+1;
			System.out.print("Case #" +x+":"+ " " + trace + " ");
			System.out.print(r + " ");
			System.out.println(c);
		}
	}
}
		
		
		
		
		
		
		
		
		