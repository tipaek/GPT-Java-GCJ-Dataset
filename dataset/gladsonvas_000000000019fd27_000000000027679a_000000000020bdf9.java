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
			String latestAssigned="";
			Map<String,List<Integer>> indexesMap= new HashMap<>(); 
			List<Integer> index= new ArrayList<>();
			indexesMap.put("J", index);
			index= new ArrayList<>();
			indexesMap.put("C", index);
			boolean broken=false;
			Set<String> sameact= new HashSet<>();
			
			for(int x=0;x<N;x++){
				if(sameact.contains(S[x][0]+""+S[x][1])){
					y="IMPOSSIBLE";
					break;
				}
				else{
					sameact.add(S[x][0]+""+S[x][1]);
				}
				// for the first task assign c
				if(x==0){
					y=y+"J";
					indexesMap.get("J").add(x);
					continue;
				}
				// no overlap
				if(!checkForOverlap(S,x,x-1)){
					latestAssigned=String.valueOf(y.charAt(y.length()-1));					
					if(y.length()-2>=0){
						//if last 2 assigned are c then we need to put j by checking if previous j is not overlapping
						if(y.charAt(y.length()-2)==y.charAt(y.length()-1) && y.charAt(y.length()-1)=='C'){
							index=indexesMap.get("J");
							if(index.size()>0){
								for(Integer eachidx:index){
									if(checkForOverlap(S, x, eachidx)){
										y="IMPOSSIBLE";
										broken=true;
										break;
									}
								}
								if(broken){
									broken=false;
									break;
								}
								else{
									y=y+"J";
									indexesMap.get("J").add(x);
									continue;
								}
							}
							else{
								y=y+"J";
								indexesMap.get("J").add(x);
								continue;
							}			
						}
						else if(y.charAt(y.length()-2)==y.charAt(y.length()-1) && y.charAt(y.length()-1)=='J'){
							index=indexesMap.get("C");
							if(index.size()>0){
								for(Integer eachidx:index){
									if(checkForOverlap(S, x, eachidx)){
										y="IMPOSSIBLE";
										broken=true;
										break;
									}
								}
								if(broken){
									broken=false;
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
						else{
							index=indexesMap.get(String.valueOf(y.charAt(y.length()-1)));
							if(index.size()>0){
								for(Integer eachidx:index){
									if(checkForOverlap(S, x, eachidx)){
										y="IMPOSSIBLE";
										broken=true;
										break;
									}
								}
								if(broken){
									broken=false;
									break;
								}
								else{
									y=y+y.charAt(y.length()-1);
									indexesMap.get(String.valueOf(y.charAt(y.length()-1))).add(x);
									continue;
								}
							}
							else{
								y=y+y.charAt(y.length()-1);
								indexesMap.get(String.valueOf(y.charAt(y.length()-1))).add(x);
								continue;
							}	
						}
					}
					else{
						y=y+y.charAt(y.length()-1);
					}
				}
				else{				
					if(y.charAt(y.length()-1)=='C'){
						index=indexesMap.get("J");
						if(index.size()>0){
							for(Integer eachidx:index){
								if(checkForOverlap(S, x, eachidx)){
									y="IMPOSSIBLE";
									broken=true;
									break;
								}
							}
							if(broken){
								broken=false;
								break;
							}
							else{
								y=y+"J";
								indexesMap.get("J").add(x);
								continue;
							}
						}
						else{
							y=y+"J";
							indexesMap.get("J").add(x);
							continue;
						}		
					}
					else if(y.charAt(y.length()-1)=='J'){
						index=indexesMap.get("C");
						if(index.size()>0){
							for(Integer eachidx:index){
								if(checkForOverlap(S, x, eachidx)){
									y="IMPOSSIBLE";
									broken=true;
									break;
								}
							}
							if(broken){
								broken=false;
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
			}
			if(y.length()!=N){
				y="IMPOSSIBLE";
			}
			System.out.println("Case #"+i+": "+y+"");
		}
	}
}
