import java.util.*;
class Vestigium{
	public static void main(String[] args){
		int T;	//Number of test cases
		List<String> finalOutput = new LinkedList<>();

		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		if(T < 1 || T > 100){
			System.out.println("1 <= T <= 100");
			System.exit(0);
		}
		int N = 0; 	//Size of square matrix
		int n = 0;
		while(n < T){
			N = sc.nextInt();
			if(N < 2 || T > 100){
				System.out.println("2 <= N <= 100");
				System.exit(0);
			}
			int k = 0;	//Trace of the matrix
			int r = 0; 	//Number of rows containing repeated elements
			int c = 0;	//Number of columns containing repeated elements
			int[][] M = new int[N][N];

			for(int i = 0; i < N; i++){
				for(int j = 0; j < N; j++){
					M[i][j] = sc.nextInt();
					if(M[i][j] > N) {
						System.out.println("Input should be in the range of Matrix size N");
						System.exit(0);
					}
				}
			}

			k = calculateTrace(M, N);
			r = rowsWithRepeatedElements(M, N);
			c = columnsWithRepeatedElements(M, N);

			finalOutput.add("Case #" + (n+1) + ": " + k + " " + r + " " + c);
			n++;
		}

		for(String s: finalOutput){
			System.out.println(s);
		}
	}

	public static int calculateTrace(int [][]m, int n){
		int trace = 0;
		for(int i = 0; i < n ; i++){
			for(int j = 0; j < n ; j++){
				if(i == j){
					trace += m[i][j];
				}
			}
		}
		return trace;
	}

	public static int rowsWithRepeatedElements(int [][]m, int n){
		int res = 0;
		int ele = -1;
		boolean repeated = false;
		for(int i = 0 ; i < n ; i++){
			for(int j = 0; j < n ; j++){
				ele = m[i][j];
				for(int k = j+1; k < n; k++){
					if(ele == m[i][k]){
						repeated = true;
						break;
					}
				}
				if(repeated) break;
			}
			if(repeated) res++;
		}
		return res;
	}

	public static int columnsWithRepeatedElements(int[][] m, int n){
		int res = 0;
		int ele = -1;
		boolean repeated = false;
		for(int j = 0 ; j < n ; j++){
			for(int i = 0; i < n ; i++){
				ele = m[i][j];
				for(int k = j+1; k < n; k++){
					if(ele == m[k][i]){
						repeated = true;
						break;
					}
				}
				if(repeated) break;
			}
			if(repeated) res++;
		}
		return res;
	}
}