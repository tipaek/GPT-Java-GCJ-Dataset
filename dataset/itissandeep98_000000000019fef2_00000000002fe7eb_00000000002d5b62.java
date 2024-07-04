import java.io.*;
import java.util.*;

public class Main {
	public static String dp(int n,int m,int i,int j,int step){
		int tn=Math.abs(n);
		int tm=Math.abs(m);
		if(i<=tn && i>=(-1)*tn && j<=tm && j>=(-1)*tm){
			if(i==n && j==m){
				return "";
			}
			// System.out.println(i+" "+j);
			String ansn,anss,answ,anse;
			int move=(int) Math.pow(2, step);
			ansn="W"+dp( n, m, i-move, j,step+1);
			anss="E"+dp( n, m, i+move, j,step+1);
			answ="S"+dp( n, m, i, j-move,step+1);
			anse="N"+dp( n, m, i, j+move,step+1);

			String ans="!";
			int len=Integer.MAX_VALUE;
			if(ansn.charAt(ansn.length()-1)!='!' && ansn.length()<len){
				ans=ansn;
				len=ansn.length();
			}
			if(anss.charAt(anss.length()-1)!='!' && anss.length()<len){
				ans=anss;
				len=anss.length();
			}
			if(anse.charAt(anse.length()-1)!='!' && anse.length()<len){
				ans=anse;
				len=anse.length();
			}
			if(answ.charAt(answ.length()-1)!='!' && answ.length()<len){
				ans=answ;
				len=answ.length();
			}
			return ans;
		}
		return "!";

	}

	public static void solve(int n) throws IOException {
		int x= scan.nextInt();
		int y= scan.nextInt();
		String ans=dp(x, y, 0, 0, 0);
		if(ans.equals("!")){
			ans="IMPOSSIBLE";
		}
		System.out.println("Case #"+n+": "+ans);

	}


	static final Scanner scan=new Scanner(System.in);
	static final BufferedReader read=new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		int t=1;
		t=scan.nextInt();
		for (int i = 0; i < t; i++) {
			solve(i+1);
		}
	}
}