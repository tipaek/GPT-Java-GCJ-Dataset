import java.util.Scanner;
class Solution {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = Integer.parseInt(scan.nextLine());
        for(int i=0; i<t; i++) {
            int n = Integer.parseInt(scan.nextLine());
            int[][] matrix = new int[n][n];
            for(int j=0; j<n; j++) {
                String[] temp = scan.nextLine().split(" ");
                for(int k=0; k<n; k++) {
                    matrix[j][k] = Integer.parseInt(temp[k]);    
                }
            }
            int[] ans = solve(matrix, n);
            System.out.print("Case #" + (i+1) + ": ");
            for(int j=0; j<3; j++) {
                System.out.print(ans[j] + " ");
            }
            System.out.println();
        }
    }
    
    private static int[] solve(int[][] matrix, int n) {
		
		int[] ans = new int[3]; 
		int x=0, y=0;
		while(x<n && y<n) {
			ans[0] += matrix[x][y];
			x++;
			y++;
		}
		
		for(int i=0; i<n; i++) {
			boolean[] check = new boolean[n];
			for(int j=0; j<n; j++) {
				if(!check[matrix[i][j]-1]){
					check[matrix[i][j]-1] = true;
				}
				else {
					ans[1]++;
					break;
				}
			}
		}
		
		for(int j=0; j<n; j++) {
			boolean[] check = new boolean[n];
			for(int i=0; i<n; i++) {
				if(!check[matrix[i][j]-1]){
					check[matrix[i][j]-1] = true;
				}
				else {
					ans[2]++;
					break;
				}
			}
		}
		return ans;
	}
    
}