import java.io.*;

public class Solution{
	public static String vestigium(int[][] matrix,int N){
		int r=0,c=0,trace=0,mask=0;
		for(int row=0;row<N;row++){ mask=0;
			for(int col=0;col<N;col++){
				int num=matrix[row][col];
				mask|=(1<<num);
			}if(mask!=2*((1<<N)-1))	r++;
			//System.out.println(Integer.toBinaryString(mask));
		}
		for(int col=0;col<N;col++){ mask=0;
			for(int row=0;row<N;row++){
				int num=matrix[row][col];
				mask|=(1<<num);
			}if(mask!=2*((1<<N)-1))	c++;
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