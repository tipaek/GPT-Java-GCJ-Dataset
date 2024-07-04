import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solutin {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int x,t,b,i,j;
		StringBuffer sb;
		char ch;
		t=Integer.parseInt(br.readLine());
		for(x=0;x<t;x++) {
			b=Integer.parseInt(br.readLine());
			sb=new StringBuffer(b);
			i=0;
			while(i<b) {
				System.out.print(i++);
				ch=br.readLine().charAt(0);
				sb.setCharAt(i-1, ch);
				for(j=1;j<=2;j++) {
					System.out.print(0);
					br.readLine();
				}
				if(i==b)
					break;
				
				System.out.print(b-(i++)-1);
				ch=br.readLine().charAt(0);
				sb.setCharAt(i-1, ch);
				for(j=1;j<=2;j++) {
					System.out.print(0);
					br.readLine();
				}
				if(i==b)
					break;
				
				System.out.print(b-(i++)-1);
				ch=br.readLine().charAt(0);
				if(ch==1)
					ch='0';
				else
					ch='1';
				sb.setCharAt(i-1, ch);
				
				System.out.print(i++);
				ch=br.readLine().charAt(0);
				sb.setCharAt(i-1, ch);
			}
			System.out.print(sb.toString());
			br.readLine();
		}

	}

}
