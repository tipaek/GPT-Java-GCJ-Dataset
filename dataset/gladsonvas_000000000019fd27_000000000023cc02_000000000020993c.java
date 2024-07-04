import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int T=Integer.parseInt(bufferedReader.readLine().trim());
		for(int i=1;i<=T;i++){
			int N=Integer.parseInt(bufferedReader.readLine().trim());
			String[] multipleInput = new String[N];
			int[][] M=new int[N][N];
			int k=0;
			int r=0;
			int c=0;
			Set<Integer> rowSet= new HashSet<>();
			Map<Integer,Set<Integer>> colMap= new HashMap<>();
			Set<Integer> colSet= null;
			for(int x=0;x<N;x++){
				multipleInput=bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
				rowSet= new HashSet<>();
				for(int y=0;y<N;y++){
					M[x][y]=Integer.parseInt(multipleInput[y]);
					if(x==y){
						k=k+M[x][y];
					}
					rowSet.add(M[x][y]);

					if(colMap.containsKey(y)){
						colMap.get(y).add(M[x][y]);
					}
					else{
						colSet= new HashSet<>();
						colSet.add(M[x][y]);
						colMap.put(y,colSet);
					}
				}
				if(rowSet.size()<N){
					r++;
				}
			}
			for(Integer keys:colMap.keySet()){
				if(colMap.get(keys).size()<N){
					c++;
				}
			}
			System.out.println("Case #"+i+": "+k+" "+r+" "+c+"");
		}
	}
}
