
public class Solution {

	public static void main(String[] args) {
	int T=0,N=0,k=0,r=0,c=0,i=0,j=0;
java.util.HashSet<Integer> set = new java.util.HashSet<>() ;

		java.util.Scanner sc=new java.util.Scanner(System.in);
	
		if(sc.hasNext()) {
			T=sc.nextInt();
			
		}
		for(int t=0;t<T;t++) {
			if(sc.hasNext()) {
				N=sc.nextInt();
			
			}
			int [][] M=new int[N][N];
			for(i=0;i<N;i++) {
				for(j=0;j<N;j++) {
					if(sc.hasNext()) {
						M[i][j]=sc.nextInt();
			
									if(i==j) {
							k+=M[i][j];
									}
					}
				}
			}
			
			for(i=0;i<N;i++) {
					
					for(int num: M[i]) {
						set.add(num);
					}
			
					if(set.size()<N) {
						r++;
			
					}
					set.clear();
			
			}
						
			for(i=0;i<N;i++) {
				int [] z=new int[N];
				for(j=0;j<N;j++) {
					z[j]=M[j][i];
			
				}
				
				for(int num: z) {
					set.add(num);
				}
		
				if(set.size()<N) {
					c++;
		
				}
				set.clear();
		}
		
			System.out.println("Case #"+(t+1)+": "+k+" "+r+" "+c);
			
		k=0;
		r=0;
		c=0;			

		}
		
		
sc.close();
	}

}