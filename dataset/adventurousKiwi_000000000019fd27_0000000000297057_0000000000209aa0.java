import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
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

	public static int[][] findMatrix(int[] diagonal){
		int N = diagonal.length;
		int [][] matrix = new int[N][N];
		for(int i=0;i<N;i++) {
			matrix[i][i]=diagonal[i];
		}
		
		return matrix;
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = Integer.parseInt(sc.nextLine());
		
		for(int i=0;i<T;i++) {
			
			int N = sc.nextInt();
			int trace = sc.nextInt();
			
			int [] sums = new int[N];
			for(int j=1;j<=N;j++) {
				sums[j-1]=trace-j*N;
			}
			int found = -1;
			for(int j=0;j<N;j++) {
				if(sums[j]==0) {
					found = j;
					break;
				}
			}
			
			if(found>=0) {
				System.out.println("Case #"+(i+1)+": POSSIBLE");

				int [] all = new int [N];
				
				for(int j = 1; j <= N; j++) {
					
					all[j-1]=j;
				}
				
				System.out.println(Arrays.toString(all));
				all = shiftRight(all,N-found);
				System.out.println(Arrays.toString(all));
				for(int j=0;j<N;j++) {
					for(int k=0;k<N;k++) {
						if(k==N-1) {
							System.out.println(all[k]);
							continue;
						}
						System.out.print(all[k]+" ");
					}
					all = shiftRight(all,1);
				}
			}
		}
		
		sc.close();
	}
}