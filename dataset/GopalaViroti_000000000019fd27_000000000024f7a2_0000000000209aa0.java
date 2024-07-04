import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter w = new PrintWriter(System.out);
        int testCount = sc.nextInt();
        for (int i = 1; i <= testCount; i++)
            solve(i, sc, w);
        w.close();
	}

	public static void solve(int testNumber, Scanner sc, PrintWriter out) {
		int N=sc.nextInt();
		int K=sc.nextInt();
		int mat[][] = new int[N][N];
		StringBuilder ans2 = new StringBuilder();
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(i+j+1>N){
					mat[i][j]=(i+j+1)%N;
				}
				else{
					mat[i][j]=i+j+1;
				}
				ans2.append(mat[i][j]+" ");
			}
			ans2.append("\n");
		}
		int count = K;
		for(int i=0;i<N;i++)
			count-=mat[i][i];
		if(count==0){
			out.println("Case #" + testNumber + ": " + "POSSIBLE");
			out.println(ans2.toString());
		}
		else{
			out.println("Case #" + testNumber + ": " + "IMPOSSIBLE");
			//out.println(ans2.toString());
		}
	}
}