import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int x,t,b,i,j,q;
		StringBuffer sb;
		char ch;
		String s[]=br.readLine().split(" ");
		t=Integer.parseInt(s[0]);
		b=Integer.parseInt(s[1]);
		for(x=0;x<t;x++) {
			sb=new StringBuffer(b);
			q=0;
			i=0;
			while(i<b) {
				q++;
				if(q%10==1) {
					System.out.print(1);
					ch=br.readLine().charAt(0);
					if(ch=='N')
						return;
					continue;
				}
				System.out.print(i++);
				ch=br.readLine().charAt(0);
				if(ch=='N')
					return;
				sb.setCharAt(i-1, ch);
			}
			System.out.print(sb.toString());
			ch=br.readLine().charAt(0);
			if(ch=='Y') {
				continue;
			}
			if(ch=='N')
				return;
		}

	}
}
