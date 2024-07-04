import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Indicium {
public static void main(String[]args) throws NumberFormatException, IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);
	int t=Integer.parseInt(br.readLine());
	StringTokenizer stt;
	for(int i=0;i<t;i++) {
		stt=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(stt.nextToken());
		int k=Integer.parseInt(stt.nextToken());
		int[][]a;
		if(n==2&&k%2!=0||(k%n!=0||k>n*n) ){
			out.println("Case #1: IMPOSSIBLE");
		}
		else {
				a=getPerm(n,k,true);
				//a=getPerm(n,k,false);
			
			out.println("Case #1: POSSIBLE");
			out.println(display(a));
		}
	}
	out.close();
}

private static String display(int[][] a) {
	String s="";
	for(int i=0;i<a.length;i++) {
		for(int j=0;j<a.length;j++) {
			s+=a[i][j]+" ";
		}
		s+="\n";
	}
	return s;
}

private static int[][] getPerm(int n, int k, boolean divideEvenly) {
	int [][]a=new int[n][n];
	int[]b=new int[n*n];
	int h=0;
	int cur=(k/n)+1;
	for(int i=1;i<b.length+1;i++) {
		 cur--;
		if(cur==0) 
			 cur=n;
		b[i-1]=cur;
		if(i%n==0)
			cur++;
	}
	for(int i=0;i<n;i++) {
			
			for(int j=0;j<n;j++) {
				a[i][j]=b[h++];
			}
		}
		
	
	return a;
}
}
