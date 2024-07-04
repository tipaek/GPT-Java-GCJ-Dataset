import java.util.*;
class Solution{
	public static void main(String[] args){
		Scanner sc= new Scanner(System.in);
		int t=sc.nextInt();
		for(int i=0;i<t;i++){
			int n=sc.nextInt();
			int[][] matrix=new int[n][n];
			int trace=0;
			int no_rep_rows=0;
			int no_rep_cols=0;
			for (int row=0;row<n;row++){
				for (int col=0;col<n;col++){
					matrix[row][col]=sc.nextInt();
					if(row ==col){
						trace+=matrix[row][col];
					}

				}
			}



			for (int row=0;row<n;row++){
				boolean[] visited=new boolean[n+1];
				for (int col=0;col<n;col++){
					if(visited[matrix[row][col]]==true){
						no_rep_rows+=1;
						break;

					}else{
						visited[matrix[row][col]]=true;
					}
				}
			}

			for (int col=0;col<n;col++){
				boolean[] visited=new boolean[n+1];
				for (int row =0;row<n;row++){
					if(visited[matrix[row][col]]==true){
	
						no_rep_cols+=1;
						break;
					}else{
						visited[matrix[row][col]]=true;
					}
				}
			}
			System.out.println("Case #"+(i+1)+": " +trace+" "+no_rep_rows+" "+no_rep_cols);

		}
	}
}