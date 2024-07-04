import java.io.*;
import java.util.*;
public class Solution{
	public static void main(String[]args) throws IOException{
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		int t = Integer.parseInt(sc.nextLine().trim());
		for(int i=1;i<=t;i++) {
			int N = Integer.parseInt(sc.nextLine());
			int[][]test=new int[3][N];
			
			for(int j=0;j<N;j++) {
				String []st = (sc.nextLine().split(" "));
				int start = Integer.parseInt(st[0]);
				int end = Integer.parseInt(st[1]);
				test[0][j]=start;
				test[1][j]=end;
				test[2][j]=j;
			}
			for(int j=0;j<N;j++) {
				test = sort(test,j);
				test = sort2(test,j);
				test = sort(test,j);
				test = sort2(test,j);
			}
			
			char []output=new char[N];
			boolean []C=new boolean[1440];
			boolean[]J = new boolean[1440];
			
			boolean possible = true;
			for(int a=0;a<N;a++) {
				boolean csfull=false;
				boolean jsfull=false;
				for(int e = test[0][a];e<test[1][a];e++) {
					if(C[e]) {
						csfull=true;
					}
					if(J[e]) {
						jsfull=true;
					}
				}
				if(!csfull) {
					output[test[2][a]]='C';
					for(int k=test[0][a];k<test[1][a];k++) {
						C[k]=true;
					}
				}
				else if(!jsfull){
					output[test[2][a]]='J';
					for(int k=test[0][a];k<test[1][a];k++) {
						J[k]=true;
					}
				}
				else {
					possible = false;
				}
			}
				if(possible) {
					String real ="";
					for(int o=0;o<output.length;o++) {
						real+=output[o];
					}
					System.out.println("Case #"+i+": "+real);
					

				}
				else {
					System.out.println("Case #"+i+": IMPOSSIBLE");
				}
			
		}
		
	}
	public static int[][]sort(int[][]n, int x){
		while(x<n[0].length-1&&n[0][x]>n[0][x+1]) {
			int temp = n[0][x];
			int temp2 = n[1][x];
			int temp3 = n[2][x];
			n[0][x]=n[0][x+1];
			n[1][x]=n[1][x+1];
			n[2][x]=n[2][x+1];
			n[0][x+1]=temp;
			n[1][x+1]=temp2;
			n[2][x+1]=temp3;
		}
		
		return n;
	}
	public static int[][]sort2(int[][]n, int x){
		while(x>0&&n[0][x]<n[0][x-1]) {
			int temp = n[0][x];
			int temp2 = n[1][x];
			int temp3 = n[2][x];
			n[0][x]=n[0][x-1];
			n[1][x]=n[1][x-1];
			n[2][x]=n[2][x-1];
			n[0][x-1]=temp;
			n[1][x-1]=temp2;
			n[2][x-1]=temp3;
		}
		
		return n;
	}
	
}