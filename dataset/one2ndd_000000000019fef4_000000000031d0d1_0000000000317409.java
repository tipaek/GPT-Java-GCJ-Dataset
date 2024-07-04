import java.io.*;

class Solution{
	static String solve(int X,int Y,String M){
		for(int i=0;i<M.length();i++){
			if(M.charAt(i)=='N') Y++;
			if(M.charAt(i)=='S') Y--;
			if(M.charAt(i)=='E') X++;
			if(M.charAt(i)=='W') X--;
			if(Math.abs(X)+Math.abs(Y)<=i+1)
				return String.valueOf(i+1);
		}return "IMPOSSIBLE";
	}
	public static void main(String[] args)throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++){
			String[] XYM=br.readLine().split(" ");
			int X=Integer.parseInt(XYM[0]);
			int Y=Integer.parseInt(XYM[1]);
			String M=XYM[2];
			System.out.println("Case #"+t+": "+solve(X,Y,M));
		}
	}
}