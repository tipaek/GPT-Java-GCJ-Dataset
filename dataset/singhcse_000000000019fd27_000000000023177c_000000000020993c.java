import java.util.*;

class Vestigium{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1;t<=T;t++){
		int N = sc.nextInt();
		int[][] arr = new int[N][N];
		int diagonalSum = 0;
		int dupRows = 0;
		for(int i=0;i<N;i++){
			Set<Integer> rowSet = new HashSet<>();
			for(int j=0;j<N;j++){
				arr[i][j] = sc.nextInt();
				rowSet.add(arr[i][j]);
				if(i==j) diagonalSum+=arr[i][j];
			}
			if(rowSet.size() != N) dupRows++;
		}
		getResult(arr,N,t,diagonalSum,dupRows);
	}

	}

	private static void getResult(int[][] arr,int N,int testCase,int diagonalSum,int dupRows){
		int dupCol = 0;
		for(int  i=0;i<N;i++){
			Set<Integer> colSet = new HashSet<>();
			for(int j=0;j<N;j++){
				colSet.add(arr[j][i]);
			}
			if(colSet.size() != N) dupCol++;
		}
		System.out.println("Case #"+testCase+": "+diagonalSum+" "+dupRows+" "+dupCol);
	}
}