import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x,i,t,open,a,j;
		String s,out[];
		t=Integer.parseInt(br.readLine());
		out=new String[t];
		for(x=0;x<t;x++) {
			out[x]="";
			s=br.readLine();
			open=0;
			for(i=0;i<s.length();i++) {
				a=s.charAt(i)-'0';
				if(open<a) {
					for(j=1;j<=(a-open);j++) {
						out[x]+="(";
					}
					open=a;
				}
				else if(open>a) {
					for(j=1;j<=(open-a);j++) {
						out[x]+=")";
					}
					open=a;
				}
				out[x]+=a;
			}
			for(i=1;i<=open;i++) {
				out[x]+=")";
			}
		}
		for(x=0;x<t;x++) {
			System.out.println("Case #"+(x+1)+": "+out[x]);
		}
	}

}
