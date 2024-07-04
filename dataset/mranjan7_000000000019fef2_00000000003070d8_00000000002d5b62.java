import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
 
public class Solution{
	int jumps[];
	int marked[];
	String result = "";
	int X;
	int Y;
	ArrayList<String> paths ;
 
	public static void main(String args[]) throws Exception{
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		new Solution().solve(br,pw);
		br.close();
		pw.flush();
		pw.close();
		System.exit(0);
	}
 
	void solve(BufferedReader br,PrintWriter pw) throws Exception{
		
		int T = Integer.parseInt(br.readLine());	
		for(int i = 0;i < T;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			X = Integer.parseInt(st.nextToken());
			Y = Integer.parseInt(st.nextToken());
			jumps = new int[1000];
			marked = new int[200*200];
			for(int j = 0;j < 1000;j++){
				jumps[j] = (int)Math.pow(2,j);
			}
			int sum = X + Y;
			int flag = 1;
			for(int j = 0;j < 1000;j++){
				
				if(Math.abs(j - Math.abs(sum)) == 2){
					break;
				}
				else if(Math.abs(j - Math.abs(sum)) >  2){
					flag = 0;
					break;
				}
			}
			result = "";
			paths = new ArrayList<String>();
			dfs(0,0,0,"");
			String finalPath = "";
			for(String path:paths){
				if(finalPath.equals("")){
					finalPath = path;
				}
				else if(finalPath.length() > path.length()){
					finalPath = path;
				}
			}
			result = finalPath;
			
			if(result.equals("")){
				pw.println("Case #"+(i+1)+": IMPOSSIBLE");
			}
			else{
				pw.println("Case #"+(i+1)+": "+result);
			}
			
			
			
		}
		
		

	}
	void dfs(int x,int y,int count,String path){
		if(count > 40){
			return;
		}
		if(x == X && y == Y){
			paths.add(path);
		}
		dfs(x - jumps[count],y,count+1,path+"W");
		dfs(x + jumps[count],y,count+1,path+"E");
		dfs(x,y+jumps[count],count+1,path+"N");
		dfs(x,y-jumps[count],count+1,path+"S");
	}
}



