import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		int[] dp=new int[12];
		dp[0]=1;
		for(int i=1;i<12;i++) {
			dp[i]=dp[i-1]*2;
		}
		int t=s.nextInt();
		for(int ie=0;ie<t;ie++) {
			int x=s.nextInt();
			int y=s.nextInt();
			ArrayList<String> list=new ArrayList<>();
			boynoob(x,y,"",0,0,0,list,dp);
			if(list.size()==0) {
				System.out.println("Case #"+(ie+1)+": IMPOSSIBLE");
			}else {
				int in=-1;
				int min=100000000;
				for(int i=0;i<list.size();i++) {
					if(list.get(i).length()<min) {
						min=list.get(i).length();
						in=i;
					}
				}
				System.out.println("Case #"+(ie+1)+": "+(list.get(in)));
			}
		}
		
	}
	public static void boynoob(int x,int y,String str,int pow,int currx,int curry,ArrayList<String> list,int[] dp) {
		if(pow>10) {
			return ;
		}
		if(currx==x&&curry==y) {
			list.add(str);
		}
		
		
		boynoob(x,y,str+"N",pow+1,currx,curry+dp[pow],list,dp);
		boynoob(x,y,str+"S",pow+1,currx,curry-dp[pow],list,dp);
		boynoob(x,y,str+"E",pow+1,currx+dp[pow],curry,list,dp);
		boynoob(x,y,str+"W",pow+1,currx-dp[pow],curry,list,dp);
		
		
		
	}
}