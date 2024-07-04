import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[]args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st;
		long[][]C=new long[50][100];
		for(int i=0;i<50;i++) {
			for(int j=0;j<100;j++) {
				C[i][j]=(j==0)?1:(i==0)?0:C[i-1][j-1]+C[i-1][j];
				//System.out.print(C[i][j]+" ");
			}
		//	System.out.println();
		}
		//st=new StringTokenizer(br.readLine());
		//long l=Long.parseLong(br.readLine());
		//int []a=new int[n];
		//long []b=new long[n];
		//int[][]mat=new int[n][n];
		//long[][]longmat=new long[n][n];
		int t=Integer.parseInt(br.readLine());
		for(int i=0;i<t;i++) {
			int n=Integer.parseInt(br.readLine());
			out.println("Case #"+(i+1)+":");
			if(n<=500) {
				out.println(1+" 1");n--;
				if(n>=1) {out.println(2+" 2");n--;}
				if(n>=1) {out.println(2+" 1");n--;}
				int cur=3;
				for(;n>0;n--) {
					out.println(cur++ +" 1");
				}
			}else {
				out.println(1+" 1");n--;
				if(n>=1) {out.println(2+" 2");n--;}
				if(n>=1) {out.println(2+" 1");n--;}
				int cur=3;boolean goOnes=false;
				for(;n>0;n-=(cur++-1)) {
					if(n-(cur-1)<0) {goOnes=true;break;}
					out.println(cur +" 2");
				}
				if(goOnes) {
					out.println(cur++ +" 1");n--;
					for(;n>0;n--) {
						out.println(cur++ +" 1");
					}
				}
				
			}
			
		
		}

		out.close();
	}
}
