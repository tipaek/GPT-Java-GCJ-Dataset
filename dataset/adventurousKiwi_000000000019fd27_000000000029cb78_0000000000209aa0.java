import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	private List<int[][]> matrices;
	
	public Solution() {
		matrices = new ArrayList<int[][]>();
	}
	
	public static int [] shiftLeft(int [] arr,int n) {
		
		if(n==0) return arr;
		
		int [] newArr = Arrays.copyOf(arr, arr.length);
		for(int i=0;i<n;i++) {
			int temp = newArr[0];
			int[] tempArr = Arrays.copyOf(newArr,arr.length);
			for(int j=1;j<arr.length;j++) {
				newArr[j-1]=tempArr[j];
			}
			newArr[arr.length-1]=temp;
		}
		return newArr;
	}
	
	public static int sum(int [] arr) {
		int sum = 0;
		for(int i=0;i<arr.length;i++) {
			sum+=arr[i];
		}
		return sum;
	}
	
	public static int [] shiftRight(int [] arr,int n) {
		
		if(n==0) return arr;
		int [] newArr = Arrays.copyOf(arr,arr.length);
		for(int i=0;i<n;i++) {
			int temp = newArr[arr.length-1];
			int[] tempArr = Arrays.copyOf(newArr,arr.length);
			for(int j=0;j<arr.length-1;j++) {
				newArr[j+1]=tempArr[j];
			}
			newArr[0]=temp;
		}
		return newArr;
	}

	public static int[][] findMatrix(int[] row){
		int N = row.length;
		int [][] matrix = new int[N][N];
		for(int i=0;i<N;i++) {
			matrix[0][i]=row[i];
		}
		for(int i=0;i<N-1;i++) {
			row = shiftLeft(row,1);
			for(int j=0;j<N;j++) {
				matrix[i+1][j]=row[j];
			}
		}
		return matrix;
	}
	
	public static int[][] findMatrixRight(int[] row){
		int N = row.length;
		int [][] matrix = new int[N][N];
		for(int i=0;i<N;i++) {
			matrix[0][i]=row[i];
		}
		for(int i=0;i<N-1;i++) {
			row = shiftRight(row,1);
			for(int j=0;j<N;j++) {
				matrix[i+1][j]=row[j];
			}
		}
		return matrix;
	}
	
	public static void swap(int[] input, int a, int b) {
	    int tmp = input[a];
	    input[a] = input[b];
	    input[b] = tmp;
	}
	
	public void printAllRecursive(int n, int[] elements,int t) {
		
		if(this.matrices.size()==1) {
			return;
		}
	    if(n == 1) {
	    	int [][] matrix = findMatrix(elements);
	    	int trace = 0;
	    	for(int i=0;i<matrix[0].length;i++) {
	    		trace+=matrix[i][i];
	    	}
	    	if(trace==t) {
	    		this.matrices.add(matrix);
	    	}else {
	    		matrix = findMatrixRight(elements);
	    		trace = 0;
		    	for(int i=0;i<matrix[0].length;i++) {
		    		trace+=matrix[i][i];
		    	}
		    	if(trace==t) {
		    		this.matrices.add(matrix);
		    	}
	    	}
	    	
	    } else {
	        for(int i = 0; i < n-1; i++) {
	            printAllRecursive(n - 1, elements,t);
	            if(n % 2 == 0) {
	                swap(elements, i, n-1);
	            } else {
	                swap(elements, 0, n-1);
	            }
	        }
	        printAllRecursive(n - 1, elements,t);
	    }
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = Integer.parseInt(sc.nextLine());
		
		for(int i=0;i<T;i++) {
			
			int N = sc.nextInt();
			int trace = sc.nextInt();
			
			Solution ind = new Solution();
			int [] all = new int[N];
			for(int j=0;j<N;j++) {
				all[j]=j+1;
			}
			ind.printAllRecursive(N, all, trace);
			
			if(ind.matrices.size()==1) {
				System.out.println("Case #"+(i+1)+": POSSIBLE");
				int[][] mat = ind.matrices.get(0);
				for(int[] row:mat) {
					for(int j=0;j<row.length;j++) {
						if(j==row.length-1) {
							System.out.println(row[j]);
						}else {
							System.out.print(row[j]+" ");
						}
					}
				}
			}else {
				System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
			}
		}
		
		sc.close();
	}
}
