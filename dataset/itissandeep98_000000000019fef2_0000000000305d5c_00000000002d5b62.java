import java.io.*;
import java.util.*;

public class Solution {
	public static String dp(long n,long m,long i,long j,long step){
		long tn=Math.abs(n);
		long tm=Math.abs(m);
		if(i<=tn && i>=(-1)*tn && j<=tm && j>=(-1)*tm){
			if(i==n && j==m){
				return "";
			}
			String ansn,anss,answ,anse;
			long move=(long) Math.pow(2, step);
			answ="W"+dp( n, m, i-move, j,step+1);
			anse="E"+dp( n, m, i+move, j,step+1);
			anss="S"+dp( n, m, i, j-move,step+1);
			ansn="N"+dp( n, m, i, j+move,step+1);

			String ans="!";
			long len=Integer.MAX_VALUE;
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
			}
			return ans;
		}
		return "!";

	}

	public static void solve(long n) throws IOException {
		long x= scan.nextLong();
		long y= scan.nextLong();
		String ans=dp(x, y, 0, 0, 0);
		if(ans.equals("!")){
			ans="IMPOSSIBLE";
		}
		System.out.println("Case #"+n+": "+ans);

	}


	static final Scanner scan=new Scanner(System.in);
	static final BufferedReader read=new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		long t=1;
		t=scan.nextLong();
		for (long i = 0; i < t; i++) {
			solve(i+1);
		}
	}
}