import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Solution {

	public static int sum( int[] array ){
		int ans = 0;
		for( int x = 0 ; x < array.length	; ++x ) ans+= array[x];
		return ans;
	}

	public static void print(int[][] matrix , StringBuilder bt){
		for( int i = 0; i < matrix.length ; ++i ){
			String line = matrix[i][0]+"";
			for( int j = 1 ; j < matrix[0].length ; ++j){
				line += " "+matrix[i][j];
			}
			bt.append(line+"\n");
		}
	}

//	public static void verif(int[] array , StringBuilder bt){
//		String linea = "";
//		for( int s : array ) linea+=s;
//		bt.append(linea+"\n");
//	}

	public static  boolean possible( int[] array ){

		int cont = 1;
		int max = 1;
		for( int i = 1 ; i < array.length ; ++i ){
			if( array[i] == array[i-1] ) cont++;
			else{ cont = 1 ; }
			if( cont > max ) max = cont;
		}
		return max != array.length-1;
	}

	public static void trace( int[][] matrix , int[] array ){
		for( int i = 0 ; i < matrix.length ; ++i ){
			matrix[i][i] = array[i];
		}
	}

	public static boolean fill( int[][] matrix){

		int row = -1;
		int col = -1;
		boolean f= true;
		for( int i = 0 ; i < matrix.length ; ++i ){
			for( int j =0; j < matrix.length ; ++j ){
				if( matrix[i][j] == 0 ){
					row = i; col = j;
					f = false;
					break;
				}
			} if( !f ){
				break;
			}
		}
		if( f ){
			return true;
		}
		for( int i = 1; i <= matrix.length; ++i ){
			if( safe(matrix, row, col , i)) {
				matrix[row][col] = i;
				if( fill(matrix)){
					return true;
				}
				else{
					matrix[row][col]=0;
				}
			}
		}
		return false;
	}



	public static boolean safe(int[][] matrix,  int row, int col,  int num)  
	{ 
		// Row 
		for (int d = 0; d < matrix.length; d++){ 
			if (matrix[row][d] == num){ 
				return false; 
			} 
		} 
		// Column 
		for (int r = 0; r < matrix.length; r++) 
		{ 
			if (matrix[r][col] == num){ 
				return false; 
			} 
		} 
		return true; 
	}


	public static void main(String[] args) {

		try{
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			String line = br.readLine();
			int n = Integer.parseInt(line);
			StringBuilder builder = new StringBuilder();


			for( int x = 0 ; x < n ; ++x ){

				String[] par = br.readLine().split(" ");
				int N = Integer.parseInt(par[0]);
				int K = Integer.parseInt(par[1]);
				int[][] matrix = new int[N][N];

				if( K == N+1 || K == N*N-1 ){
					builder.append("Case #"+(x+1)+": IMPOSSIBLE\n");
				}

				else if( K % N == 0 ){
					builder.append("Case #"+(x+1)+": POSSIBLE\n");
					int y = K/N;
					for( int i = 0 ; i < N ; ++i){
						matrix[i][0] = (y+i > N )? y+i-N : y+i;
						for( int j = 1 ; j < N ; ++j ){
							matrix[i][j] = (matrix[i][j-1]-1 == 0 )? N: matrix[i][j-1]-1;
						}
					}
					print(matrix , builder);
				}

				else{
					int[] array = new int[N];
					for( int k = 0 ; k < N ;++k ) array[k]= 1;

					boolean done = false;
					int a = 0;
					int b = 0;

					while( sum(array) != N*N ){

						if( sum(array) == K && possible(array)){
//							verif(array , builder);
							trace(matrix, array);
							if( fill(matrix)){
								builder.append("Case #"+(x+1)+": POSSIBLE\n");
								print(matrix, builder);
								done = true;
								break;
							}
						}

						if( array[a] == N){

							boolean f = false;
							for( int m = 0 ; m < N && ! f; m++){
								if( array[m] != N){
									b = m; f = true;
								}
							}
							array[b]++;	
							for( int k = 0 ; k <= b ; ++k ) array[k]=array[b];
							a = 0;
						}
						else{
							array[a]++;
						}
					}
					if( !done ){
						builder.append("Case #"+(x+1)+": IMPOSSIBLE\n");
					}
				}
			}
			System.out.println(builder.toString());
		}
		catch( Exception e ){

		}
	}
}
