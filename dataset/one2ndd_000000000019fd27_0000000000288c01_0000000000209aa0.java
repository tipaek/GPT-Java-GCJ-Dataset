import java.io.*;

public class Solution{
	public static void viewMtx(int[][] mtx,int N){
		for(int r=0;r<N;r++){
			for(int c=0;c<N;c++)
				System.out.print(mtx[r][c]+" ");
			System.out.println();
		}System.out.println();
	}
	public static String computeTrace(int[] P,int N,int K){
		int trace=0; String mtx="POSSIBLE\n";
		int[][] latinMtx=new int[N][N];
		for(int i=0;i<N;i++){
			latinMtx[0][i]=P[i];
			for(int j=1;j<N;j++){
				latinMtx[j][i]=((P[i]+j)%N==0)?N:(P[i]+j)%N;
			}
		}//viewMtx(latinMtx,N);
		for(int r=0;r<N;r++){
			for(int c=0;c<N;c++){
				mtx+=String.valueOf(latinMtx[r][c]); if(c<N-1) mtx+=" ";
			}if(r<N-1)mtx+="\n";
		}for(int i=0;i<N;i++)	trace+=latinMtx[i][i];
		return (trace==K)?mtx:"";
	}
	public static String indicium(int visited,int[] P,int ptr,int N,int K){
		String ret="";
		if(visited==2*((1<<N)-1)){  //for(int i=0;i<N;i++) System.out.print(P[i]+" "); System.out.println();
			return computeTrace(P,N,K); 
		}for(int i=1;i<=N;i++){
			if(((1<<i)&visited)==0){
				int tmp=P[ptr];
				P[ptr]=i;
				ret=indicium(visited|(1<<i),P,ptr+1,N,K);
				if(!ret.equals(""))	break;
				P[ptr]=tmp;
			}
		}
		return ret;
	}
	public static void main(String[] args)throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++){
			String[] NK=br.readLine().split(" ");
			int N=Integer.parseInt(NK[0]);
			int K=Integer.parseInt(NK[1]);
			int[] P=new int[N];
			String ret=indicium(0,P,0,N,K);
			if(ret.equals(""))	ret="IMPOSSIBLE";
			System.out.println("Case #"+t+": "+ret);
		}
	}
}