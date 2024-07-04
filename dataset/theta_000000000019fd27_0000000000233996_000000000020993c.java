package classwork;

import java.util.*;


class vestigium{
	

	public static int[] ifVestigium(int matrix[][]){
		int arr[] = new int[3];
		int trace=0;
		int r=0;
		int c=0;
		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix.length; j++){
				if(i==j) {
					trace+=matrix[i][j];
				}
				int n = matrix[i][j];
				int m = matrix[i][j];
				for(int k=j; k<matrix.length-1; k++){
					if(n==matrix[i][k+1]){
					r++;
					}
				}
				for(int k=i; k<matrix.length-1; k++){
					if(n==matrix[k+1][i]){
					c++;
					}
				}
			}
			
			

		}
		arr[0]=trace;
		arr[1]=r;
		arr[2]=c;
		return arr;
	}

    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        int testCount = 1;
        
        
        while(testCount<=testCases) {
        int size = scan.nextInt();
        int matrix[][] = new int [size][size];

        for (int i=0; i<size; i++){
        	for(int j=0; j<size; j++){
        		matrix[i][j] = scan.nextInt();
        	}
        }
        int arr [] = new int [3];
        arr = ifVestigium(matrix);





        for (int i=0; i<arr.length; i++){
        		System.out.print("Case #"+testCount + ": "+arr[i]+" ");

        }
    }
        
    }


}