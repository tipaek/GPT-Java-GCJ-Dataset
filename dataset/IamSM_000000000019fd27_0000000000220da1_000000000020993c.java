import java.util.*;
class Solution{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int no_of_prob = sc.nextInt();
		int ans[][] = new int[no_of_prob][3];
		for(int a=0;a<no_of_prob;a++)
		{
			//Scanner sc = new Scanner(System.in);
			//int n=4;
			int n = sc.nextInt();
			int x[][] = /*{{2,3,2,3},
						{2,2,2,2},
						{2,2,2,2},
						{2,2,2,2}
					};*/new int [n][n];
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
					x[i][j]=sc.nextInt();
			int trace=0;
			for(int i=0;i<n;i++)
				trace += x[i][i];
			//for row check
			int row = 0;
			for(int i=0;i<n;i++){
				int f=0;
				for(int j=0;j<n;j++){
					for(int k=j+1;k<n;k++){
						if(x[i][j] == x[i][k]){
							row++;
							f++;
							break;
						}
					}
					if(f==1)
						break;
				}
			}
			//for column check
			int col = 0;
			for(int j=0;j<n;j++){
				int f=0;
				for(int i=0;i<n;i++){
					for(int k=i+1;k<n;k++){
						if(x[i][j] == x[k][j]){
							col++;
							f++;
							break;
						}
					}
					if(f==1)
						break;
				}
			}
			ans[a][0]=trace;
			ans[a][1]=row;
			ans[a][2]=col;
			//System.out.print("Case #"+(a+1)+": "+trace+" "+row+" "+col);
		}
		for(int a=0;a<no_of_prob;a++)
		    if((a-1)!=no_of_prob)
			    System.out.println("Case #"+(a+1)+": "+ans[a][0]+" "+ans[a][1]+" "+ans[a][2]);
			else
			    System.out.print("Case #"+(a+1)+": "+ans[a][0]+" "+ans[a][1]+" "+ans[a][2]);
	}
}