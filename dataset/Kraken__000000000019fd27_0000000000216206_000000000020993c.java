import java.util.Scanner; 

public class Solution {

public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	String s = scanner.nextLine();
	int T=Integer.parseInt(s);
	int[] nt=new int[31];
	for (int i = 1; i <= T; i++) {
		s = scanner.nextLine();
		int N=Integer.parseInt(s);
		int trc=0, rr=0, cr=0;
		boolean[][] mat=new boolean[N][N];
		boolean[] cl=new boolean[N];
		for (int j = 0; j < N; j++) {
		    boolean[] rw=new boolean[N];
		    boolean rp=false;
		    s = scanner.nextLine();
		    String[] tok=s.split(" ");
		    for (int h = 0; h < N; h++) {
		        int v=Integer.parseInt(tok[h]);
		        if (h==j) trc+=v;
		        if (mat[h][v-1]) cl[h]=true;
		        else mat[h][v-1]=true;
		        if (!rp && rw[v-1]) {rp =true; rr++;}
		        else rw[v-1]=true;
		    }
		}
		for (int j = 0; j < N; j++) if (cl[j]) cr++;
		System.out.println("Case #"+i+": "+trc+ " "+rr+" "+cr);
	}
	scanner.close();		
}	
}