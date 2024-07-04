import java.util.*;
class Solution {
    public static void main(String args[]) {
        int T,N,k,r,c,x=1,i,j,m,n;
		boolean rowFlag,columnFlag;
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        while(T>0){
			k = r = c = 0;
			N = sc.nextInt();
			int M[][] = new int[N][N];
			for(i=0;i<N;i++) {
				m = 0;
				Integer row[] = new Integer[N];
				rowFlag = false;
				for(j=0;j<N;j++) {
					M[i][j] = sc.nextInt();
					if(!rowFlag) {
						if(Arrays.asList(row).contains(M[i][j])){
							rowFlag = true;
							r++;
						} else {
							row[m] = M[i][j];
							m++;
						}
					}
				}
				k+=M[i][i];
			}
			for(i=0;i<N;i++) {
				n = 0;
				Integer col[] = new Integer[N];
				columnFlag = false;
				for(j=0;j<N;j++) {
					if(!columnFlag) {
						if(Arrays.asList(col).contains(M[j][i])){
							columnFlag = true;
							c++;
						} else {
							col[n] = M[j][i];
							n++;
						}
					}
				}
			}
			System.out.println("Case #"+x+": "+k+" "+r+" "+c);
            T--;
			x++;
        }
    }
}