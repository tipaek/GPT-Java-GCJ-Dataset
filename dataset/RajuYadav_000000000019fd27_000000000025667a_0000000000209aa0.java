import java.util.*;
public class Solution {

	public static int[][]  indicium(int n){
		int matrix[][] = new int[n][n];
		for(int i = 0 ; i < n ; i++){
			int value = i+1;
			for(int j =0 ; j<n ; j++){
				if(i==0){
					matrix[i][j] = j+1;
				}else{
					if(value < (n+1)){
						matrix[i][j] = value;
						value++;
					}else{
						value = 1;
						matrix[i][j] = value;
						value++;
					}
					
				}
			}
		}
		return matrix;
	}

	public static int mainDiagonalSum(int[][] matrix,int n){
		int mainDiagonal = 0;
		for(int i = 0 ; i < n ; i++){
			for(int j =0 ; j<n ; j++){
				if(i==j){
					mainDiagonal = mainDiagonal + matrix[i][i];
				}
			}
		}

		return mainDiagonal;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int numberOfTestCase = input.nextInt();
		

		for(int p = 0 ; p < numberOfTestCase ; p++){
			int n = input.nextInt();
		    int k = input.nextInt();
		    int testCaseNumber = p+1;

		    int[][] returnMatix = new int[n][n];
            returnMatix = indicium(n);

            int mainDiagonal = mainDiagonalSum(returnMatix,n);
            if(mainDiagonal == k){            	
            	System.out.println("Case #"+testCaseNumber+":"+" POSSIBLE");
            	for(int i = 0 ; i<n ;i++){
            		for(int j = 0 ; j<n ;j++){
            			 System.out.print(returnMatix[i][j]+" "); 
            		}
            		System.out.println(); 
            	}

            }else{
            	System.out.println("Case #"+testCaseNumber+":"+" IMPOSSIBLE");
            }
		}

      // System.out.println("mainDiagonal "+mainDiagonal + "k given value "+k); 

	}
}