import java.io.*;
import java.util.*;
public class Solution {

	public static void main(String[]args) throws IOException{
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		int t = Integer.parseInt(sc.nextLine().trim());
		for(int i=1;i<=t;i++) {
			int N = Integer.parseInt(sc.nextLine());
			int[]C=new int[1440];
			int[]J=new int[1440];
			char[]output = new char[N];
			boolean possible=true;
			for(int j=0;j<N;j++) {

				String[] st = (sc.nextLine().split(" "));
				int start = Integer.parseInt(st[0]);
				int end = Integer.parseInt(st[1]);
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
