import java.io.*;
import java.util.*;

public class Solution{
//    static PrintWriter out = new PrintWriter(System.out);
	static BufferedReader in=new BufferedReader(new InputStreamReader(System.in));

	public static void solve(int tcase) throws Exception{
		StringTokenizer st=new StringTokenizer(in.readLine());
		long l=Integer.parseInt(st.nextToken());
		long r=Integer.parseInt(st.nextToken());
		int stranka=1;
		while(true){
			if(l>=r){
				if(l>=stranka){
					l-=stranka;
				}else {
					System.out.println("Case #"+tcase+": "+(stranka-1)+" "+l+" "+r);
					return;
				}
			}else {
				if(r>=stranka){
					r-=stranka;
				}else {
					System.out.println("Case #"+tcase+": "+(stranka-1)+" "+l+" "+r);
					return;
				}
			}
			stranka++;
		}
	}

	public static void main(String[] args) throws Exception{
		StringTokenizer st=new StringTokenizer(in.readLine());
		int t=Integer.parseInt(st.nextToken());
		for(int tcase=1;tcase<=t;tcase++){
			solve(tcase);
		}
	}

}
