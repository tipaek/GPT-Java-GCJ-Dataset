import java.util.Scanner; 

public class Solution {

public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	String s = scanner.nextLine();
	int T=Integer.parseInt(s);
	for (int i = 1; i <= T; i++) {
		s = scanner.nextLine();
		String[] tok=s.split(" ");
		long X=Integer.parseInt(tok[0]);
		long Y=Integer.parseInt(tok[1]);
		long ax=Math.abs(X), ay=Math.abs(Y);
		int nj=0;
		boolean[] dm=new boolean[11];
		boolean[] sg=new boolean[11];
		int fg=-1;
		boolean imp=false, fn=false;
		for (int j = 0; j < 11 && !imp && !fn; j++) {
			fn = ((ax == (ax & (1 << j)-1)) && (ay == (ay & (1 << j)-1)));
			boolean bx=(1 << j & ax)>0;
			boolean by=(1 << j & ay)>0;
			if (fg==-1) {
				if (!bx && !by) { if (!fn) {imp=true;} break;}
				if (bx && !by) dm[j]=true;
				if (!bx && by) dm[j]=false;
				if (bx && by) { if (j==0) {imp=true; break;}
					sg[j-1]=true; fg=dm[j-1]?0:1; dm[j]=(fg==1);
				} 
			}
			else {
				if (bx ^ by) {imp=true; break;}
				if (bx && by) dm[j]=(fg==1);
				if (!bx && !by) {dm[j]=(fg==0); fg=-1;}
			}
			nj++;
		}
		if (imp) s="IMPOSSIBLE";
		else {
			s="";
			for (int j = 0; j < nj; j++) {
				if (dm[j]) { s+=(X==ax ^ sg[j])?"E":"W";}
				else { s+=(Y==ay ^ sg[j])?"N":"S";}
			}
		}
		System.out.println("Case #"+i+": "+ s);
	}
	scanner.close();		
}	
}