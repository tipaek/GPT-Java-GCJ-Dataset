import java.util.Scanner;
public class Solution {
	public static void main(String args[]) {
		int T=0;
		Scanner a = new Scanner(System.in);
		T = a.nextInt();
		int cases=0;
		String work[][] = new String[T][1000];
		String data[] = new String[T];
		while(T>cases) {
			int N=a.nextInt();
			int J[][] = new int[N][2];
			int C[][] = new int[N][2];
			for(int i=0;i<N;i++) {
				int Si = a.nextInt();
				int Ei = a.nextInt();
				boolean check = true;
				boolean check1 =true;
				for(int k=0;k<i;k++) {
					if(Si>=J[k][0]&&Si<J[k][1]) {
						check=false;
					}
					if(Ei>J[k][0]&&Ei<=J[k][1]) {
						check=false;
					}
					if(Si>=C[k][0]&&Si<C[k][1]) {
						check1=false;
					}
					if(Ei>C[k][0]&&Ei<=C[k][1]) {
						check1=false;
					}
				}
				if(check) {
					J[i][0] = Si;
					J[i][1] = Ei;
					work[cases][i] = "J";
				}else if(check1) {
					C[i][0] = Si;
					C[i][1] = Ei; 
					work[cases][i] = "C";
				}else
					work[cases][i]= "I";
			}
			for(int k=0;k<N;k++) {
				if(work[cases][k]=="I") {
					data[cases] = null;
					data[cases] = "Impossible";
				}else if(k==0)
					data[cases] = work[cases][k];
				else
					data[cases]+=work[cases][k];
			}
			cases++;
		}
		for(int i=0;i<T;i++) {
			System.out.println("Case #" + (i+1) + ": "+ data[i]);			
		}
	}
}