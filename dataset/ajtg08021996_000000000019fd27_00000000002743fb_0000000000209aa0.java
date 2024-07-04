public class Solution{
	
	public static void main(String[] args) {
	int T=0,N=0,K=0;
	java.util.ArrayList<String> sl=new java.util.ArrayList<>();
		
	java.util.Scanner sc=new java.util.Scanner(System.in);
	if(sc.hasNext()) {
		T=sc.nextInt();
	}
	
	for(int t=0;t<T;t++) {
		if(sc.hasNext()) {
			N=sc.nextInt();
			K=sc.nextInt();
		}
		
		if(K%N==0) {
			//sl.add("POSSIBLE");
			System.out.println("Case #"+(t+1)+": "+"POSSIBLE");
			K=K/N;
			int a=0;
			int [][]b=new int[N][N];
	
			b[0][0]=K;
			for(int i=1;i<N;i++) {
				
				if(K<N) {
					b[0][i]=++K;
				}
				if(K==N) {
					K=0;
				}
				
			}
			
			for(int i=0;i<(N-1);i++) {
				for(int j=0;j<N;j++) {
					a=j+1;
					if(a==N) {
						a=0;
					}
					b[i+1][a]=b[i][j];
					
					
				}
			}
			
			
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					System.out.print(b[i][j]+" ");
				}
				System.out.println();
			}
			
			
		}
		else {
			//sl.add("IMPOSSIBLE");
			System.out.println("Case #"+(t+1)+": "+"IMPOSSIBLE");
		}
		
		
		
		
		
	}
		
		
	}
	
	
	
	
	
}