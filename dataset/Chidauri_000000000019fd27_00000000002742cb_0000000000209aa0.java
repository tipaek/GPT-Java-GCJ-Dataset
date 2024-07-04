import java.util.*;

class Solution{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int q=0;q<t;q++){
			int n = in.nextInt();
			int k = in.nextInt();
			int diagonal_element = 0;
			boolean is_possible = false;
			for(int i=1;i<=n;i++){
				diagonal_element = n*i;
				if(k - diagonal_element == 0){
					is_possible = true;
					diagonal_element = i;
					break;
				}
			}
			if(!is_possible){
				System.out.println("Case #" + (q+1) + ": IMPOSSIBLE");
			} else {
				System.out.println("Case #" + (q+1) + ": POSSIBLE");
				int[][] arr = new int[n][n];
				for(int i=0;i<n;i++){
					if(i == 0){
						arr[0][i] = diagonal_element;
					} else {
						arr[0][i] = (arr[0][i-1] - 1) < 1 ? (n + (arr[0][i-1] - 1)) : (arr[0][i-1] - 1);
					}
					for(int j=1;j<n;j++){
						arr[j][i] = (arr[j-1][i] + 1) > n ? (arr[j-1][i] + 1 - n) : (arr[j-1][i] + 1);
					}
				}
				for(int i=0;i<n;i++){
					for(int j=0;j<n;j++){
						System.out.print(arr[i][j] + " ");
					}
					System.out.println();
				}
			}
		}
	}
}