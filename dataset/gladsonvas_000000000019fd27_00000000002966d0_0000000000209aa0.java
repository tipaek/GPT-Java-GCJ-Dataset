import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int T=Integer.parseInt(bufferedReader.readLine().trim());
		for(int i=1;i<=T;i++){
			String[] multipleInput=bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
			int N=Integer.parseInt(multipleInput[0]);
			int K=Integer.parseInt(multipleInput[1]);
			String y="";
			
			int[][] latinSquare= new int[N][N];
			int sum=0;
			for(int r=0;r<N;r++){
				for(int c=0;c<N;c++){
					if(r==0){
						latinSquare[r][c]=c+1;
					}
					else{
						if(c+1<N){
							latinSquare[r][c]=latinSquare[r-1][c+1];
						}
						else{
							latinSquare[r][c]=latinSquare[r-1][(c+1)%N];
						}
					}
					if(r==c){
						sum=sum+latinSquare[r][c];
					}
				}
			}
			if(sum==K){
				System.out.println("Case #"+i+": POSSIBLE");
			}
			else{
				System.out.println("Case #"+i+": IMPOSSIBLE");
			}
			
		}
	}
}
