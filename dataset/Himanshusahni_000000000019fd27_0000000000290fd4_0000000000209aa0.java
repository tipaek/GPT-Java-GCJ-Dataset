import java.io.*;
import java.util.*;
public class Solution{

	public static void printMatrix(int n ,int k){
		int matrix[][] = new int[n][n];
		boolean ans = printMatrixHelp(matrix,n,k,0,0);
		if(!ans)
			System.out.print("IMPOSSIBLE\n");
		return;
	}
	public static boolean printMatrixHelp(int matrix[][],int n,int k,int i,int j){
		
		if(i==n && j==0 ){
			if(k == 0){
				System.out.print("POSSIBLE\n");
				for(int i1 = 0;i1<n;i1++){
					for(int j1 = 0;j1<n;j1++){
						System.out.print(matrix[i1][j1]+" ");
					}
					System.out.println();
				}
				return true;
			}else
				return false;
		}
		
		//Recursive Case
		int i1 , j1,k1 = k;
		for(int value = 1; value<=n ;value++){
			
			if(isPossibleToPlace(matrix,i,j,value)){
				matrix[i][j] = value;
				if( i == j )
					k1 = k - matrix[i][j]; 
				if(j == n-1){
					i1 = i+1;
					j1 = 0;
				}
				else {
					i1 = i;
					j1 = j +1;
				}

				boolean ans = printMatrixHelp(matrix,n,k1,i1,j1);
				if(ans == true)
					return true;
				matrix[i][j] = 0;
			}
		}
		return false;

	}
	public static boolean isPossibleToPlace(int matrix[][],int i, int j ,int value){
		//Check in the left row
		int j1 = j-1; 
		while(j1 >= 0){
			if(matrix[i][j1] == value)
				return false;
			j1--;
		}

		//Check in the above column
		int i1 = i-1;
		while(i1 >= 0){
			if(matrix[i1][j] == value)
				return false;
			i1--;
		}
		return true;
	}

	public static void main(String[]args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i = 1;i<=t;i++){
			String strArr[] = br.readLine().split(" ");
			int n = Integer.parseInt(strArr[0]);
			int k = Integer.parseInt(strArr[1]);
			System.out.print("Case #"+i+": ");
			printMatrix(n,k);

		}
	}
}