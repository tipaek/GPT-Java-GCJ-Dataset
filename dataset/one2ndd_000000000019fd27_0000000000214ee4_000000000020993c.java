import java.io.*;

public class Solution{
	public static String vestigium(int[][] matrix,int N){
		int r=0,c=0,trace=0,mask=0,count=0;
		int[] visited=new int[N+1]; boolean visitedAll=true;
		for(int row=0;row<N;row++){ 
			visited=new int[N+1]; visitedAll=true;
			for(int col=0;col<N;col++){
				int num=matrix[row][col];
				visited[num]=1;
			}for(int i=1;i<N+1;i++){
				if(visited[i]==0)	visitedAll=false;
			}if(visitedAll==false)	r++;
		}
		for(int col=0;col<N;col++){ 
			visited=new int[N+1]; visitedAll=true;
			for(int row=0;row<N;row++){
				int num=matrix[row][col];
				visited[num]=1;
			}for(int i=1;i<N+1;i++){
				if(visited[i]==0)	visitedAll=false;
			}if(visitedAll==false)	c++;
		}for(int i=0;i<N;i++)	trace+=matrix[i][i];
		return String.valueOf(trace)+" "+String.valueOf(r)+" "+String.valueOf(c);
	}
	public static void main(String[] args)throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++){
			int N=Integer.parseInt(br.readLine());
			int[][] matrix=new int[N][N];
			for(int row=0;row<N;row++){
				String[] line=br.readLine().split(" ");
				for(int col=0;col<N;col++) 
					matrix[row][col]=Integer.parseInt(line[col]);
			}System.out.println("Case #"+t+": "+vestigium(matrix,N));
		}
	}
}