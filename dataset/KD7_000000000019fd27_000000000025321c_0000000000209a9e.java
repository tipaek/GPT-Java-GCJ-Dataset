import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int x,t,b,i,q=0;
		String out;
		char ch;
		String s[]=br.readLine().split(" ");
		t=Integer.parseInt(s[0]);
		b=Integer.parseInt(s[1]);
		for(x=0;x<t;x++) {
			out="";
			//q=0;
			i=0;
			while(i<b) {
				q++;
				if(q%10==1) {
					System.out.println(1);
					ch=br.readLine().trim().charAt(0);
					if(ch=='0' || ch=='1')
						continue;
					else
						return;
				}
				System.out.println(++i);
				ch=br.readLine().trim().charAt(0);
				if(ch=='0' || ch=='1')
					out+=ch;
				else
					return;
			}
			System.out.println(out);
			ch=br.readLine().trim().charAt(0);
			if(ch=='N')
				break;
		}

	}
}
