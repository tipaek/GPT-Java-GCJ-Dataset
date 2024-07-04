import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int numTests = input.nextInt();
		for (int i = 0; i < numTests; i++) {
			int N = input.nextInt();
			int T = input.nextInt();
			boolean isFeasible = false;
			int n = 0;
			for(int j=1;j<=N;j++) {
				if(T==N*j){
					n=j;
					isFeasible=true;
					break;
				}
			}
			
			if(!isFeasible) {
				System.out.printf("Case #%d: ",i+1);
				System.out.println("IMPOSSIBLE");
			}else {
				System.out.printf("Case #%d: ",i+1);
				System.out.println("POSSIBLE");
				int n2 = n;
				for(int k=0;k<N;k++) {
					StringBuilder sb = new StringBuilder();
					for(int l=0;l<N;l++) {
						int t1= n2+l;
						int t2 = (t1>N)?t1%N:t1;
						sb.append(t2);
						if(l!=N-1) sb.append(" ");
					}
					System.out.println(sb.toString());
					n2--;
					if(n2<1) n2+=N;
				}
			}
		}
	}
}
