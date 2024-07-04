import java.io.*;

public class Solution{
	public static boolean doesOverlap(int a,int b,int aP,int bP){
		if((aP>=a && aP<b) || (bP<=b && bP>a))	return true;
		else					return false;
	}
	public static String assignment(int[][] interval,int N){
		int[][] overlapMTX=new int[N][N]; char[] stat=new char[N];
		int[] overlapCount=new int[N]; int a,b,aPrime,bPrime,ptr;
		String sched="";
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(i!=j){
					a=interval[i][0]; b=interval[i][1];
					aPrime=interval[j][0]; bPrime=interval[j][1];
					boolean tmp=doesOverlap(a,b,aPrime,bPrime);
					if(tmp==true){
						overlapMTX[i][j]=1;
						overlapCount[i]++; 
					}
				}
			}
		}for(int i=0;i<N;i++)	
			if(overlapCount[i]>2)	return "IMPOSSIBLE";
		int[][] overlapMtx=new int[N][2]; 
		for(int i=0;i<N;i++){ ptr=0;
			for(int j=0;j<N;j++)
				if(overlapMTX[i][j]==1)	overlapMtx[i][ptr++]=j;
		}for(int i=0;i<N;i++){
			if(overlapCount[i]==2){
				a=overlapMtx[i][0]; b=overlapMtx[i][1];
				if(overlapMTX[a][b]==1)	return "IMPOSSIBLE";
			}
		}for(int i=0;i<N;i++){
			if(stat[i]=='\0')	stat[i]='J';
			char adjColor=(stat[i]=='C')?'J':'C';
			for(int j=0;j<overlapCount[i];j++){
				a=overlapMtx[i][j]; 
				stat[a]=adjColor;
			}
		}for(int i=0;i<N;i++)	sched+=String.valueOf(stat[i]);
		//for(int i=0;i<N;i++)
		//	System.out.println(overlapMtx[i][0]+" "+overlapMtx[i][1]);
		return sched;
	}
	public static void main(String[] args)throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++){
			int N=Integer.parseInt(br.readLine());
			int[][] interval=new int[N][2];
			for(int i=0;i<N;i++){
				String[] SE=br.readLine().split(" ");
				int S=Integer.parseInt(SE[0]); 
				int E=Integer.parseInt(SE[1]); 
				interval[i][0]=S; interval[i][1]=E;
			}System.out.println("Case #"+t+": "+assignment(interval,N));
		}
	}
}