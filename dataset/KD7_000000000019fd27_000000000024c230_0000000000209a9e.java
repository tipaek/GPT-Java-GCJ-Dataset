import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int x,t,b,i,q;
		String out;
		char ch;
		String s[]=br.readLine().split(" ");
		t=Integer.parseInt(s[0]);
		b=Integer.parseInt(s[1]);
		for(x=0;x<t;x++) {
			out="";
			q=0;
			i=0;
			while(i<b) {
				q++;
				if(q%10==1) {
					System.out.print(1);
					ch=br.readLine().charAt(0);
					if(ch!='0' || ch!='1')
						return;
					continue;
				}
				System.out.print(++i);
				ch=br.readLine().charAt(0);
				if(ch!='0' || ch!='1')
					return;
				out+=ch;
			}
			System.out.print(out);
			ch=br.readLine().charAt(0);
			if(ch=='Y') {
				continue;
			}
			else
				break;
		}

	}
}
