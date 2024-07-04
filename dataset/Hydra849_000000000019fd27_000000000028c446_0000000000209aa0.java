import java.io.*;
import java.util.*;
public class Solution {

	public static void main(String[]args) throws IOException{
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		int t = Integer.parseInt(sc.nextLine().trim());
		for(int i=1;i<=t;i++) {
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[][]matrix=new int[N][N];
			boolean possible=true;
			double K2 = K;
			
			if((K2/N)%1!=0||K2/N>N) {
				possible=false;
			}
			else {
				String output = "";
				for(int l=(int) (K2/N);l<=N;l++) {
					output+=l;
				}
				for(int l=1;l<(K2/N);l++) {
					output+=l;
				}
				
				for(int l=0;l<N;l++) {
					for(int m=0;m<N;m++) {
						matrix[l][m]=output.charAt(m)-48;
					}
					output = output.substring(output.length()-1)+output.substring(0, output.length()-1);
				}
				
			}
			
			
			
			if(possible) {
				
				
				
				System.out.println("Case #"+i+": POSSIBLE");
				for(int q=0;q<N;q++) {
					for(int w=0;w<N;w++) {
						System.out.print(matrix[q][w]+" ");
					}
					System.out.println();
				}
			}
			else {
				System.out.println("Case #"+i+": IMPOSSIBLE");
			}
		}
	}

}
