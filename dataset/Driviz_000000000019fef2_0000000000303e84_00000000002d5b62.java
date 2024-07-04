import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		int test=0;
		while(test++<T) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			if((x%2==0 && y%2==0)||(x%2!=0 && y%2!=0)) {
				System.out.println("Case #"+test+":"+" IMPOSSIBLE");
				continue;
			}
			
			ArrayList<String> res=new ArrayList<>();
			getResult(x, y, 0, 0, res, new String(),0);
			
			Collections.sort(res,(a,b)->a.length()-b.length());
			if(res.get(0).isEmpty())
				System.out.println("Case #"+test+":"+" IMPOSSIBLE");
			else
				System.out.println("Case #"+test+":"+" "+res.get(0));
			}
	}
	
	static void getResult(int x, int y, int currx, int curry, ArrayList<String> res, String currPath, int stepNumber)
	{
		if(x==currx && y==curry) {
			res.add(currPath);
			return;
		}

		if(Math.abs(currx)>Math.abs(2*x) || Math.abs(curry)>Math.abs(2*y))
			return;
				
			getResult(x, y, (int)(currx+Math.pow(2, stepNumber)), curry, res, currPath+'E',stepNumber+1);
			getResult(x, y, (int)(currx-Math.pow(2, stepNumber)), curry, res, currPath+"W",stepNumber+1);
			getResult(x, y, currx, (int)(curry+Math.pow(2, stepNumber)), res, currPath+"N",stepNumber+1);		
			getResult(x, y, currx, (int)(curry-Math.pow(2, stepNumber)), res, currPath+"S",stepNumber+1);
	}

}
