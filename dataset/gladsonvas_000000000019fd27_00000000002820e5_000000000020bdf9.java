import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

	static boolean checkForOverlap(int[][] S,int idx1,int idx2){
		if((S[idx1][0]>=S[idx2][0] && S[idx1][1]<=S[idx2][1]) || 
				(S[idx1][0]>=S[idx2][0] && S[idx1][1]>=S[idx2][1] && S[idx1][0]<S[idx2][1]) || 
				(S[idx1][0]<=S[idx2][0] && S[idx1][1]>=S[idx2][1]) || 
				(S[idx1][0]<=S[idx2][0] && S[idx1][1]<=S[idx2][1] && S[idx1][1]>S[idx2][0] )){
			return true;
		}
		else{
			return false;
		}
	}
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
			Map<String,List<Integer>> indexesMap= new HashMap<>(); 
			List<Integer> index= new ArrayList<>();
			indexesMap.put("J", index);
			index= new ArrayList<>();
			indexesMap.put("C", index);
			int broken=0;			
			for(int x=0;x<N;x++){
				// for the first task assign J
				if(x==0){
					y=y+"J";
					indexesMap.get("J").add(x);
					continue;
				}
				//check if it overlaps for all indexes of J
				index=indexesMap.get("J");
				broken=0;
				for(Integer eachidx:index){
					if(checkForOverlap(S, x, eachidx)){
						broken++;
						break;
					}
				}
				if(broken==0){
					y=y+"J";
					indexesMap.get("J").add(x);
					continue;
				}
				if(broken==1){
					index=indexesMap.get("C");
					if(index.size()>0){
						for(Integer eachidx:index){
							if(checkForOverlap(S, x, eachidx)){
								broken++;
								break;
							}
						}
						if(broken==2){
							y="IMPOSSIBLE";
							break;
						}
						else{
							y=y+"C";
							indexesMap.get("C").add(x);
							continue;
						}
					}
					else{
						y=y+"C";
						indexesMap.get("C").add(x);
						continue;
					}
				}
			}
			if(y.length()!=N){
				y="IMPOSSIBLE";
			}
			System.out.println("Case #"+i+": "+y+"");
		}
	}
}
