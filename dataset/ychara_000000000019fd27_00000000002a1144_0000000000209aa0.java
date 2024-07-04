import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution  {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for(int i=1; i<=T; i++) {
		int N = sc.nextInt();
		int K = sc.nextInt();
		int q=K/N;
		int r=K%N; 
		int k=0;
		int[][] m = new int[N][N];
		Set<Integer> setUsed = new HashSet<Integer>();
		Set<Integer> setNotUsed = new HashSet<Integer>();
		
		for(int j=0; j<N; j++) {
			 if(j<r) {
				 m[j][j]=q+1;
			 } else {
				 m[j][j]=q; 
			 }
		} 
		for(int j=1; j<=N; j++) {
			if(j==q || j==q+1) {
				setUsed.add(j);
			}else {
				setNotUsed.add(j);
			}
		}
		boolean res =true;
		for(int j=1; j<N; j++) {
			 res = resolve(m,j, setUsed, setNotUsed, r, q  );
			 if(!res) {
				 break;
			 }
		} 
		if(res) {
			System.out.println("Case #"+i+": POSSIBLE");
			printMatrice(m, N);
			
		} else {
			System.out.println("Case #"+i+": IMPOSSIBLE"); 
		}
		
	}
}

private static void printMatrice(int[][] m, int  N) {
	for(int j=0; j<N; j++) {
		String sep=""; 
		for(int h=0; h<N; h++) {
			System.out.print(sep+ m[j][h]);
			sep=" ";
		}
		System.out.println();
	}
	
}

private static boolean resolve(int[][] m, int i, Set<Integer> setUsed, Set<Integer> setNotUsed, int r, int q) {
 
	int N = m[0].length;
	int lastC=0;
	for(int j=0; j<N; j++) {
		int jc=(j+i)%N;
		Set<Integer> sr = new HashSet<>();
		for(int h=0; h <N; h++) {
			sr.add(m[j][h]);
		}
		//System.out.println("sr["+j+"]="+sr);
		Set<Integer> sc = new HashSet<>();
		for(int h=0; h <N; h++) {
			sc.add(m[h][jc]);
		}
		//System.out.println("sc["+jc+"]="+sc);
		int c=0;
	 
			if(!sr.contains(lastC) && !sc.contains(lastC)) {
				c=lastC;
			}
		 
			
			if(c==0) {
		for(int x : setUsed) {
			if(sr.contains(x))
				continue;
			if(sc.contains(x))
				continue;
			c=x;
			break;
			
		}
			}
		if(c==0) {
			for(int x : setNotUsed) { 
				if(sr.contains(x))
					continue;
				if(sc.contains(x))
					continue;
				c=x;
				break;
				
			} 
		}
		if(c==0) {
			//System.out.println(">>>i="+i+" j="+j+" jc="+jc);
			return false;
		}
		lastC = c;
		m[j][jc] = c;
	}
	return true;
}
 
}