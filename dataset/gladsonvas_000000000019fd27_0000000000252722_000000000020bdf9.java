import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int T=Integer.parseInt(bufferedReader.readLine().trim());
		for(int i=1;i<=T;i++){
			int N=Integer.parseInt(bufferedReader.readLine().trim());
			int S[][]= new int[N][2];
			String[] multipleInput=new String[N];
			for(int r=0;r<N;r++)
			{
				multipleInput=bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
				for(int c=0;c<2;c++){
					S[r][c]=Integer.parseInt(multipleInput[c]);
				}
			}
			String y="";
			for(int x=0;x<N;x++){
				if(x==0){
					y=y+"C";
					continue;
				}
				// no overlap then give next task to the same guy if the same guy hasnt done the task twice already
				if(S[x][0]>=S[x-1][1] || S[x][1]<=S[x-1][0]){
					if(y.length()-2>=0){
						if(y.charAt(y.length()-1)==y.charAt(y.length()-2) && y.charAt(y.length()-1)=='C'){
							y=y+"J";
							continue;
						}
						else if(y.charAt(y.length()-1)==y.charAt(y.length()-2) && y.charAt(y.length()-1)=='J'){
							y=y+"C";
							continue;
						}
						else if(y.charAt(y.length()-1)!=y.charAt(y.length()-2)){
							y=y+y.charAt(y.length()-1);
							continue;
						}
					}
					else if(y.charAt(y.length()-1)=='C'){
						y=y+"C";
						continue;
					}
					else{
						y=y+"J";
						continue;
					}
				} 
				// if 2 consecutive tasks overlap then it is impoosible
				if(x-2>=0 && ((S[x][0]>=S[x-1][0] && S[x][0]<=S[x-1][1]) || (S[x][1]>=S[x-1][0] && S[x][1]<=S[x-1][1]) 
							&& (S[x][0]>=S[x-2][0] && S[x][0]<=S[x-2][1]) || (S[x][1]>=S[x-2][0] && S[x][1]<=S[x-2][1]))){
						y="IMPOSSIBLE";
						break;
					}					
				
				// if overlap then give next task to the other guy if the other guy hasnt done the task twice already
				if(S[x][0]>=S[x-1][0] && S[x][0]<=S[x-1][1] || S[x][1]>=S[x-1][0] && S[x][1]<=S[x-1][1]){
					if(y.length()-2>=0){
						if(y.charAt(y.length()-1)==y.charAt(y.length()-2) && y.charAt(y.length()-1)=='C'){
							y=y+"J";
							continue;
						}
						else if(y.charAt(y.length()-1)==y.charAt(y.length()-2) && y.charAt(y.length()-1)=='J'){
							y=y+"C";
							continue;
						}
						else if(y.charAt(y.length()-1)!=y.charAt(y.length()-2)){
							if(y.charAt(y.length()-1)=='C'){
								y=y+"J";
								continue;
							}
							else{
								y=y+"C";
								continue;
							}
						}
					}
					else if(y.charAt(y.length()-1)=='C'){
						y=y+"J";
						continue;
					}
					else{
						y=y+"C";
						continue;
					}
				}

			}

			System.out.println("Case #"+i+": "+y+"");
		}
	}
}
