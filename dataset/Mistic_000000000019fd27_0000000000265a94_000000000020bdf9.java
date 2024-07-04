import java.util.*;
class parent {
	int time;
	parent() {
		time = 0;
	}
}
class Solution {
    public static void main(String args[]) {
        int T,N,i,j,min,x=1;
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        while(T>0){
			String r = "";
			min = 0;
			N = sc.nextInt();
			int M[][] = new int[N][3];
			for(i=0;i<N;i++) {
				for(j=0;j<2;j++) {
					M[i][j] = sc.nextInt();
				}
				M[i][j] = 0;
			}
			parent C = new parent();
			parent J = new parent();
			for(j=0;j<N;j++) {
				for(i=0;i<N;i++) {
					if(M[i][0]<M[min][0] && M[i][2]!=1) {
						min = i;
					}
				}
				if(C.time<=M[min][0]) {
					C.time=M[min][1];
					r+="C";
					M[min][2]=1;
					M[min][0]=9999;
				} else if (J.time<=M[min][0]) {
					J.time=M[min][1];
					r+="J";
					M[min][2]=1;
					M[min][0]=9999;
				} else {
					r = "IMPOSSIBLE";
					break;
				}
			}
			System.out.println("Case #"+x+": "+r);
            T--;
			x++;
        }
    }
}