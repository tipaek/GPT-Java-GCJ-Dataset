import java.util.Scanner;

public class Indicium {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		int T;
		do { T = s.nextInt(); } while( T<1 && T>100 );
		String op = "";
		int case_no = 1;
		
		for( int i = 0; i < T; i++ )
		{
			int N, trace = 0;
			do { N = s.nextInt(); } while( N<2 && N>50 );
			int K;
			do { K = s.nextInt(); } while( K<N && K>(N*N) );
			
			if( N==2 && K==2 ) { op += ("Case #"+ case_no +": POSSIBLE\n1 2\n2 1\n"); case_no++; continue; }
			if( N==2 && K==4 ) { op += ("Case #"+ case_no +": POSSIBLE\n2 1\n1 2\n"); case_no++; continue; }
			if( N==2 && K==3 ) { op += ("Case #"+ case_no +": IMPOSSIBLE\n"); case_no++; continue; }
			
			int M[][] = new int[N][N];
			int temp[] = new int[N];
			for( int j = 0; j < N; j++ )
				temp[j] = (j+1);
			
			int p = 0;
			for( int u = 0; u < N; u++ )
				for( int f = 0; f < N; f++ )
				{
					M[u][f] = temp[p];
					p++;
					if( f==N-1 ) p--;
					if( p==N ) p = 0;
					if( u == f ) trace += M[u][f];
				}
			
			if( trace == K )
			{
				op += ("Case #"+ case_no +": POSSIBLE\n");
				for( int u = 0; u < N; u++ )
				{
					for( int f = 0; f < N; f++ )
						op += ( String.valueOf(M[u][f]) + " " );
					op += "\n";
				}
			}
			else {
				int tp = 1, succ = 0;  
				while( tp<N && succ==0 )
				{	
					for( int u = 0; u < N; u++ )
					{
						int last = M[u][N-1];
						for( int f = N-1; f > 0; f-- )
						{
							M[u][f] = M[u][f-1];
						}
						M[u][0] = last;
					}
					
					trace = 0;
					for( int u = 0; u < N; u++ )
						for( int f = 0; f < N; f++ )
							if( u == f ) trace += M[u][f];
					
					if( trace == K )
					{
						op += ("Case #"+ case_no +": POSSIBLE\n");
						for( int u = 0; u < N; u++ )
						{
							for( int f = 0; f < N; f++ )
								op += ( String.valueOf(M[u][f]) + " " );
							op += "\n";
						}
						succ = 1; break;
					}
					tp++;
				}
				
				if( succ == 0 )
					op += ("Case #"+ case_no +": IMPOSSIBLE\n");
			}	
			case_no++;
		}
		
		System.out.println(op);
		s.close();
	}
}