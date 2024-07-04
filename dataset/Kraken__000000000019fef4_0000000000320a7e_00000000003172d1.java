import java.util.Arrays;
import java.util.Scanner; 

public class Solution {

public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	String s = scanner.nextLine();
	int T=Integer.parseInt(s);
	for (int i = 1; i <= T; i++) {
		s = scanner.nextLine();
		String[] tok=s.split(" ");
		int N=Integer.parseInt(tok[0]);
		int D=Integer.parseInt(tok[1]);
		long[] As=new long[N];
		s = scanner.nextLine();
		tok=s.split(" ");
		long tot=0;
		for (int j = 0; j < N; j++) {
			As[j]=Long.parseLong(tok[j]); tot+=As[j];
		}
		Arrays.sort(As);		
		long mn=D;
		for (int j = 0; j < N; j++) {
			for (int h = 1; h <= D; h++) {
				if (tot<As[j]*D/h-N) continue;
				long sr=0,nc=0;
				for (int k = 0; k < N && sr<D; k++) {
					if ((As[k]*h) % As[j]==0) {
						long nsr=(As[k]*h)/As[j];
						nc+=Math.min(nsr-1,D-sr);
						sr=Math.min(D, sr+nsr);						
					}
				}
				for (int k = 0; k < N && sr<D; k++) {
					if ((As[k]*h) % As[j]==0)  continue;
					long nsr=(As[k]*h)/As[j];
					nc+=Math.min(nsr,D-sr);
					sr=Math.min(D, sr+nsr);	
				}
				//System.out.println(mn+" "+sr+" "+nc+" --  "+h);
				if (sr==D) mn=Math.min(mn, nc);
			}			
		}
		System.out.println("Case #"+i+": "+ mn);
	}
	scanner.close();		
}	
}