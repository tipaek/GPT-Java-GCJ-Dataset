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
			String latestAssigned="";
			int indexOfLatestAssigned=0;
			for(int x=0;x<N;x++){
				// for the first task assign c
				if(x==0){
					y=y+"C";
					continue;
				}
				// no overlap
				if(S[x][0]>=S[x-1][1] || S[x][1]<=S[x-1][0]){
					if(y.length()-2>=0){
						if(y.charAt(y.length()-1)==y.charAt(y.length()-2) && y.charAt(y.length()-1)=='C'){
							indexOfLatestAssigned=y.lastIndexOf("J");
							if(indexOfLatestAssigned>-1){
								if((S[x][0]>=S[indexOfLatestAssigned][0] && S[x][0]<S[indexOfLatestAssigned][1]) || 
										(S[x][1]>S[indexOfLatestAssigned][0] && S[x][1]<=S[indexOfLatestAssigned][1]) || 
										(S[x][0]<S[indexOfLatestAssigned][1] && S[x][1]>=S[indexOfLatestAssigned][1]) || 
										(S[x][0]<S[indexOfLatestAssigned][0] && S[x][1]>=S[indexOfLatestAssigned][0])){
									y="IMPOSSIBLE";
									break;
								}
							}
							y=y+"J";
							continue;
						}
						else if(y.charAt(y.length()-1)==y.charAt(y.length()-2) && y.charAt(y.length()-1)=='J'){
							indexOfLatestAssigned=y.lastIndexOf("C");
							if(indexOfLatestAssigned>-1){
								if((S[x][0]>=S[indexOfLatestAssigned][0] && S[x][0]<S[indexOfLatestAssigned][1]) || 
										(S[x][1]>S[indexOfLatestAssigned][0] && S[x][1]<=S[indexOfLatestAssigned][1]) || 
										(S[x][0]<S[indexOfLatestAssigned][1] && S[x][1]>=S[indexOfLatestAssigned][1]) || 
										(S[x][0]<S[indexOfLatestAssigned][0] && S[x][1]>=S[indexOfLatestAssigned][0])){
									y="IMPOSSIBLE";
									break;
								}
							}
							y=y+"C";
							continue;
						}
						else if(y.charAt(y.length()-1)!=y.charAt(y.length()-2)){
							indexOfLatestAssigned=y.lastIndexOf(y.charAt(y.length()-1));
							if(indexOfLatestAssigned>-1){
								if((S[x][0]>=S[indexOfLatestAssigned][0] && S[x][0]<S[indexOfLatestAssigned][1]) || 
										(S[x][1]>S[indexOfLatestAssigned][0] && S[x][1]<=S[indexOfLatestAssigned][1]) || 
										(S[x][0]<S[indexOfLatestAssigned][1] && S[x][1]>=S[indexOfLatestAssigned][1]) || 
										(S[x][0]<S[indexOfLatestAssigned][0] && S[x][1]>=S[indexOfLatestAssigned][0])){
									y="IMPOSSIBLE";
									break;
								}
							}
							y=y+y.charAt(y.length()-1);
							continue;
							
						}
					}
					else if(y.charAt(y.length()-1)=='C'){
						indexOfLatestAssigned=y.lastIndexOf("C");
						if(indexOfLatestAssigned>-1){
							if((S[x][0]>=S[indexOfLatestAssigned][0] && S[x][0]<S[indexOfLatestAssigned][1]) || 
									(S[x][1]>S[indexOfLatestAssigned][0] && S[x][1]<=S[indexOfLatestAssigned][1]) || 
									(S[x][0]<S[indexOfLatestAssigned][1] && S[x][1]>=S[indexOfLatestAssigned][1]) || 
									(S[x][0]<S[indexOfLatestAssigned][0] && S[x][1]>=S[indexOfLatestAssigned][0])){
								y="IMPOSSIBLE";
								break;
							}
						}
						y=y+"C";
						continue;
					}
					else{
						indexOfLatestAssigned=y.lastIndexOf("J");
						if(indexOfLatestAssigned>-1){
							if((S[x][0]>=S[indexOfLatestAssigned][0] && S[x][0]<S[indexOfLatestAssigned][1]) || 
									(S[x][1]>S[indexOfLatestAssigned][0] && S[x][1]<=S[indexOfLatestAssigned][1]) || 
									(S[x][0]<S[indexOfLatestAssigned][1] && S[x][1]>=S[indexOfLatestAssigned][1]) || 
									(S[x][0]<S[indexOfLatestAssigned][0] && S[x][1]>=S[indexOfLatestAssigned][0])){
								y="IMPOSSIBLE";
								break;
							}
						}
						y=y+"J";
						continue;
					}
				}
				latestAssigned=String.valueOf(y.charAt(y.length()-1));
				//get the last assigned guy and check if it overlaps
				if((S[x][0]>=S[x-1][0] && S[x][0]<S[x-1][1]) || 
						(S[x][1]>S[x-1][0] && S[x][1]<=S[x-1][1]) || 
						(S[x][0]<S[x-1][1] && S[x][1]>=S[x-1][1]) || 
						(S[x][0]<S[x-1][0] && S[x][1]>=S[x-1][0])){
					if(latestAssigned.equals("C")){
						// here check if the previous index of j is overlaping then it is impossible
						indexOfLatestAssigned=y.lastIndexOf("J");
						if(indexOfLatestAssigned>-1){
							if((S[x][0]>=S[indexOfLatestAssigned][0] && S[x][0]<S[indexOfLatestAssigned][1]) || 
									(S[x][1]>S[indexOfLatestAssigned][0] && S[x][1]<=S[indexOfLatestAssigned][1]) || 
									(S[x][0]<S[indexOfLatestAssigned][1] && S[x][1]>=S[indexOfLatestAssigned][1]) || 
									(S[x][0]<S[indexOfLatestAssigned][0] && S[x][1]>=S[indexOfLatestAssigned][0])){
								y="IMPOSSIBLE";
								break;
							}
						}
						y=y+"J";
						continue;
					}
					else{
						// here check if the previous index of C is overlaping then it is impossible
						indexOfLatestAssigned=y.lastIndexOf("C");
						if(indexOfLatestAssigned>-1){
							if((S[x][0]>=S[indexOfLatestAssigned][0] && S[x][0]<S[indexOfLatestAssigned][1]) || 
									(S[x][1]>S[indexOfLatestAssigned][0] && S[x][1]<=S[indexOfLatestAssigned][1]) || 
									(S[x][0]<S[indexOfLatestAssigned][1] && S[x][1]>=S[indexOfLatestAssigned][1]) || 
									(S[x][0]<S[indexOfLatestAssigned][0] && S[x][1]>=S[indexOfLatestAssigned][0])){
								y="IMPOSSIBLE";
								break;
							}
						}
						y=y+"C";
						continue;
					}
				}
			}

			System.out.println("Case #"+i+": "+y+"");
		}
	}
}
