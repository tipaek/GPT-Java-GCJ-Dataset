import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int x,t,b,i,j;
		StringBuffer sb;
		char ch;
		String s[]=br.readLine().split(" ");
		t=Integer.parseInt(s[0]);
		b=Integer.parseInt(s[1]);
		for(x=0;x<t;x++) {
		    sb=new StringBuffer(b);
			i=0;
			while(i<b) {
				System.out.print(i++);
				ch=br.readLine().charAt(0);
				if(ch=='N')
					return;
				sb.setCharAt(i-1, ch);
				for(j=1;j<=10;j++) {
					System.out.print(0);
					ch=br.readLine().charAt(0);
					if(ch=='N')
						return;
				}
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
