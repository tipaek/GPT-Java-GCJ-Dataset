import java.io.*;
import java.util.*;
public class Solution {

	public static void main(String[]args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine().trim());
		for(int i=1;i<=t;i++) {
			int N = Integer.parseInt(bf.readLine());
			int[]C=new int[1440];
			int[]J=new int[1440];
			char[]output = new char[N];
			boolean possible=true;
			for(int j=0;j<N;j++) {

				StringTokenizer st = new StringTokenizer(bf.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				boolean csjob=true;
				boolean jsjob=true;
				for(int k=start;k<end;k++) {
					if(C[k]==1) {
						csjob=false;
					}
					if(J[k]==1) {
						jsjob=false;
					}

				}
				if(csjob) {
					for(int k=start;k<end;k++) {
						C[k]=1;
						output[j]='C';
					}
				}
				else if(jsjob) {
					for(int k=start;k<end;k++) {
						J[k]=1;
						output[j]='J';
					}
				}
				else {
					System.out.println("Case #"+i+": IMPOSSIBLE");
					possible=false;
				}
			}
			if(possible) {
				System.out.print("Case #"+i+": ");
				for(int w=0;w<output.length;w++) {
					System.out.print(output[w]);
				}
				System.out.println();
			}
		}
	}

}
