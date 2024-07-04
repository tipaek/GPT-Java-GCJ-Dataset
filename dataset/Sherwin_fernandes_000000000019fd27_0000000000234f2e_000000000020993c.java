import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		int T;
		do { T = s.nextInt(); } while( T<1 && T>100 );
		int x = 1;
		int op[][] = new int[T][4];
		
		for( int i = 0; i < T; i++ )
		{
			int N;
			do { N = s.nextInt(); } while( N<2 && N>100 );
			int M[][] = new int[N][N];
			int trace = 0;
			int r = 0, c = 0;
			
			for( int j = 0; j < N; j++ )
				for( int k = 0; k < N; k++ )
				{
					do { M[j][k] = s.nextInt(); } while( M[j][k]<1 && M[j][k]>N );
					if ( j == k )
						trace += M[j][k];
				}
					
			// duplicate row count
			for( int j = 0; j < N; j++ )
			{
				int k_ = 0;
				for( int k = 0; k < N-1; k++ )
				{
					if( M[j][k_] == M[j][k+1] )
					{
						r++;
						break;
					}
					if( (k+1) == (N-1) ) { k_++;  k = k_; }
						
				}
			}
			
			// duplicate column count
			for( int j = 0; j < N; j++ )
			{
				int k_ = 0;
				for( int k = 0; k < N-1; k++ )
				{
					if( M[k_][j] == M[k+1][j] )
					{
						c++;
						break;
					}
					if( (k+1) == (N-1) ) { k_++;  k = k_; k--; }
						
				}
			}
			
			// output array
			op[i][0] = x;
			op[i][1] = trace;
			op[i][2] = r;
			op[i][3] = c;
			
			x++; 
		}
		
		for( int i = 0; i < T; i++ )
			System.out.println("Case #"+ op[i][0] +": "+ op[i][1] +" "+ op[i][2] +" "+ op[i][3]);
			
		s.close();
	}
}
