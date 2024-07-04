import java.util.Scanner;

public class Solution{
	public static void main(String[] args){
		Scanner in =new Scanner(System.in);
		
		int T=Integer.parseInt(in.nextLine());
		
		for(int i=0;i<T;i++){
			int N=Integer.parseInt(in.nextLine());
			int[][] mat =new int[N][N];
			
			for(int j=0;j<N;j++){
				
				mat[j]= intify(in.nextLine().split(" "));
			}
			
			System.out.println("Case #"+(i+1)+": "+solve(mat));
		}
	}
	
	public static String solve(int[][] mat){
		//String ans="";
		int k=0;
		int r=0;
		int c=0;
		//sum arith: (n/2)(2a +(n-1)d)
		int check=(mat.length/2)*(2 +(mat.length -1));
		
		int[] sumRow=new int[mat.length];
		int[] sumCol=new int[mat.length];
		
		
		
		for(int i=0;i<mat.length;i++){
			sumRow=new int[mat.length];
			sumCol=new int[mat.length];
			boolean rdup=false;
			boolean cdup=false;
			
			for(int j=0;j<mat.length;j++){
				sumRow[mat[i][j]-1]++;
				sumCol[mat[j][i]-1]++;
				
				if(i==j){
					k+=mat[i][j];
				}
				
				if(sumRow[mat[i][j]-1] >1){
					rdup=true;
				}
				if(sumCol[mat[j][i]-1]>1){
					cdup=true;
				}
				
				
			}
			if(rdup){
				r++;
			}
			if(cdup){
				c++;
			}
		}
		
		
		
	
		return k+" "+r+" "+c;
		
	}
	
	public static int[] intify(String[] arr){
		int[] ans=new int[arr.length];
		
		for(int i=0;i<ans.length;i++){
			ans[i]=Integer.parseInt(arr[i]);
		}
		return ans;
	}
}